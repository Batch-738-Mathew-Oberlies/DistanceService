package com.revature.rideshare.distanceservice.controllers;

import com.google.maps.errors.ApiException;
import com.revature.rideshare.distanceservice.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class DistanceController {

	@Autowired
	DistanceService distanceService;

	@GetMapping("/")
	public Object get(@RequestParam(name = "api-key", required = false) Boolean apiKey) {
		if (apiKey != null && apiKey)
			return distanceService.getGoogleMAPKey();
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{address}")
	public Object getDistance(
			@RequestParam(name = "driver", required = false) Boolean driver,
			@RequestParam(name = "trip", required = false) Boolean trip,
			@RequestParam(name = "user_id", required = false) Integer userId,
			@PathVariable("address") String address)
			throws ApiException, InterruptedException, IOException {
		List<String> origins = new ArrayList<>();
		origins.add(address);
		if (driver != null && trip != null)
			return ResponseEntity.badRequest().build();
		if (driver != null && driver)
			return distanceService.findClosestDrivers(origins);
		if (trip != null)
			return distanceService.findClosestTrips(origins, userId == null ? 0 : userId);
		return ResponseEntity.badRequest().build();
	}
}
