package com.example.Multiple_FileUpload.Implii;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Multiple_FileUpload.Entityyy.Child_Entityyy;
import com.example.Multiple_FileUpload.Entityyy.Multi_Main_Entity;
import com.example.Multiple_FileUpload.Helper.Multiple_Helper;
import com.example.Multiple_FileUpload.Proxy.Child_DTOOO;
import com.example.Multiple_FileUpload.Proxy.Multiple_DTOO;
import com.example.Multiple_FileUpload.Repoo.Child_Repooo;
import com.example.Multiple_FileUpload.Repoo.Multiple_Repooo;
import com.example.Multiple_FileUpload.Service.Multiple_Service;

@Component
public class Multiple_Implimentation implements Multiple_Service {

	@Autowired
	private Multiple_Helper helper;
	
	@Autowired
	private Multiple_Repooo repo;
	
	@Autowired
	private Child_Repooo cRepooo;
/************************************************** SAVE MULTIPLE FILE USING ENTITY ****************************************************************************/	
	public String MultipleFile_Uploading(MultipartFile[] file) 
		{
		try {
			final String path = new ClassPathResource("").getFile().getAbsolutePath();
		
			File f = new File(path,"documents");
			if(!f.exists()) 
			{
				f.mkdir();
			     
			}
		System.err.println(path);
		List<Child_Entityyy> cEntity = new ArrayList<>();
		
		for (MultipartFile files : file) {
			
			Child_Entityyy child_Entityyy = new Child_Entityyy(0l, 
					files.getOriginalFilename(), "static", files.getContentType() );
					cEntity.add(child_Entityyy);
			
			System.err.println("CHILD ENTITY DATA AFTER SAVE----->>>>>>" + child_Entityyy);
			
			String fullpath = f.getAbsolutePath()+File.separator+files.getOriginalFilename();
			
			System.err.println("FULPATH---------->>>>>>>>" + fullpath);
			
			Files.copy(files.getInputStream(), Path.of(fullpath),StandardCopyOption.REPLACE_EXISTING);		 
		}
		Multi_Main_Entity m1 = new Multi_Main_Entity(0l, cEntity);
		repo.save(m1);
		System.err.println("Main Entity Data--------" + m1);	
		}
	/****FIRST TRY CLOSED HEAR****/	
		  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "All File Has Been Saved";
		}

	/************************************************** SAVE MULTIPLE FILE USING ENTITY ****************************************************************************/	
//	public String MultipleFile_Uploading(MultipartFile[] file) 
//		{
//		try {
//			List<Child_Entityyy> cEntity = new ArrayList<>();
//			final String path = new ClassPathResource("").getFile().getAbsolutePath();
//		
//			File f = new File(path,"documents");
//			if(!f.exists()) 
//			{
//				f.mkdir();
//			     
//			}
//		System.err.println(path);
//		List<Child_DTOOO> cDtooos = new ArrayList<>();
//		
//		for (MultipartFile files : file) {
//			
//			Child_DTOOO child_Dto = new Child_DTOOO(0l, 
//					files.getOriginalFilename(), "static", files.getContentType() );
//					cDtooos.add(child_Dto);
//					
//			
//			System.err.println("CHILD ENTITY DATA AFTER SAVE----->>>>>>" + child_Dto);
//			
//			String fullpath = f.getAbsolutePath()+File.separator+files.getOriginalFilename();
//			
//			System.err.println("FULPATH---------->>>>>>>>" + fullpath);
//			
//			Files.copy(files.getInputStream(), Path.of(fullpath),StandardCopyOption.REPLACE_EXISTING);		 
//		}
//		
//		Multi_Main_Entity m1 = new Multi_Main_Entity(0l, cEntity);
//		repo.save(m1);
//		System.err.println("Main Entity Data--------" + m1);	
//		}
	/****FIRST TRY CLOSED HEAR****/	
//		  catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 return "All File Has Been Saved";
//		}
}









