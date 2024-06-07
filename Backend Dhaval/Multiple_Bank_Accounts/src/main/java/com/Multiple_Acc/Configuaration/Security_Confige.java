package com.Multiple_Acc.Configuaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Multiple_Acc.EntryPoint_X_Filter.Jwt_Entrypoint;
import com.Multiple_Acc.EntryPoint_X_Filter.Jwt_Filter;

@Configuration
@EnableWebSecurity
public class Security_Confige {

	
	@Autowired
	private Jwt_Entrypoint entrypoint;
	
	@Autowired
	private Jwt_Filter filter;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(cs -> cs.disable()).cors(co -> co.disable())
				.authorizeHttpRequests(req -> req
				.antMatchers("/Get_Ac_Balance/**").hasRole("ADMIN")
				.antMatchers("/login","/Add_User")
				.permitAll()
				.anyRequest()
				.authenticated())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(entrypoint))
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
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
