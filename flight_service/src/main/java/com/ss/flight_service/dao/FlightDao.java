package com.ss.flight_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.flight_service.entity.Flight;


@Repository
public interface FlightDao extends JpaRepository<Flight, Integer> {

}