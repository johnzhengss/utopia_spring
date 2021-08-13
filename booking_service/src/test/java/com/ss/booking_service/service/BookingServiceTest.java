package com.ss.booking_service.service;

import com.ss.booking_service.Entity.Booking;
import com.ss.booking_service.Entity.FlightBookings;
import com.ss.booking_service.dao.FlightBookingsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTest {
    @Autowired
    BookingService service;

    @Autowired
    FlightBookingsRepository flightBookingsRepository;

    @Test
    public void getBookingById() {
        Booking booking = service.getBookingById(1);
        System.out.println(booking);
    }

    @Test
    public void addBooking(){
        Booking b = new Booking();
        b.setConfirmationCode("67480470");
        Booking booking = service.addBooking(b);
        System.out.println(booking);
    }

    @Test
    public void cancelBooking(){
        Booking b = service.getBookingById(12);
        Booking re = service.cancelBooking(b);
        System.out.println(re);
    }

    @Test
    public void deleteBookingById(){
        service.deleteBookingById(13);
    }

    @Test
    public void getFlightByBookingId(){
        List<FlightBookings> list = service.getFlightByBookingId(4);
        System.out.println(list);
    }

}
