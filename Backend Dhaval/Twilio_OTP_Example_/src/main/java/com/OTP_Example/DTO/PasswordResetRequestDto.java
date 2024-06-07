package com.OTP_Example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetRequestDto {
	
	
	private String phoneNo;
	private String userName;
	private String otp;

}
