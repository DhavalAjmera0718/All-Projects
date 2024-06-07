package com.SIS.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SIS.Entities.Student_Entity;
import com.SIS.Proxies.EducationDetails_DTO;
import com.SIS.Proxies.FeeDetails_DTO;
import com.SIS.Proxies.Student_DTO;

@Service
public interface StudentServices {
	
	
	public String 	registerWithDetails (Student_DTO dto);

	public Student_DTO   getUser(String enRoll);

	//public Student_DTO   getFeeDetails();//jpql query

	public String 	updateUserDetails(String enRoll , Student_Entity sEntity )  ;

	public String   updateEducationDetails(Long idLong , EducationDetails_DTO dto);
	public String addEducationDetails(EducationDetails_DTO eDto);

	public List<FeeDetails_DTO> getFeeDetails(String enRoll);
	
	public List<Object[]> getSecurityKeyAndEnrollmentNo(String enrollmentNo);

	/************************************************************************************************************************************************/





}
