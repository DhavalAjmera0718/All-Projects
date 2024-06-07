package com.SIS.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*d. EducationDetails (id Long (PrimaryKey),student_enrollmentNo String, educationType String,
percentage String, qualified boolean, updatedBy String, updatedDate date)*/
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "EducationDetails_Entity")
public class EducationDetails_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String student_enrollmentNo;
	
	private String educationType;
	
	private String percentage;
	
	private boolean qualified;
	
	private String updatedBy;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}
