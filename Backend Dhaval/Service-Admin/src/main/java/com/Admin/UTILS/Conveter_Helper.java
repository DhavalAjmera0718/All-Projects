package com.Admin.UTILS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Admin.Entity.Administartor_Entity;
import com.Admin.Entity.FeeDetails_Entity;
import com.Admin.Proxi.Administartor_DTOO;
import com.Admin.Proxi.FeeDetails_DTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component	
public class Conveter_Helper {

	@Autowired
	private ObjectMapper mapper;
/***************************************************** Administartor_Entity *******************************************************************************************/	
	public Administartor_Entity administartor_ConvertToDTo(Administartor_DTOO aDto) 
	{
		return mapper.convertValue(aDto, Administartor_Entity.class);
	}
	public Administartor_DTOO administartor_ConvertToEntity(Administartor_Entity aeEntity) 
	{
		return mapper.convertValue(aeEntity, Administartor_DTOO.class);
	}
	
/************************************************************ FEES DETAILS**************************************************************************************/	
	public FeeDetails_Entity FeeDetails_ConvertToDTO(FeeDetails_DTO fDto) 
	{
		return mapper.convertValue(fDto, FeeDetails_Entity.class);
	} 
	public FeeDetails_DTO FeeDetails_ConvertTOEntity(FeeDetails_Entity fEntity)
	{
		return mapper.convertValue(fEntity, FeeDetails_DTO.class);
	}
}