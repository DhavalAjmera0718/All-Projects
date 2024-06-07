package com.DemoOld_Security.Roll_User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.DemoOld_Security.Entity.Old_JWT_Entity;
import com.DemoOld_Security.Repository.Old_Jwt_Repository;

@Configuration
public class User_Roll implements UserDetailsService{

//	@Bean
//    public UserDetailsService userDetailsService() {
//    	System.err.println("From USER DETAILS");
//        UserDetails userDetails = User.builder().
//                username("dhaval")
//                .roles("ADMIN")
//                .password(passwordEncoder().encode("dhaval"))
//                .build();
//        System.err.println( "User details From ROLL CONFIG----------"+ userDetails);
//        return new InMemoryUserDetailsManager(userDetails);
//    }
	
	@Autowired
	private Old_Jwt_Repository repository;
	
	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
//	

	public String Add_User(Old_JWT_Entity entity) 
	{
		repository.save(entity);
		return "User Has Been Register..";
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Old_JWT_Entity old_JWT_Entity = repository.findById(username).get();
	
		
		
		if (old_JWT_Entity.getUserName()!=null) {
			String role = (username.equals("admin")) ? "ROLE_ADMIN" : "ROLE_NORMAL";
			List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(role);
			System.err.println(authorityList);
			
			
			
			return new User(old_JWT_Entity.getUserName()
					, passwordEncoder().encode(old_JWT_Entity.getPassword())
					, authorityList);
		}
		throw new UsernameNotFoundException("Username is Invalid");
	}

	}


	

