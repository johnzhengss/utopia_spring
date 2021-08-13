package com.ss.booking_service.controller;

import com.ss.booking_service.Entity.FlightBookings;
import com.ss.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class FlightController {

    @Autowired
    private RestTemplate template;

    @Autowired
    BookingService bookingService;

    @GetMapping("/{bid}/flight")
    public ResponseEntity<?> getFlightByBookingId(@PathVariable Integer bid){
        List<FlightBookings> list = bookingService.getFlightByBookingId(bid);
        if (list != null && list.size() > 0){
            return ResponseEntity.status(200).body(list);
        }

        return ResponseEntity.status(404).body("");
    }

    @GetMapping("/flight")
    public ResponseEntity<?> getFlight(@RequestParam Integer fid){
        String url = String.format("http://%s/flights/" + fid, "FLIGHT");
        String result = template.getForObject(url, String.class);
        return ResponseEntity.status(200).body(result);
    }
}
