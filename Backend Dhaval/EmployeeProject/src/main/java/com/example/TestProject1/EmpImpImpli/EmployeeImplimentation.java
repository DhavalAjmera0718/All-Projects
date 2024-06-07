package com.example.TestProject1.EmpImpImpli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.TestProject1.EmpDataset.Employee;

@Component
public class EmployeeImplimentation {

	List<Employee> emplist = new ArrayList<>();
	public void CreateData() 
	{
		
		Employee e1 = new Employee();
		e1.setEmpId("1");
		e1.setEmpName("Dhaval");
		e1.setEmpAddress("Ahmedabad");
		e1.setEmpCity("Gujrat");

	Employee e2 = new Employee("2","Ms Dhoni","Ranchi","India");
	Employee e3 = new Employee("3","Rohit sharma","Nala Sopara","Mumbai");
	Employee e4 = new Employee("4","Virat Kohli","Dehli","Inida");
	Employee e5 = new Employee("5","jadeja","Jamngar","Gujrat");
	
	emplist.add(e1);
	emplist.add(e2);
	emplist.add(e3);
	emplist.add(e4);
	emplist.add(e5);
	
	}
	public List<Employee> GetAllEmp()
	{
		return emplist;
	}
	public String SaveSingleData(Employee employee) 
	{
		emplist.add(employee);
		return "New Added Data Saved...............";
	}
/*-------------------------------------To Search BY ID-----------------------------------------------------------------------------*/
	public Employee getEmployeeById(String empId) 
	{
		for(Employee dataset : emplist) 
		{
			System.out.println("Hello");
			if(empId.equals(dataset.getEmpId())) 
			{
				System.out.println("Hello 2");
				return dataset;
			}		
		}
		return null;
	}

	
/*------------------------------------- To Update By Id-----------------------------------------------------------------------------*/
	
	public String UpdateEmpById(String empId , Employee employee) 
	{
		for(Employee empdata : emplist) 
		{
			if(empdata.getEmpId().equals(empId)) 
			{
				empdata.setEmpName(employee.getEmpName());
				empdata.setEmpCity(employee.getEmpCity());
				empdata.setEmpAddress(employee.getEmpAddress());
			}
		}
		return "Employee Data Updated........";
	}
	
	
/*-----------------------------------------------Delete Data Using Id--------------------------------------------------------------------------------------*/	
	
	public String DeleteDataById(String empId) 
	{
		for(Employee empdata : emplist) 
		{
			if(empId.equals(empdata.getEmpId())) 
			{
				emplist.remove(empdata);
				return "Data Delete";
			}
			
		}
		return "Data Deleted...";
	}
	
/*---------------------------------------------------------------------------------------------------------------------------*/
	
	public String AllDataDelete() 
	{
		
		emplist.clear();
		return "Data Deleted...";
	}
	
	
	
	
}
