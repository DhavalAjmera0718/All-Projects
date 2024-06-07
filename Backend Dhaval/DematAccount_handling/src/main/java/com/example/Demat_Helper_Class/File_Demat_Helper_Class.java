package com.example.Demat_Helper_Class;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Demat.DTOOO.File_DematAccount_DTOO;
import com.example.Demat.Entity.File_Demat_Enitity;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class File_Demat_Helper_Class {

/***************************************************** ENTITY TO DTO CONVERTER *************************************************************************************/	
	public static File_Demat_Enitity ConvertTo_DTO(File_DematAccount_DTOO dtos) 
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(dtos, File_Demat_Enitity.class);
	}
/***************************************************** DTO TO ENTITY CONVERTER *************************************************************************************/	

	public static File_DematAccount_DTOO convertTO_Entity(File_Demat_Enitity enitity) 
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(enitity, File_DematAccount_DTOO.class);
	}
	
	
/***************************************************** ENTITY TO LIST CONVERTER *************************************************************************************/	
	public static List<File_DematAccount_DTOO> ConvertTo_List(List<File_Demat_Enitity> ldtos)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		List<File_DematAccount_DTOO> dummyList = new ArrayList<>();
		for(File_Demat_Enitity entity :  ldtos) 
		{
			File_DematAccount_DTOO convertValue = objectMapper.convertValue(entity, File_DematAccount_DTOO.class);
			dummyList.add(convertValue);
			System.err.println("DUMMY LIST ------->>> " + dummyList);
			
		}
		return dummyList;
	
	
	}
	
}
