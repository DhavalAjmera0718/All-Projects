package com.O_Auth2.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/demo")
public class O_Auth_Controller {

	
	
	@GetMapping("getdata")
	public ResponseEntity<String> Demodata()
	{
		return ResponseEntity.ok("Hello From Demo Data");
	}
 	
}
