package com.example.Adhar.Implimantation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Adhar.Entity.Adhar_Entity;
import com.example.Adhar.Entity.User;
import com.example.Adhar.Entity.User_Input_Data_ForAngular;
import com.example.Adhar.Helper.Adhar_Helper;
import com.example.Adhar.Helper.User_Input_Helper;
import com.example.Adhar.Repoo.User_Input_Repository;
import com.example.Adhar.Repoo.User_repository;

@Component
public class User_Input_Implimantation {

	
	@Autowired
	private User_Input_Repository userRepo;
	
	@Autowired 
	private	User_Input_Helper helper;
	
	@Autowired
	private User_repository userdataRepo;
	
	
	public String PostAllData( MultipartFile file , User userdata) throws IOException 
	{
		System.err.println("111");
		try {
			
		final String path = new ClassPathResource("/documnets").getFile().getAbsolutePath();
		
		System.err.println("F DOES NOT EXIT ");
		File f = new File(path);
		if(!f.exists()) 
		{
			f.mkdir();
		    
		}
	System.err.println(path);
	 
/*********************************************************** 2 *******************************************************************/	 
	 String originalName = file.getOriginalFilename();
	 
	 Long convertIntoMb = file.getSize();
	 float fileSizeInMb =  convertIntoMb/(1024*1024);
	 System.err.println("FILE SIZE In MB----------" + fileSizeInMb);
	 
	 String uniqueId = UUID.randomUUID().toString();
	 
	 String FinalName = uniqueId.concat(originalName.substring(originalName.lastIndexOf(".")));
	
/************************************************************* 3 *****************************************************************/		 		 
//	 User_Input_Data_ForAngular mainData = new User_Input_Data_ForAngular(0l, file.getOriginalFilename(),file.getOriginalFilename(), FinalName);
	
	 userdata.setDisplayPicture(FinalName);
	 userdataRepo.save(userdata);
//	 userRepo.save(userdata);
	 
	 System.err.println("Main DATA in helper Class MUlti Uploading---------" + userdata);
	 
	 String fullpath = f.getAbsolutePath()+File.separator+FinalName;
	 
		Files.copy(file.getInputStream(), Path.of(fullpath),StandardCopyOption.REPLACE_EXISTING);
	}
	  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
	}
		
	
	public Resource DownloadAnyFile(String filename) 
	 {
		 Resource resource = new ClassPathResource("/documnets/" + filename);
		 System.err.println(resource);
		 return resource;
	 }   
	    	
/**********************************************************[ DOWNLOAD FORMAt ]***********************************************************************************************************************/	
	
	public Resource downloadFormaExcelFormet() 
	 {
		 Resource resource = new ClassPathResource("excelformat.xlsx");
		 System.err.println(resource);
		 return resource;
	 }  		
		
/*************************************************************[ Excel Uploading ]************************************************************************************************************/	
	
    public String saveExceldata(MultipartFile file) {
        try {
            List<User_Input_Data_ForAngular> maid_Data = null;
            
            if (User_Input_Helper.Check_ExcelFormat(file)) {
               
            	final String path = new ClassPathResource("").getFile().getAbsolutePath();
              
            	System.err.println("Path----" + path);
               
            	Files.copy(file.getInputStream(), Paths.get(path + File.separator + file.getOriginalFilename()),
                        StandardCopyOption.REPLACE_EXISTING);
               
            	maid_Data = User_Input_Helper.Excel_To_List_Converter(file.getInputStream());
                
            	this.userRepo.saveAll(maid_Data);
            } 

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Data Has Been Saved";
    }
	
	
/*******************************************************[ GET ALL USER DATA ]***************************************************************************/	
	
	
	public List<User_Input_Data_ForAngular> getAlluserData() {
	 List< User_Input_Data_ForAngular> entitytData = (List<User_Input_Data_ForAngular>) userRepo.findAll();
	 return entitytData;
	
	}
/****************************************************[ GET ALL DATA WITH PAGINATION]***************************************************************************************************/	
	
	
	public List<User_Input_Data_ForAngular> getalldata_Withpagination(Integer pageNumberInteger , Integer PageSize)
	{
		int pageSize =5;
		int pageNumber=1;
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<User_Input_Data_ForAngular> pagePost = userRepo.findAll(pageable);
		List<User_Input_Data_ForAngular> allPost = pagePost.getContent();
		
		
		return allPost;
	}
	
	
	
	
	
	
}
