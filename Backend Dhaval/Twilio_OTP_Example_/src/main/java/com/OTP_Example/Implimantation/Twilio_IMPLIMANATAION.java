package com.OTP_Example.Implimantation;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.OTP_Example.Config.TwilioConfig;
import com.OTP_Example.DTO.OtpStatus;
import com.OTP_Example.DTO.PasswordResetRequestDto;
import com.OTP_Example.DTO.PasswordResetResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import reactor.core.publisher.Mono;

@Component
public class Twilio_IMPLIMANATAION {

	
	   @Autowired
	    private TwilioConfig twilioConfig;
	   
	   PasswordResetResponseDto passwordResetResponseDto=null;

	   Map<String, String> otpMap = new HashMap<>();

	    public Mono<PasswordResetResponseDto> sendOTPForPasswordReset(PasswordResetRequestDto passwordResetRequestDto) {

	        PasswordResetResponseDto passwordResetResponseDto = null;
	        System.err.println("Trail Number--------->" + twilioConfig.getTrailnumber());
	        try {
	        	PhoneNumber to = new PhoneNumber(passwordResetRequestDto.getPhoneNo());
	            PhoneNumber from = new PhoneNumber("+15096318405");  // Ensure this is not null
	            String otp = generateOTP();
	            String otpMessage = "Dear Customer, Your OTP is " + otp + ". Use this Passcode to complete your transaction. Thank You.";

	            Message message = Message.creator(to, from, otpMessage).create();
	            otpMap.put(passwordResetRequestDto.getUserName(), otp);

	            System.out.println("SMS sent with SID: " + message.getSid());

	            passwordResetResponseDto = new PasswordResetResponseDto(OtpStatus.DELIVERED, otpMessage);
	        } catch (Exception e) {
	            System.err.println("Error sending SMS: " + e.getMessage());
	            passwordResetResponseDto = new PasswordResetResponseDto(OtpStatus.FAILED, e.getMessage());
	        }
	        return Mono.just(passwordResetResponseDto);
	    }

	    public Mono<String> validateOTP(String userInputOtp, String userName) {
	        if (userInputOtp.equals(otpMap.get(userName))) {
	            otpMap.remove(userName,userInputOtp);
	            return Mono.just("Valid OTP please proceed with your transaction !");
	        } else {
	            return Mono.error(new IllegalArgumentException("Invalid otp please retry !"));
	        }
	    }

	    //6 digit otp
	    private String generateOTP() {
	        return new DecimalFormat("000000")
	                .format(new Random().nextInt(999999));
	    }
}
