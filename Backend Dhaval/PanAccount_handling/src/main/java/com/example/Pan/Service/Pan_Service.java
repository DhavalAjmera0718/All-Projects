package com.example.Pan.Service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Pan.Enitity.Pan_Entity;

@Service
public interface Pan_Service {

	
	public Resource Get_Blank_Excel() ;
	
	public String Upload_Excel(MultipartFile file) ;
	
	public void Download_Excel(HttpServletResponse response);
	
	public List<Pan_Entity>	GetAllData();
	
	public List<Pan_Entity> Get_DataBY_Id(Long id);
}
