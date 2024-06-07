package com.DemoOld_Security.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DemoOld_Security.Entity.user;
import com.DemoOld_Security.Service.JWT_Service;

@RestController
public class JWT_Controller {

	@Autowired
	private JWT_Service service;
	
	@GetMapping("/HomePage")
	public String Homepage()
	{
		return "Welcome To Home Page";
	}
	
	@GetMapping("/users")
	public List<user> getUser() 
	{
		System.err.println("USERRRRRR");
		return this.service.Get_All_user();
	}
	
	@GetMapping("/Current_User")
	public String LoggedIn_User(Principal principal) 
	{
		return principal.getName();
	}
	
}
