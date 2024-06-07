package com.example.Company.Implimantation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Company.Entity.CompanyEntity;
import com.example.Company.Entity.Upload_EntityMain;
import com.example.Company.Helper.Company_FileUpload_Helper;
import com.example.Company.Repository.Image_Repo;
import com.example.Company.Repository.Repo_Company;
import com.example.Company.Service.Service_Company;
@Component
public class Impli_Company implements Service_Company{

	
	@Autowired
	private Repo_Company repo;
	
	@Autowired
	private Image_Repo iRepo;
	@Autowired
	private Company_FileUpload_Helper helper;
	/*--------------------------------------------------------------------------------------------------------------------------------------*/
	
	@Override
	public List<CompanyEntity> GetAllCompanyData() {
		// TODO Auto-generated method stub
		
		List<CompanyEntity> alldata = (List<CompanyEntity>) repo.findAll();
		
		return alldata;
	}
/*--------------------------------------------------------------------------------------------------------------------------------------*/

	@Override
	public String SaveAlldata(CompanyEntity company) {
		repo.save(company);
		return "Data Saved";
	}
	/************************************************************************************************************************/

	@Override
	public String DeleteById(int cid) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		repo.deleteById(cid);
		return "Id Number" + cid + " Deleted";
	}
/*--------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public String UpdateById(int cid, CompanyEntity compay) {
		
			Optional<CompanyEntity> byId = repo.findById(cid);
			if(byId.isPresent()) 
			{
				System.out.println("Entity Data byId >>  " + byId);
				CompanyEntity cp = byId.get();
				System.out.println("Entity Data CP >>  " + cp);
				cp.setName(compay.getName());
				cp.setLocation(compay.getLocation());
				
				repo.save(cp);
				return " Data Updated of ID Number >> " + cid;
			}
			else 
			{
				return "Please Check Your Id id not Found...";

			}
	}
/*--------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public String Upload_Image(MultipartFile file) {
		
		try {
			
			Upload_EntityMain main_EnitityData = Upload_EntityMain.builder().name(file.getOriginalFilename()).type(file.getContentType()).path(helper.UploadFile(file)).build();//Upload_EntitityMain.builder().name(file.getOriginalFilename()).
			//size(file.getSize()).type(file.getContentType());
			System.err.println(main_EnitityData);
			if(main_EnitityData!=null) 
			{
				iRepo.save(main_EnitityData);
				return "Data has Been Uploaded..";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} 
		
		return "Try Again";
	}
}
