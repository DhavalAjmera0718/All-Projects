package com.SIS.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SIS.Entities.Administartor_Entity;
import com.SIS.Proxies.Administartor_DTOO;
import com.SIS.Proxies.EducationDetails_DTO;
import com.SIS.Proxies.FeeDetails_DTO;
import com.SIS.Proxies.Student_DTO;

@Service
public interface Admin_Service {

	
	public String registerWithDetails(Administartor_DTOO dto) ;
	
	public Administartor_DTOO getAdmin(String id) ;
	
	public String updateAdminDetails( String id , Administartor_DTOO dtoo) ;
/********************************************** STUDENT DETAILS****************************************************************************/	
	public List<Student_DTO> getUsers() ;
	
	
	public String deleteUser(String enRoll) ;
/********************************************** EDUCATION DETAILS****************************************************************************/	
	
	public List<EducationDetails_DTO> GetEducationDetails();

/*********************************************** FEES DETAILS ***************************************************************************/	
	
//	public List<FeeDetails_DTO> getFeeDetails();
//	
//	public String addFeeDetails(FeeDetails_DTO feeDetails_DTO);
	public  List<Administartor_Entity> getAllAdminData();
	
}

