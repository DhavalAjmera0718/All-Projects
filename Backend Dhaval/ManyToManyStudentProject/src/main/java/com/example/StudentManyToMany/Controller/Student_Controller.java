package com.example.StudentManyToMany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManyToMany.Entity.Student_Entity;
import com.example.StudentManyToMany.Reoo.Course_Repo;
import com.example.StudentManyToMany.Service.Student_Service;
import com.example.StudentManyToMany_DTOOO.Course_DTOOO;
import com.example.StudentManyToMany_DTOOO.Student_DTO;

import net.bytebuddy.asm.Advice.Return;

@RestController
@CrossOrigin("*")
public class Student_Controller {

	@Autowired
	private Student_Service serve;
	
	

	@PostMapping("/SaveData")
	public String SaveData(@RequestBody Student_DTO sDto) 
	{
		System.err.println("----------");
		return serve.SaveData(sDto);
	}
	
/**************************************************** GET DATA MANY TO MANY *************************************************************************************/	
	@GetMapping("/GetDataById/{id}")
	public ResponseEntity<Student_DTO> GetDataById(@PathVariable Long id) 
	{
//		return serve.GetDataById(id);
		return new ResponseEntity<Student_DTO>(serve.GetDataById(id) ,HttpStatus.OK);
	}
	
/**************************************************** GET CHILD DATA MANY TO MANY *************************************************************************************/		
	@GetMapping("/getChildData/{id}")
	public Course_DTOOO getChildData(@PathVariable Long id) 
	{
		return serve.getChildData(id);
	} 
/******************************************************[ GET ALL DATA }**********************************************************************************/	 	
	
	@GetMapping("/getallStudent")
	public ResponseEntity<List<Student_DTO>> GetAlldata()
	{
		return new ResponseEntity<List<Student_DTO>>(serve.GetAllStudentData(),HttpStatus.OK);
	}
	
	
}
