package com.OTP_Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.OTP_Example.Config.TwilioConfig;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class TwilioOtpExampleApplication {

	
	@Autowired
	private TwilioConfig twilioConfig;
	
//	@Bean
//	@PostConstruct
//	public void init() 
//	{
//		Twilio.init(twilioConfig.getAccount_sid(), twilioConfig.getAuthToken());
//	}
//	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TwilioOtpExampleApplication.class, args);
		System.err.println("MAIN APPLICATION");
	}

}
