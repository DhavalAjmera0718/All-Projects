package com.DemoOld_Security.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DemoOld_Security.Configuaration.JWT_Helper;
import com.DemoOld_Security.Entity.JWT_Request;
import com.DemoOld_Security.Entity.JWT_Response;

import lombok.experimental.PackagePrivate;

@RestController
public class Auth_Controller {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	//@PackagePrivate JWT_Helper helper;
	@Autowired
	private JWT_Helper helper;
	
	private Logger logger = LoggerFactory.getLogger(Auth_Controller.class);
	
	


    @PostMapping("/login")
    public ResponseEntity<JWT_Response> login(@RequestBody JWT_Request request) {

    	System.err.println( "Email From Auth Controller------- " + request.getEmail());
    	System.err.println("Password From Auth Controller-------  " + request.getPassword());
    	this.doAuthenticate(request.getEmail(), request.getPassword());
        

      
    	UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        
    	System.err.println("User Details From AUTH_ Controller" + userDetails);
        String token = this.helper.generateToken(userDetails);
        System.err.println("Token-----------------"+token);
        JWT_Response response = JWT_Response.builder()
                .jwtToken(token)
                .userName(userDetails.getUsername()).build();
        System.err.println("Response From Auth Controller |||||||||  " + response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        System.err.println( "authantication From auth controller "+authentication+  " || "+password.toString());
        try {
            Authentication authenticate = authenticationManager.authenticate(authentication);
            System.err.println(authenticate);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
    	//logger.error(e.getMessage());
        return "Credentials Invalid !!";
    }
	
}
