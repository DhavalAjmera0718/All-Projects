package com.Multiple_Acc.Response_X_Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jwt_Request {

	private String userName;
	
	private String passWord;
}
