package com.DemoOld_Security.Req_Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Jwt_Request {

	private String userName;
	
	private String password;
}
