package com.ss.booking_service.Entity.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightVO {
    private int id;
    private String originAirport;
    private String destinationAirport;
    private String originCity;
    private String destinationCity;
}
