package com.practise.HELPER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practise.DTO.p_DTO;
import com.practise.Entity.p_Entity;

@Component
public class p_Helper {

	
	@Autowired
	private ObjectMapper objectMapper;
	
	public p_Entity Dto_To_Entity(p_DTO dto) 
	{
		return objectMapper.convertValue(dto, p_Entity.class);
	}

	public p_DTO entity_TO_DTO(p_Entity entity) 
	{
		return objectMapper.convertValue(entity, p_DTO.class);
	}
	
	
	
}
