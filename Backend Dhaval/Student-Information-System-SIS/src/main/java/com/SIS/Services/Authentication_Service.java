package com.SIS.Services;

import org.springframework.stereotype.Service;

import com.SIS.Response_X_Request.Jwt_Request;
import com.SIS.Response_X_Request.Jwt_Response;

@Service
public interface Authentication_Service {
	
	public Jwt_Response loginWithCredentials(Jwt_Request request);

}
