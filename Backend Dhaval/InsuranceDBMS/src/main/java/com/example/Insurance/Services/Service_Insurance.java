package com.example.Insurance.Services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Insurance.Enitity.Entity_Insurance;


public interface Service_Insurance {
	
	
	public List<Entity_Insurance> getAllAccDetails();
	
	public String getAccDetail(Long id);
	
	
	public String saveAccDetail(Entity_Insurance insurance);
	
	public String deleteAccDetail(Long id);
	
	
	
	public String updateAccDetail(Long id , Entity_Insurance insurance);
	
	public String deleteAllAccDetails(Entity_Insurance insurance);
	
	/***********************************************************************************************************************/
	
	public String Upload_Image(MultipartFile file);
	
	/*saveAccountDetail() : POST
	2. getAccountDetail() : POST
	3. deleteAccountDetail() : PUT
	4. updateAccountDetail() : DELETE
	5. getAllAccountDetails(): GET
	6. deleteAllAccountDetails() : DELETE
	*/
	
	
	
	
	
	
}
