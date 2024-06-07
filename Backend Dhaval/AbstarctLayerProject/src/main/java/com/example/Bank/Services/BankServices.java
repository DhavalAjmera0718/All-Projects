package com.example.Bank.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Bank.Dataset.Bank;

@Service
public interface BankServices {

	public List<Bank> GetAllData();
	
	public String SaveData(Bank bank); 

	public Bank SearchById(String Bid);
	//public Bank SearchById();
	
	public String DeleteById(String Did);
	
	public String AllDataDelete() ;

	public String UpdateEmpById(String BId , Bank bank) ;
}
