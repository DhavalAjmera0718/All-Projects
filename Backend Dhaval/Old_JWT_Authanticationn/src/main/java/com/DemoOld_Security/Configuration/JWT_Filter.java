package com.DemoOld_Security.Configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.DemoOld_Security.Helper.JWT_Helper;
import com.DemoOld_Security.Roll_User.User_Roll;

@Component
public class JWT_Filter extends OncePerRequestFilter {

	@Autowired
	private JWT_Helper helper;
	
	@Autowired
	private User_Roll implimantation;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");
		String token =  null;
		if (header!=null && header.startsWith("Bearer ")) {
			
			token = header.substring(7);
			String username = helper.extractUsername(token);
			UserDetails userByUsername = implimantation.loadUserByUsername(username);
			
			
			if(helper.validateToken(token, userByUsername)) 
			{
				UsernamePasswordAuthenticationToken AuthenticationToken = 
						new UsernamePasswordAuthenticationToken(username, null,userByUsername.getAuthorities());
				AuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(AuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
		
		
	}

}
