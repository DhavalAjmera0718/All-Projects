package com.example.TestProject1.EmployeeControler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestProject1.EmpDataset.Employee;
import com.example.TestProject1.EmpImpImpli.EmployeeImplimentation;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeImplimentation empImpli1;
	
	@GetMapping("/createData")
	public String CreateDataset() 
	{
		empImpli1.CreateData();
		return "Data Set Is Ready...";
	}
	
/*---------------------------------------------------GET ALL EMP DATA---------------------------------------------------*/
	@GetMapping("/GetAllEmpData")
	public List<Employee> GetAllEmpData()
	{
		return empImpli1.GetAllEmp();
	}
	
/*---------------------------------------To Add Single Data In dataset------------------------------------------------------------------------------*/	
	
	@PostMapping("/SaveSingleEmpdata")
	public String SaveSingleEmpdata(@RequestBody Employee employee) 
	{
		return empImpli1.SaveSingleData(employee);
	}
	
	@GetMapping("/Searchdata/{empId}")
	public Employee Search(@PathVariable String empId) 
	{
		return empImpli1.getEmployeeById(empId);
	}
/*--------------------------------------------------Update Employee By ID-----------------------------------------------------------------------------*/	
@PutMapping("/updateEmpById/{empId}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable("empId") String empId)
	
	{
		return empImpli1.UpdateEmpById(empId, employee);
	}
	
/*-------------------------------------------------Deleted By Id--------------------------------------------------------------------------*/	
	@DeleteMapping("/DeleteById/{empId}")
	public String DeleteById(@PathVariable String empId) 
	{
		return empImpli1.DeleteDataById(empId);
	}
/*------------------------------------------------------DELETE ALL ---------------------------------------------------------------------*/
	@DeleteMapping("/DeleteAll")
	public String AllDataDelete() 
	{
		return empImpli1.AllDataDelete();
	}
	
	
	
	
}
