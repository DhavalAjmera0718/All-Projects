package com.SIS.Implimantation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SIS.Entities.EducationDetails_Entity;
import com.SIS.Proxies.EducationDetails_DTO;
import com.SIS.Repositories.EducationDetails_Repo;
import com.SIS.Services.Educational_Service;
import com.SIS.Utils.Conveter_Helper;

@Component
public class Educational_Implimantation implements Educational_Service{
	
	@Autowired
	private EducationDetails_Repo eDetails_Repo;

	@Autowired
	private Conveter_Helper helper;
	
/*****************************************************************************************************************************************************************************/
	@Override
	public String addEducationDetails(EducationDetails_DTO eDto) {
		
		EducationDetails_Entity edEntity = helper.EducationDetails_ConvertToDTo(eDto);
		eDetails_Repo.save(edEntity);
		
		return "EducationDetails Has Been saved..";
	}
/***************************************************************************************************************************************************************************/
	
	
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
