package com.example.Form.Service;

import java.util.List;

import com.example.Form.DTO.DTO_Form;

	public interface Service_Form {
	
	public List<DTO_Form> GetAllform();
	
	public String SaveData(DTO_Form form);

	public String DeleteByid(int fid );
	
	public String FingByid(int fid );
	
	public String UpdateById(int fid , DTO_Form form);
	
	public String DeleAll();

}
