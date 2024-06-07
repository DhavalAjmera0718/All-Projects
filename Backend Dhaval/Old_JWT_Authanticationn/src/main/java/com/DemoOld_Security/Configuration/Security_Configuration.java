package com.DemoOld_Security.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.DemoOld_Security.Global_Exception.Global_Exception_Hanlding;
import com.DemoOld_Security.Implimantation.Old_Jwt_Implimantation;
import com.DemoOld_Security.Roll_User.User_Roll;

@Configuration
@EnableWebSecurity
public class Security_Configuration  extends WebSecurityConfigurerAdapter  {

	@Autowired
	private JWT_Filter filter;

//	@Autowired
//	private Old_Jwt_Implimantation implimantation;
	@Autowired
	private User_Roll implimantation;
	
	@Autowired
	private Global_Exception_Hanlding exception;
	//@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(implimantation);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.err.println(http);
		http.cors().disable()
		.csrf().disable()
		.authorizeHttpRequests()
		.antMatchers("/Admin_User").hasRole("ADMIN")
		.antMatchers("/Normal_User").hasRole("NORMAL")
		.antMatchers("/Add_User","/login")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling(ex -> ex.authenticationEntryPoint(exception))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}
	@Bean
	public AuthenticationManager authenticationManager() throws Exception
	{
		return super.authenticationManager();
	}
	
	
	
	
	
	
}
