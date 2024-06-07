package com.practise.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practise.DTO.p_DTO;
import com.practise.Service.p_Service;

@RestController
public class p_Controller {

	Logger logger=LoggerFactory.getLogger(p_Controller.class);
	
	@Autowired
	private p_Service service;
	
	
	
	@PostMapping("/savedata")
	public ResponseEntity<String> SaveData(@RequestBody p_DTO dto)
	{
		System.err.println(dto);
		return new ResponseEntity<String>(service.savdData(dto) , HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<p_DTO>> getAlldata() 
	{
		logger.error("From controller");
		return new ResponseEntity<List<p_DTO>>(service.getAlldata() , HttpStatus.OK);
		
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> UpdateBy_Id(@PathVariable("id") Integer id  ,@RequestBody  p_DTO dto) 
	{
		System.err.println("Controller---->" + dto);
		return new ResponseEntity<String>(service.UpdateBy_Id(id, dto) , HttpStatus.OK);
	}
	
	
}
