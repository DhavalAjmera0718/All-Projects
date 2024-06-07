package com.Admin.Implimantation;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Admin.Entity.Administartor_Entity;
import com.Admin.Entity.FeeDetails_Entity;
import com.Admin.Proxi.Administartor_DTOO;
import com.Admin.Proxi.FeeDetails_DTO;
import com.Admin.Repository.Administartor_Repo;
import com.Admin.Repository.FeeDetails_Repo;
import com.Admin.Service.Admin_Service;
import com.Admin.Service.FeeDetailsServices;
import com.Admin.UTILS.Conveter_Helper;


@Component
public class Admin_implii  implements Admin_Service,FeeDetailsServices{
	
	@Autowired
	private Administartor_Repo adRepo;
	
	@Autowired
	private Conveter_Helper helper;
	
	@Autowired
	private FeeDetails_Repo feeDetails_Repo;
	
	
/********************************************************************[ registerWithDetails ]***************************************************************************/	
	
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
	public Administartor_DTOO getAdmin(Long id) 
	{
		Administartor_Entity adminEntity = adRepo.findById(id).get();
		Administartor_DTOO adminDtoData = helper.administartor_ConvertToEntity(adminEntity);
		return adminDtoData;
	}
/********************************************updateAdminDetails ***********************************************************************/
	@Override
	public String updateAdminDetails( Long id , Administartor_DTOO dtoo) 
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
	@Override
	public List<Administartor_Entity> getAllAdminData() {
		
		List<Administartor_Entity> all = (List<Administartor_Entity>) adRepo.findAll();
		
		List<Administartor_Entity> dummylist = new ArrayList<>();
		for (Administartor_Entity administartor_Entity : all) {
			dummylist.add(administartor_Entity);
			
		}
		return dummylist;
	}
/********************************************************[ DELETE ADMIN BY ID]*******************************************************************************/		
		 
		@Override
	public String Delete_AdminBy_Id( Long id) 
	{
		adRepo.deleteById(id);
		return "Admin Data Hase Been Deleted";
	}
		 
		 
	
}
