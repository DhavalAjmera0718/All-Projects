package com.OTP_Example.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class TwilioConfig {

	
	
	private String account_sid;
	private String authToken;
	private String trailnumber;
	
	 @PostConstruct
	    public void initTwilio() {
	        Twilio.init(account_sid, authToken);
	    }
	
	
}
