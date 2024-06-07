package com.example.Excel.Service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Excel.DTO.File_DTOO;
import com.example.Excel.Main_Entity.Main_Enitity;

@Service
public interface File_Sevice {
	
	public String SaveData(MultipartFile file);
	
	//public List<Main_Enitity> GetData();
	
	public List<File_DTOO> GetData();
	
	public Integer Division(Integer a, Integer b);
	
	public void genrateExcel(HttpServletResponse response) ;
	
	 public Resource Download_Excel_Format_From_DB() ;
}
