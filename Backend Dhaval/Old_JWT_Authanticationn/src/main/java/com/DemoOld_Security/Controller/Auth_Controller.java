package com.DemoOld_Security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DemoOld_Security.Entity.Old_JWT_Entity;
import com.DemoOld_Security.Helper.JWT_Helper;
import com.DemoOld_Security.Implimantation.Old_Jwt_Implimantation;
import com.DemoOld_Security.Req_Response.Jwt_Request;
import com.DemoOld_Security.Req_Response.Jwt_Response;
import com.DemoOld_Security.Roll_User.User_Roll;

@RestController
public class Auth_Controller {

	@Autowired
	private AuthenticationManager authenticationManager;
	
//	@Autowired
//	private Old_Jwt_Implimantation implimantation;
	
	@Autowired
	private User_Roll userDetailsService;
	
	@Autowired
	private JWT_Helper helper;
	
	@PostMapping("/Add_User")
	public ResponseEntity<String> Add_User(@RequestBody Old_JWT_Entity request)
	{
		return new ResponseEntity<String>(userDetailsService.Add_User(request) , HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Admin_User")
	public String Checkingapi_Admin() 
	{
		return "This Api is for Checking ADMIN.......";
	}
	
	@GetMapping("/Normal_User")
	public String Checkingapi_NormalUser() 
	{
		return "This Api is for Checking Normal User.......";
	}
	
	@GetMapping("/Public_Api")
	public String Public_Api() 
	{
		return "Public Api is Working Correctly..";
	}	
	
	
	@PostMapping("/login")
	public ResponseEntity<Jwt_Response> Login(@RequestBody Jwt_Request request)
	{System.err.println(request);

		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
			
			
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}
		
//		UserDetails userByUsername = implimantation.loadUserByUsername(request.getUserName());
		UserDetails userByUsername2 = userDetailsService.loadUserByUsername(request.getUserName());
		String token = helper.generateToken(userByUsername2);
		System.err.println(token);
		
		return new ResponseEntity<>(new Jwt_Response(token),HttpStatus.ACCEPTED);
		
	}
}
