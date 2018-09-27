package com.eventmanagerapi.eventmanagerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = {EventManagerApiApplication.class, Jsr310Converters.class})
public class EventManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagerApiApplication.class, args);
	}
}
