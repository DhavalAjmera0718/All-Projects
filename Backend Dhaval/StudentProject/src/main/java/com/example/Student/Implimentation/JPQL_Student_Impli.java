package com.example.Student.Implimentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Student.Dataset.StudentModel;
import com.example.Student.Enitity.Student_Enitity;
import com.example.Student.Enitity.Users_Entity;
import com.example.Student.Helper.Student_Helper;
import com.example.Student.Repository.Student_Repo;
import com.example.Student.Repository.User_Details_Repo;
import com.example.Student.Service.Student_Service;
import com.github.javafaker.Faker;

@Component
@Primary
public class JPQL_Student_Impli  implements Student_Service{

	@Autowired
	private Student_Repo repo;
	
	@Autowired
	private Faker faker;
	
	
	@Override
	public List<StudentModel> GetAlldata() {

		List<Student_Enitity> getAlldata = repo.GetAlldata();
		List<StudentModel> dummList =  new ArrayList<>();
		for(Student_Enitity enitity : getAlldata) 
		{
			StudentModel convert_Entity_TO_Dto = Student_Helper.convert_Entity_TO_Dto(enitity);
			dummList.add(convert_Entity_TO_Dto);
		}
		
		return dummList;
	}


	@Override
	public StudentModel GetStudentById(Long sid) {
		
	Student_Enitity getDataById = repo.GetDataById(sid);
		StudentModel convert_Entity_TO_Dto = Student_Helper.convert_Entity_TO_Dto(getDataById);
		return convert_Entity_TO_Dto;
		
		
		/*Student_Enitity getSingleData_ByName = repo.GetSingleData_ByName(sid, "dhaval");
		StudentModel convert_Entity_TO_Dto = Student_Helper.convert_Entity_TO_Dto(getSingleData_ByName);
		return convert_Entity_TO_Dto;*/
		
//		String get_Only_Name_Using_Id = repo.Get_Only_Name_Using_Id(sid);
//		System.err.println(get_Only_Name_Using_Id);
//		return get_Only_Name_Using_Id;
}


	@Override
	public String DeleteById(Long stid) {

		System.err.println("------------------------------");
		repo.DeleteBy_ID(stid);
		return "Data Deleted";
				
		
	}

/************************************************* Save Data Using Faker *****************************************************************************************/

	@Override
	public String saveData() {
	
		for(int i=0; i<=1800; i++)
		{
			Student_Enitity enitity = new Student_Enitity();
			enitity.setName(faker.name().fullName());
			enitity.setAddress(faker.address().city());
			enitity.setAge(faker.number().randomDigit());
		//	System.err.println("------------");
			repo.save(enitity);
		}
		return "Data Has Been Savaed....";
		
	}
/************************************************ Update Data using JPQL Query ******************************************************************************************/

	@Override
	public String update(Long id , StudentModel model) {

		repo.updateNameByRollNo(model.getRollNo(), model.getName(), model.getAddress(), model.getAge());;
		
		return "id number "+id+" Is Updated ";
	}
/*********************************************** COUNT DATA USING NATIVE QUERY************************************************************************************/	

	public Long Count_Data() 
	{
		return repo.count();
	}
	
/*********************************************** Find Name From Address Using Native Query ************************************************************************************/	

	public List<StudentModel> FindData_byAdress(String city) 
	{
	   List<Student_Enitity> findData_byAdress = repo.FindData_byAdress(city);
	   System.err.println(findData_byAdress);
	  List<StudentModel> dummList =  new ArrayList<>();
	   for (Student_Enitity student_Enitity : findData_byAdress) {
		
		   StudentModel convert_Entity_TO_Dto = Student_Helper.convert_Entity_TO_Dto(student_Enitity);
		   dummList.add(convert_Entity_TO_Dto);
		   System.err.println(convert_Entity_TO_Dto);
	}
	   
	   return dummList;
	}
/*********************************************** Find Data From Table Using Name Character************************************************************************************/	
	
	public List<StudentModel> FindData_By_Character(String character)
	{
		 List<Student_Enitity> findData_byAdress = repo.FindData_By_Character(character);
		   System.err.println(findData_byAdress);
		  List<StudentModel> dummList =  new ArrayList<>();
		   for (Student_Enitity student_Enitity : findData_byAdress) {
			
			   StudentModel convert_Entity_TO_Dto = Student_Helper.convert_Entity_TO_Dto(student_Enitity);
			   dummList.add(convert_Entity_TO_Dto);
			   System.err.println(convert_Entity_TO_Dto);
		}
		   
		   return dummList;
	}	
/******************************************************** Asending Ordered_By_age *********************************************************************************/	

	public List<StudentModel> Ordered_By_age()
	{
		 List<Student_Enitity> findData_byAdress = repo.Ordered_By_age();
		   System.err.println(findData_byAdress);
		  List<StudentModel> dummList =  new ArrayList<>();
		   for (Student_Enitity student_Enitity : findData_byAdress) {
			
			   StudentModel convert_Entity_TO_Dto = Student_Helper.convert_Entity_TO_Dto(student_Enitity);
			   dummList.add(convert_Entity_TO_Dto);
			   System.err.println(convert_Entity_TO_Dto);
		}
		   
		   return dummList;
	}
/************************************************* FOR SECUTITY CHECKING ************************************************************************************/

@Override
public String getHome(Model model) {
	
	
	return "Home";
}


@Override
public String getAboutPage() {
	// TODO Auto-generated method stub
	return "Welcom to About Us";
}


@Override
public String getService() {
	// TODO Auto-generated method stub
	return "Which Type of Sevice Do you Want";
}


@Override
public String getCareer() {
	// TODO Auto-generated method stub
	return "Fill The Form For Better Career opportunity";
}

/*********************************************************** USER DETAILS CODING *****************************************************************************/
@Autowired
private User_Details_Repo users_Entity;

public String UserName(Users_Entity entity) 
	{
		
		users_Entity.save(entity);
		return "User Has Been Saved";
	}
		
		
		
	
public String User_Password(Users_Entity entity) 
{
	List<Users_Entity> password = users_Entity.findAll();
	List<Users_Entity> dummyList = new ArrayList<>();
	for (Users_Entity users_Entity : password) {
		users_Entity.setUser1(entity.getUser1());
		users_Entity.setPass2(entity.getPass2());
		dummyList.add(entity);
	}
	
	
	//	System.err.println(password);
//	this.users_Entity.saveAll(password);
	return "User Register";
	
	
}


























}
