package com.example.Company.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Company.Entity.CompanyEntity;

public interface Service_Company {

	public List<CompanyEntity> GetAllCompanyData();
	
	public String SaveAlldata(CompanyEntity company);
	
	public String DeleteById(int cid);
	
	public String UpdateById(int cid , CompanyEntity compay);
	
	/*******************************************************************************************************/
	public String Upload_Image(MultipartFile file);
	
}
