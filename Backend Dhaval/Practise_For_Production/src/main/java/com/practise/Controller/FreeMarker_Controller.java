package com.practise.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practise.DTO.MailRequest;
import com.practise.DTO.MailResponse;
import com.practise.Implimantation.FreeMarker_Impli;

@RestController
public class FreeMarker_Controller {

	
	
	@Autowired
	private FreeMarker_Impli service;

	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Ahmedabad");
		return service.sendEmail(request, model);

	}
}
