package com.revature.rideshare.distanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy
@ServletComponentScan
public class DistanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistanceServiceApplication.class, args);
	}

}
