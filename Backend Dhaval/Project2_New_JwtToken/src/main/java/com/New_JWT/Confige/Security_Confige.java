
package com.New_JWT.Confige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.New_JWT.Filter_X_EntryPoint.EntryPoint_New_Jwt;
import com.New_JWT.Filter_X_EntryPoint.Filter_New_JWT;

@Configuration
@EnableWebSecurity
public class Security_Confige {

	@Autowired
	private EntryPoint_New_Jwt entryPoint;

	@Autowired
	private Filter_New_JWT jwtFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(cs -> cs.disable()).cors(co -> co.disable())
				.authorizeHttpRequests(req -> req
				.requestMatchers("/public").hasRole("ADMIN")
				.requestMatchers("/login" , "Add_User")
				.permitAll()
				.anyRequest()
				.authenticated())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(entryPoint))
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();

	}

//	@Bean
//	public PasswordEncoder passwordEncoder() 
//	{
//		return new BCryptPasswordEncoder();
//	}
//	
//	
//	@Bean
//	public AuthenticationManager authManager (AuthenticationConfiguration builder) throws Exception 
//	{
//		return builder.getAuthenticationManager();
//	}

}
