package com.example.Insurance.Implimantation;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Insurance.Enitity.Entity_Insurance;
import com.example.Insurance.Enitity.Upload_EntitityMain;
import com.example.Insurance.Enitity.Upload_EntitityMain.Upload_EntitityMainBuilder;
import com.example.Insurance.Helper.FileUpload_Helper;
import com.example.Insurance.Repository.Image_Repo;
import com.example.Insurance.Repository.Repo_Insurance;
import com.example.Insurance.Services.Service_Insurance;

@Component
public class Implimantation_Insurance implements Service_Insurance {

	@Autowired
	private Repo_Insurance Repo;
	
	@Autowired
	private Image_Repo iRepo;
	
	@Autowired
	private FileUpload_Helper helper;

	@Override
	public List<Entity_Insurance> getAllAccDetails() {

		List<Entity_Insurance> Alldata = (List<Entity_Insurance>) Repo.findAll();
		return Alldata;
	}

	/*---------------------------------------------------------SAVE DELTAILS------------------------------------------------------------------------------*/
	@Override
	public String saveAccDetail(Entity_Insurance insurance) {
		// System.out.println("Get All DAta..............."+insurance);
		Repo.save(insurance);

		return "Data has Been Saved....";
	}

	/*---------------------------------------------------------Get Single Account----------------------------------------------------------------------------------*/
	@Override
	public String getAccDetail(Long id) {

		return "Id >> " + Repo.findById(id);

	}
	/*---------------------------------------------------------Delete Single Account----------------------------------------------------------------------------------*/

	@Override
	public String deleteAccDetail(Long id) {

		Repo.deleteById(id);
		return "Id Number " + id + " Deleted";

	}
	/*---------------------------------------------------------Update Single Account----------------------------------------------------------------------------------*/

	@Override
	public String updateAccDetail(Long id, Entity_Insurance insurance) {

		Optional<Entity_Insurance> byId = Repo.findById(id);
		System.out.println("Obj Of Optional Class " + byId);
		System.out.println("Id is >>>>>>>>>>>>> " + id);
		System.out.println("Insurance Perametar >>>>> " + insurance);
		if (byId.isPresent()) {
			Entity_Insurance enity = byId.get();
			System.out.println("OBJ in IF Condition Enityty >> " + enity);

			if (insurance.getClientAccType() != null) {
				enity.setClientAccType(insurance.getClientAccType());
			}

			if (insurance.getClientAddress() != null) {
				enity.setClientAddress(insurance.getClientAddress());
			}

			if (insurance.getClientGender() != null) {
				enity.setClientGender(insurance.getClientGender());
			}
			if (insurance.getClientMobileNo() != null) {
				enity.setClientMobileNo(insurance.getClientMobileNo());

			}
			if (insurance.getClientName() != null) {
				enity.setClientName(insurance.getClientName());

			}
			if (insurance.getClinetBankName() != null) {
				enity.setClinetBankName(insurance.getClinetBankName());

			}
			Repo.save(enity);

			return "Data Updated...";
		} else {
			return "Enter VAlid ID Please";
		}
	}

	/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public String deleteAllAccDetails(Entity_Insurance insurance) {
		// TODO Auto-generated method stub
		Repo.deleteAll();
		return "All Data Deleted";
	}
/******************************************************* FETCHING IMAGE USING MULTIPART FILE  **********************************************************************************/
	@Override
	public String Upload_Image(MultipartFile file) {
		
		try {
			
			Upload_EntitityMain main_EnitityData = Upload_EntitityMain.builder().name(file.getOriginalFilename()).size(file.getSize()).type(file.getContentType()).path(helper.UploadFile(file)).image(helper.UploadFile(file)).build();//Upload_EntitityMain.builder().name(file.getOriginalFilename()).
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
