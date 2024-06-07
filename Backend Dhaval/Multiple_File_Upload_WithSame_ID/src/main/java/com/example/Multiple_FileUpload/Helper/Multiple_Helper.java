package com.example.Multiple_FileUpload.Helper;

import org.springframework.stereotype.Component;

import com.example.Multiple_FileUpload.Entityyy.Child_Entityyy;
import com.example.Multiple_FileUpload.Entityyy.Multi_Main_Entity;
import com.example.Multiple_FileUpload.Proxy.Child_DTOOO;
import com.example.Multiple_FileUpload.Proxy.Multiple_DTOO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Multiple_Helper {

	public Multi_Main_Entity Convert_To_DTO(Multiple_DTOO dtos) 
	{
		ObjectMapper objectMapper =  new ObjectMapper();
		return objectMapper.convertValue(dtos, Multi_Main_Entity.class);
	}
	
	public Multiple_DTOO Convert_To_Entity(Multi_Main_Entity entity) 
	{
		ObjectMapper objectMapper =  new ObjectMapper();
		return objectMapper.convertValue(entity, Multiple_DTOO.class);
		
	}
	
/***********************************************  FOR CHILD CLASS ********************************************************************/	

	public Child_Entityyy Convert_To_DTO_Child(Child_DTOOO dtos) 
	{
		ObjectMapper objectMapper =  new ObjectMapper();
		return objectMapper.convertValue(dtos, Child_Entityyy.class);
	}
	
	public Child_DTOOO Convert_To_Entity_Child(Child_Entityyy entity) 
	{
		ObjectMapper objectMapper =  new ObjectMapper();
		return objectMapper.convertValue(entity, Child_DTOOO.class);
		
	}

	
	
}
