package com.example.Mapping.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Mapping.DTO.Emp_DTO;
import com.example.Mapping.Entity.Emp_Entity;

@Service
public interface Emp_Service {
	
//	public String SaveAll(Emp_DTO emp);
	
	public String SaveAll();
	
	public Emp_DTO GetDataById(Long id);
	
	public String DeleteById(Long id);
	
	public String UpdateById(Long id,Emp_DTO empdto);
	
	public List<Emp_DTO> GetAllData();
	
	public String DeleteAll();
	

}
