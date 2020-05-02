package com.revature.rideshare.distanceservice.services;

import com.revature.rideshare.distanceservice.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-service", url = "http://user-service:8080")
public interface UserService {
	@GetMapping("/?is-driver=true&is-active=true")
	List<User> getActiveDrivers();
}
