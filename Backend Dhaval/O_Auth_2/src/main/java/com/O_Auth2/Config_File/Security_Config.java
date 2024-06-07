package com.O_Auth2.Config_File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security_Config {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception 
	{
		
		httpSecurity
			.csrf(cs -> cs.disable())
			.cors(co-> co.disable())
			.authorizeHttpRequests(req-> req.anyRequest()
			.authenticated())
			.oauth2Login();
		
		
		return httpSecurity.build();
	}
}
