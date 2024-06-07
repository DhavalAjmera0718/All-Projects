package com.Auth.Implimantation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Auth.Configuaration.UserDetail_Configuaration;
import com.Auth.ENTITY.Credential_Entity;
import com.Auth.Repository.Credential_Repo;
import com.Auth.Response_X_Request.Jwt_Request;
import com.Auth.Response_X_Request.Jwt_Response;
import com.Auth.Service.Authentication_Service;
import com.Auth.UTILS.Jwt_Utils;

@Component
public class Authentication_Implii implements Authentication_Service{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetail_Configuaration userDetailsService;
	
	@Autowired
	private Jwt_Utils jwtUtils;
	
	@Autowired
	private Credential_Repo cRepo;
	
	
	
	
	public String RegisterUser(Credential_Entity cEntity) 
	{
		cEntity.setRole("ROLE_USER");
		cRepo.save(cEntity);
		return "User Data has Been saved..";
	}
	
	@Override
	public String RegisterAdmin(Credential_Entity cEntity) {
		cEntity.setRole("ROLE_ADMIN");
		cRepo.save(cEntity);
		return "Admin Data has Been saved..";
	}
		
	@Override
	public String RegisterTeacher(Credential_Entity cEntity) {
		cEntity.setRole("ROLE_ADMIN");
		cRepo.save(cEntity);
		return "Admin Data has Been saved..";
	}
			
	
	
	
/**********************************************************************************************************************************************************/
	@Override
	public Jwt_Response loginWithCredentials(Jwt_Request request)
	{
		System.err.println(request);
		if (request!=null) 
		{
//			BCryptPasswordEncoder encryptedPass =  new BCryptPasswordEncoder();
//			String encode = encryptedPass.encode(request.getPassword());
//			System.err.println("Encoded Password ------>" + encode);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));						
		}
		
		userDetailsService.setRole(request.getRole());
		UserDetails userByUsername = userDetailsService.loadUserByUsername(request.getUsername());
		String jwtToken = null;
		
		
		if (userByUsername != null) {
			
			jwtToken = jwtUtils.generateToken(userByUsername);
			System.err.println(jwtToken);
		}
//		return new ResponseEntity<Jwt_Response>(new Jwt_Response(jwtToken) , HttpStatus.ACCEPTED);
		return new Jwt_Response(jwtToken);
		
	}

/*********************************************************[ UPDATE PASS]*************************************************************************************/

	
	public String UpdatePassword( String name, String entity ) 
	{
		Optional<Credential_Entity> entitydata=  cRepo.findById(name);
		if (entity!=null) {
			
			
			Credential_Entity credential_Entity = entitydata.get();
			credential_Entity.setPassword(entity);
			cRepo.save(credential_Entity);
			return "Password Hase Been Changed";
		}
		else {
			return "Please Re-Enter Password...!!";
		}
		
	}

	
	
	
	
}
