package com.SIS.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SIS.Entities.Administartor_Entity;
import com.SIS.Entities.EducationDetails_Entity;
import com.SIS.Entities.FeeDetails_Entity;
import com.SIS.Entities.Student_Entity;
import com.SIS.Proxies.Administartor_DTOO;
import com.SIS.Proxies.EducationDetails_DTO;
import com.SIS.Proxies.FeeDetails_DTO;
import com.SIS.Proxies.Student_DTO;
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
/******************************************************** Educational Details **************************************************************************************/	
	
	public EducationDetails_Entity EducationDetails_ConvertToDTo(EducationDetails_DTO eDto) 
	{
		return mapper.convertValue(eDto, EducationDetails_Entity.class);
	} 
	public EducationDetails_DTO EducationDetails_ConvertToEntity(EducationDetails_Entity eDetails_Entity) 
	{
		return mapper.convertValue(eDetails_Entity, EducationDetails_DTO.class);
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
/************************************************************ Student Converter**************************************************************************************/

	public Student_Entity Student_ConvertToDtoo(Student_DTO sDto) 
	{
		//ObjectMapper objectMapper = new ObjectMapper();
		return mapper.convertValue(sDto, Student_Entity.class);
	} 
	public Student_DTO Student_ConvertToEntity(Student_Entity sEntity) 
	{
		//ObjectMapper objectMapper = new ObjectMapper();
		return mapper.convertValue(sEntity, Student_DTO.class);
	} 
	
	
	
}
