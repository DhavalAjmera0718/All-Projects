package com.DemoOld_Security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo_Controller {

	
	@GetMapping("/home")
	public String Home() 
	{
		return "Home Data";
	}
	@GetMapping("/about")
	public String about() 
	{
		return "about Data";
	}
	@GetMapping("/service")
	public String service() 
	{
		return "service Data";
	}
	@GetMapping("/public")
	public String publicc() 
	{
		return "Home Data";
	}
	
	
}

