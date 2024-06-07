package com.practise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.practise.Controller.FirstAnotation;

@SpringBootApplication
@EnableDiscoveryClient
@FirstAnotation(myValue = 101)
public class PractiseForProductionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractiseForProductionApplication.class, args);
		System.err.println("MAIN FILE");
		
		PractiseForProductionApplication p = new PractiseForProductionApplication();
		Class<? extends PractiseForProductionApplication> class1 = p.getClass();
		System.err.println("CLass Name From main File ---->" + class1.getName());
		
		FirstAnotation annotation = class1.getAnnotation(FirstAnotation.class);
		
		System.err.println("Value From Annotation----->" + annotation.myValue());
		System.err.println("Name Fro  Annotation----->" + annotation.name());
		System.err.println("City From Annotation----->" + annotation.city());
		
	}
	
	

}
