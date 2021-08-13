package com.ss.booking_service.service;

import com.ss.booking_service.Entity.Booking;
import com.ss.booking_service.Entity.Passenger;
import com.ss.booking_service.dao.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public Passenger getPassengerById(int id){
        try{
            Optional<Passenger> option = passengerRepository.findById(id);
            return option.get();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    public Passenger addPassenger(Passenger passenger){
        Passenger p = passengerRepository.save(passenger);
        return p;
    }

    public Passenger updatePassenger(Passenger passenger){
        Passenger p;
        try{
            p = getPassengerById(passenger.getId());
            if (p != null){
                p = passengerRepository.save(passenger);
            }
            return p;
        }catch (Exception e){
            System.out.println(e);
            return passenger;
        }

    }

    public List<Passenger> getPassengersByBookingId(int id){
        List<Passenger> list = passengerRepository.findAllByBookingId(id);
        return list;
    }


}
