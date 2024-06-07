package com.example.StudentManyToMany.Service;

import java.util.List;

import com.example.StudentManyToMany_DTOOO.Course_DTOOO;
import com.example.StudentManyToMany_DTOOO.Student_DTO;

public interface Student_Service {

	public String SaveData(Student_DTO sDto); 

	public Student_DTO GetDataById(Long id) ;
	
	public Course_DTOOO getChildData(Long id);
	
	public List<Student_DTO> GetAllStudentData();
	
	
}
