package com.New_JWT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.New_JWT.DToo.New_Jwt_DTO;
import com.New_JWT.Entity.New_EntityMain;
import com.New_JWT.Request_Response.Jwt_Request;
import com.New_JWT.Request_Response.Jwt_Response;
import com.New_JWT.Service.JWT_Service;
import com.New_JWT.Utils.JWT_Utils;

@RestController
public class New_Jwt_Controller {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWT_Utils jwt_Utils;
	
	@Autowired
	private JWT_Service service;

	@PostMapping("/login")
	public ResponseEntity<Jwt_Response> Login(@RequestBody Jwt_Request request) {
		System.err.println("JWT Request From Main Controller------" + request);

		if (request != null) {
			try {

				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassWord()));

			} catch (Exception e) {

				throw new UsernameNotFoundException("Bad Credentials");
			}
		}

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
		String jwtToken = null;

		if (userDetails != null) {
			jwtToken = jwt_Utils.generateToken(userDetails);
		}

		return new ResponseEntity<Jwt_Response>(new Jwt_Response(jwtToken), HttpStatus.CREATED);

	}

	/********************************************************************************************************************************************/

	@GetMapping("/public")
	public ResponseEntity<String> Public_Api() {
		return new ResponseEntity<String>("This is Public Api For Checkinng", HttpStatus.OK);
	}
	
	@GetMapping("/Checking")
	public ResponseEntity<String> Checking_Api() {
		return new ResponseEntity<String>("This is Checking For Checkinng", HttpStatus.OK);
	}
	
	@PostMapping("/Add_User")
	public ResponseEntity<String> Add_User(@RequestBody New_Jwt_DTO entityMain) 
	{
		return new ResponseEntity<String>(service.Add_User(entityMain) , HttpStatus.CREATED);
	}


}
