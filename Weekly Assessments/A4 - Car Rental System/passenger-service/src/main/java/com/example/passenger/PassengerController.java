package com.example.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PassengerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/passengerdetails")
    public String getPassengerDetails() {

        String carDetails =
        restTemplate.getForObject(
        "http://localhost:6607/rentalcardetails",
        String.class);

        return "Passenger: Ashutosh | Car Info: " + carDetails;
    }
}