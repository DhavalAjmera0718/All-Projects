package com.SIS.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SIS.Entities.Student_Entity;
import com.SIS.Implimantation.Student_impli;
import com.SIS.Proxies.EducationDetails_DTO;
import com.SIS.Proxies.FeeDetails_DTO;
import com.SIS.Proxies.Student_DTO;
import com.SIS.Services.Educational_Service;
import com.SIS.Services.StudentServices;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private Student_impli stImlimantation;
	
	@Autowired
	private StudentServices stServices;
	
	@Autowired
	private Educational_Service edService;
	@PostMapping("/register")
	public ResponseEntity<String> registerWithDetails(@RequestBody Student_DTO sDto)
	{
		System.err.println(sDto);
		return new ResponseEntity<String>(stServices.registerWithDetails(sDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{enRoll}")
	public ResponseEntity<Student_DTO>   getUser(@PathVariable("enRoll") String enRoll) 
	{
		return new ResponseEntity<Student_DTO>(stServices.getUser(enRoll),HttpStatus.ACCEPTED);
	}
/******************************************************** updateUserDetails ****************************************************************************************/	
	@PutMapping("updateUser/{enRoll}")
	public ResponseEntity<String> updateUserDetails(@PathVariable("enRoll") String enRoll, @RequestBody Student_Entity sEntity) 
	{
		System.err.println(sEntity);
		return new ResponseEntity<String>(stServices.updateUserDetails(enRoll, sEntity),HttpStatus.ACCEPTED);
	}
	
/************************************************************************************************************************************************/
	@PostMapping("/addEducationDetails")
	public ResponseEntity<String> addEducationDetails(@RequestBody EducationDetails_DTO eDto) 
	{
		return new ResponseEntity<String>(edService.addEducationDetails(eDto) , HttpStatus.OK);
	}	
	
/*************************************************************************************************************************************************/	
	@PutMapping("/updateEducationDetails/{id}")
	public ResponseEntity<String> updateEducationDetails(@PathVariable("id") Long id ,@RequestBody EducationDetails_DTO dto) 
	{
		return new ResponseEntity<String>(edService.updateEducationDetails(id, dto) , HttpStatus.OK);

	}
/**************************************************** GET FEES DETAILS *********************************************************************************************/	

	@GetMapping("/getFeeDetails/{enRoll}")
	public  ResponseEntity<List<FeeDetails_DTO>> getFeeDetails(@PathVariable("enRoll") String enRoll)
	{
		System.err.println("------------->"+enRoll);
		return new ResponseEntity<List<FeeDetails_DTO>>(stServices.getFeeDetails(enRoll),HttpStatus.ACCEPTED);
	}
/*********************************************************************************************************************************************/	
	@GetMapping("/getKey/{enrollmentNo}")
    public List<Object[]> getSecurityKeyAndEnrollmentNo(@PathVariable String enrollmentNo) {
        return stServices.getSecurityKeyAndEnrollmentNo(enrollmentNo);
    }
}
