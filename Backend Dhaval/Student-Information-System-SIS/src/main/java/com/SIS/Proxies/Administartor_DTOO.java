package com.SIS.Proxies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administartor_DTOO {

	private Long id;
	
	private String password;
	
	private String name;
	
	private String gender;
	
	private String contact;
	
	private String address;
	
	private String city;
	
	private String pinCode;
	
	private String securityKey;
}
