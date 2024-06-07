package com.example.Book.Service;

import java.util.List;

import com.example.Book.Entity.BookEntity;
import com.example.Book.dto.Book_DTO;

public interface BookServices {
	
	
	  public List<Book_DTO> GetAllBook();
	  
	  public boolean SaveData(int count);
	 
	 public String DeleteByid(int Bid );
	 
	 public String FingByid(int Bid );
	 
	 public String UpdateById(int Bid , Book_DTO books);
	 
	 public String DeleAll();
	 
	
}
