package com.ss.booking_service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private Integer id;
    private Route route;
    private Airplane airplane;
    private LocalDateTime departureTime;
    private int reservedSeats;
    private float seatPrice;
}
