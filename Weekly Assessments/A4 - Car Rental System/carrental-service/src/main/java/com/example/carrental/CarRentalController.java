package com.example.carrental;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarRentalController {

    @GetMapping("/rentalcardetails")
    public String getCarDetails() {
        return "Car: Toyota | Price: 2500/day";
    }

    @GetMapping("/bookingdetails")
    public String getBookingDetails() {
        return "Booking ID: 101 | Status: Confirmed";
    }
}