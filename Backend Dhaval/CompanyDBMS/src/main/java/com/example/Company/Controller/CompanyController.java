package com.example.Company.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Company.Entity.CompanyEntity;
import com.example.Company.Service.Service_Company;

@RestController
public class CompanyController {

	@Autowired 
	private Service_Company serve;
	
	@GetMapping("/GetAllCompanyData")
	public List<CompanyEntity> GetAllCompanyData()
	{
		return serve.GetAllCompanyData();
	}
	
	@PostMapping("/SaveAlldata")
	public String SaveAlldata(@RequestBody CompanyEntity company) 
	{
		return serve.SaveAlldata(company);
	}
	
	@PutMapping("/UpdateById/{cid}")
	public String UpdateById(@PathVariable int cid,@RequestBody CompanyEntity compay) 
	{
		return serve.UpdateById(cid, compay);
	}
	
	@DeleteMapping("/DeleteById/{cid}")
	public String DeleteById(@PathVariable int cid) 
	{
		return serve.DeleteById(cid);
	}
}
