package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringbootMicroServiceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroServiceEurekaServerApplication.class, args);
	}

}
