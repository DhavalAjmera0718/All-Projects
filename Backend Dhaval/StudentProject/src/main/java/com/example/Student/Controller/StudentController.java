	package com.example.Student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Dataset.StudentModel;
import com.example.Student.Enitity.Users_Entity;
import com.example.Student.Service.Student_Service;


//@Tag(name = "STUDENT PROJECT" , description = "STUDENT DATA")
@RestController
public class StudentController {
	
	@Autowired
	private Student_Service StImpli;
	

	@GetMapping("/GetAllData")
//	@Operation(summary = "Get All Data" , description = "By this you can Access all the data")
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200" , description = "OK")
//			})
	public List<StudentModel> GetAllData()
	{
		return StImpli.GetAlldata();
	}
/*-------------------------------------------------Get Student Data Usinng Id ------------------------------------------------------------------------*/
	@GetMapping("/GetDataById/{sid}")
	public StudentModel GetDataByID(@PathVariable("sid") Long sid) 
	{
		return StImpli.GetStudentById(sid);
	}

/*-------------------------------------------------Delete Student Data Usinng Id ------------------------------------------------------------------------*/
	
	@DeleteMapping("/DeleteDataById/{stid}")
	public String DeleteDataById(@PathVariable("stid") Long stid) 
	{
		return StImpli.DeleteById(stid);
	}
/*-------------------------------------------------Save Student Data ------------------------------------------------------------------------*/
	@PostMapping("/SaveData")
	public String SaveData()  
	{
		
		return StImpli.saveData();
	}

/*-------------------------------------------------Delete All Student Data------------------------------------------------------------------------
	@DeleteMapping("/DeleteAllData")
	public String DeleteDataById(@RequestBody StudentModel student) 
	{
		return StImpli.DeleteAll(student);
	}*/
/*--------------------------------------------------Update Student Data Using Id-------------------------------------------------------------------------------*/	
	@PutMapping("/updateStdById/{id}")
	public String updateStdById(@PathVariable("id") Long id ,@RequestBody StudentModel model)
	
	{
		return StImpli.update(id, model);
	}	
/*********************************************** COUNT DATA USING NATIVE QUERY************************************************************************************/	
	@GetMapping("/Count_Data")
	public Long Count_Data() 
	{
		return StImpli.Count_Data();
	}
/*********************************************** Find Name From Address Using Native Query ************************************************************************************/	
	@GetMapping("/FindData_byAdress/{city}")
	public List<StudentModel> FindData_byAdress(@PathVariable("city") String city) 
	{
		return StImpli.FindData_byAdress(city);
	}
	
/*********************************************** Find Data From Table Using Name Character************************************************************************************/	
	@GetMapping("FindData_By_Character/{character}")
	public List<StudentModel> FindData_By_Character(@PathVariable("character") String character)
	{
		
		System.err.println(character);
		return StImpli.FindData_By_Character(character);
	}
/******************************************************** Asending Ordered_By_age *********************************************************************************/	
	@GetMapping("/Ordered_By_age")
	public List<StudentModel> Ordered_By_age(){
		
		return StImpli.Ordered_By_age();
	}	
/************************************************* PAGE  FOR SECUTITY CHECKING ************************************************************************************/
	@GetMapping("/home")
	public String home() {
//	    System.err.println("Home page---------" + model);
//	    Model attribute = model.addAttribute("getdata", StImpli.GetAlldata());
//	    System.err.println(attribute);
	    return "index"; // This should correspond to the template name (home.html)
	}
				

	 
	@GetMapping("/AboutUs")
	public ResponseEntity<String> AboutUs()
	{
		return new ResponseEntity<String>(StImpli.getAboutPage(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/Service")
	public ResponseEntity<String> Service()
	{
		return new ResponseEntity<String>(StImpli.getService(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/Career")
	public ResponseEntity<String> Career()
	{
		return new ResponseEntity<String>(StImpli.getCareer(),HttpStatus.ACCEPTED);
	}

/*********************************************************** USER DETAILS CODING *****************************************************************************/
	
//	@RequestMapping("/user/pass")
	@PostMapping("/user")
	public String UserName(@RequestBody Users_Entity entity) 
	{
		System.err.println(entity);
		return StImpli.UserName(entity);
		
	}
	
//	@PostMapping("/pass")
//	public String User_Password(@RequestBody Users_Entity entity)
//	 {
//		return StImpli.User_Password(entity);
//	 }


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
