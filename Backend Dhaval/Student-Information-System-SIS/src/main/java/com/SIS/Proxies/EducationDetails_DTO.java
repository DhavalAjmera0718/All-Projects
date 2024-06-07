package com.SIS.Proxies;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDetails_DTO {
	
	private Long id;
	
	private String student_enrollmentNo;
	
	private String educationType;
	
	private String percentage;
	
	private boolean qualified;
	
	private String updatedBy;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd HH:MM:SS")
	private Date updatedDate;


}
