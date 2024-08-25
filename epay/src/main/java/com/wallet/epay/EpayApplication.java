package com.wallet.epay;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the ePay application.
 *
 * Author: Rajkumar Karnakar
 *
 * This class serves as the entry point for the Spring Boot application.
 * It implements CommandLineRunner to execute additional code at startup.
 */
@SpringBootApplication
public class EpayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EpayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from run");
	}
}
