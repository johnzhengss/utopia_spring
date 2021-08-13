package com.ss.booking_service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FlightBookings {


    private Integer flight_id;
    @Id
    private Integer booking_id;

}
