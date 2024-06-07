package com.SIS.Services;

import org.springframework.stereotype.Service;

import com.SIS.Proxies.EducationDetails_DTO;

@Service
	public interface Educational_Service {

	public String   updateEducationDetails(Long idLong , EducationDetails_DTO dto);
	public String addEducationDetails(EducationDetails_DTO eDto);

	
}
