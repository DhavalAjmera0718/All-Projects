package com.New_JWT.Service;

import org.springframework.stereotype.Service;

import com.New_JWT.DToo.New_Jwt_DTO;
import com.New_JWT.Entity.New_EntityMain;

@Service
public interface JWT_Service {

	
	public String Add_User(New_Jwt_DTO dto);
}
