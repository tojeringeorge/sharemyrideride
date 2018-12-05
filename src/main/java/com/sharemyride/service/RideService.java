package com.sharemyride.service;

import com.sharemyride.dto.ResponseDto;
import com.sharemyride.dto.SaveRideDto;

public interface RideService {
 ResponseDto saveRide(SaveRideDto saveRideDto);
}
