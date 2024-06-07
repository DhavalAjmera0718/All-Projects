package com.Multiple_Acc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Multiple_Acc.Helper_Utils.Jwt_Helper;
import com.Multiple_Acc.Response_X_Request.Jwt_Request;
import com.Multiple_Acc.Response_X_Request.Jwt_Response;

@RestController
public class Auth_Controller {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private Jwt_Helper jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<Jwt_Response> LoginWithCredencial(@RequestBody Jwt_Request request)
	{
		if (request!=null) {
			
			try {

				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassWord()));
				
			} catch (Exception e) {
				throw new UsernameNotFoundException("Error In Controller");
			}
		}	
			UserDetails userByUsername = userDetailsService.loadUserByUsername(request.getUserName());
			String jwtToken = null;
			
			if (userByUsername!=null) {
				
				jwtToken = jwtUtils.generateToken(userByUsername);
			}
			
			return new ResponseEntity<Jwt_Response>(new Jwt_Response(jwtToken) , HttpStatus.ACCEPTED);
			
		
	}
 	
}
