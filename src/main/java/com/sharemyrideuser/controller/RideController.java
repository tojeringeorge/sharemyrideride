package com.sharemyrideuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sharemyride.dto.ResponseDto;
import com.sharemyride.dto.SaveRideDto;
import com.sharemyride.service.RideService;
import com.sharemyride.validation.Validations;

@Controller
public class RideController {
	
	@Autowired
	private Validations validations;
	
	@Autowired
	private RideService rideService;

	@RequestMapping(value = "/saveRide", method = RequestMethod.POST)
	ResponseEntity<ResponseDto> saveRide(@RequestBody SaveRideDto saveRideDto) {
		ResponseDto responseDto = new ResponseDto();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (validations.saveRideValidation(saveRideDto).getStatus() != 200) {
			responseDto = validations.saveRideValidation(saveRideDto);
			return ResponseEntity.ok().headers(responseHeaders).body(responseDto);
		} else {
			responseDto = rideService.saveRide(saveRideDto);
			return ResponseEntity.ok().headers(responseHeaders).body(responseDto);
		}

	}
	
	
}
