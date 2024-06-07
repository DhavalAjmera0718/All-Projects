package com.Auth.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Auth.ENTITY.Credential_Entity;
import com.Auth.Response_X_Request.Jwt_Request;
import com.Auth.Response_X_Request.Jwt_Response;
import com.Auth.Service.Authentication_Service;


@RestController
//@RequestMapping("/auth")
public class AuthController {

	
	@Autowired
	private Authentication_Service authService;
	


	@PostMapping("/RegisterUser")
	public ResponseEntity<String> RegisterUser(@RequestBody Credential_Entity cEntity) 
	{
		return new ResponseEntity<String>(authService.RegisterUser(cEntity),HttpStatus.CREATED);
	} 

	@PostMapping("/RegisterAdmin")
	public ResponseEntity<String> RegisterAdmin(@RequestBody Credential_Entity cEntity) 
	{
		return new ResponseEntity<String>(authService.RegisterAdmin(cEntity),HttpStatus.CREATED);
	} 
	
	@PostMapping("/registerTeacher")
	public ResponseEntity<String> RegisterTeacher(@RequestBody Credential_Entity cEntity) 
	{
		return new ResponseEntity<String>(authService.RegisterTeacher(cEntity),HttpStatus.CREATED);
	} 

/**************************************************************************************************************************/
	
	@PostMapping("/login")
	public ResponseEntity<Jwt_Response> loginWithCredentials1(@RequestBody Jwt_Request request)
	{
		System.err.println(request);
		return new ResponseEntity<Jwt_Response>(authService.loginWithCredentials(request),HttpStatus.ACCEPTED);
	}
/***************************************************************************************************************/
	@PostMapping("/validate")
	public Boolean ValidateToken()
	{
		System.out.println("Hello");
		return true;
	}	
	
/********************************************************[ UPDATE PASSWORD ]***********************************************************************************/	

	@PostMapping("/updatepass/{pass}")
	public ResponseEntity<String> UpdatePassword(@PathVariable("pass") String name,@RequestBody String entity ) 
	{
		return new ResponseEntity<String>(authService.UpdatePassword(name, entity) , HttpStatus.ACCEPTED);
	}
	
/**************************************************************************************************************************************/	

	
}
