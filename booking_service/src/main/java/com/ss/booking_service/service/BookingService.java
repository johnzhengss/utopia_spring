package com.ss.booking_service.service;

import com.ss.booking_service.Entity.Booking;
import com.ss.booking_service.Entity.BookingPayment;
import com.ss.booking_service.Entity.FlightBookings;
import com.ss.booking_service.Entity.Passenger;
import com.ss.booking_service.dao.BookingPaymentRepository;
import com.ss.booking_service.dao.BookingRepository;
import com.ss.booking_service.dao.FlightBookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FlightBookingsRepository flightBookingsRepository;

    @Autowired
    BookingPaymentRepository bookingPaymentRepository;

    @Autowired
    PaymentService paymentService;

    public Booking getBookingById(int id){
        try {
            Optional<Booking> optional = bookingRepository.findById(id);
            return optional.get();
        }catch (Exception e){
            return null;
        }
    }

    public Booking addBooking(Booking booking){
        Booking b = bookingRepository.save(booking);
        return b;
    }

    public void deleteBookingById(int id){
        bookingRepository.deleteById(id);
    }


    @Transactional
    public Booking cancelBooking(Booking booking){
        try{
            Optional<BookingPayment> optional = bookingPaymentRepository.findById(booking.getId());
            BookingPayment bookingPayment = optional.get();
            if (bookingPayment.isRefunded()){
                return booking;
            }
            if (!paymentService.refundApiCall(bookingPayment.getStripeId())){
                return booking;
            }
            bookingPayment.setRefunded(true);
            bookingPaymentRepository.save(bookingPayment);
            booking.setActive(false);
            Booking b = bookingRepository.save(booking);
            return b;
        }catch (Exception e){
            System.out.println(e);
            return booking;
        }
    }


    public Booking paymentFailedUpdate(Booking booking){
        booking.setActive(false);
        Booking b = bookingRepository.save(booking);
        return b;
    }

    public List<FlightBookings> getFlightByBookingId(int booking_id){
        List<FlightBookings> list = flightBookingsRepository.findAllByBookingId(booking_id);
        return list;
    }

}
