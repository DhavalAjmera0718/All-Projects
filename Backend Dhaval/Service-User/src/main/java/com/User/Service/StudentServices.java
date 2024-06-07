package com.User.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.User.DTO.EducationDetails_DTO;
import com.User.DTO.Student_DTO;
import com.User.Entity.Student_Entity;

@Service
public interface StudentServices {
	
	
	public String 	registerWithDetails (Student_DTO dto);

	public Student_DTO   getUser(String enRoll);

	public List<Student_DTO> getUsers() ;

	public String 	updateUserDetails(String enRoll , Student_Entity sEntity )  ;

	public String   updateEducationDetails(Long idLong , EducationDetails_DTO dto);

	public String addEducationDetails(EducationDetails_DTO eDto);
	
	public List<Object[]> getSecurityKeyAndEnrollmentNo(String enrollmentNo);
	
	public String DeleteUser(String id);
	
/**************************************************** [ GET SECURITY KEY USINF JPQL ]*******************************************************************************/ 
	public String getOnly_SecurityKey_ByName(String name);
	
	public String Count_Data ();
	
	public List<Student_Entity> Get_DataBy_Character(String character);
	
}