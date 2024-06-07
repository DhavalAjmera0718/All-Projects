package com.SIS.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SIS.Implimantation.Authentication_Implii;
import com.SIS.Response_X_Request.Jwt_Request;
import com.SIS.Response_X_Request.Jwt_Response;
import com.SIS.Services.Authentication_Service;
import com.SIS.Utils.Jwt_Utils;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private Authentication_Service authService;
	
	@Autowired
	private Jwt_Utils jwtUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<Jwt_Response> loginWithCredentials(@RequestBody Jwt_Request request)
	{
		if (request!=null) 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));						
		}
		
		UserDetails userByUsername = userDetailsService.loadUserByUsername(request.getUsername());
		String jwtToken = null;
		
		
		if (userByUsername != null /*
									 * && passwordEncoder.matches(request.getPassword(),
									 * userByUsername.getPassword())
									 */) {
			
			jwtToken = jwtUtils.generateToken(userByUsername);
		}
		return new ResponseEntity<Jwt_Response>(new Jwt_Response(jwtToken) , HttpStatus.ACCEPTED);
	}
	
/************************************************ VALIDATE TOKEN ********************************************************************************************/	
	@GetMapping("/validateToken")
	public ResponseEntity<String> validateToken()
	{
		return new ResponseEntity<String>("Token Has Been Verified......" ,HttpStatus.ACCEPTED);
	}
/**************************************************************************************************************************/
	
	@Autowired
	private Authentication_Implii implii;
	@PostMapping("/login1")
	public ResponseEntity<Jwt_Response> loginWithCredentials1(@RequestBody Jwt_Request request)
	{
		return new ResponseEntity<Jwt_Response>(authService.loginWithCredentials(request),HttpStatus.ACCEPTED);
	}
	
}
