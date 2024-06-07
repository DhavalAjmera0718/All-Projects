package com.example.Demat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Demat.DTOOO.File_DematAccount_DTOO;
import com.example.Demat.Service.File_Demat_Service;

@RestController
public class File_Demat_Controller {

	@Autowired
	private File_Demat_Service service;

	@PostMapping("/Save-Data")
	public  ResponseEntity<File_DematAccount_DTOO> SaveData(@RequestParam("file") MultipartFile file) 
	{
		return new ResponseEntity<File_DematAccount_DTOO>(service.SaveData(file),HttpStatus.CREATED);
	}
/*******************************************	MULTIPLE FILE UPLODING  	**************************************************************************/
	@PostMapping("/Multiple_Fileuploding")
	public  ResponseEntity<String> Multiple_Fileuploding(@RequestParam("file") MultipartFile[] file) 
	{
		return new ResponseEntity<String>(service.Multiple_Fileuploding(file),HttpStatus.CREATED);
	}
/****************************************  SAVE MULTIPLE FILE IN ZIP   ****************************************************************************************************************************/	
	
	@PostMapping("/Multiple_File_Zip")
	public  ResponseEntity<String> Multiple_File_Zip(@RequestParam("file") MultipartFile[] file) 
	{
		return new ResponseEntity<String>(service.Multiple_File_Zip(file),HttpStatus.CREATED);
	}	
/******************************************** 	GET ONLY ONE FILE DATA BY ID	*******************************************************************************************/	
	@GetMapping("/getDatabyId/{id}")
	public ResponseEntity<File_DematAccount_DTOO> getDatabyId(@PathVariable("id") Long id)
	{
		return new ResponseEntity<File_DematAccount_DTOO> (service.getDatabyId(id),HttpStatus.OK);
	}

	

}

