package com.example.BookOneToMany.Service;

import com.example.BookOneToMany.DTO.Author_DTO;

public interface Author_Service {

	public String saveData(Author_DTO author);
	
	public Author_DTO getAllById(Long id);
	
}
