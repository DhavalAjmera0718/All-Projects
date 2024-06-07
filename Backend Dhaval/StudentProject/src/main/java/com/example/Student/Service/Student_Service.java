package com.example.Student.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.Student.Dataset.StudentModel;
import com.example.Student.Enitity.Users_Entity;

@Service
public interface Student_Service {

	public List<StudentModel> GetAlldata(); 
	
	public StudentModel GetStudentById(Long id) ;
	
	public String DeleteById(Long stid);
	//public String saveData(StudentModel student) ;
	//public String saveData(Student_Enitity student);
	public String saveData();
	
	public Long Count_Data() ;
	
	public List<StudentModel> FindData_byAdress(String city);
	public List<StudentModel> FindData_By_Character(String character);
	
	public List<StudentModel> Ordered_By_age();
	
	public String update(Long id , StudentModel model);
	
	/************************************************************************************************/
	
	public String getHome(Model model);
	public String getAboutPage();
	public String getService();
	public String getCareer();
/*********************************************************** USER DETAILS CODING *****************************************************************************/
	public String User_Password(Users_Entity entity);
	public String UserName(Users_Entity entity);
}



























