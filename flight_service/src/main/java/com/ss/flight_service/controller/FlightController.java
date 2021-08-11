package com.ss.flight_service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.flight_service.dao.FlightDao;
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
    public Flight saveFlight(@Valid @RequestBody Flight flight) {
    	return flightService.saveFlight(flight);
    }
    
    @GetMapping("/{id}")
    public Flight findFlightById(@PathVariable("id") Integer flightId) {
    	return flightService.findFlightById(flightId);
    }
    
    
    
}
