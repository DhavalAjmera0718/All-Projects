package com.DemoOld_Security.Configuaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.DemoOld_Security.Auth.JwtAuthenticationEntryPoint;
import com.DemoOld_Security.Auth.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiger {

	
	@Autowired
	private JwtAuthenticationFilter filter;
	@Autowired
	private JwtAuthenticationEntryPoint point;
	
//	@Autowired
//	private JWT_Helper helper;
//	@Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter(JWT_Helper jwtHelper, UserDetailsService userDetailsService) {
//		System.err.println("JWT_Helper From Security configure------" + jwtHelper.toString());
//		System.err.println("JWT_Helper From Security userDetailsService------" + userDetailsService.toString());
//        return new JwtAuthenticationFilter(jwtHelper, userDetailsService);
//    }
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{
		
		httpSecurity.csrf(csrf -> csrf.disable())
		.cors(cors -> cors.disable())
		.authorizeHttpRequests(auth ->  auth
		.requestMatchers("/HomePage").hasRole("ADMIN")
		.requestMatchers("/login").permitAll()
		.anyRequest().authenticated())
		.exceptionHandling(Ex -> Ex.authenticationEntryPoint(point))
		.sessionManagement(Session -> Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) );
		
		httpSecurity.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
	
	
//	@Bean
//	public PasswordEncoder psEncoder() 
//	{
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public UserDetailsService userDetailsService() 
//	{
//		UserDetails user1 = User.withUsername("admin")
//				.password(psEncoder().encode("admin"))
//				.roles("ADMIN")
//				.build();
//		System.err.println(user1);
//		UserDetails user2 = User.withUsername("user2")
//				.password(psEncoder().encode("user2"))
//				.roles("NORMAL")
//				.build();
//
//		return new InMemoryUserDetailsManager(user1,user2);
////				
//	}
//	 @Bean
//	    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
//	        return builder.getAuthenticationManager();
//	    }
//	
	
}
