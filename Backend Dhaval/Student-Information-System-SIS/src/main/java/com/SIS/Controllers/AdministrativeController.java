package com.SIS.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SIS.Entities.Administartor_Entity;
import com.SIS.Proxies.Administartor_DTOO;
import com.SIS.Proxies.EducationDetails_DTO;
import com.SIS.Proxies.FeeDetails_DTO;
import com.SIS.Proxies.Student_DTO;
import com.SIS.Repositories.FeeDetails_Repo;
import com.SIS.Services.Admin_Service;
import com.SIS.Services.FeeDetailsServices;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdministrativeController {

	
	@Autowired
	private Admin_Service admin_Service;
	
	@Autowired
	private FeeDetailsServices fee_Services;
	

/*************************************************************************************************************************************************************/	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerWithDetails(@RequestBody Administartor_DTOO dto) 
	{
		System.err.println(dto);
		return new ResponseEntity<String>(admin_Service.registerWithDetails(dto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Administartor_DTOO> getAdmin(@PathVariable String id) 
	{
		return new ResponseEntity<Administartor_DTOO>(admin_Service.getAdmin(id),HttpStatus.ACCEPTED);

	}
/************************************************* updateAdminDetails ********************************************************************************************/	
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<String> updateAdminDetails(@PathVariable String id , @RequestBody Administartor_DTOO dtoo)
	{
		return new ResponseEntity<String>(admin_Service.updateAdminDetails(id, dtoo) , HttpStatus.ACCEPTED);
	}
	
/******************************************************* getAllUser *****************************************************************************************/	
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<Student_DTO>> getUsers() 
	{
		return new ResponseEntity<List<Student_DTO>>(admin_Service.getUsers() , HttpStatus.ACCEPTED);

	}
/************************************************* Delete By Id Student ********************************************************************************************/		
	@DeleteMapping("/deleteUser/{enRoll}")
	public ResponseEntity<String> deleteUser(@PathVariable("enRoll") String enRoll)
	{
		return new ResponseEntity<String>(admin_Service.deleteUser(enRoll),HttpStatus.GONE);
	}
	
/************************************************** Get Education Details**********************************************************************************************/	
	@GetMapping("/getEducationDetails")
	public ResponseEntity<List<EducationDetails_DTO>> GetEducationDetails() 
	{
		return new ResponseEntity<List<EducationDetails_DTO>>(admin_Service.GetEducationDetails() , HttpStatus.ACCEPTED);

	}
	
/**************************************************** [GET ALL ADMIN DATA ] ************************************************************************************/		
	
	@GetMapping("/getalladminData")
	public ResponseEntity<List<Administartor_Entity>> getAllAdminData()
	{
		return new ResponseEntity<List<Administartor_Entity>>(admin_Service.getAllAdminData(),HttpStatus.OK);
	}
	
/************************************************************* FEES DETAILS **************************************************************************************/	
/************************************************************** ADD FEES DETAILS *************************************************************************/	
	
	@PostMapping("/addFeeDetails")
	public ResponseEntity<String> addFeeDetails(@RequestBody FeeDetails_DTO feeDetails_DTO) 
	{
		return new ResponseEntity<String>(fee_Services.addFeeDetails(feeDetails_DTO),HttpStatus.CREATED);
	}
/************************************************************** GET FEES DETAILS *************************************************************************/	
	@GetMapping("/getFeeDetails")
	public ResponseEntity<List<FeeDetails_DTO>>  getFeeDetails()
	{
		return new ResponseEntity<List<FeeDetails_DTO>>(fee_Services.getFeeDetails(), HttpStatus.OK);
	}
	
	
	
	
}
