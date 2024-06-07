package com.example.Student.Helper;

import org.springframework.stereotype.Component;

import com.example.Student.Dataset.StudentModel;
import com.example.Student.Enitity.Student_Enitity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Student_Helper {

	public static Student_Enitity convert_Dto_TO_Entitity(StudentModel dtos) 
	{
		ObjectMapper  objmapper = new ObjectMapper();
		return objmapper.convertValue(dtos, Student_Enitity.class);
	}
/***************************************************************************************************************************************************/
	public static StudentModel convert_Entity_TO_Dto(Student_Enitity enitity) 
	{
		ObjectMapper objmapper = new ObjectMapper();
		return objmapper.convertValue(enitity, StudentModel.class);
	}

}
