package com.example.Insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Insurance.Enitity.MainEntity_Excel;
import com.example.Insurance.Helper.Excel_Helper;
import com.example.Insurance.Implimantation.Excel_Implimantation;

@RestController
public class Excel_Controllerr {

	@Autowired 
	private Excel_Implimantation serve;
	
	@Autowired
	private Excel_Helper helper;
	
	@PostMapping("Upload")
	public ResponseEntity<String> SaveData(@RequestParam("file") MultipartFile file) 
	{
		if(Excel_Helper.CheckExcelFormat(file)) 
		{
			//serve.SaveData(file);
			return new ResponseEntity<String>(serve.SaveData(file),HttpStatus.ACCEPTED);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Enter Only Excel File");
		}
	}
/************************************************ GET EXCEL DATA *****************************************************************************************/	
	
	@GetMapping("/GetData")
	public List<MainEntity_Excel> GetData()
	{
		return serve.GetData();
	}
	
	
	
	
	
}
