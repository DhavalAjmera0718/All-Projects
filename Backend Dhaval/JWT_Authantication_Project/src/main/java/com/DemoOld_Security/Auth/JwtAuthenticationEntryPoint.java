package com.DemoOld_Security.Auth;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
//public class JwtAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
//
//	
//	public JwtAuthenticationEntryPoint() 
//	{
//		setRealmName("admin");
//	}
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException {
//	
//		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//		PrintWriter eWriter = response.getWriter();
//		System.err.println("PrintWitter From JET EntryPOint--------->>>>>" + eWriter);
//		eWriter.println("Access Denied !! " + authException.getMessage());
//		
//		// TODO Auto-generated method stub
//		super.commence(request, response, authException);
//	}
//	
//}

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	 private Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) 
    		throws IOException, ServletException {
    	System.err.println("JwtAuthenticationEntryPoint---------"+ response);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        System.err.println("Writer From Entry point -----" + writer);
        logger.error("Authentication failed: {}", authException.getMessage());
        writer.println("Access Denied !! " + authException.getMessage());
    }
}
























