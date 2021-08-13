package com.ss.booking_service.Entity.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightPrice {
    private Integer id;
    private float seatPrice;
}
