package com.SIS.Configurations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.SIS.Entities.Administartor_Entity;
import com.SIS.Entities.Student_Entity;
import com.SIS.Repositories.Administartor_Repo;
import com.SIS.Repositories.Student_Repo;

@Configuration
public class UserDetail_Configuaration implements UserDetailsService {

	@Autowired
	private Administartor_Repo administartor_Repo;
	@Autowired
	private Student_Repo student_Repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		Optional<Administartor_Entity> adminEntityOptional = administartor_Repo.findById(username);
	    if (adminEntityOptional.isPresent()) {
	        	Administartor_Entity adminEntity = adminEntityOptional.get();
	        	System.err.println(adminEntity.getPassword());
	        	//if (passwordEncoder().matches(null, adminEntity.getPassword())) {
					
	        		return new User(adminEntity.getName(),
	                passwordEncoder().encode(adminEntity.getPassword()),
	                getAuthorities("ROLE_ADMIN"));
	        		
	        	//}
	        	
	    }
/*********************************************************************************************************************/
	    Optional<Student_Entity> studentEntityOptional = student_Repo.findById(username);
	    if (studentEntityOptional.isPresent()) {
	        Student_Entity studentEntity = studentEntityOptional.get();

	        if (studentEntity.getName() != null) {
	        		
	        			return new User(studentEntity.getEnrollmentNo(),
	                    passwordEncoder().encode(studentEntity.getPassword()),
	                    getAuthorities("ROLE_USER"));
	        }
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
