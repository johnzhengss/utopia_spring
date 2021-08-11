package com.ss.flight_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.flight_service.dao.FlightDao;
import com.ss.flight_service.entity.Flight;

@Service
public class FlightService {
	
	@Autowired
	private FlightDao flightDao;

	public Flight saveFlight(Flight flight) {
		return flightDao.save(flight);
	}

	public Flight findFlightById(Integer flightId) {
		return flightDao.getById(flightId);
	}

	public List<Flight> findAllFlights() {
		return flightDao.findAll();
	}
}
