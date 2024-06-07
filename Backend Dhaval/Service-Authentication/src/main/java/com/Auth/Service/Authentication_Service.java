package com.Auth.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Auth.ENTITY.Credential_Entity;
import com.Auth.Response_X_Request.Jwt_Request;
import com.Auth.Response_X_Request.Jwt_Response;



@Service
public interface Authentication_Service {
	
	public Jwt_Response loginWithCredentials(Jwt_Request request);
	
	public String RegisterUser(Credential_Entity cEntity) ;
	public String RegisterAdmin(Credential_Entity cEntity) ;
	
	public String RegisterTeacher(Credential_Entity cEntity);
	
//	public String UpdatePassword( String name, Credential_Entity entity );
	public String UpdatePassword( String name, String entity );
	
	

}
