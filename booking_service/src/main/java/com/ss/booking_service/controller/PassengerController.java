package com.ss.booking_service.controller;

import com.ss.booking_service.Entity.Passenger;
import com.ss.booking_service.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/booking")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @GetMapping("/passenger")
    public ResponseEntity<?> getPassengerById(@RequestParam Integer pid){
        Passenger p = passengerService.getPassengerById(pid);
        if (p != null){
            return ResponseEntity.status(200).body(p);
        }
        return ResponseEntity.status(404).body("");
    }

    @PutMapping("/passenger")
    public ResponseEntity<?> updatePassenger(@RequestBody Passenger passenger){
        Passenger p = passengerService.updatePassenger(passenger);
        if (p != null){
            return ResponseEntity.status(200).body(p);
        }
        return ResponseEntity.status(404).body("");
    }

}
