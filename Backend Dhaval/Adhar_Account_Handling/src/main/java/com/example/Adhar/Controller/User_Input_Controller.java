package com.example.Adhar.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Adhar.Entity.User;
import com.example.Adhar.Entity.User_Input_Data_ForAngular;
import com.example.Adhar.Implimantation.User_Input_Implimantation;
import com.example.Adhar.Repoo.User_Input_Repository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin("*")
public class User_Input_Controller {

	@Autowired
	private  User_Input_Repository userRepo;
	
	@Autowired
	private User_Input_Implimantation service;
	
	@PostMapping(value = "/postalldata" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public ResponseEntity<?> postalldata( @RequestParam(value = "file" , required = false) MultipartFile multipartFile
			,@RequestParam("name") String userData 
			) throws IOException
	{
		
		
		System.out.println("UserData- "+userData);
		ObjectMapper mapper =  new ObjectMapper();
//		User_Input_Data_ForAngular value = mapper.readValue(userData, User_Input_Data_ForAngular.class);
		User userinfo = mapper.readValue(userData, User.class);
		
		System.err.println("value from postData function--------" + userinfo);
		
		System.err.println("Image Name----->" + multipartFile.getOriginalFilename());
		
		System.err.println("User data ----->" + userData);
		
		return new ResponseEntity<String>(service.PostAllData( multipartFile ,userinfo),HttpStatus.OK);
//		return new ResponseEntity<>("",HttpStatus.OK);
	}
	
	
	
	@GetMapping("Download_AnyFile/{filename}")
	public ResponseEntity<Resource> DownloadAnyFile_WithName(@PathVariable("filename") String filename)
	{
		Resource downloadAnyFile = service.DownloadAnyFile(filename);
		System.err.println(downloadAnyFile);
		System.err.println("1111111111111");
		
		if(downloadAnyFile.exists()) 
		{
			System.err.println("2222222222222");
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attchment;filename="+filename);
			return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(downloadAnyFile);		
		}
		else {
			return new ResponseEntity<Resource>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	/***********************************************************[ DOWNLOAD EXCEL FORMAT ]**************************************************************************************/	
	@GetMapping("/Download_Format")
	public ResponseEntity<Resource> downloadFormaExcelFormet()
	{
		Resource downloadAnyFile = service.downloadFormaExcelFormet();
		System.err.println(downloadAnyFile);
		System.err.println("1111111111111");
		
		if(downloadAnyFile.exists()) 
		{
			System.err.println("2222222222222");
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attchment;filename="+"excelformat.xlsx");
			return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(downloadAnyFile);		
		}
		else {
			return new ResponseEntity<Resource>(HttpStatus.BAD_GATEWAY);
		}
	}
		
/*************************************************************************************************************************************************/
	
	@PostMapping(value = "/saveExceldata" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	  public ResponseEntity<String> SaveData(@RequestParam("file") MultipartFile file) 
	  {
		  return new ResponseEntity<String>(service.saveExceldata(file),HttpStatus.OK);
	  }
	
	
	
	
	
	
/**************************************************************[ GET ALL DAT WITH PAGINATION ]*******************************************************************************************/	
	@GetMapping("/getAlluserData_pagination")
	public ResponseEntity<List<User_Input_Data_ForAngular>> getalldata_Withpagination( 
			@RequestParam(value = "pageNumber" , defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize" , defaultValue = "5",required = false) Integer pageSize
	)
	{
		return new ResponseEntity<List<User_Input_Data_ForAngular>>(service.getalldata_Withpagination(pageNumber,pageSize) , HttpStatus.ACCEPTED);
	}

	
/*********************************************************************************************************************************************************/	
	
	@GetMapping("/getAlluserData")
	public ResponseEntity<List<User_Input_Data_ForAngular>> getAlluserData(){
		return new ResponseEntity<List<User_Input_Data_ForAngular>>(service.getAlluserData() , HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
}
