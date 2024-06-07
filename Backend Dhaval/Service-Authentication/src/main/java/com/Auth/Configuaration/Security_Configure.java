

package com.Auth.Configuaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Auth.Exception.Jwt_Entrypoint;
import com.Auth.FILTER.Jwt_Filter;

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
//				.requestMatchers("/admin/**", "/user/**" ).hasAuthority("ROLE_ADMIN")
//				.requestMatchers("/auth/**","/admin/**", "/user/**" ).permitAll()
				.requestMatchers("/admin/**", "/user/**" ).hasRole("ADMIN")
				.requestMatchers("/admin/getFeeDetails","/login","/RegisterAdmin","/RegisterUser",
				"/registerTeacher","/sendotp/**" , "/verifyotp/**","/updatepass/**","/getLink/**" , "/auth/**").permitAll()	
//				.requestMatchers("/user/**").hasRole("USER")
//				.requestMatchers("/auth/**")
//				.permitAll()
				.anyRequest()
				.authenticated())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(entrypoint))
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
