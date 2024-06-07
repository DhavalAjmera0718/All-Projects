package com.SIS.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
