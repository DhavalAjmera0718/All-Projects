package com.New_JWT.Confige;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.New_JWT.Entity.New_EntityMain;
import com.New_JWT.Repository.New_Repooo;

@Configuration
public class User_Details_Config implements UserDetailsService {

	@Autowired
	private New_Repooo repooo;
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//	UserDetails userDetails = User.builder()
//				.username("admin")
//				.password(passwordEncoder().encode("admin"))
//				.build();
//	System.err.println(userDetails);
//		return new InMemoryUserDetailsManager(userDetails);
//	}
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	        return builder.getAuthenticationManager();
	    }
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			New_EntityMain new_EntityMain = repooo.findById(username).get();
			
			if (new_EntityMain.getUserName()!=null) {
				String role= (username.equals("admin")) ? "ROLE_ADMIN" :"ROLE_NORMAL";
				
				List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(role);
				
				
				return new User(new_EntityMain.getUserName(),
						passwordEncoder().encode(new_EntityMain.getUserName()),
						authorityList);
			}
			throw new UsernameNotFoundException(username + "is Invalid.!!"); 
		}
	
}
