package com.EMPLOYEEAUTH.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EMPLOYEEAUTH.FreeMarker_DTO.MailRequest;
import com.EMPLOYEEAUTH.FreeMarker_DTO.MailResponse;
import com.EMPLOYEEAUTH.Implimantation.FreeMarker_Email_Impli;

import jakarta.mail.MessagingException;

@RestController
public class FreeMarker_Controller {

	
	
	
	@Autowired
	private FreeMarker_Email_Impli freeMarker_Impli;
	
	@PostMapping("freemarker_mail")
	public ResponseEntity<MailResponse> SendMail(@RequestBody MailRequest request ) throws MessagingException, javax.mail.MessagingException
	{
		System.err.println("Req----->| " + request);
		Map<String, Object> model = new HashMap<>(); 
		model.put("Name", request.getName());
		model.put("Location", " Ahmedabad");
		System.err.println("********");
		return new ResponseEntity<MailResponse>(freeMarker_Impli.sendEmail(request, model),HttpStatus.OK);
	} 
	
	
}
