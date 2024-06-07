package com.example.Demat.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Demat.Entity.Demat_MainEntity;

@Service
public interface Demat_Service {

	public String SaveData(MultipartFile file);
	
	public List<Demat_MainEntity> GetData();
	
	public List<Demat_MainEntity> GetDataById(Long id);
	
	public String UpdateById(Long id , Demat_MainEntity demat) ;
}
