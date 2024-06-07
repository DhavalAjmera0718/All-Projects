package com.example.Bank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bank.Dataset.Bank;
import com.example.Bank.Services.BankServices;


@RestController
public class BankController {

	@Autowired
	
	private BankServices BankInterface;
	
	@GetMapping("/GetAllData")
	public List<Bank> GetAllData()
	{
		return BankInterface.GetAllData();
	}
	
/*-------------------------------------------------------Save Data --------------------------------------------------------------------*/	

	@PostMapping("/SaveData")
	public String SaveData(@RequestBody Bank bank) 
	{
		return BankInterface.SaveData(bank);
	}
	
/*-----------------------------------------------------------SEARCH BY ID----------------------------------------------------------------*/	
	@GetMapping("/SearchById/{Bid}")
	public Bank SearchById(@PathVariable String Bid) 
	{
		return BankInterface.SearchById(Bid);
	}
	
/*--------------------------------------------------------DELETE BY ID-------------------------------------------------------------------*/	
	@DeleteMapping("DeleteById/{Did}")
	public String DeleteById( @PathVariable String Did) 
	{
		return BankInterface.DeleteById(Did);
	}
/*------------------------------------------------------DELETE ALL ---------------------------------------------------------------------*/
	@DeleteMapping("/DeleteAll")
	public String AllDataDelete() 
	{
		return BankInterface.AllDataDelete();
	}
/*------------------------------------------------------UPDATE DATA Using ID---------------------------------------------------------------------*/	
	@PutMapping("/UpdateEmpById/{BId}")
	public String UpdateEmpById(@PathVariable String BId ,@RequestBody Bank bank)
	{
		return BankInterface.UpdateEmpById(BId, bank);
	}
	
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	
}
