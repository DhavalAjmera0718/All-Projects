package com.example.Mapping.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.Mapping.DTO.Emp_DTO;
import com.example.Mapping.Entity.Emp_Entity;
import com.example.Mapping.Service.Emp_Service;

@RestController
public class Emp_Controller {
	
	@Autowired
	private Emp_Service service;
	/*
	@PostMapping("/SaveAll")
	public ResponseEntity<String> SaveAll(@RequestBody Emp_DTO empdto) 
	{
		return new ResponseEntity<String> (service.SaveAll(empdto) , HttpStatus.CREATED);
	}*/
	
	@PostMapping("/SaveAll")
	public ResponseEntity<String> SaveAll() 
	{
		return new ResponseEntity<String> (service.SaveAll() , HttpStatus.CREATED);
	}
	/*-------------------------------------------------Get DATA By Id-------------------------------------------------------------------------------*/
	@GetMapping("/GetDataById/{id}")
	
	public ResponseEntity<Emp_DTO> GetDataById(@PathVariable("id") Long id ) 
	{
		return new ResponseEntity<Emp_DTO>(service.GetDataById(id ),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/GetAllData")
	public List<Emp_DTO> GetAllData()
	{
		return service.GetAllData();
	}
	/*-----------------------------------------------------Delete By ID-----------------------------------------------------------------------------------*/
	
	@DeleteMapping("/DeleteById/{id}")
	public ResponseEntity<String> DeleteById(@PathVariable Long id)
	{
		return new ResponseEntity<String>(service.DeleteById(id),HttpStatus.GONE);
	}
	/*-----------------------------------------------------Delete By ID-----------------------------------------------------------------------------------*/
	
	@DeleteMapping("/DeleteAll")
	public ResponseEntity<String> DeleteAll()
	{
		return new ResponseEntity<String>(service.DeleteAll(),HttpStatus.CONFLICT);
	}
	
	/*-------------------------------------------------------UPDATE BY ID-------------------------------------------------------------------------*/

	@PutMapping("/UpdateById/{id}")
	public ResponseEntity<String> UpdateById(@RequestBody Emp_DTO empdto , @PathVariable("id") Long id)
	{
		return new ResponseEntity<String>(service.UpdateById(id, empdto),HttpStatus.ACCEPTED);
	}
	
	
}
