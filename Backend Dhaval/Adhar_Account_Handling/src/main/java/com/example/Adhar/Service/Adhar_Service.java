package com.example.Adhar.Service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Adhar.DTO.Adhar_DTO;

@Service
public interface Adhar_Service {

	public String SaveData(MultipartFile file);
	
	public List<Adhar_DTO> GetAllData();
	
	public Resource DownloadAnyFile(String filename);
	
	 public Resource downloadFormaExcelFormet() ;
}
