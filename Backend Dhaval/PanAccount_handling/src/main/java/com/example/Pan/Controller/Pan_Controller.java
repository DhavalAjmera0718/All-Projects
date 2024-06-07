package com.example.Pan.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Pan.Enitity.Pan_Entity;
import com.example.Pan.Service.Pan_Service;

@RestController
public class Pan_Controller {

	@Autowired 
	private Pan_Service service;
/**************************************************** FOR DOWNLOAD BLANK EXCEL FROM LOACL MACHINE ***********************************************************************************/	
	@GetMapping("/Blank-Excel")
	public ResponseEntity<Resource>  Get_Blank_Excel() 
	{
		Resource resource = service.Get_Blank_Excel();
		System.err.println(resource);
		if (resource.exists()) {
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attchment;filename=pan.xlsx");
			System.err.println(headers);
			
			return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(resource);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
/***************************************************** UPLOAD THAT BLANK EXCEL WITH NEW DATA ***********************************************************************************/	
	
	@PostMapping("Upload_Excel")
	public ResponseEntity<String> Upload_Excel(@RequestParam("file") MultipartFile file) 
	{
		return new ResponseEntity<String>(service.Upload_Excel(file),HttpStatus.OK);
	}
	
/**************************************************** DOWNLOAD EXCEL FROM DATABSE***********************************************************************************/	
	
	@GetMapping("/Download_Excel")
	public void Download_Excel(HttpServletResponse response)
	{
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=pan.xlsx");
		service.Download_Excel(response);
		System.err.println("RESPONSE IN CONTROLLER--------"+response);
	}
/*************************************************** GET ALL DATA IN JSON**************************************************************************************/		
	@GetMapping("/GetAllData")
	public ResponseEntity<List<Pan_Entity>>	GetAllData()
	{
		return new ResponseEntity<List<Pan_Entity>>(service.GetAllData(),HttpStatus.ACCEPTED);
	}
/*************************************************** GET DATA BY ID IN JSON**************************************************************************************/		
	@GetMapping("/Get_DataBY_Id/{id}")
	public ResponseEntity<List<Pan_Entity>> Get_DataBY_Id(@PathVariable("id") Long id)	
	{
		
		return new ResponseEntity<List<Pan_Entity>>(service.Get_DataBY_Id(id),HttpStatus.ACCEPTED);
	}
	
}
