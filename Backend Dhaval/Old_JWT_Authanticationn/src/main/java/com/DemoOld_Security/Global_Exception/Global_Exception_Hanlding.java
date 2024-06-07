package com.DemoOld_Security.Global_Exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Global_Exception_Hanlding implements AuthenticationEntryPoint  {
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Object> AcessDenied(AccessDeniedException e)
	{

		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<Object>("You Don't Have Authority To Use This URl....." + e.getMessage(),headers , HttpStatus.FORBIDDEN);
	}
	private Logger logger = LoggerFactory.getLogger(Global_Exception_Hanlding.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		 
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        PrintWriter writer = response.getWriter();
	        logger.error("Authentication failed: {}", authException.getMessage());
	        writer.println("Access Denied !! " + authException.getMessage() + " In Database......");
		
	}
	

}
