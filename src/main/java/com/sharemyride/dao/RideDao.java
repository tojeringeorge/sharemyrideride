package com.sharemyride.dao;

import com.sharemyride.dto.ResponseDto;
import com.sharemyride.dto.SaveRideDto;

public interface RideDao {
	ResponseDto saveRide(SaveRideDto saveRideDto);
}
