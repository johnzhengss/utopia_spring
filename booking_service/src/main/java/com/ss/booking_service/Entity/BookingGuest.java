package com.ss.booking_service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookingGuest {
    @Id
    private int bookingId;
    private String contactEmail;
    private String contactPhone;
}
