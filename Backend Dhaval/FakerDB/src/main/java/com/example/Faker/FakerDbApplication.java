package com.example.Faker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.github.javafaker.Faker;

@SpringBootApplication
public class FakerDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakerDbApplication.class, args);
		
		/*
		 * for(int i =1;i<=50;i++) {
		 * 
		 * Faker feker = new Faker(); String lastName = feker.name().firstName(); String
		 * FastName = feker.name().lastName(); System.out.println(FastName + ' ' +
		 * lastName); }
		 */
		
		
	}	
	@Bean
	Faker feker() 
	{
		return new Faker();
	}
	@Bean
	RestTemplate resttemp() 
	{
		return new RestTemplate();
	}
}
