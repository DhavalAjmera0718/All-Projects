package com.Multiple_Acc.Configuaration;

import java.util.List;
import java.util.Optional;

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

import com.Multiple_Acc.Entity.DataBase_User_Id_Pass;
import com.Multiple_Acc.Repository.Database_Id_Pass_Repo;

@Configuration
public class User_Configuaration implements UserDetailsService {

	@Autowired
	private Database_Id_Pass_Repo repoo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		 DataBase_User_Id_Pass dataBase_User_Id_Pass = repoo.findById(username).get();
		 if (dataBase_User_Id_Pass.getUs()!=null) {
				String role= (username.equals("admin")) ? "ROLE_ADMIN" :"ROLE_NORMAL";
				
				List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(role);
				
				
				return new User(dataBase_User_Id_Pass.getUs(),
						passwordEncoder().encode(dataBase_User_Id_Pass.getUs()),
						authorityList);
			}
			throw new UsernameNotFoundException(username + "is Invalid.!!"); 
	}
	/*********************************************************************************************************************************/
	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationManager authManager (AuthenticationConfiguration builder) throws Exception 
	{
		return builder.getAuthenticationManager();
	}

}
