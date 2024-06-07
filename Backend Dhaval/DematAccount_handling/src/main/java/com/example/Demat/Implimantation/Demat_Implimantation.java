package com.example.Demat.Implimantation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Demat.Entity.Demat_MainEntity;
import com.example.Demat.Repository.Demat_Repoo;
import com.example.Demat.Service.Demat_Service;
import com.example.Demat_Helper_Class.Demat_Helper;

@Component
public class Demat_Implimantation implements Demat_Service{

	@Autowired 
	private Demat_Repoo repo;
	
	@Override
	public String SaveData(MultipartFile file) {
		
		try {
			
			if(Demat_Helper.ContentType_Excel(file)) {
				
			List<Demat_MainEntity> convert_Excel_To_List = Demat_Helper.convert_Excel_To_List(file.getInputStream());
			
			this.repo.saveAll(convert_Excel_To_List);
			}
			else {
				return "Please Enter Only Excel Format";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Data Has Been Saved";
	}

	/*******************************************************GET ALL DATA*****************************************************************/
	@Override
	public List<Demat_MainEntity> GetData() {

		return repo.findAll();
		
	}
	/*******************************************************GET DATA BY ID ****************************************************************************/
	public List<Demat_MainEntity> GetDataById(Long id)
	{
		Demat_MainEntity demat_MainEntity = repo.findById(id).get();
		
		System.err.println(demat_MainEntity);
		
		List<Demat_MainEntity> dummylList = new ArrayList<>();
		
//		for (Demat_MainEntity demat_MainEntity2 : demat_MainEntity) {
			
			Demat_MainEntity allStatic = Demat_MainEntity.allStatic(demat_MainEntity.getDid(), demat_MainEntity.getName(), demat_MainEntity.getSprice());
			dummylList.add(allStatic);
		//}
		System.err.println("DUMMY LIST -------------->>>>>>"+dummylList);
		return dummylList;
	}
	/******************************************UPDATE BY ID ********************************************************************************************/
	
	public String UpdateById(Long id, Demat_MainEntity demat) 
	{
		
		Optional<Demat_MainEntity> byId = repo.findById(id);
		//List<Demat_MainEntity> mainData = new ArrayList<>();
	try {	
		if(byId.isPresent()) 
		{
			Demat_MainEntity dm = byId.get();
			if(demat.getDid()!=null) 
			{
				dm.setDid(demat.getDid());
			}
			if(demat.getName()!=null) 
			{
				dm.setName(demat.getName());
			}
			if(demat.getSprice()!=null) 
			{
				dm.setSprice(demat.getSprice());
			}
			repo.save(dm);
			System.err.println("DM ------------>>>>>>>>>" + dm);
			return "Data Has Been Updated";
		}
	}
	catch (Exception e) {
		return "Please Enter Correct Id...";
	}
	return "ENTER CORRECT ID";
	
	}
	
	
	
}
