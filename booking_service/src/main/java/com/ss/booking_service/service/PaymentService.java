package com.ss.booking_service.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    public String paymentApiCall(Float price){
        try {
            Thread.sleep(100);
            int randomNumber = new Random().nextInt(900000000) + 100000000;
            return Integer.toString(randomNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "";
    }

    public boolean refundApiCall(String stripeId){
        try {
            Thread.sleep(100);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

}
