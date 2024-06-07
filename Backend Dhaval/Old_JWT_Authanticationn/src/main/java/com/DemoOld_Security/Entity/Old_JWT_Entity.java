package com.DemoOld_Security.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "old_jwt")
public class Old_JWT_Entity {

	@Id
	private String userName;
	
	private String password;

}
