package com.ss.booking_service;


import com.ss.booking_service.Entity.vo.FlightPrice;
import com.ss.booking_service.dao.FlightBookingsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceApplicationTests {

    @Autowired
    FlightBookingsRepository flightBookingsRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        List<Object[]> list = flightBookingsRepository.findFlightPriceById(1107);
        System.out.println(list.get(0));
        Object[] o = list.get(0);
        FlightPrice flightPrice = new FlightPrice((Integer) o[0], (Float) o[1]);
        System.out.println(flightPrice);

    }


}
