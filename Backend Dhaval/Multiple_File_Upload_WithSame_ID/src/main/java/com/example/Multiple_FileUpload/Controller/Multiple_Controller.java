package com.example.Multiple_FileUpload.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Multiple_FileUpload.Entityyy.Multi_Main_Entity;
import com.example.Multiple_FileUpload.Service.Multiple_Service;

@RestController
public class Multiple_Controller {

	@Autowired
	private Multiple_Service service;
	
	@PostMapping("/MultipleFile_Uploading")
	public ResponseEntity<String> MultipleFile_Uploading(@RequestParam("file") MultipartFile[] file) 
	{
		return new ResponseEntity<String>(service.MultipleFile_Uploading(file),HttpStatus.OK);
	} 
	
	
	
}
