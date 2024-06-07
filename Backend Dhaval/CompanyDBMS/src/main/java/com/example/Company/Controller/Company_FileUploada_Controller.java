package com.example.Company.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Company.Entity.Upload_EntityMain;
import com.example.Company.Helper.Company_FileUpload_Helper;
import com.example.Company.Repository.Image_Repo;
import com.example.Company.Service.Service_Company;

@RestController
public class Company_FileUploada_Controller {

	@Autowired
	private Company_FileUpload_Helper helper;
	
	@Autowired
	private Image_Repo iRepo;
	
	@Autowired
	private Service_Company  serve;
	
	/*
	@PostMapping("/Upload")
	public ResponseEntity<String> UploadData(@RequestParam("image") MultipartFile multipartFile)
	{
		 * try {
			
			if(multipartFile.isEmpty()) 
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
			}
			if(!multipartFile.getContentType().equals("image/jpeg")) 
			{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FILE SHOULD BE IN JPEG FORMAT");
			}
			Boolean data_Upload = helper.UploadFile(multipartFile);
			if(data_Upload) 
			{
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipartFile.getOriginalFilename()).toUriString());
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOMTHING WENT WRONG PLEASE TRY AGIN......");
	}
		 */
/****************************************************FETCH IMAGE INTO DATA BASE ********************************************************************************/
	@PostMapping("/Upload_Image")
	public ResponseEntity<String> Upload_Image(@RequestParam("image") MultipartFile file) 
	{
		return new ResponseEntity<String>(serve.Upload_Image(file),HttpStatus.ACCEPTED);
		
		//return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
	}
	
/********************************************************* READ FILR FROM POSTMAN AND SAVE INTO MY SQL *****************************************************************************/
	@GetMapping("/getDataByid/{id}")
	public ResponseEntity<?> getDataByid(@PathVariable("id") Long id)
	{
		Optional<Upload_EntityMain> byId = iRepo.findById(id);
		if(byId!=null) 
		{
			Upload_EntityMain EntityData = byId.get();
			System.err.println(EntityData.getPath());
			byte[] file = helper.readFile(EntityData.getPath());
			MediaType mediaType = MediaType.valueOf(EntityData.getType());
			String contentDisposition = 
			"xyz filename=\"" + EntityData.getName() + "\"" 
			+"fileType=\"" + EntityData.getType()
			+ "\""+"filepath=\"" + EntityData.getPath() + "\"";
			
			return ResponseEntity.ok()
					.contentType(mediaType)
					.header("contentDisposition",contentDisposition)
					.body(file);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
