package com.example.Bank.Implimantation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.Bank.Dataset.Bank;
import com.example.Bank.Services.BankServices;


@Component
public class BankImplimantation implements BankServices {

	static List<Bank> sbi = new ArrayList<>();
	
	static 
	{
		Bank b1 = new Bank("001" ,"Dhaval","Sola");
		Bank b2 = new Bank("002","Kashyap","Morbi");
		Bank b3 = new Bank("003","Shubham","Mehshana");
		Bank b4 = new Bank("004","Kunj","Ahmedabad");
		Bank b5 = new Bank("005","Dhoni","Ranchi");
		
		
		sbi.add(b1);
		sbi.add(b2);
		sbi.add(b3);
		sbi.add(b4);
		sbi.add(b5);
		
		
		
	}
	public List<Bank> GetAllData()
	{
		return sbi;
	}
/*-----------------------------------------------------------------------------------------------------------------------------*/	
	public String SaveData(Bank bank) 
	{
		sbi.add(bank);
		return "Data Saved......";
	}
/*************************************************SEARCH BY ID***************************************************************************/	
	
/*	public Bank SearchById(String Bid) 
	{
		for(Bank dataset : sbi) 
		{
			System.out.println("Hello");
			if(Bid.equals(dataset.getAc())) 
			{
				System.out.println("Hello 2");
				return dataset;
			}		
		}
		return null;
	}*/
/*************************************************SEARCH BY ID Using Stream***************************************************************************/	
	public Bank SearchById(String Bid) 
	{
		Bank james = sbi.stream()
				.filter(sbi -> Bid.equals(sbi.getAc()))
				.findAny()
				.orElse(null);
		System.out.println("Hello");
		return james;
	}
	
	
/*************************************************Delete BY ID***************************************************************************/	
	/*public String DeleteById(String Bid) 
	{
		for(Bank dataset : sbi) 
		{
			System.out.println("Hello");
			if(Bid.equals(dataset.getAc())) 
			{
				sbi.remove(dataset);
				break;
				
			}		
		}
		return null;
	}*/
/*************************************************Delete BY ID Using Stream***************************************************************************/	
	/*public String DeleteById(String Bid) 
	{
		Bank Delete = sbi.stream()
				.filter(sbi -> Bid.equals(sbi.getAc()))
				.findAny().orElse(null);
		return  "Data Removed.."+ sbi.remove(Delete);
	}	
	*/
/*************************************************Delete BY ID Using Stream 2***************************************************************************/	
	public String DeleteById(String Bid) 
	{
		List<Bank> collect = sbi.stream().filter(a -> a.getAc().equals(Bid)).collect(Collectors.toList());
		if(!collect.isEmpty()) 
		{
			Bank DeleteById = collect.remove(0);
			System.out.println(DeleteById);
			
			
		}
		else 
			
		{
			return "Id Not Found";
		}
		return "Data Deleted";
	}		
/*************************************************Delete All***************************************************************************/	
	public String AllDataDelete() 
	{
		
		sbi.clear();
		return "Data Deleted...";
	}	

/*************************************************Update By Id All***************************************************************************/	
/*	
	public String UpdateEmpById(String BId , Bank bank)
	{
		for(Bank Bankdata : sbi) 
		{
			if(BId.equals(Bankdata.getAc())) 
			{
				Bankdata.setName(bank.getName());
				Bankdata.setBranch(bank.getBranch());
				
			}		
		}
		return "Employee Data Updated";
		
	}*/	

/*************************************************Update By Id Using Stream***************************************************************************/	
	
	/*public String UpdateEmpById(String BId , Bank bank)
	{
		Bank UpdateById = sbi.stream()
				.filter(sbi -> BId.equals(sbi.getAc()))
				.findAny().orElse(null);
		UpdateById.setName(bank.getName());	
		UpdateById.setBranch(bank.getBranch());
		return null;
		
	}*/	
/*************************************************Update By Id Using Stream 2***************************************************************************/	
	
	public String UpdateEmpById(String BId , Bank bank) 
	{
		
		List<Bank> collect = sbi.stream().filter(a -> a.getAc().equals(BId)).collect(Collectors.toList());
		if(!collect.isEmpty()) 
		{
			System.out.println("Hello World");
			Bank update = collect.get(0);
			update.setName(bank.getName());
			update.setBranch(bank.getBranch());
		
		}
		return "Data Updated";
		
		
	}
}
