package com.SIS.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Administartor (id Long (PrimaryKey), 
password String, name String, gender String, contact String, address String, city String, pinCode String,securityKey String, role String)*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Administartor_Entity")
public class Administartor_Entity {
	
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String password;
	
	@Id
	private String name;
	
	private String gender;
	
	private String contact;
	
	private String address;
	
	private String city;
	
	private String pinCode;
	
	private String securityKey;
	
	

}
