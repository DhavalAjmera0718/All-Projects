package com.Teacher.Implimantation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Teacher.Entity.Teacher_Entity;
import com.Teacher.REPOSITORY.Teacher_Repoo;

@Component
public class Teacher_Implimantation {

	@Autowired
	private Teacher_Repoo teacher_Repoo;
	
	public String Register_Teacher( Teacher_Entity tEntity) 
	{
		System.err.println(tEntity);
		teacher_Repoo.save(tEntity);
		return "Teacher has Been Register Thank You..!!!";
	}
	
}
