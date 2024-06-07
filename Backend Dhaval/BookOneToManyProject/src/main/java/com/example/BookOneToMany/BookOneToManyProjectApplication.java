package com.example.BookOneToMany;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookOneToManyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookOneToManyProjectApplication.class, args);
	}
	
	@Bean
	ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
