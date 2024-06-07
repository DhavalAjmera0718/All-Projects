package com.SIS.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*tudent(enrollmentNo String (PrimaryKey), password String, name String,gender String, dob date, 
 * branch String, contact String, address String, city String, pinCode Integer, securityKey String,role String)*/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_table")
public class Student_Entity {

	@Id
	private String enrollmentNo;
	
	private String password;
	
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
	
	
	
	
}
