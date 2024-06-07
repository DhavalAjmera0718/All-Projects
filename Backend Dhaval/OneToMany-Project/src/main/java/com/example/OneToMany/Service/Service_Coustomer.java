package com.example.OneToMany.Service;

import java.util.List;

import com.example.OneToMany.DTO_Customer.DTO_Customer;

public interface Service_Coustomer {
	
	public String SaveData(DTO_Customer cDto_Customer);
	
	public DTO_Customer GetData(Long id);
	
	public String DeleteById(Long id);
	
	public String UpdateById(Long id , DTO_Customer customer );
	
	public List<DTO_Customer> GetAllData();


}
