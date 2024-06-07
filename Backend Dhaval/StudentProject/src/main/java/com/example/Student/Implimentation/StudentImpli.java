package com.example.Student.Implimentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.Student.Dataset.StudentModel;

@Component
public class StudentImpli {

	static List<StudentModel> stList = new ArrayList<>();
	
	static 
	{
		StudentModel s1 = new StudentModel(1l,"100" , "Dhaval",11);
		StudentModel s2 = new StudentModel(2l,"100" , "Dhaval",12);
		StudentModel s3 = new StudentModel(3l,"100" , "Dhaval",13);
		StudentModel s4 = new StudentModel(4l,"100" , "Dhaval",15);
		StudentModel s5 = new StudentModel(5l,"100" , "Dhaval",16);
		StudentModel s6 = new StudentModel(5l,"100" , "Dhaval",17);
		
		stList.add(s1);
		stList.add(s2);
		stList.add(s3);
		stList.add(s4);
		stList.add(s5);
		stList.add(s6);
		
		
	}
	public List<StudentModel> GetAllData()
	{
		return stList;
	}
/*-----------------------------------------------------Get Student Data Usinng Id ------------------------------------------------------------------*/	
	public StudentModel GetStudentById(String id) 
	{
		for(StudentModel student : stList) 
		{
			if(student.getRollNo().equals(id)) 
			{
				return student;
			}
		}
		return null;
	}
/*-----------------------------------------------------Delete Student Data Usinng Id ------------------------------------------------------------------*/	
	public String DeleteById(String stid) 
	{
		for(StudentModel student : stList) 
		{
			System.out.println(stid);
			
			if(student.getRollNo().equals(stid))
			{
				System.out.println("Helooooooo");
				stList.remove(student);
				break;
			}
			
		}
		return "Data Deleted..........";
	}
/*----------------------------------------------------------------Saving Data--------------------------------------------------------------------*/	
	public String saveData(StudentModel student) 
	{
		
		stList.add(student);
		return "Data Saved..";
		
	}
/*-------------------------------------------------Delete All Student Data------------------------------------------------------------------------*/
	
	public String DeleteAll(StudentModel student) 
	{
		stList.clear();
		return "All Student Data Deleted";
	}
/*-------------------------------------------------Update All Student Data------------------------------------------------------------------------*/
	
	
	public String UpdateDataById(String stid , StudentModel student1) 
	{
		for(StudentModel studentdata : stList) 
			
		{
			//System.out.println(studentdata);
			if(stid.equals(studentdata.getRollNo())) 
			{
				System.out.println("hello");
			//	studentdata.setRollNo(student1.getRollNo());
				studentdata.setName(student1.getName());
				System.out.println(studentdata);
				
			}
		}
		return "Data Updated";
	}
	
	
	
	
	
	
	
}
