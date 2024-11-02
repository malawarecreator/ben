package com.example.ben;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BenApplication {

	public static void main(String[] args) {
		System.out.println("Brought to you by Ben L, BitQuery, and coindesk");
		SpringApplication.run(BenApplication.class, args);
	}

}
