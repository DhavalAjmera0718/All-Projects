package com.Admin.UTILS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiAuthantication_helper {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void apiAuth_Function(@RequestHeader("Authorization") String headerToken) 
	{
		String value = headerToken;
		System.err.println(value);
		HttpHeaders headers=new HttpHeaders();
		headers.set("Authorization", value);
		System.err.println(value);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> req = new HttpEntity<>(null, headers);
		
		Boolean postForEntity = restTemplate.postForObject("http://SERVICE-AUTHENTICATION/auth/validate", req,  Boolean.class);
	}
	
}
