package com.ss.booking_service.dao;

import com.ss.booking_service.Entity.FlightBookings;
import com.ss.booking_service.Entity.vo.FlightPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookingsRepository extends JpaRepository<FlightBookings, Integer> {
    @Query(value="select * from flight_bookings where booking_id=?1", nativeQuery=true)
    List<FlightBookings> findAllByBookingId(int id);

    @Query(value="select * from flight_bookings where flight_id=?1", nativeQuery=true)
    List<FlightBookings> findAllByFlightId(int id);

    @Query(value="select id, seat_price from flight f where id=?1",nativeQuery=true)
    List<Object[]> findFlightPriceById(int id);
}
