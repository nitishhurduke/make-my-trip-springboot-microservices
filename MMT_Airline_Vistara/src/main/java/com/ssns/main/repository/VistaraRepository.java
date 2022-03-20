package com.ssns.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssns.main.model.Flight;

@Repository
public interface VistaraRepository extends CrudRepository<Flight, Integer>{

	List<Flight> findByDate(String date);

	List<Flight> findBySourceAndDestnAndDate(String source, String destn, String date);

	List<Flight> findBySourceAndDestn(String source, String destn);

}
