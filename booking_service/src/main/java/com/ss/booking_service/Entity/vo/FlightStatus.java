package com.ss.booking_service.Entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightStatus {
    private int id;
    private int routeId;
    private int airplaneId;
    private LocalDateTime departureTime;
    private int reservedSeats;
    private float seatPrice;
    private int maxCapacity;
    private int passengerCount;
    private int availableSeats;

}
