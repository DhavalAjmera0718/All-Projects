package com.User.Implimantation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.User.DTO.EducationDetails_DTO;
import com.User.Entity.EducationDetails_Entity;
import com.User.REPOSITORY.EducationDetails_Repo;
import com.User.Service.Educational_Service;
import com.User.UTILS.Conveter_Helper;

@Component
public class Educational_Implimantation implements Educational_Service{
	
	@Autowired
	private EducationDetails_Repo eDetails_Repo;

	@Autowired
	private Conveter_Helper helper;
	
/***************************************************[ addEducationDetails ]*******************************************************************************************************************/
	@Override
	public String addEducationDetails(EducationDetails_DTO eDto) {
		
		EducationDetails_Entity edEntity = helper.EducationDetails_ConvertToDTo(eDto);
		eDetails_Repo.save(edEntity);
		
		return "EducationDetails Has Been saved..";
	}
/**************************************************[ updateEducationDetails ]*************************************************************************************************************************/
	
	
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
}