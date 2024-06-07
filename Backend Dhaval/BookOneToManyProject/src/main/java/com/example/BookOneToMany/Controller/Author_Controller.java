package com.example.BookOneToMany.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookOneToMany.DTO.Author_DTO;
import com.example.BookOneToMany.Service.Author_Service;

@RestController
public class Author_Controller {

	@Autowired
	private Author_Service service;
	
	@PostMapping("/saveData")
	public ResponseEntity<String> saveData(@RequestBody Author_DTO author) 
	{
		return new ResponseEntity<String> (service.saveData(author),HttpStatus.CREATED);
	}
	
/************************************************************* GET DATA BY ID *************************************************************************/	
	
	@GetMapping("/getAllById/{id}")
	public ResponseEntity<Author_DTO> getAllById(@PathVariable("id") Long id) 
	{
		return new ResponseEntity<Author_DTO>(service.getAllById(id),HttpStatus.FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**************************************************************************************************************************************/	
	/**************************************************************************************************************************************/	
	/**************************************************************************************************************************************/	
	/**************************************************************************************************************************************/	
	
}
