package com.Admin.Controller;

import java.util.List;
import java.util.Map;

import javax.security.auth.login.CredentialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Admin.Entity.Administartor_Entity;
import com.Admin.Proxi.Administartor_DTOO;
import com.Admin.Proxi.FeeDetails_DTO;
import com.Admin.Service.Admin_Service;
import com.Admin.Service.FeeDetailsServices;
import com.Admin.UTILS.ApiAuthantication_helper;


@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdministrativeController {
	@Autowired
	private Admin_Service admin_Service;
	
	@Autowired
	private FeeDetailsServices fee_Services;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ApiAuthantication_helper authhelper;
	

/*************************************************************************************************************************************************************/	
	
	@PostMapping("/register_admin")
	public ResponseEntity<String> registerWithDetails(@RequestHeader("Authorization") String headerToken,@RequestBody Administartor_DTOO dto) 
//	public ResponseEntity<String> registerWithDetails(@RequestBody Administartor_DTOO dto) 

	{
		String value = headerToken;
		System.err.println(value);
		HttpHeaders headers=new HttpHeaders();
		headers.set("Authorization", value);
		System.err.println(value);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> req = new HttpEntity<>(null, headers);
		
		Boolean postForEntity = restTemplate.postForObject("http://SERVICE-AUTHENTICATION/auth/validate", req,  Boolean.class);
		System.err.println("postForEntity********" + postForEntity);
		if(postForEntity) {
			String registerWithDetails = admin_Service.registerWithDetails(dto);
			return new ResponseEntity<String>(registerWithDetails,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!",HttpStatus.BAD_REQUEST);
//		
	}
	
	@GetMapping("/getAdmin/{id}")
//	public ResponseEntity<Administartor_DTOO> getAdmin(@RequestHeader ("Authorization") String headerToken,  @PathVariable String id) throws CredentialException 
	public ResponseEntity<Administartor_DTOO> getAdmin(@PathVariable Long id) throws CredentialException 

	{
//		String value = headerToken;
//		System.err.println(value);
//		HttpHeaders headers=new HttpHeaders();
//		headers.set("Authorization", value);
//		System.err.println(value);
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<Object> req = new HttpEntity<>(null, headers);
//		
//		Boolean postForEntity = restTemplate.postForObject("http://SERVICE-AUTHENTICATION/auth/validate", req,  Boolean.class);
//		
//		if(postForEntity) {
		return new ResponseEntity<Administartor_DTOO>(admin_Service.getAdmin(id),HttpStatus.ACCEPTED);
//		}
//		else {
//			throw new CredentialException();
//		}
	}
/************************************************* updateAdminDetails ********************************************************************************************/	
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<String> updateAdminDetails(@RequestHeader("Authorization") String headerToken, @PathVariable Long id , @RequestBody Administartor_DTOO dtoo)
	{
		String value = headerToken;
		System.err.println(value);
		HttpHeaders headers=new HttpHeaders();
		headers.set("Authorization", value);
		System.err.println(value);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> req = new HttpEntity<>(null, headers);
		
		Boolean postForEntity = restTemplate.postForObject("http://SERVICE-AUTHENTICATION/auth/validate", req,  Boolean.class);
		System.err.println("postFORENTITY From Admin Controller**********" + postForEntity);
		if (postForEntity) {			
			return new ResponseEntity<String>(admin_Service.updateAdminDetails(id, dtoo) , HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
		
		
	}
	
/************************************************************* FEES DETAILS **************************************************************************************/	
/************************************************************** ADD FEES DETAILS *************************************************************************/	
		
		@PostMapping("/addFeeDetails")
		public ResponseEntity<String> addFeeDetails(@RequestBody FeeDetails_DTO feeDetails_DTO) 
		{
			return new ResponseEntity<String>(fee_Services.addFeeDetails(feeDetails_DTO),HttpStatus.CREATED);
		}
/************************************************************** GET FEES DETAILS *************************************************************************/	
		@GetMapping("/get_FeesDetails")
		public ResponseEntity<List<FeeDetails_DTO>>  getFeeDetails()
		{
			return new ResponseEntity<List<FeeDetails_DTO>>(fee_Services.getFeeDetails(), HttpStatus.OK);
		}
		
/***********************************************************************************************************************************************/
/******************************************************** USE OF REST TEMPLATE [ GET USER DATA] ********************************************************************* @throws UserPrincipalNotFoundException *******************************************************************************************/		
		@GetMapping("/get-apii")
		public ResponseEntity<Object> getApi(@RequestHeader Map<String,String> headerData )
		{
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Authorization", headerData.get("token"));
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Object> hEntity = new HttpEntity<>(null, httpHeaders);
			System.err.println("hEntity From Admin Controller ------------> " + hEntity);
			
			Boolean validate = restTemplate.postForObject("http://SERVICE-AUTHENTICATION/auth/validate",hEntity, Boolean.class);
			
			
			System.err.println("Validation --------> "  + validate);
			
			if (validate) {
				
				System.err.println("Data to be Get From SERVISE-ADMIN -------------> " );
				String forObject =restTemplate.getForObject("http://SERVICE-AUTHENTICATION/user/user/get-api", String.class);;
				return new ResponseEntity<Object>(forObject , HttpStatus.ACCEPTED);
			}
			return null;
		} 
/*********************************************************************************************************************************************/
		@PostMapping("/save-data")
		public ResponseEntity<Object> savdata(@RequestHeader Map<String, String> header, @RequestBody Object object)
		{
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Authorization", header.get("token"));
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<Object> reqHttpEntity = new HttpEntity<Object>( object , httpHeaders);
			System.err.println("reqHttpEntity From Admin Controller Save data--------->" + reqHttpEntity);
			
			Boolean validate = restTemplate.postForObject("http://SERVICE-AUTHENTICATION/auth/validate", reqHttpEntity , Boolean.class);
			System.err.println("From Admin Controller Save data--------->" + validate) ;
			if (validate) {
				System.err.println("111111111111");
				Object postForObject = restTemplate.postForObject("http://SERVICE-USER/user/user/check-api", reqHttpEntity, Object.class);
				System.err.println("----------------->  " + postForObject);
				
				return new ResponseEntity<Object>(postForObject,HttpStatus.ACCEPTED);
			}
			return null;
			
		}
/******************************************************* [ ADD STUDENT DATA ]*******************************************************************************************/		
		@PostMapping("/add-student-data")
		public ResponseEntity<?> AddStudent(@RequestBody Object object)
		{
			System.err.println("OBJECT FROM SERVICE-Admin---------> " + object);
			ResponseEntity<String> postForEntity = restTemplate.postForEntity("http://SERVICE-USER/user/user/register-user", object, String.class);
			
			return ResponseEntity.ok(postForEntity);
		}
/*************************************************** [ DELETE USER DATA ]*************************************************************************************/		
		@GetMapping("/delete_userdata/{id}")
		public ResponseEntity<String> DeleteUserData(@PathVariable("id") String id)
		{
			System.err.println("OBJECT FROM SERVICE-Admin---------> " + id);
			String getForObject = restTemplate.getForObject("http://SERVICE-USER/user/user/delete_user/"+id, String.class);
			
			return new ResponseEntity<String>(getForObject,HttpStatus.ACCEPTED);
		}
		
/***************************************************** [ UPDATE STUDENT ]*************************************************************************************/		

		@PostMapping("/updateEducationDetails/{id}")
		public ResponseEntity<String> updateEducationDetails(@PathVariable("id") Long id ,@RequestBody Object object) 
		{
			//String getForObject = restTemplate.getForObject("http://SERVICE-USER/user/user/updateEducationDetails/"+id, String.class);
			
			String getForObject = restTemplate.postForObject("http://SERVICE-USER/user/user/updateEducationDetails/"+id, object, String.class);
			return new ResponseEntity<String>(getForObject,HttpStatus.ACCEPTED);

		}
		
/*****************************************************[GET ALL STUDENT]********************************************************************************************/		

		
		@GetMapping("/getAllUser")
		public ResponseEntity<String> getallsudent()
		{
		  System.err.println("Data to be Get From SERVISE-ADMIN -------------> " );
		  String forObject =restTemplate.getForObject("http://SERVICE-USER/user/user/getAllUser", String.class);;
		  return new ResponseEntity<String>(forObject , HttpStatus.ACCEPTED);
		} 
		
/**************************************************** [GET ALL ADMIN DATA ] ************************************************************************************/		
		
		@GetMapping("/getalladminData")
		public ResponseEntity<?> getAllAdminData()
		{
			return new ResponseEntity<List<Administartor_Entity>>(admin_Service.getAllAdminData(),HttpStatus.OK);
		}
		
/****************************************************[ DELETE ADMIN BY ID]*********************************************************************************/		
		@GetMapping("/delete_admin/{id}")
		public ResponseEntity<String> DeleteAdminByID(@PathVariable("id") Long id)
		{
			return new ResponseEntity<String>(admin_Service.Delete_AdminBy_Id(id),HttpStatus.ACCEPTED);
		}
		


}























