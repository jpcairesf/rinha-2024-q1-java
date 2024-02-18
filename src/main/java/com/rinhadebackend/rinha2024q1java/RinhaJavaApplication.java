package com.rinhadebackend.rinha2024q1java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RinhaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RinhaJavaApplication.class, args);
	}

}
