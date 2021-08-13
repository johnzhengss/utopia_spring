package com.ss.booking_service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    private Integer id;
    private Airport originAirport;
    private Airport destAirport;
    private List<Flight> flights;
}
