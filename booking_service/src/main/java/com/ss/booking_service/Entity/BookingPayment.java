package com.ss.booking_service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookingPayment {
    @Id
    private Integer booking_id;
    private String stripeId;
    private boolean refunded;
}
