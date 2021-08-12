package com.ss.flight_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ss.flight_service.dao.FlightDao;
import com.ss.flight_service.entity.Flight;

@Service
public class FlightService {
	
	@Autowired
	private FlightDao flightDao;
	
	@SuppressWarnings("unused")
	@Autowired
	private RestTemplate restTemplate;

	public Flight saveFlight(Flight flight) {
		return flightDao.save(flight);
	}

	public Optional<Flight> findFlightById(Integer flightId) {
		return flightDao.findById(flightId);
	}

	public List<Flight> findAllFlights() {
		return flightDao.findAll();
	}

	public String deleteFlightById(Integer flightId) {
		if (flightDao.existsById(flightId)) {
			flightDao.deleteById(flightId);
			return "Deleted flight at id: " + flightId;
		} else {
			return "Flight with id: " + flightId + " does not exist";
		}

	}

	public String updateFlight(Flight flight) {
		Optional<Flight> flightFromDb = flightDao.findById(flight.getFlightId());
		if (flightFromDb.isPresent()) {
			flightFromDb.get().setFlightId(flight.getFlightId());
			flightFromDb.get().setRouteId(flight.getRouteId());
			flightFromDb.get().setDepartureTime(flight.getDepartureTime());
			flightFromDb.get().setReservedSeats(flight.getReservedSeats());
			flightFromDb.get().setSeatPrice(flight.getSeatPrice());
			flightDao.save(flightFromDb.get());
			return "Updated: " + flightFromDb.get().toString();
		}
		return "Failed to update, flight with id: " + flight.getFlightId() + " does not exist";
	}
}