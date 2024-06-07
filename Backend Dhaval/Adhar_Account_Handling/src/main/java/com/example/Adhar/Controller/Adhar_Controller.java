package com.example.Adhar.Controller;

import java.util.List;
import java.util.Map;

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

import com.example.Adhar.DTO.Adhar_DTO;
import com.example.Adhar.Service.Adhar_Service;

@RestController
@CrossOrigin("*")
public class Adhar_Controller {

	@Autowired 
	private Adhar_Service service;
	

	
	@PostMapping("/SaveData")
	public ResponseEntity<String> SaveData(@RequestParam("file") MultipartFile file) 
	{
		return new ResponseEntity<String>(service.SaveData(file) , HttpStatus.ACCEPTED);
	}
/****************************************************** GET DATA OF DATA BASE ************************************************************************************/	
	@GetMapping("/GetAllData")
	public ResponseEntity<List<Adhar_DTO>> GetAllData()
	{
		return new ResponseEntity<List<Adhar_DTO>>(service.GetAllData() , HttpStatus.ACCEPTED);
	}
/********************************************* DOWNLOAD ANY FILE FROM LOCAL MACHNE ************************************************************************************************/	

	
//	@GetMapping("Download_AnyFile/{filename}")
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
//	@GetMapping("/Download_Format")
	public ResponseEntity<Resource> downloadFormaExcelFormet()
	{
		Resource downloadAnyFile = service.downloadFormaExcelFormet();
		System.err.println(downloadAnyFile);
		System.err.println("1111111111111");
		
		if(downloadAnyFile.exists()) 
		{
			System.err.println("2222222222222");
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attchment;filename="+"excelformat");
			return ResponseEntity.ok()
					.headers(headers)
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(downloadAnyFile);		
		}
		else {
			return new ResponseEntity<Resource>(HttpStatus.BAD_GATEWAY);
		}
	}
	
}


