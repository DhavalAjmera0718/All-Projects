package com.Teacher.Helper;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

@Component
public class Teacher_Helper {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public boolean authentication(@RequestHeader Map<String,String> headerData) 
	{
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", headerData.get("token"));
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> hEntity = new HttpEntity<>(null, httpHeaders);
		 restTemplate.postForObject("http://SERVICE-AUTHENTICATION/auth/validate",hEntity, Boolean.class);
		 return true;
	}

}
