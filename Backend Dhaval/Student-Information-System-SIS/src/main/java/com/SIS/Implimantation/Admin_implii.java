package com.SIS.Implimantation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SIS.Entities.Administartor_Entity;
import com.SIS.Entities.EducationDetails_Entity;
import com.SIS.Entities.FeeDetails_Entity;
import com.SIS.Entities.Student_Entity;
import com.SIS.Proxies.Administartor_DTOO;
import com.SIS.Proxies.EducationDetails_DTO;
import com.SIS.Proxies.FeeDetails_DTO;
import com.SIS.Proxies.Student_DTO;
import com.SIS.Repositories.Administartor_Repo;
import com.SIS.Repositories.EducationDetails_Repo;
import com.SIS.Repositories.FeeDetails_Repo;
import com.SIS.Repositories.Student_Repo;
import com.SIS.Services.Admin_Service;
import com.SIS.Services.FeeDetailsServices;
import com.SIS.Utils.Conveter_Helper;

@Component
public class Admin_implii implements Admin_Service , FeeDetailsServices{
	
	@Autowired
	private Administartor_Repo adRepo;
	
	@Autowired
	private Conveter_Helper helper;
	
	@Autowired
	private Student_Repo stRepo;
	
	@Autowired
	private EducationDetails_Repo edRepoo;
	
	@Autowired
	private FeeDetails_Repo feeDetails_Repo;
/***********************************************************************************************************************************************/	
	
	@Override
	public String registerWithDetails(Administartor_DTOO dto) 
	{
		Administartor_Entity adEntity = helper.administartor_ConvertToDTo(dto);
		System.err.println("Before Save---------------------->  " + adEntity);
		adRepo.save(adEntity);
		System.err.println("After Save---------------------->  " + adEntity);
		return"Admin Data Has Been Saved";
	}
	@Override
	public Administartor_DTOO getAdmin(String id) 
	{
		Administartor_Entity adminEntity = adRepo.findById(id).get();
		Administartor_DTOO adminDtoData = helper.administartor_ConvertToEntity(adminEntity);
		return adminDtoData;
	}
/********************************************updateAdminDetails ***********************************************************************/
	@Override
	public String updateAdminDetails( String id , Administartor_DTOO dtoo) 
	{
		Optional<Administartor_Entity> byId = adRepo.findById(id);
		if (byId!=null) {
			
			Administartor_Entity adEntity = byId.get();
			adEntity.setAddress(dtoo.getAddress());
			adEntity.setCity(dtoo.getCity());
			adEntity.setContact(dtoo.getContact());
			adEntity.setGender(dtoo.getGender());
			adEntity.setName(dtoo.getName());
			adEntity.setPassword(dtoo.getPassword());
			adEntity.setPinCode(dtoo.getPinCode());
			adEntity.setSecurityKey(dtoo.getSecurityKey());
			adRepo.save(adEntity);
			return "Admin data Hase Been Updated.......";
		}
		return "please Enter Valid Admin Id..";
	}
/******************************************************* GET ALL STUDENTS *******************************************************************************************/
	@Override
	public List<Student_DTO> getUsers() 
	{
		List<Student_Entity> alldata = (List<Student_Entity>) stRepo.findAll();
		List<Student_DTO> dumList = new ArrayList<>();
		for (Student_Entity student_Entity : alldata) {
			Student_DTO stDtoData = helper.Student_ConvertToEntity(student_Entity);
			dumList.add(stDtoData);
		}
		return dumList;
	
	}
/********************************************************* GET STUDENTs BY ID  ************************************************************************************/	
	@Override
	public String deleteUser(String enRoll) 
	{
		stRepo.deleteById(enRoll);
		return enRoll + " -----> Number Is Deleted...";
	}

/******************************************************** GET EDUCATIONAL DETAILS*****************************************************************************************************************************/
	@Override
	public List<EducationDetails_DTO> GetEducationDetails()
	{
		List<EducationDetails_Entity> edEntityData = (List<EducationDetails_Entity>) edRepoo.findAll();
		List<EducationDetails_DTO> dummyList = new ArrayList<>();
		for (EducationDetails_Entity educationDetails_Entity : edEntityData) {
			EducationDetails_DTO edDtodata = helper.EducationDetails_ConvertToEntity(educationDetails_Entity);
		
			dummyList.add(edDtodata);
		}
		return dummyList;
	}
/*************************************************************[ GET All Admin User]*************************************************************************************/	
	@Override
	public List<Administartor_Entity> getAllAdminData() {
		
		List<Administartor_Entity> all = (List<Administartor_Entity>) adRepo.findAll();
		
		List<Administartor_Entity> dummylist = new ArrayList<>();
		for (Administartor_Entity administartor_Entity : all) {
			dummylist.add(administartor_Entity);
			
		}
		return dummylist;
	}
	
/************************************************************* FEES DETAILS **************************************************************************************/	
/************************************************************ ADD FEES DETAILS *************************************************************************/	
	@Override
	public String addFeeDetails(FeeDetails_DTO feeDetails_DTO) 
	{
		try {
	        FeeDetails_Entity feeEntityData = helper.FeeDetails_ConvertToDTO(feeDetails_DTO);
	        feeDetails_Repo.save(feeEntityData);
	        System.err.println(feeEntityData);
	        return "Your fees Detail Has Been Saved";
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception or use a logger
	        return "Error: Unable to save fee details.";
	    }
		
	}
/************************************************************ GET FEES DETAILS *************************************************************************/	

	@Override
	public List<FeeDetails_DTO> getFeeDetails()
	{
		List<FeeDetails_Entity> allFeesData = (List<FeeDetails_Entity>) feeDetails_Repo.findAll();
		
		List<FeeDetails_DTO> dummyList = new ArrayList<>();
		for (FeeDetails_Entity feeDetails_Entity : allFeesData) {
			FeeDetails_DTO FeesDtoData = helper.FeeDetails_ConvertTOEntity(feeDetails_Entity);
			dummyList.add(FeesDtoData);
			
		}
		return dummyList;
	}
}

























