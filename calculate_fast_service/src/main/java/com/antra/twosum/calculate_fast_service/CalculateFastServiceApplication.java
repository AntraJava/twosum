package com.antra.twosum.calculate_fast_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CalculateFastServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateFastServiceApplication.class, args);
	}

}
