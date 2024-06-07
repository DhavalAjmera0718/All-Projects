package com.example.Mapping.Implimantation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Mapping.DTO.Emp_DTO;
import com.example.Mapping.DTO.Laptop_DTO;
import com.example.Mapping.Entity.Emp_Entity;
import com.example.Mapping.Entity.Laptop_Entity;
import com.example.Mapping.Repo.Repo_Emp;
import com.example.Mapping.Service.Emp_Service;
import com.github.javafaker.Faker;

import net.bytebuddy.asm.Advice.Return;

@Component

public class Emp_Implimantation implements Emp_Service {

	@Autowired
	private Repo_Emp repo;
	
	@Autowired
	Faker feker;
	
	/*public String SaveAll(Emp_DTO empdto) 
	
	{
		Laptop_Entity laptop = Laptop_Entity.laptopStatic(empdto.getLaptop().getLapId(),empdto.getLaptop().getLapCompany(),empdto.getLaptop().getLapPrice());
		 System.out.println("Laptop Data >>>>>>>>>>> " + laptop);
		Emp_Entity employee = Emp_Entity.EmpStatic(empdto.getEmp_id() , empdto.getName() , empdto.getCity(),laptop);
		repo.save(employee);
		return "Data has Been Saved..";
	}*/
public String SaveAll() 
	
	{
	for(int i=1;i<100;i++) {
		Laptop_Entity laptop = Laptop_Entity.laptopStatic(0l,feker.name().firstName(),feker.address().city());
		 System.out.println("Laptop Data >>>>>>>>>>> " + laptop);
		 
		Emp_Entity employee = Emp_Entity.EmpStatic(0l ,feker.name().firstName(),feker.address().fullAddress(),laptop);
		
		System.out.println("Employee Data >>>>  " + employee);
		repo.save(employee);
	}
		return "Data has Been Saved..";
	
	}

/*-----------------------------------------------------------------GET DATA BY ID---------------------------------------------------------------------------*/
	@Override
	public Emp_DTO GetDataById(Long id ) {
		
		 Emp_Entity employee = repo.findById(id).get();
		 
		 System.out.println("Employee Data >>>>>> " + employee);
		// Laptop_Entity laptop1 = Laptop_Entity.laptopStatic(employee.getLaptop().getLapId(),employee.getLaptop().getLapCompany(),employee.getLaptop().getLapPrice());
		 
		 Laptop_DTO laptop = Laptop_DTO.laptopStaticDto(employee.getLaptop().getLapId(),employee.getLaptop().getLapCompany(),employee.getLaptop().getLapPrice());
		 System.out.println("Laptop Data >>>>>>>>>>> " + laptop);
		
		// Emp_DTO dtos = Emp_DTO.empDtoName(/*employee.getEmp_id() , employee.getName() , employee.getCity()*/employee.getEmp_id(),employee.getName(),employee.getCity(),laptop1);
		
		 Emp_DTO dtos = Emp_DTO.empDtoName(employee.getEmp_id(), employee.getName(), employee.getCity(), laptop);
		 System.out.println("DTOS DATA >>>>>>>>>>>>>>>>> " +dtos);
		
		 return dtos;
	}	
/*-----------------------------------------------------------------Delete By Id DATA BY ID---------------------------------------------------------------------------*/

	@Override
	public String DeleteById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Id Number " + id + " Is Deleted.........";
	}
	
/*----------------------------------------------------------Delete All--------------------------------------------------------------------------------*/	
	public String DeleteAll() 
	{
		repo.deleteAll();
		return "All Data Deleted.........";
	}
	
/*-----------------------------------------------------------------UPDATE BY Id DATA BY ID---------------------------------------------------------------------------*/

	@Override
	public String UpdateById(Long id, Emp_DTO empdto) {
		
		Optional<Emp_Entity> Emp_Enitity = repo.findById(id);
	
		

		
		if(Emp_Enitity.isPresent()) 
		{
			Emp_Entity entity = Emp_Enitity.get();
			
			if(empdto.getName()!=null) 
			{
				entity.setName(empdto.getName());						
			}
			
			if(empdto.getCity()!=null) 
			{
				entity.setCity(empdto.getCity());
			}
			Laptop_DTO lapdto = empdto.getLaptop(); //postman data 	
			
			System.out.println("Body Data >>         " + lapdto);
			
			Laptop_Entity existingLap = entity.getLaptop();
			
			System.out.println("Existing Data In LapTop Entity >>>>>> " + existingLap);
			
			if(lapdto!=null) 
			{
				if(lapdto.getLapCompany()!=null) {
					existingLap.setLapCompany(lapdto.getLapCompany());
				}
				if(lapdto.getLapPrice()!=null) {
					existingLap.setLapPrice(lapdto.getLapPrice());
				}
				entity.setLaptop(existingLap);
			}
			
			
			repo.save(entity);
			
			System.out.println("Entity Data Into If>>>>>>>>>>>>>>>>>>>>   "+entity);
			return "Data Hase Been Updated ";
		}
		else 
		{
			return "Please Enter Valid Id.";
		}
		
		
	}
/*--------------------------------------------------GET ALL DATA-----------------------------------------------------------------------*/
	@Override
	public List<Emp_DTO> GetAllData() {
		
		List<Emp_Entity> all= (List<Emp_Entity>) repo.findAll();		
		
		List<Emp_DTO> Emp_DTO1 = new ArrayList<>();
		
	for(Emp_Entity employEmp_Entity :  all) 
		{
			Laptop_DTO laptop_DTO = Laptop_DTO.laptopStaticDto(employEmp_Entity.getLaptop().getLapId(),
					employEmp_Entity.getLaptop().getLapCompany(), employEmp_Entity.getLaptop().getLapPrice());
			
			
			 Emp_DTO dtos = Emp_DTO.empDtoName(employEmp_Entity.getEmp_id(), employEmp_Entity.getName(), employEmp_Entity.getCity(), laptop_DTO);
			 
			 Emp_DTO1.add(dtos);
		}
	return Emp_DTO1;
		
	
		
		

	}
	/*
	private Laptop_DTO convertLaptopDto(Laptop_Entity LEntity) 
	{
		return Laptop_DTO.laptopStaticDto(LEntity.getLapId(), LEntity.getLapCompany(),LEntity.getLapPrice());
	}
	
	private Emp_DTO convertToEmpDto(Emp_Entity entity) 
	{
		 Laptop_DTO convertLaptopDto = convertLaptopDto(entity.getLaptop());
		return Emp_DTO.empDtoName(entity.getEmp_id(), entity.getName(), entity.getCity(),convertLaptopDto);
	}*/
}
