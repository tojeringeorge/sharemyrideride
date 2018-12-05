package com.sharemyride.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sharemyride.dto.ResponseDto;
import com.sharemyride.dto.SaveRideDto;
import com.sharemyride.dto.UserRequestDto;
import com.sharemyride.service.ValidtionSevice;

@Component
public class Validations {
	
	@Autowired
	private ValidtionSevice validtionSevice;
	
	public ResponseDto userValidation(UserRequestDto userRequestDto) {
		ResponseDto responseDto = new ResponseDto();
	if (!validtionSevice.emptyNullValidation(userRequestDto.getCompany())) {
		responseDto.setMessage("Company null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if (!validtionSevice.emptyNullValidation(userRequestDto.getEmail())) {
		responseDto.setMessage("Email null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if (!validtionSevice.emailFormatValidation(userRequestDto.getEmail())) {
		responseDto.setMessage("Email format invalid");
		responseDto.setStatus(101);
		return responseDto;
	} else if (!validtionSevice.emptyNullValidation(userRequestDto.getGender())) {
		responseDto.setMessage("Gender null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if(!validtionSevice.genderValidtion(userRequestDto.getGender())){
		responseDto.setMessage("Gender Invalid");
		responseDto.setStatus(101);
		return responseDto;
	} else if(!validtionSevice.emptyNullValidation(userRequestDto.getName())){
		responseDto.setMessage("Name null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if(!validtionSevice.StringOnlyValidation(userRequestDto.getName())){
		responseDto.setMessage("Name Invalid");
		responseDto.setStatus(101);
		return responseDto;
	} else if(!validtionSevice.emptyNullValidation(userRequestDto.getPhone())){
		responseDto.setMessage("Phone null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if(!validtionSevice.numberFormatValidation(userRequestDto.getPhone())){
		responseDto.setMessage("Phone Invalid");
		responseDto.setStatus(101);
		return responseDto;
	}
	responseDto.setMessage("success");
	responseDto.setStatus(200);
	return responseDto;
	
	}
	
	public ResponseDto saveRideValidation(SaveRideDto saveRideDto) {
		ResponseDto responseDto = new ResponseDto();
	if (!validtionSevice.emptyNullValidation(saveRideDto.getDateTime())) {
		responseDto.setMessage("Time null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if (!validtionSevice.emptyNullValidation(saveRideDto.getFromLatitude())) {
		responseDto.setMessage("From Latitude null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if (!validtionSevice.decimalFormatValidation(saveRideDto.getFromLatitude())) {
		responseDto.setMessage("From Latitude format invalid");
		responseDto.setStatus(101);
		return responseDto;
	} else if (!validtionSevice.emptyNullValidation(saveRideDto.getFromLongitude())) {
		responseDto.setMessage("From Longitude null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if(!validtionSevice.decimalFormatValidation(saveRideDto.getFromLongitude())){
		responseDto.setMessage("From Longitude Invalid");
		responseDto.setStatus(101);
		return responseDto;
	} else if(!validtionSevice.emptyNullValidation(saveRideDto.getToLatitude())){
		responseDto.setMessage("To Latitude null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if(!validtionSevice.decimalFormatValidation(saveRideDto.getToLatitude())){
		responseDto.setMessage("To Latitude Invalid");
		responseDto.setStatus(101);
		return responseDto;
	} else if(!validtionSevice.emptyNullValidation(saveRideDto.getToLongitude())){
		responseDto.setMessage("To Longitude null or empty");
		responseDto.setStatus(100);
		return responseDto;
	} else if(!validtionSevice.decimalFormatValidation(saveRideDto.getToLongitude())){
		responseDto.setMessage("To Longitude Invalid");
		responseDto.setStatus(101);
		return responseDto;
	}  else if(!validtionSevice.numberFormatValidation(saveRideDto.getUserId() + "")){
		responseDto.setMessage("user id Invalid");
		responseDto.setStatus(101);
		return responseDto;
	}  else if(!validtionSevice.dateFormatValidation(saveRideDto.getDateTime())){
		responseDto.setMessage("date format Invalid");
		responseDto.setStatus(101);
		return responseDto;
	} else if(!validtionSevice.numberFormatValidation(saveRideDto.getVechileId() + "")){
		responseDto.setMessage("vechile id Invalid");
		responseDto.setStatus(101);
		return responseDto;
	}
	responseDto.setMessage("success");
	responseDto.setStatus(200);
	return responseDto;
	
	}
}
