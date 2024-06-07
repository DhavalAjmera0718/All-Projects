package com.Multiple_Acc.Helper_Utils;

import org.springframework.stereotype.Component;

import com.Multiple_Acc.DTOO.Account_DTO;
import com.Multiple_Acc.DTOO.User_DTOO;
import com.Multiple_Acc.Entity.Account_Entity;
import com.Multiple_Acc.Entity.User_Entity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Converter_Helper {

	public User_Entity Convert_Entity_To_DTO(User_DTOO perentDto) 
	{
		ObjectMapper mapper =  new ObjectMapper();
		return mapper.convertValue(perentDto, User_Entity.class);
	}
	public User_DTOO Convert_DTO_TO_Entity(User_Entity perentEntity) 
	{
		ObjectMapper mapper =  new ObjectMapper();
		return mapper.convertValue(perentEntity, User_DTOO.class);
	}
	
/**************************************** Child Converter Process************************************************************************/	
//	public Account_Entity Child_Entity_To_DTO(Account_DTO childDto) 
//	{
//		ObjectMapper mapper =  new ObjectMapper();
//		return mapper.convertValue(childDto, Account_Entity.class);
//	}
//	public Account_DTO Child_DTO_TO_Entity(Account_Entity childEntity) 
//	{
//		ObjectMapper mapper =  new ObjectMapper();
//		return mapper.convertValue(childEntity, Account_DTO.class);
//	}
	
	
	
	
	
}
