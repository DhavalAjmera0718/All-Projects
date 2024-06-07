package com.Admin.Entity;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
. FeeDetails (id Long (PrimaryKey), student_enrollmentNo String, feeAmount double, dueDate date, updatedBy String, updatedDate date)-*/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "FeeDetails_Entity")
public class FeeDetails_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String student_enrollmentNo;
	
	private double feeAmount;
	
	@JsonFormat(pattern = "yyyy-mm-dd",timezone = "UTC")
	private Date dueDate;
	
	private String updatedBy;

	@CreationTimestamp
	private Date updatedDate;
}
