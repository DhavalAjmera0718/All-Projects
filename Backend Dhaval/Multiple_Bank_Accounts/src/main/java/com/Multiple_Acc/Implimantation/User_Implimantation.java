package com.Multiple_Acc.Implimantation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Multiple_Acc.DTOO.Account_DTO;
import com.Multiple_Acc.DTOO.User_DTOO;
import com.Multiple_Acc.Entity.Account_Entity;
import com.Multiple_Acc.Entity.DataBase_User_Id_Pass;
import com.Multiple_Acc.Entity.User_Entity;
import com.Multiple_Acc.Helper_Utils.Converter_Helper;
import com.Multiple_Acc.Repository.Database_Id_Pass_Repo;
import com.Multiple_Acc.Repository.User_Repoo;

@Component
public class User_Implimantation {

	@Autowired
	private User_Repoo repoo;
	
	@Autowired
	private Database_Id_Pass_Repo repo2;
	
	@Autowired
	private Converter_Helper helper;
	
	public String SaveData(User_DTOO dtoo) 
	{
		User_Entity DTO_Data = helper.Convert_Entity_To_DTO(dtoo);
		repoo.save(DTO_Data);
		return "Data Has Been Saved.....!!!!!!";
		
	}
	
/********************************************************* GET BY ID **********************************************************************************/
	
	public User_DTOO GetByID(Long id) 
	{
		User_Entity entity = repoo.findById(id).get();
		
		List<Account_DTO> dummyList = new ArrayList<>();
		
		List<Account_Entity> accDetails = entity.getAccDetails();
		
		for (Account_Entity cEntity : accDetails) {
			
			Account_DTO childStatic_DTO = Account_DTO.childStatic_DTO(0l, cEntity.getBankName(), cEntity.getAccNumber(), cEntity.getAccBalance());
			
			dummyList.add(childStatic_DTO);
		}
		User_DTOO AllDtodata = User_DTOO.perentStatic_Dto(0l, entity.getUsername(), dummyList);
	
		return AllDtodata;
	}
	
	
	
	
//	public User_DTOO GetByID(Long id) 
//	{
//		User_Entity user_Entity = repoo.findById(id).get();
//		System.err.println(user_Entity);
//		 User_DTOO convert_DTO_TO_Entity = helper.Convert_DTO_TO_Entity(user_Entity);
//	
//		 System.err.println("------------"+convert_DTO_TO_Entity);
//		 return convert_DTO_TO_Entity;
//	}
	
	
/*************************************************** GET BANK DETAILS USING JPQL QUERY****************************************************************************************/	
	
	public List<Long> getAccountBalancesByUserId(Long id)
	{
		System.err.println("id in Implimantation---- " + id);
		 List<Long> accountBalancesByUserId = repoo.getAccountBalancesByUserId(id);
		return accountBalancesByUserId;
	}
	
/***********************************************  ADD USER *****************************************************************************************************/	
	public String Add_User(DataBase_User_Id_Pass dto) 
	{
		repo2.save(dto);
		
		return "Username-Password Has Been Saved";
	}

/***********************************************  DELETE BY ID  *****************************************************************************************************/	

	public String DeleteById(Long id) 
	{
		repoo.deleteById(id);
		return "Id Number "+ id + " Has Been Deleted.";
		
	}
/********************************************** UPDATE BY ID ********************************************************************************************/

 public String UpdateByID(Long id ,User_Entity entity ) 
 {
	 Optional<User_Entity> entitydata = repoo.findById(id);
	
	 
	 if(entitydata.isPresent()) 
	 {
		 User_Entity user_Entity = entitydata.get();
		 if (entity.getUserId()!=null) 
		 { 
			user_Entity.setUserId(entity.getUserId());	
		 }
		 if(entity.getUsername()!=null) 
		 {
			 user_Entity.setUsername(entity.getUsername());
		 }
		 if(entity.getAccDetails()!=null) 
		 {
			 user_Entity.setAccDetails(entity.getAccDetails());
		 }
		 repoo.save(user_Entity);
		 return "Data Has Been Updated";
	 }
	 else {
		return "Please Enter Valid id..";
	}
 }


}





