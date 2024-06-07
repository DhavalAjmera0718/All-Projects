package com.SIS.Filters;

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

import com.SIS.Configurations.UserDetail_Configuaration;
import com.SIS.Utils.Jwt_Utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class Jwt_Filter extends OncePerRequestFilter {

	@Autowired
	private Jwt_Utils helper;
	
	@Autowired
	private UserDetail_Configuaration userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String headerToken=request.getHeader("Authorization");
		String userName = null;
		String jwtToken = null;

		System.err.println("headerToken From Filter1111----------------  " + headerToken);
		if (headerToken != null && headerToken.startsWith("Bearer ")) {
			jwtToken = headerToken.substring(7);
			System.err.println("JWTTOKEN From If ----------" + jwtToken);
			
			try {
				userName = helper.getUsernameFromToken(jwtToken);
				
			} catch (IllegalArgumentException e) {
                logger.info("Illegal Argument while fetching the username !!");
                e.printStackTrace();
            } catch (ExpiredJwtException e) {
                logger.info("Given jwt token is expired !!");
                e.printStackTrace();
            } catch (MalformedJwtException e) {
                logger.info("Some changed has done in token !! Invalid Token");
                e.printStackTrace();
            } 
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
			System.out.println("userDetails-"+userDetails);
			if (userDetails != null && helper.validateToken(jwtToken, userDetails)
					&& SecurityContextHolder.getContext().getAuthentication() == null) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}

		}
		filterChain.doFilter(request, response);
	}
		
		
	}


