package com.DemoOld_Security.Secyruty_Configuaration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity 
		.authorizeHttpRequests((auth) -> auth
				.antMatchers("/home")
				.permitAll()
				.anyRequest()
				.authenticated()
				)
		.httpBasic(Customizer.withDefaults());

	}
	
}
