package com.OTP_Example.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import com.OTP_Example.DTO.PasswordResetRequestDto;
import com.OTP_Example.DTO.PasswordResetResponseDto;
import com.OTP_Example.Implimantation.Twilio_IMPLIMANATAION;

@RestController
@RequestMapping("/api/otp")
public class OTPController {

    @Autowired
    private Twilio_IMPLIMANATAION twilioImplementation;

    @PostMapping("/send")
    public Mono<ResponseEntity<PasswordResetResponseDto>> sendOTP(@RequestBody PasswordResetRequestDto requestDto) {
        return twilioImplementation.sendOTPForPasswordReset(requestDto)
                .map(response -> ResponseEntity.ok(response))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/check")
    public ResponseEntity<Boolean> checkEntity ()
    {
    	return new ResponseEntity<Boolean>(true , HttpStatus.OK);
    }
    
    
    @PostMapping("/verify")
    public Mono<ResponseEntity<String>> verifyOtp(@RequestBody PasswordResetRequestDto requestDto) {
        return twilioImplementation.validateOTP(requestDto.getOtp(), requestDto.getUserName())
            .map(ResponseEntity::ok)
            .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().body(e.getMessage())));
    }
    
}
