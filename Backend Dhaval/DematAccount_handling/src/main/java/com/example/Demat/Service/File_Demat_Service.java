package com.example.Demat.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.example.Demat.DTOOO.File_DematAccount_DTOO;

@Service
public interface File_Demat_Service {
	
	public  File_DematAccount_DTOO SaveData(MultipartFile file) ;
	
	public File_DematAccount_DTOO getDatabyId(@PathVariable("id") Long id);
	
	public  String Multiple_Fileuploding(MultipartFile[] file) ;
	
	public  String Multiple_File_Zip(MultipartFile[] file);
}
