package com.example.Insurance.Implimantation;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Insurance.Enitity.MainEntity_Excel;
import com.example.Insurance.Helper.Excel_Helper;
import com.example.Insurance.Repository.Excel_Repoo;

@Component
public class Excel_Implimantation {

	@Autowired
	private Excel_Helper helper;
	
	@Autowired
	private Excel_Repoo repo;
	
	
	public String SaveData(MultipartFile file) 
	{
		
			try {
				
				List<MainEntity_Excel> convertExcel_To_List = Excel_Helper.ConvertExcel_To_List(file.getInputStream());
				this.repo.saveAll(convertExcel_To_List);
				return "Data Has Been Saved";
				
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return"Try Again...";
			}
		
	}
/**************************************************** GET ALL EXCEL DATA  *****************************************************************************/	
	public List<MainEntity_Excel> GetData()
	{
		return repo.findAll();
	}
}
