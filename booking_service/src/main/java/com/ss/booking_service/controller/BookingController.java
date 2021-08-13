package com.ss.booking_service.controller;

import com.ss.booking_service.Entity.Booking;
import com.ss.booking_service.Entity.Flight;
import com.ss.booking_service.Entity.Passenger;
import com.ss.booking_service.Entity.User;
import com.ss.booking_service.service.BookingService;
import com.ss.booking_service.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/test")
    public String test(){
        return "hello booking";
    }

    @GetMapping("")
    public ResponseEntity<?> getBookingById(@RequestParam int id){
        Booking b = bookingService.getBookingById(id);
        if(b != null){
            return ResponseEntity.status(200).body(b);
        }
        return ResponseEntity.status(404).body("");
    }

    /**
     * {
     *     "flightId": "2369",
     *     "givenName": "Lisa",
     *     "familyName": "Tan",
     *     "dob": "03/17/1990",
     *     "gender": "f",
     *     "address": "lancaster,pa",
     *     "userId": "3",
     *     "agentId": "4"
     * }
     * @param data
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Object> buyTicket(@RequestBody Map<String, String> data) {

        try {
            Flight flight = new Flight();
            flight.setId(Integer.parseInt(data.get("flightId")));

            Passenger p = new Passenger();
            p.setGivenName(data.get("givenName"));
            p.setFamilyName(data.get("familyName"));
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            p.setDob(df.parse(data.get("dob")));
            p.setGender(data.get("gender"));
            p.setAddress(data.get("address"));

            User user = new User();
            user.setId(Integer.parseInt(data.get("userId")));

            User agent = new User();
            agent.setId(Integer.parseInt(data.get("agentId")));

            Booking b = ticketService.buyTicket(p, flight, user, agent);

            return ResponseEntity.status(201).body(b);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).body("data error");
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> cancelTicket(@RequestBody Booking booking){
        Booking b = bookingService.cancelBooking(booking);
        return ResponseEntity.status(200).body(b);
    }

}
