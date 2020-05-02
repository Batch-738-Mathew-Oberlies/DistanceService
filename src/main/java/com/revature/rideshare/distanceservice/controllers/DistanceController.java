package com.revature.rideshare.distanceservice.controllers;

import com.google.maps.errors.ApiException;
import com.revature.rideshare.distanceservice.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
			@PathVariable("address") String address)
			throws ApiException, InterruptedException, IOException {
		if ((driver != null && trip != null) && (driver && trip))
			return ResponseEntity.badRequest().build();
		if (driver != null && driver)
			return distanceService.distanceMatrix(new String[]{address});
		// if (trip != null && trip)
		//      return distanceService.getTrip();
		return ResponseEntity.badRequest().build();
	}
}
