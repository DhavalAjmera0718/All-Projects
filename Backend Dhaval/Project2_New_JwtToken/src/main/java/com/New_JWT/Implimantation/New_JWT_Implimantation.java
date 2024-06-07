package com.New_JWT.Implimantation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.New_JWT.DToo.Converter_Utils;
import com.New_JWT.DToo.New_Jwt_DTO;
import com.New_JWT.Entity.New_EntityMain;
import com.New_JWT.Repository.New_Repooo;
import com.New_JWT.Service.JWT_Service;

@Component
public class New_JWT_Implimantation implements JWT_Service {

	@Autowired
	private New_Repooo repooo;
	
	@Autowired
	private Converter_Utils helper;
	
	public String Add_User(New_Jwt_DTO dto) 
	{
		
		New_EntityMain convert_DTO_To_Entity = helper.Convert_DTO_To_Entity(dto);
		repooo.save(convert_DTO_To_Entity);
		return "UserName-Password has Been Saved....";
	}
	
	
}
