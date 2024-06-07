package com.example.Demat.Implimantation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Demat.DTOOO.File_DematAccount_DTOO;
import com.example.Demat.Entity.File_Demat_Enitity;
import com.example.Demat.Repository.File_Demat_Repoooo;
import com.example.Demat.Service.File_Demat_Service;
import com.example.Demat_Helper_Class.File_Demat_Helper_Class;

@Component
public class File_Demate_Impliii implements File_Demat_Service {

	@Autowired
	private File_Demat_Repoooo repo;
	
	
	
/******************************************* FOR UPLOADING DOCUMENTS ********************************************************************************/
	
	public  File_DematAccount_DTOO SaveData(MultipartFile file) 
	{
//	 final String path = "C:\\Users\\DhavalAjmera\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\DematAccount_handling\\src\\main\\resources\\static";
	
	try {
		final String path = new ClassPathResource("").getFile().getAbsolutePath();
	
		File f = new File(path,"documents");
		if(!f.exists()) 
		{
			f.mkdir();
		    
		}
	System.err.println(path);
	 
	 
	 String originalName = file.getOriginalFilename();
	 
	 Long convertIntoMb = file.getSize();
	 float fileSizeInMb =  convertIntoMb/(1024*1024);
	 System.err.println("FILE SIZE In MB----------" + fileSizeInMb);
	 
	 String uniqueId = UUID.randomUUID().toString();
	 
	 String FinalName = uniqueId.concat(originalName.substring(originalName.lastIndexOf(".")));
	 System.err.println("FILE NAME ------->>>>>>>" + FinalName);
	 
//		File f = new File(path);
//		if(!f.exists()) 
//		{
//			f.mkdir();
//		    
//		}

	 
	 File_Demat_Enitity mainData = new File_Demat_Enitity(0l,FinalName, 
			(long) fileSizeInMb, "static", file.getOriginalFilename(), file.getContentType());
	 repo.save(mainData);
	 
	 
	 String fullpath = f.getAbsolutePath()+File.separator+FinalName;
	 
	 System.err.println("Full Path------------>>>>>>>" + fullpath);
		 
		Files.copy(file.getInputStream(), Path.of(fullpath),StandardCopyOption.REPLACE_EXISTING);
	}
	  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
	}
/********************************************************SAVE MULTIPLE FILE **************************************************************************/	
	public  String Multiple_Fileuploding(MultipartFile[] file) 
	{
		try {
			final String path = new ClassPathResource("").getFile().getAbsolutePath();
		
			File f = new File(path,"documents");
			if(!f.exists()) 
			{
				f.mkdir();
			    
			}
		System.err.println(path);
		 
		 
		for (MultipartFile multipartFile : file) {
			
			File_Demat_Enitity mainData = new File_Demat_Enitity(0l,multipartFile.getOriginalFilename(), 
					multipartFile.getSize(), "static", multipartFile.getOriginalFilename(), multipartFile.getContentType());
			repo.save(mainData);
		}
			
		 for (MultipartFile multipartFile : file) {
			 String fullpath = f.getAbsolutePath()+File.separator+multipartFile.getOriginalFilename();
			
			 Files.copy(multipartFile.getInputStream(), Path.of(fullpath),StandardCopyOption.REPLACE_EXISTING);
		}
		 
		}
		  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "All File Has Been Saved";
	} 
	
	
	/********************************************************SAVE MULTIPLE FILE IN ZIP **************************************************************************/	
	public  String Multiple_File_Zip(MultipartFile[] file) 
	{
		try {
			final String path = new ClassPathResource("").getFile().getAbsolutePath();
		
			File f = new File(path,"documents");
			if(!f.exists()) 
			{
				f.mkdir();
			    
			}
		System.err.println(path);
		String zipFileName = "All_File1.Zip";
		String zipFilePath = f.getAbsolutePath()+File.separator+zipFileName;
		 
		// try{
			 ZipOutputStream zipOutputStream =  new ZipOutputStream(new FileOutputStream(zipFilePath));
			for (MultipartFile multipartFile : file) {
					
				File_Demat_Enitity mainData = new File_Demat_Enitity(0l,multipartFile.getOriginalFilename(), 
						multipartFile.getSize(), "static", multipartFile.getOriginalFilename(), multipartFile.getContentType());
				repo.save(mainData);
				
				ZipEntry zipEntry = new ZipEntry(multipartFile.getOriginalFilename());
				zipOutputStream.putNextEntry(zipEntry);
				zipOutputStream.write(multipartFile.getBytes());
				Files.copy(multipartFile.getInputStream(), Path.of(zipFilePath),StandardCopyOption.REPLACE_EXISTING);	 
//				zipOutputStream.close();
				}
//			String fullpath = f.getAbsolutePath()+File.separator+multipartFile.getOriginalFilename()		
		//}

		 System.err.println("ZIPFILE PATH---------->>>>>>>>"+zipFilePath);
		 return "All Files Are Saved In ZIP Format"  + zipFilePath;
		
		}
/*First Try Ended Hear*/		
		  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error Has Been Occured Please try Agaun...........";
		}
		 
	} 
	
	
/********************************************************* GET DATA BY ID *************************************************************************/	
	
	public File_DematAccount_DTOO getDatabyId(Long id)
	{
		Optional<File_Demat_Enitity> byId = repo.findById(id);
		System.err.println(byId);
		
		File_DematAccount_DTOO databyId=null;
		if(!byId.isEmpty()) 
		{
			 databyId = File_Demat_Helper_Class.convertTO_Entity(byId.get());
		}
		System.err.println(databyId);
		String downloadPath="";
		
		try {
			downloadPath = new ClassPathResource("documents").getFile().getAbsolutePath();
			downloadPath = 	downloadPath+File.separator + databyId.getName();
			System.err.println("DOWNLOAD PATH ----------->>>>>>>> "+ downloadPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return databyId;
		
		
	}
}
