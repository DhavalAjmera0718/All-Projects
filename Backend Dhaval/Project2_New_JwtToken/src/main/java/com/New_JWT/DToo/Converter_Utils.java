package com.New_JWT.DToo;

import org.springframework.stereotype.Component;

import com.New_JWT.Entity.New_EntityMain;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Converter_Utils {

	public New_EntityMain Convert_DTO_To_Entity(New_Jwt_DTO dto) 
	{
		ObjectMapper mapper =  new ObjectMapper();
		return mapper.convertValue(dto, New_EntityMain.class);
		
	}
	public New_Jwt_DTO Convert_Entity_DTO(New_EntityMain entityMain) 
	{
		ObjectMapper mapper =  new ObjectMapper();
		return mapper.convertValue(entityMain, New_Jwt_DTO.class);
		
	}
}
