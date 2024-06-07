package com.example.Excel.Helper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.Excel.DTO.File_DTOO;
import com.example.Excel.Main_Entity.Main_Enitity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class File_DTO_Helper {

	public static Main_Enitity Convert_To_Dto(List<File_DTOO> convertExcet_To_List) 
	{
		ObjectMapper objectMapper =  new ObjectMapper();
		System.err.println("convertExcet_To_List DTOOOOOOO---------------------" + convertExcet_To_List);
		return objectMapper.convertValue(convertExcet_To_List, Main_Enitity.class);
	}

	
	public static File_DTOO Convert_TO_Entity(Main_Enitity all) 
	{
		ObjectMapper objectMapper =  new ObjectMapper();
		return objectMapper.convertValue(all, File_DTOO.class);
	}
	
	
}
