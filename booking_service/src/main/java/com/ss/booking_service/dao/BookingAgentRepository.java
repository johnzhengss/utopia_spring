package com.ss.booking_service.dao;

import com.ss.booking_service.Entity.BookingAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingAgentRepository extends JpaRepository<BookingAgent, Integer> {
}
