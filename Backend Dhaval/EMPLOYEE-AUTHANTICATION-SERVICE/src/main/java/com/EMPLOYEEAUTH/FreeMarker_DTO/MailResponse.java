package com.EMPLOYEEAUTH.FreeMarker_DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponse {
	
	
	private String message;
	private boolean status;

}