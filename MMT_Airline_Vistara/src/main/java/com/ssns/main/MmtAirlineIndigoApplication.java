package com.ssns.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@EntityScan
public class MmtAirlineIndigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmtAirlineIndigoApplication.class, args);
	}

}
