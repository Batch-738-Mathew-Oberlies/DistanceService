package com.revature.rideshare.distanceservice.services;

import com.revature.rideshare.distanceservice.models.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "trip-service", url = "http://trip-service:8080")
public interface TripService {
	@GetMapping("/?current=true")
	List<Trip> getCurrentTrips();
}
