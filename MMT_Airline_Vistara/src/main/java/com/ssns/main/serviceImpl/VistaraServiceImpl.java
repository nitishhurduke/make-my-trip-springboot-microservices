package com.ssns.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssns.main.model.Flight;
import com.ssns.main.repository.VistaraRepository;
import com.ssns.main.service.VistaraService;

@Service
public class VistaraServiceImpl implements VistaraService{

	@Autowired
	VistaraRepository repo;
	
	@Override
	public List<Flight> getAllFlights() {
		List<Flight> flights =(List<Flight>) repo.findAll();
		return  flights;
	}

	@Override
	public void addNewFlight(Flight flight) {
		repo.save(flight);
	}

	@Override
	public List<Flight> findByDate(String date) {
		List<Flight> flights = repo.findByDate(date);
		return flights;
	}

	@Override
	public List<Flight> findBySourceAndDestnAndDate(String source, String destn, String date) {
		return repo.findBySourceAndDestnAndDate(source,destn,date);
	}

	@Override
	public void addNewFlights(List<Flight> flights) {
		repo.saveAll(flights);
	}

	@Override
	public List<Flight> findBySourceAndDestnAndDate(String source, String destn) {
		return repo.findBySourceAndDestn(source, destn);
	}

	@Override
	public void updateFlight(Flight flight) {
		repo.save(flight);
	}

	@Override
	public void deleteFlight(int fid) {
			repo.deleteById(fid);
	}

}
