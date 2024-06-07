package com.example.Mapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

@SpringBootApplication
public class EmployeeMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMappingApplication.class, args);
	}

	@Bean
	Faker feker()
	{
		return new Faker();
	}
}
