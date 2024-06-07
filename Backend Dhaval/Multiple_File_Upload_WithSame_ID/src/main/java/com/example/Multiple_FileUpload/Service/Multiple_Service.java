package com.example.Multiple_FileUpload.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Multiple_FileUpload.Entityyy.Multi_Main_Entity;

@Service
public interface Multiple_Service {

	
	public String MultipleFile_Uploading(MultipartFile[] file); 
}
