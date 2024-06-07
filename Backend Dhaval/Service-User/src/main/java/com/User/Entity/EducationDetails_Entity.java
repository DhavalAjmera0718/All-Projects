package com.User.Entity;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
