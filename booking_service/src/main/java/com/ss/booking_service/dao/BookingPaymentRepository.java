package com.ss.booking_service.dao;

import com.ss.booking_service.Entity.BookingPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingPaymentRepository extends JpaRepository<BookingPayment, Integer> {
}
