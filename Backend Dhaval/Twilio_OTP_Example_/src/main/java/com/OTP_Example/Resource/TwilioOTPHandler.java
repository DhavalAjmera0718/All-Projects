package com.OTP_Example.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.OTP_Example.DTO.PasswordResetRequestDto;
import com.OTP_Example.Implimantation.Twilio_IMPLIMANATAION;

import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
@Component
public class TwilioOTPHandler {

	
	 @Autowired
	    private Twilio_IMPLIMANATAION service;

	    public Mono<ServerResponse> sendOTP(ServerRequest serverRequest) {
			return serverRequest.bodyToMono(PasswordResetRequestDto.class)
	       .flatMap(dto-> service.sendOTPForPasswordReset(dto))
	       .flatMap(dto->ServerResponse.status(HttpStatus.OK)
	    		   .body(BodyInserters.fromValue(dto)));
	    }
	    
/********************************************************[ Validate OTP]***************************************************************************/	    
	    public Mono<ServerResponse> validOTP(ServerRequest serverRequest) {
			return serverRequest.bodyToMono(PasswordResetRequestDto.class)
	       .flatMap(dto-> service.validateOTP(dto.getOtp() , dto.getUserName()))
	       .flatMap(dto->ServerResponse.status(HttpStatus.OK)
	    		   .bodyValue(dto));
	    }
}
