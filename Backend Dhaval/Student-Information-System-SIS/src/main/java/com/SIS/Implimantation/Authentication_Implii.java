package com.SIS.Implimantation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.SIS.Response_X_Request.Jwt_Request;
import com.SIS.Response_X_Request.Jwt_Response;
import com.SIS.Services.Authentication_Service;
import com.SIS.Utils.Jwt_Utils;

@Component
public class Authentication_Implii implements Authentication_Service{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private Jwt_Utils jwtUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Jwt_Response loginWithCredentials(Jwt_Request request)
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
			System.err.println(jwtToken);
		}
//		return new ResponseEntity<Jwt_Response>(new Jwt_Response(jwtToken) , HttpStatus.ACCEPTED);
		return new Jwt_Response(jwtToken);
		
	}
	
	
}
