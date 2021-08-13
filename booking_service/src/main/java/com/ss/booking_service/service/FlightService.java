package com.ss.booking_service.service;

import com.ss.booking_service.Entity.vo.FlightPrice;
import com.ss.booking_service.dao.FlightBookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightBookingsRepository flightBookingsRepository;

    public FlightPrice getFlightPrice(int id){

        List<Object[]> list = flightBookingsRepository.findFlightPriceById(id);
        Object[] o = list.get(0);
        FlightPrice flightPrice = new FlightPrice((Integer) o[0], (Float) o[1]);
        return flightPrice;
    }


}
