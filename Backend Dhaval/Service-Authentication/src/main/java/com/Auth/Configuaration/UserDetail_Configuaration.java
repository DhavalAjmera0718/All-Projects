
package com.Auth.Configuaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Auth.ENTITY.Credential_Entity;
import com.Auth.Repository.Credential_Repo;

@Configuration
public class UserDetail_Configuaration implements UserDetailsService {

	@Autowired
	private Credential_Repo credRepo;
	
	private String role;
	public void setRole(String role) {
			this.role = role;
		}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.err.println(username);

		Optional<Credential_Entity> credEntity = credRepo.findById(username);
		if (credEntity.isPresent()) {
			Credential_Entity adminEntity = credEntity.get();
			System.err.println(adminEntity.getPassword());

//		if (adminEntity.getName()!=null) {
			System.err.println("GET NAME FORM USER DETAILS CONFIG******** " + adminEntity.getName() +" " + adminEntity.getRole());
			
			return new User(adminEntity.getName(), passwordEncoder().encode(adminEntity.getPassword()),
					getAuthorities(adminEntity.getRole()));
//		}
//			throw new UsernameNotFoundException(username + " is Invalid.!!");
		}
		throw new UsernameNotFoundException(username + " is Invalid.!!");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		
		return Collections.singletonList(new SimpleGrantedAuthority(role));
	}
}

//long long1 = Long.parseLong(username);

//System.out.println("username->"+username);
//Student_Entity student_Entity = student_Repo.findById(username).get();
//System.out.println("student Data->>"+student_Repo.findById(username).get());
//System.err.println("student_Entity From User Detail--------" + student_Entity);
//if (student_Entity.getName()!=null) {
//	
//	System.err.println("55555555555555555555");
//	return new User(student_Entity.getEnrollmentNo()
//			, passwordEncoder().
//			encode(student_Entity.getPassword()), 
//			getAuthorities("ROLE_USER"));
//}

//Administartor_Entity administartor_Entity = administartor_Repo.findByName(username).get();
//System.err.println("admin user name --------" + administartor_Entity);
//if (administartor_Entity!=null) {
//	
//	return new User(administartor_Entity.getName()
//			, passwordEncoder().encode(administartor_Entity.getPassword())
//			, getAuthorities("ROLE_ADMIN"));
//}
