	package com.SIS.Response_X_Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jwt_Request {
	
	private String username ;
	private String password;

}
