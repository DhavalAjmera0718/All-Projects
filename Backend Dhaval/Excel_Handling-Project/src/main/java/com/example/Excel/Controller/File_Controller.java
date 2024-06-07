package com.example.Excel.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Excel.DTO.File_DTOO;
import com.example.Excel.Main_Entity.Main_Enitity;
import com.example.Excel.Service.File_Sevice;

@RestController
public class File_Controller {

	
	@Autowired
	private File_Sevice serve;
	
	@PostMapping("/Upload")
	public ResponseEntity<?> Upload_File(@RequestParam("file") MultipartFile file)
	{
		
			
			serve.SaveData(file);
			System.err.println("file---" + file);
			return ResponseEntity.ok(Map.of("Message","file is Uploaded And Data Hase Been Saved"));
			
			
		
		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Enter Excwl File");
	}
	
/************************************************* GET ALL DATA *****************************************************************/
	@GetMapping("/GetData")
	public List<File_DTOO> GetData()
	{
		return serve.GetData();
	}

/*********************************************** EXCEPTION PRACTICE ***************************************************************************************/	

	@GetMapping("/division")
	public ResponseEntity<?> Division(@PathParam ("a")  Integer a, @PathParam  ("b") Integer b)
	{
		return new ResponseEntity<>(serve.Division(a, b),HttpStatus.ACCEPTED);
	}	
	
/************************************************** EXCEL EXPORT CONTROLLER *******************************************************************************************/	
	@GetMapping("/genrateExcel")
	public void genrateExcel(HttpServletResponse response) 
	{
		response.setContentType("application/octet-stream");
		String headerKey =  "Content-Disposition";
		String headerValueString = "attachment;filename=data.xlsx";
		
		response.setHeader(headerKey, headerValueString);
		
		serve.genrateExcel(response);
	}
/***************************************************DOWNLOAD ONLY FIELD EXCEL FROM LOCAL SYSTEM *************************************************************************************/
	 
	@GetMapping("/GetExcel_WithFiled")
	 public ResponseEntity<Resource> Download_Excel_Format_From_DB() 
	 {
		 Resource resource = serve.Download_Excel_Format_From_DB();
		 if(resource.exists()) 
		 {
			 HttpHeaders headers = new HttpHeaders();
			 headers.add(HttpHeaders.CONTENT_DISPOSITION, "attchment;filename=data.xlsx");
			 
			 return ResponseEntity.ok()
					 .headers(headers)
					 .contentType(MediaType.APPLICATION_OCTET_STREAM)
					 .body(resource);
		 }else {
			return ResponseEntity.notFound().build();
		}
	 }	
	
}
