package com.Auth.ENTITY;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Authentication_credential")
public class Credential_Entity {

//	private String enRoll;
	
	@Id
	private String name;
	
	private String password;
	
	private String role;
	
	private String email;
	
//	@JsonFormat( pattern = "dd-MM-yyyy")
	private LocalDate dob;
	
	private Integer otp;
	
	@CreationTimestamp
	private Date createdTime;
	
	private String url;
	
	
	
	
	
}
