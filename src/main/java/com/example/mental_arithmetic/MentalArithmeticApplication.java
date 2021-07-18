package com.example.mental_arithmetic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MentalArithmeticApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentalArithmeticApplication.class, args);
	}

}
