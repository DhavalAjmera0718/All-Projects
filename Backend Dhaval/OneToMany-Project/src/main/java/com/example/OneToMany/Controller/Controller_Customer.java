package com.example.OneToMany.Controller;

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

import com.example.OneToMany.DTO_Customer.DTO_Customer;
import com.example.OneToMany.Service.Service_Coustomer;

@RestController
public class Controller_Customer {

	
	@Autowired
	private Service_Coustomer serve;
	
	@PostMapping("/SaveData")
	public ResponseEntity<String> SaveData(@RequestBody DTO_Customer cDto_Customer) 
	{
		return new ResponseEntity<String>(serve.SaveData(cDto_Customer),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/GetDataById/{id}")
	public ResponseEntity<DTO_Customer>  GetDataById(@PathVariable("id") Long id) 
	{
		System.out.println("ID >>>>>>>>>>>>>>>>>>>> " + id);
		return new ResponseEntity<DTO_Customer>(serve.GetData(id),HttpStatus.ACCEPTED);
	}
/*-----------------------------------------------------Delete By ID-----------------------------------------------------------------------------------*/
	
	@DeleteMapping("/DeleteById/{id}")
	public ResponseEntity<String> DeleteById(@PathVariable Long id)
	{
		return new ResponseEntity<String>(serve.DeleteById(id),HttpStatus.GONE);
	}
	
	@PutMapping("/UpdateById/{id}")
	public ResponseEntity<String> UpdateById(@RequestBody DTO_Customer empdto , @PathVariable("id") Long id)
	{
		return new ResponseEntity<String>(serve.UpdateById(id, empdto),HttpStatus.ACCEPTED);
	}
/*---------------------------------------------------------Get Alll-----------------------------------------------------------------------------*/	
	
	@GetMapping("/GetAllData")
	public List<DTO_Customer>  GetAllData()
	{
		
		return serve.GetAllData();
	}	
	
	
	
}
