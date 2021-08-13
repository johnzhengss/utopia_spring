package com.ss.booking_service.service;

import com.ss.booking_service.Entity.Passenger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PassengerServiceTest {

    @Autowired
    PassengerService passengerService;

    @Test
    public void getPassengerById() {
        Passenger p = passengerService.getPassengerById(13);
        System.out.println(p);
    }

    @Test
    public void addPassenger(){
        Passenger p = passengerService.getPassengerById(2);
        p.setId(null);
        p.setGivenName("Lancy");
        passengerService.addPassenger(p);
    }

    @Test
    public void updatePassenger(){
        Passenger p = passengerService.getPassengerById(2);
        p.setFamilyName("Fool");
        passengerService.updatePassenger(p);
    }

    @Test
    public void getPassengersByBooking(){
        List<Passenger> list = passengerService.getPassengersByBookingId(3);
        System.out.println(list);
    }



}
