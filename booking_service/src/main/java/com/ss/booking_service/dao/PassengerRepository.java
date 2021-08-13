package com.ss.booking_service.dao;

import com.ss.booking_service.Entity.Passenger;
import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

    @Query(value="select * from passenger where booking_id=?1", nativeQuery=true)
    List<Passenger> findAllByBookingId(int id);
}
