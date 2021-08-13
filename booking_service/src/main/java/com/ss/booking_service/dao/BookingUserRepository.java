package com.ss.booking_service.dao;

import com.ss.booking_service.Entity.BookingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingUserRepository extends JpaRepository<BookingUser, Integer> {
}
