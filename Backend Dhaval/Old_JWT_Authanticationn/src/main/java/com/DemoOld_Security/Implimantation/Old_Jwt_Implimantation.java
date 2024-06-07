package com.DemoOld_Security.Implimantation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Old_Jwt_Implimantation  {
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		if (username.equals("admin")) {
//			
//			return new User("admin", passwordEncoder.encode("admin"), new ArrayList<>());
//		}
//		throw new UsernameNotFoundException("Username is Invalid");
//	}

	

}
