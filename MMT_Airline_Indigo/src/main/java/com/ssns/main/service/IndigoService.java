package com.ssns.main.service;

import java.util.List;

import com.ssns.main.model.Flight;

public interface IndigoService {

	List<Flight> getAllFlights();

	void addNewFlight(Flight flight);

	List<Flight> findByDate(String date);

	List<Flight> findBySourceAndDestnAndDate(String source, String destn, String date);

	void addNewFlights(List<Flight> flights);

	List<Flight> findBySourceAndDestnAndDate(String source, String destn);

	void updateFlight(Flight flight);

	void deleteFlight(int fid);

}
