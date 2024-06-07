package com.example.Book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

@SpringBootApplication
public class BookDbms1Application {

	public static void main(String[] args) {
		SpringApplication.run(BookDbms1Application.class, args);
	}
	
	@Bean
	Faker faker() 
	{
		return new Faker();
	}

}
