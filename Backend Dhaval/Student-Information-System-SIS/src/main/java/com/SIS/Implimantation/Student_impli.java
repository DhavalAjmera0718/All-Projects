package com.SIS.Implimantation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SIS.Entities.EducationDetails_Entity;
import com.SIS.Entities.FeeDetails_Entity;
import com.SIS.Entities.Student_Entity;
import com.SIS.Proxies.EducationDetails_DTO;
import com.SIS.Proxies.FeeDetails_DTO;
import com.SIS.Proxies.Student_DTO;
import com.SIS.Repositories.EducationDetails_Repo;
import com.SIS.Repositories.FeeDetails_Repo;
import com.SIS.Repositories.Student_Repo;
import com.SIS.Services.StudentServices;
import com.SIS.Utils.Conveter_Helper;

@Component
public class Student_impli implements StudentServices {

	@Autowired
	private Student_Repo stRepoo;
	
	@Autowired
	private FeeDetails_Repo feeDetails_Repo;
	
	
	@Autowired
	private Conveter_Helper helper;
	
	@Autowired
	private EducationDetails_Repo eDetails_Repo;
	
	@Override
	public String registerWithDetails(Student_DTO dto) {
	
		Student_Entity student_Data = helper.Student_ConvertToDtoo(dto);
		stRepoo.save(student_Data);
		return "Student Resgistration Has Been successful...!!!";
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
		System.err.println(sEntity);
		Optional<Student_Entity> byId = stRepoo.findById(enRoll);
		if (byId!=null) {
			
			Student_Entity student_Entity = byId.get();
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
			System.err.println(student_Entity);
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
/******************************************************* getFeeDetails *****************************************************************************************/
@Override
public List<FeeDetails_DTO> getFeeDetails(String enRoll) {
	
	System.err.println("++++++++++++  " + enRoll);
		List<FeeDetails_Entity> byEnrollmentNo = feeDetails_Repo.findByEnrollmentNo(enRoll);
		List<FeeDetails_DTO> dummyList = new ArrayList<>();
		for (FeeDetails_Entity feeDetails_Entity : byEnrollmentNo) {
			FeeDetails_DTO fdtodata = helper.FeeDetails_ConvertTOEntity(feeDetails_Entity);
			dummyList.add(fdtodata);
			
		}
	
	return dummyList;
}	
/******************************************************* GET SECURITY USING ID*********************************************************************************************/

public List<Object[]> getSecurityKeyAndEnrollmentNo(String enrollmentNo) {
    return stRepoo.findSecurityKeyAndEnrollmentNoByEnrollmentNo(enrollmentNo);
    }
}




















