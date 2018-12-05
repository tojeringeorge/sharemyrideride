package com.sharemyride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemyride.dao.RideDao;
import com.sharemyride.dto.ResponseDto;
import com.sharemyride.dto.SaveRideDto;

@Service
public class RideServiceImpl implements RideService{
	
	@Autowired
	private RideDao rideDao;

	@Override
	public ResponseDto saveRide(SaveRideDto saveRideDto) {
		return rideDao.saveRide(saveRideDto);
	}

}
