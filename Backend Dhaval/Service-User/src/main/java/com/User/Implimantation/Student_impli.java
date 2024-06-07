package com.User.Implimantation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.User.DTO.EducationDetails_DTO;
import com.User.DTO.Student_DTO;
import com.User.Entity.EducationDetails_Entity;
import com.User.Entity.Student_Entity;
import com.User.REPOSITORY.EducationDetails_Repo;
import com.User.REPOSITORY.Student_Repo;
import com.User.Service.StudentServices;
import com.User.UTILS.Conveter_Helper;

@Component
public class Student_impli implements StudentServices {

	@Autowired
	private Student_Repo stRepoo;
	
//	@Autowired
//	private FeeDetails_Repo feeDetails_Repo;
	
	
	@Autowired
	private Conveter_Helper helper;
	
	@Autowired
	private EducationDetails_Repo eDetails_Repo;
	
	@Override
	public String registerWithDetails(Student_DTO dto) {
	
		Student_Entity student_Data = helper.Student_ConvertToDtoo(dto);
		stRepoo.save(student_Data);
//		return "Student Resgistration Has Been successful...!!!";
		return "Student Data Hse Been Saved";
	}
/****************************************************** getUser *****************************************************************************************/
	@Override
	public Student_DTO getUser(String enRoll) {
		Student_Entity student_Entity = stRepoo.findById(enRoll).get();
		
		Student_DTO stDtoData = helper.Student_ConvertToEntity(student_Entity);
		return stDtoData;		
		
	}
/**************************************************** addEducationDetails ********************************************************************************************/

	@Override
	public String addEducationDetails(EducationDetails_DTO eDto) {
		
		EducationDetails_Entity edEntity = helper.EducationDetails_ConvertToDTo(eDto);
		eDetails_Repo.save(edEntity);
		
		return "EducationDetails Has Been saved..";
	}

/********************************************************** updateUserDetails **************************************************************************************/
	@Override
	public String updateUserDetails(String enRoll, Student_Entity sEntity) {
		System.err.println( "BEFOR SAVE*********" + sEntity);
		Optional<Student_Entity> byId = stRepoo.findById(enRoll);
		if (byId!=null) {
			System.err.println("-***********");
			Student_Entity student_Entity = byId.get();
			student_Entity.setEnrollmentNo(sEntity.getEnrollmentNo());
			student_Entity.setAddress(sEntity.getAddress());
			student_Entity.setBranch(sEntity.getBranch());
			student_Entity.setCity(sEntity.getCity());
			student_Entity.setContact(sEntity.getContact());
			student_Entity.setGender(sEntity.getGender());
			student_Entity.setName(sEntity.getName());
			student_Entity.setPassword(sEntity.getPassword());
			student_Entity.setPinCode(sEntity.getPinCode());
			student_Entity.setSecurityKey(sEntity.getSecurityKey());
			stRepoo.save(student_Entity);
			System.err.println( "After SAVE******" + student_Entity);
			return "Data Has Been Updated....";
			
		}
		else {
			return "Please Enter valid Enrollment Number....";
		}
		
	}
/************************************************************************************************************************************************/
	@Override
	public String updateEducationDetails(Long idLong , EducationDetails_DTO dto) {
		
		Optional<EducationDetails_Entity> byId = eDetails_Repo.findById(idLong);
		
		if (byId!=null) {
			EducationDetails_Entity edEntity = byId.get();
			
			edEntity.setEducationType(dto.getEducationType());
			edEntity.setPercentage(dto.getPercentage());
			edEntity.setUpdatedBy(dto.getUpdatedBy());
			edEntity.setUpdatedDate(dto.getUpdatedDate());
			eDetails_Repo.save(edEntity);
			return "Educational Data has Been Updated.."; 
		}
		else {
			return "Please Enter Valid Id...!!!";
			
		}
	}
/************************************************************ [ GET ALL USER ]************************************************************************************/

	@Override
	public List<Student_DTO> getUsers() 
	{
		List<Student_Entity> alldata = (List<Student_Entity>) stRepoo.findAll();
		List<Student_DTO> dumList = new ArrayList<>();
		for (Student_Entity student_Entity : alldata) {
			Student_DTO stDtoData = helper.Student_ConvertToEntity(student_Entity);
			dumList.add(stDtoData);
		}
		return dumList;
	
	}
	
/******************************************************* GET SECURITY USING ID*********************************************************************************************/

public List<Object[]> getSecurityKeyAndEnrollmentNo(String enrollmentNo) {
    return stRepoo.findSecurityKeyAndEnrollmentNoByEnrollmentNo(enrollmentNo);
    }

/******************************************************** DELETE USER ***********************************************************************************************************/
	@Override
	public String DeleteUser(String id) 
	{
		System.err.println("FROM STUDENT IMPLI ---->> " + id);
		stRepoo.deleteById(id);
//		return "Student Id -----> " + id + " Has Been Deleted.";
		return null;
	}
/**************************************************** [ GET SECURITY KEY USINF JPQL ]*******************************************************************************/ 

	
	public String getOnly_SecurityKey_ByName(String name) 
	{
		return	stRepoo.getOnly_SecurityKey_ByName(name);
	}
/******************************************************[ COUNT DATA ] *********************************************************************************/	
	@Override
	public String Count_Data() {
			
		return stRepoo.Count_Data();
	}
	@Override
	public List<Student_Entity> Get_DataBy_Character(String character) {
		
		return stRepoo.Get_DataBy_Character(character);
	}
/**************************************************************[ GET ALL USER ]********************************************************************************/	

	
	
	
}
