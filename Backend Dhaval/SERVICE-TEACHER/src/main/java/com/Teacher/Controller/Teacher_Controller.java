package com.Teacher.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Teacher.Entity.Teacher_Entity;
import com.Teacher.Helper.Teacher_Helper;
import com.Teacher.Implimantation.Teacher_Implimantation;

@RestController
public class Teacher_Controller {

	
	@Autowired
	private Teacher_Implimantation service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Teacher_Helper helper;
	
	@PostMapping("/register_teacher")
	public ResponseEntity<String> Register_Teacher( @RequestHeader Map<String,String> headerData, @RequestBody Teacher_Entity tEntity) 
	{
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", headerData.get("token"));
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> hEntity = new HttpEntity<>(null, httpHeaders);
		System.err.println("hEntity From Admin Controller ------------> " + hEntity);
		
		Boolean validate = restTemplate.postForObject("http://SERVICE-AUTHENTICATION/auth/validate",hEntity, Boolean.class);
		
		
		System.err.println("Validation --------> "  + validate);
		
		if (validate) {
		
		return new ResponseEntity<String>(service.Register_Teacher(tEntity),HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("PLEASE ENTER VALID TOKEN",HttpStatus.BAD_GATEWAY);
		}
	}
/*************************************************[ ADD MARKS OF STUDENTS ]***************************************************************************************************/	
	@PostMapping("/add_marks")
	public ResponseEntity<Object> Add_Marks(@RequestHeader Map<String, String> headertoken, @RequestBody Object object)
	{
		System.err.println("HEDAER TOKEN ------> "+headertoken);
		HttpHeaders httpHeaders =  new HttpHeaders();
		httpHeaders.set("Authorization", headertoken.get("token"));
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object>httpEntity = new HttpEntity<Object>(object, httpHeaders);
		Boolean postForObject2 = restTemplate.postForObject("http://SERVICE-AUTHENTICATION/auth/validate",httpEntity, Boolean.class);
		
		if (postForObject2) {
			
			String postForObject = restTemplate.postForObject("http://SERVICE-USER/user/marks/add_marks", object, String.class);
			return new ResponseEntity<Object>(postForObject,HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_GATEWAY);
	}	
/*************************************************[ GET MARKS BY ID ]***************************************************************************************/	
	@GetMapping("/getmarks_ById/{id}")
	public ResponseEntity<String> Getmarks_ById(@RequestHeader Map<String, String> headertoken, @PathVariable Long id)
	{
		if (helper.authentication(headertoken)) {
			
			String forEntity = restTemplate.getForObject("http://SERVICE-USER/user/marks/getmarks_ById/"+id, String.class);
			return new ResponseEntity<String>(forEntity,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
	}

/***********************************************[ UPDATE STUDENT MARKS BY ID ]***************************************************************************************************/	
	@PostMapping("/updateby_id/{id}")
	public ResponseEntity<Object> updateById( @RequestHeader Map<String, String> headertoken,  @PathVariable Long id  ,@RequestBody Object object)
	{
		if (helper.authentication(headertoken)) {
			
			String postForObject = restTemplate.postForObject("http://SERVICE-USER/user/marks/UpdateBy_id/"+id, object, String.class);
			return new ResponseEntity<Object>(postForObject , HttpStatus.FOUND);
		}
		return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
	}
	
/***********************************************[ Delete STUDENT MARKS BY ID ]***************************************************************************************************/	
	
	@GetMapping("/deleteBy_id/{id}")
	public ResponseEntity<String> DeleteBy_Id(@PathVariable Long id)
	{
		String forObject = restTemplate.getForObject("http://SERVICE-USER/user/marks/deleteBy_id/"+id, String.class);
		return new ResponseEntity<String>(forObject,HttpStatus.CREATED);
	}
}


















