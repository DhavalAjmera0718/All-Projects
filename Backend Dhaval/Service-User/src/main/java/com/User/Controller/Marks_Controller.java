package com.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.User.Entity.Marks_Entity;
import com.User.Implimantation.Marks_Implimentation;

@RestController
@RequestMapping("/marks")
public class Marks_Controller {

	@Autowired
	private Marks_Implimentation service;
	
	
	@PostMapping("/add_marks")
	public ResponseEntity<String> Add_Marks(@RequestBody Marks_Entity mEntity)
	{
		return new ResponseEntity<String>(service.Add_Marks(mEntity),HttpStatus.CREATED);
	}
	
	@GetMapping("/getmarks_ById/{id}")
	public ResponseEntity<Marks_Entity> Getmarks_ById(@PathVariable Long id)
	{
		return new ResponseEntity<Marks_Entity>(service.getmarks_ById(id),HttpStatus.CREATED);
		
	}
	
	@PostMapping("/UpdateBy_id/{id}")
	public ResponseEntity<String> UpdateBy_id( @PathVariable Long id  ,@RequestBody  Marks_Entity mEntity) 
	{
		return new ResponseEntity<String>(service.UpdateBy_id(id,mEntity),HttpStatus.CREATED);
		
	}
	@GetMapping("/deleteBy_id/{id}")
	public ResponseEntity<String> DeleteBy_Id(@PathVariable Long id)
	{
		return new ResponseEntity<String>(service.DeleteBy_Id(id),HttpStatus.CREATED);
	}
	
	
	
}
