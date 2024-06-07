package com.example.StudentManyToMany.Utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.StudentManyToMany.Entity.Course_Entity;
import com.example.StudentManyToMany.Entity.Student_Entity;
import com.example.StudentManyToMany_DTOOO.Course_DTOOO;
import com.example.StudentManyToMany_DTOOO.Student_DTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Helper_Student {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public Student_Entity DtoToEntityConvert(Student_DTO stDto) 
	{
		return objectMapper.convertValue(stDto, Student_Entity.class);
	}
	
	public Student_DTO EnitityToDto_Convert(Student_Entity mainEntity) 
	{
		return objectMapper.convertValue(mainEntity, Student_DTO.class);
	}
/******************************************************************************************************************************************/
	public Course_Entity DtoToEntityConvert_Child(Course_DTOOO cDto)
	{
		return objectMapper.convertValue(cDto, Course_Entity.class);
	}
	public Course_DTOOO EnitityToDtoConvert_Child(Course_Entity cEntity) 
	{
		return objectMapper.convertValue(cEntity, Course_DTOOO.class);
	}
}
