package com.DemoOld_Security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {

	@Id
	private String userId;
	
	private String name;
	
	private String email;
}
