package com.SIS.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.SIS.Exceptions.Jwt_Entrypoint;
import com.SIS.Filters.Jwt_Filter;

@Configuration
@EnableWebSecurity
public class Security_Configure {
	
	
	@Autowired
	private Jwt_Entrypoint entrypoint;
	
	@Autowired
	private Jwt_Filter filter;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(cs -> cs.disable()).cors(co -> co.disable())
				.authorizeHttpRequests(req -> req
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/auth/**","/user/**")
				.permitAll()
				.anyRequest()
				.authenticated())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(entrypoint))
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
