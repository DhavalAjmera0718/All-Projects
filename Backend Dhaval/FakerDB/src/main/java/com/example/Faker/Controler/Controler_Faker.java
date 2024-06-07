package com.example.Faker.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Faker.Implimantation.Implimantation_Faker;

@RestController
public class Controler_Faker {

	@Autowired
	private Implimantation_Faker fc;

	@GetMapping("/GetData")
	public String GetData() 
	{
		return fc.GetData();
	}
}
