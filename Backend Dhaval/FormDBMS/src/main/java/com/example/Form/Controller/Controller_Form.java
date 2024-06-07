package com.example.Form.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.Form.DTO.DTO_Form;
import com.example.Form.Enity.Entity_Form;
import com.example.Form.Service.Service_Form;

@RestController
public class Controller_Form {
	@Autowired
	private Service_Form services;
	
	@GetMapping("/GetAllForm")
	public ResponseEntity<List<DTO_Form>> GetAllform()
	{
		return new ResponseEntity<List<DTO_Form>>(services.GetAllform(),HttpStatus.ACCEPTED);
	}
/*----------------------------------------------------------Save Data ---------------------------------------------------------------------------*/

	@PostMapping("/SaveData")

	public ResponseEntity<String> SaveData(@Valid @RequestBody DTO_Form form) {
		return new ResponseEntity<>(services.SaveData(form), HttpStatus.ACCEPTED);
	}	
/*--------------------------------------------------------DELET By ID----------------------------------------------------------------------------*/
	@DeleteMapping("/DeleteByid/{fid}")
	public String DeleteByid(@PathVariable int fid) {
		return services.DeleteByid(fid);	
	}

}
