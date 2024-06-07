package com.example.Insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Insurance.Enitity.Entity_Insurance;
import com.example.Insurance.Services.Service_Insurance;

@RestController
public class Controller_Insurance {

	
	@Autowired
	private Service_Insurance serve;
	
	
	@GetMapping("/getAllAccDetails")
	public List<Entity_Insurance> getAllAccDetails()
	{
		return serve.getAllAccDetails();
	}
	
/*--------------------------------------------------------------SAVED ATA----------------------------------------------------------------------------*/
	@PostMapping("/saveAccDetail")
	public String saveAccDetail(@RequestBody Entity_Insurance insurance) 
	{
		return serve.saveAccDetail(insurance);
	}
/*-----------------------------------------------------------------Get Single Account Detail------------------------------------------------------------------------*/
	
	@GetMapping("/getAccDetail/{id}")
	public String getAccDetail( @PathVariable Long id) 
	{
		return serve.getAccDetail(id);
	}
/*---------------------------------------------------------Delete Single Account----------------------------------------------------------------------------------*/	
	@DeleteMapping("/deleteAccDetail/{id}")
	public String deleteAccDetail(@PathVariable Long id) 
	{
		return serve.deleteAccDetail(id);
	}
	
/*----------------------------------------------------------UPDATE BY ID--------------------------------------------------------------------------------*/	
	@PutMapping("/updateAccDetail/{id}")
	public String updateAccDetail(@PathVariable("id") Long id, @RequestBody Entity_Insurance insurance) 
	{
		return serve.updateAccDetail(id, insurance);
	}
/*---------------------------------------------------------Delete All Account----------------------------------------------------------------------------------*/	
	@DeleteMapping("/deleteAllAccDetails")
	public String deleteAllAccDetails(Entity_Insurance insurance) 
	{
		return serve.deleteAllAccDetails(insurance);
	}	
}
