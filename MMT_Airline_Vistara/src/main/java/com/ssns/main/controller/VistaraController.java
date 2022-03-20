package com.ssns.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssns.main.model.Flight;
import com.ssns.main.service.VistaraService;

@RestController
public class VistaraController {

	@Autowired
	VistaraService service;

	@PostMapping("/flight")
	public String addNewFlight(@RequestBody Flight flight) {
		service.addNewFlight(flight);
		return "flight added Successfully...";
	}
	@PostMapping("/flights")
	public String addNewFlight(@RequestBody List<Flight> flights) {
		service.addNewFlights(flights);
		return "flights added Successfully...";
	}

	@GetMapping("/flights")
	public List<Flight> getAllFlights() {
		List<Flight> flights = service.getAllFlights();
		return flights;
	}

	@GetMapping("/flights/{date}")
	public List<Flight> findFlightByDate(@PathVariable("date") String date) {
		List<Flight> flights = service.findByDate(date);
		return flights;
	}
	
	@GetMapping("/flights/{src}/{destn}/{dt}")
	public List<Flight> searchFlights(@PathVariable("src") String source,@PathVariable("destn") String destn,@PathVariable("dt") String date) {
		List<Flight> flights = service.findBySourceAndDestnAndDate(source,destn,date);
		return flights;
	}
	
	@GetMapping("/flights/{src}/{destn}")
	public List<Flight> searchFlights(@PathVariable("src") String source,@PathVariable("destn") String destn) {
		List<Flight> flights = service.findBySourceAndDestnAndDate(source,destn);
		return flights;
	}
	@PatchMapping("/flight")
	public String updateFlight(@RequestBody Flight flight)
	{
		service.updateFlight(flight);
		return "flight updated Successfully";
	}
	@DeleteMapping("/flight/{fid}")
	public String deleteFlight(@PathVariable("fid") int fid)
	{
		service.deleteFlight(fid);
		return "Flight Deleted Successfully...";
	}
}
