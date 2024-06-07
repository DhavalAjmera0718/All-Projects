package com.User.Entity;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*tudent(enrollmentNo String (PrimaryKey), password String, name String,gender String, dob date, 
 * branch String, contact String, address String, city String, pinCode Integer, securityKey String,role String)*/

@jakarta.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_table")
public class Student_Entity {

	//@Id
	private String enrollmentNo;
	
	private String password;
	@Id
	private String name;
	
	private String gender;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	
	private String branch;
	
	private String contact;
	
	private String address;
	
	private String city;
	
	private Integer pinCode;
	
	private String securityKey;
	
	private String role;
	
	
	
	
}
