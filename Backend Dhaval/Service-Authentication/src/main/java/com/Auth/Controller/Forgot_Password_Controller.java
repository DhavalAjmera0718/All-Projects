package com.Auth.Controller;

import java.time.LocalDate;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Auth.Implimantation.Forgot_password_IMPLI;
import com.Auth.Repository.Credential_Repo;

@RestController
public class Forgot_Password_Controller {

	
	@Autowired
	private Credential_Repo crepo;
	
	@Autowired
	private Forgot_password_IMPLI forgotImpli;
	
	
//	@PostMapping("/sendotp/{email}/{dob}")
////	public ResponseEntity<?> sendRandomOTP(@RequestBody String email , @RequestBody Data dob) throws MessagingException 
//	public ResponseEntity<?> sendRandomOTP(@PathVariable("email") String email ,  @PathVariable("dob")  Data dob) throws MessagingException 
//	{
////		Credential_Entity byEmail = crepo.findByEmail(email);
////		if (byEmail!=null) {			
//			return new ResponseEntity<String>(forgotImpli.sendRandomOTP(email , dob) , HttpStatus.CREATED);
////		}
////		else {
////			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
////		}
//		
//	}
	@PostMapping("/sendotp/{email}/{dob}")
	public ResponseEntity<String> sendRandomOTP(@PathVariable("email") String email
			,@PathVariable("dob")  LocalDate dob) throws MessagingException {
		System.err.println("Email from Controller"+email);
		System.err.println("DOB from Controller"+dob);
	    return new ResponseEntity<String>(forgotImpli.sendRandomOTP(email, dob), HttpStatus.CREATED);
	}
/******************************************************* [ Verify OTP ] ******************************************************************************************************************/	
	
	@GetMapping("/verifyotp/{email}/{otp}/{dob}")
	public ResponseEntity<String> verifyOTP(@PathVariable("email") String email ,
			@PathVariable("otp") Integer otp 
			,@PathVariable("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob  ) throws MessagingException 
	{
		return new ResponseEntity<>(forgotImpli.verifyOTP(email, otp, dob) , HttpStatus.CREATED);
	} 
/******************************************************* [GET LINK FOR NEVIGATE TO UPDATE PASSWORD ] ******************************************************************************************************************/	
	
	@GetMapping("/getLink/{email}/{otp}/{dob}")
	public ResponseEntity<String> getLink(@PathVariable("email") String email ,
			@PathVariable("otp") Integer otp 
			,@PathVariable("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob  ) throws MessagingException 
	{
		return new ResponseEntity<>(forgotImpli.verifyOTP(email, otp, dob) , HttpStatus.CREATED);
	} 
	
	
	
}
