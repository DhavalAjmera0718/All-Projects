package com.example.Demat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Demat.Entity.Demat_MainEntity;
import com.example.Demat.Service.Demat_Service;

@RestController
public class Demat_Controller {

	@Autowired
	private Demat_Service serve;
	
	@PostMapping("/SaveData")
	public ResponseEntity<String> SaveData(@RequestParam("file") MultipartFile file) 
	{
		return new ResponseEntity<String>(serve.SaveData(file),HttpStatus.CREATED);
	}
	
/**************************************************	TO GET ALL DATA ************************************************************************/
	
	@GetMapping("/GetData")
	public ResponseEntity<List<Demat_MainEntity>> GetData() 
	{
		return new ResponseEntity<List<Demat_MainEntity>>(serve.GetData(),HttpStatus.ACCEPTED);
	}
/*************************************************GET DATA BY ID ****************************************************************************************/	

	@GetMapping("/GetDataById/{id}")
	public ResponseEntity<List<Demat_MainEntity>> GetDataById(@PathVariable("id") Long id)
	{
		return new ResponseEntity<List<Demat_MainEntity>>(serve.GetDataById(id),HttpStatus.ACCEPTED);
	}
	
/***************************************** UPDATE DATA BY ID**********************************************************************************************/	
	@PostMapping("/UpdateById/{id}")
	public String UpdateById(@PathVariable("id") Long id  ,@RequestBody Demat_MainEntity demat) 
	{
		return serve.UpdateById(id, demat);
	}
}
