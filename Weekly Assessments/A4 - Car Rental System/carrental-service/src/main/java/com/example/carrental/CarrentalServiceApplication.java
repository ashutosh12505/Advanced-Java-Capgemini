package com.example.carrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CarrentalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrentalServiceApplication.class, args);
	}

}
