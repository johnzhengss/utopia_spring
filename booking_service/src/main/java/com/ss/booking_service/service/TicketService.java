package com.ss.booking_service.service;

import com.ss.booking_service.Entity.*;
import com.ss.booking_service.Entity.vo.FlightPrice;
import com.ss.booking_service.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class TicketService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    BookingUserRepository bookingUserRepository;

    @Autowired
    BookingAgentRepository bookingAgentRepository;

    @Autowired
    BookingPaymentRepository bookingPaymentRepository;

    @Autowired
    FlightBookingsRepository flightBookingsRepository;

    @Autowired
    PaymentService paymentService;

    @Autowired
    FlightService flightService;

    @Autowired
    BookingService bookingService;



    public Booking buyTicket(Passenger p, Flight f, User user, User agent){
        //step 1 insert data
        Booking b = saveBookingData(p, f, user, agent);

        //send payment request
        if (b != null){

            BookingPayment bookingPayment = new BookingPayment();
            bookingPayment.setBooking_id(b.getId());

            FlightPrice flightPrice = flightService.getFlightPrice(f.getId());
            String stripeId = paymentService.paymentApiCall(flightPrice.getSeatPrice());
            if (stripeId == null || stripeId.isEmpty()){
                //Payment failed, set booking is_active to false
                bookingService.paymentFailedUpdate(b);
            } else {
                bookingPayment.setStripeId(stripeId);
                bookingPaymentRepository.save(bookingPayment);
            }
        }

        return b;
    }

    @Transactional
    public Booking saveBookingData(Passenger p, Flight f, User user, User agent){
        try{
            Booking b = new Booking();
            int randomNumber = new Random().nextInt(90000000) + 10000000;
            b.setConfirmationCode(Integer.toString(randomNumber));
            Booking newBooking = bookingRepository.save(b);
            if (newBooking.getId() > 0){
                p.setBooking(newBooking);
                passengerRepository.save(p);

                FlightBookings flightBookings = new FlightBookings();
                flightBookings.setBooking_id(newBooking.getId());
                flightBookings.setFlight_id(f.getId());
                flightBookingsRepository.save(flightBookings);

                BookingUser bookingUser = new BookingUser();
                bookingUser.setBooking_id(newBooking.getId());
                bookingUser.setUser_id(user.getId());
                bookingUserRepository.save(bookingUser);

                BookingAgent bookingAgent = new BookingAgent();
                bookingAgent.setBooking_id(newBooking.getId());
                bookingAgent.setAgent_id(agent.getId());
                bookingAgentRepository.save(bookingAgent);
            }
            return newBooking;
        }catch (Exception e){
            System.out.println("insert data error");
            return null;
        }
    }
}
