package com.sharemyride.dao;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.LatLng;
import com.sharemyride.dto.ResponseDto;
import com.sharemyride.dto.SaveRideDto;
import com.sharemyride.model.User;
import com.sharemyride.model.UserOfferRide;
import com.sharemyride.model.UserRideDetails;
import com.sharemyride.model.UserVehicle;

@Transactional
@Repository
public class RideDaoImpl implements RideDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public ResponseDto saveRide(SaveRideDto saveRideDto) {
		ResponseDto responseDto = new ResponseDto();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		UserOfferRide userOfferRide = new UserOfferRide();
		userOfferRide.setCreatedDate(new Date());
		try {
			userOfferRide.setDatetime(simpleDateFormat.parse(saveRideDto.getDateTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userOfferRide.setFromLatitude(saveRideDto.getFromLatitude());
		userOfferRide.setFromLongitude(saveRideDto.getFromLongitude());
		userOfferRide.setToLatitude(saveRideDto.getToLatitude());
		userOfferRide.setToLongitude(saveRideDto.getToLongitude());
		userOfferRide.setUpdatedDate(new Date());
		List<User> users = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", saveRideDto.getUserId())).list();
		if (users.size() == 1) {
			userOfferRide.setUser(users.get(0));
		} else {
			responseDto.setMessage("Invalid user Id");
			responseDto.setStatus(104);
			return responseDto;
		}
		List<UserVehicle> userVehicles = sessionFactory.getCurrentSession().createCriteria(UserVehicle.class).add(Restrictions.eq("id", saveRideDto.getVechileId())).list();
		if (userVehicles.size() == 1) {
			userOfferRide.setUserVehicle(userVehicles.get(0));
		} else {
			responseDto.setMessage("Invalid vechile Id");
			responseDto.setStatus(104);
			return responseDto;
		}
		sessionFactory.getCurrentSession().save(userOfferRide);
		
		
		//String origin = "10.008169,76.362285";
		//String destination = "10.791030,76.654132";
		String origin = saveRideDto.getFromLatitude() + "," + saveRideDto.getFromLongitude();
		String destination = saveRideDto.getToLatitude() + "," + saveRideDto.getToLongitude();


		for (LatLng latLng : getDirectionsPathFromWebService(origin, destination)) {
			UserRideDetails userRideDetails = new UserRideDetails();
			userRideDetails.setCreatedDate(new Date());
			userRideDetails.setDateTime(userOfferRide.getDatetime());
			userRideDetails.setLatitude(latLng.lat + "");
			userRideDetails.setLongitude(latLng.lng + "");
			userRideDetails.setUpdatedDate(new Date());
			userRideDetails.setUserOfferRide(userOfferRide);		
			sessionFactory.getCurrentSession().save(userRideDetails);
		}
		
		
		responseDto.setMessage("success");
		responseDto.setStatus(200);
		return responseDto;
	}
	
	private List<LatLng> getDirectionsPathFromWebService(String origin, String destination) {
		List<LatLng> path = new ArrayList();

		// Execute Directions API request
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBrPt88vvoPDDn_imh-RzCXl5Ha2F2LYig").build();
		DirectionsApiRequest req = DirectionsApi.getDirections(context, origin, destination);
		try {
			DirectionsResult res = req.await();

			// Loop through legs and steps to get encoded polylines of each step
			if (res.routes != null && res.routes.length > 0) {
				DirectionsRoute route = res.routes[0];

				if (route.legs != null) {
					for (int i = 0; i < route.legs.length; i++) {
						DirectionsLeg leg = route.legs[i];
						if (leg.steps != null) {
							for (int j = 0; j < leg.steps.length; j++) {
								DirectionsStep step = leg.steps[j];
								if (step.steps != null && step.steps.length > 0) {
									for (int k = 0; k < step.steps.length; k++) {

										DirectionsStep step1 = step.steps[k];
										EncodedPolyline points1 = step1.polyline;
										if (points1 != null) {
											// Decode polyline and add points to list of route coordinates
											List<com.google.maps.model.LatLng> coords1 = points1.decodePath();
											for (com.google.maps.model.LatLng coord1 : coords1) {
												path.add(new LatLng(coord1.lat, coord1.lng));
											}
										}
									}
								} else {
									EncodedPolyline points = step.polyline;
									if (points != null) {
										// Decode polyline and add points to list of route coordinates
										List<com.google.maps.model.LatLng> coords = points.decodePath();

										//edited by me for getting lat long with some minimum gap
										for (int k = 0; k < coords.size(); k += 5) {
											path.add(new LatLng(coords.get(k).lat, coords.get(k).lng));
										}

										/*
										 * for (com.google.maps.model.LatLng coord : coords) { path.add(new
										 * LatLng(coord.lat, coord.lng)); }
										 */
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return path;
	}

}
