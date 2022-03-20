package com.ssns.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MmtMakeMyTripBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmtMakeMyTripBackApplication.class, args);
	}

	@Bean
	public RestTemplate restTemp() {
		
		RestTemplate rest = new RestTemplate();
		
		return rest;
	}
	
}
