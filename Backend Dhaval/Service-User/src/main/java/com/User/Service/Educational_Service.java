package com.User.Service;

import org.springframework.stereotype.Service;

import com.User.DTO.EducationDetails_DTO;

@Service
public interface Educational_Service {
	
	public String   updateEducationDetails(Long idLong , EducationDetails_DTO dto);
	public String addEducationDetails(EducationDetails_DTO eDto);

}
