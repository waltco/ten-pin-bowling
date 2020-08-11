package com.jobsity.tenpinbowling;

import com.jobsity.tenpinbowling.service.TenPinBowlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TenPinBowlingApplication implements CommandLineRunner {

	@Autowired
	TenPinBowlingService tenPinBowlingService;

	public static void main(String[] args) {
		SpringApplication.run(TenPinBowlingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tenPinBowlingService.run();
	}
}
