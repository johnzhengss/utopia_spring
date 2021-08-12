package com.ss.flight_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.flight_service.entity.Flight;
import com.ss.flight_service.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private FlightService flightService;

	@GetMapping("/")
	public List<Flight> getAllFlights() {
	    return flightService.findAllFlights();
	}
    
    @PostMapping("/")
    public Flight saveFlight(@RequestBody Flight flight) {
    	return flightService.saveFlight(flight);
    }
    
    @PutMapping("/")
    public String updateFlight(@RequestBody Flight flight) {
    	return flightService.updateFlight(flight);
    }
        
    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable("id") Integer flightId) {
    	return flightService.findFlightById(flightId);
    }
    
    @DeleteMapping("/{id}")
    public String deleteFlightById(@PathVariable("id") Integer flightId) {
    	return flightService.deleteFlightById(flightId);
    }
    
    
    
}
