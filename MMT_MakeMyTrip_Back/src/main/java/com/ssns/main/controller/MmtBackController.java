package com.ssns.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ssns.main.model.Flight;

@RestController
@CrossOrigin
public class MmtBackController {

	@Autowired
	RestTemplate restTemp;
	
	@GetMapping("/flights/{src}/{destn}")
	public List<Flight> searchFlights(@PathVariable("src") String source,@PathVariable("destn") String destn){
		System.out.println("Source: "+source);
		System.out.println("Destination: "+destn);
		String urlIndigo = "http://localhost:8081/flights/"+source+"/"+destn;
		List<Flight> flights = restTemp.getForObject(urlIndigo, List.class);
		String urlVistara = "http://localhost:8082/flights/"+source+"/"+destn;
		flights.addAll( restTemp.getForObject(urlVistara, List.class));
		
		return flights;
	}
	
}
