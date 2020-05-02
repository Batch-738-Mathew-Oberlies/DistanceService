package com.revature.rideshare.distanceservice.services;

import com.google.maps.errors.ApiException;
import com.revature.rideshare.distanceservice.models.User;

import java.io.IOException;
import java.util.List;

public interface DistanceService {

	List<User> distanceMatrix(String[] origins) throws ApiException, InterruptedException, IOException;

	// Place key googleMapAPIKey & value apiKey (to be shared on slack) into Environment Vars.
	String getGoogleMAPKey();

}
