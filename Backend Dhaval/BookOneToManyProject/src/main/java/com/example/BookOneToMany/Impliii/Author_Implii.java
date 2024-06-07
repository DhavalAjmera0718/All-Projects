package com.example.BookOneToMany.Impliii;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookOneToMany.DTO.Author_DTO;
import com.example.BookOneToMany.DTO.BookO_DTO;
import com.example.BookOneToMany.Entity.AuthorMain_Entity;
import com.example.BookOneToMany.Entity.BookO_Entity;
import com.example.BookOneToMany.Repoo.Author_Repo;
import com.example.BookOneToMany.Service.Author_Service;
import com.example.BookOneToMany.Utils.Helper;

@Component
public class Author_Implii implements Author_Service{

@Autowired 
private Author_Repo repo;

@Autowired
private Helper helper;
	
	@Override
	public String saveData(Author_DTO author) {
			
		List<BookO_Entity> childEnity = new ArrayList<>();
		
		List<BookO_DTO> bookO_DTOs = author.getBookE(); // All Data From Postman
		
		for (BookO_DTO book1 : bookO_DTOs) {
			
			BookO_Entity ChildEnityData = BookO_Entity.bookStaticEntity(book1.getId(), book1.getName(), book1.getPrice(), null);
			childEnity.add(ChildEnityData);
		}
		AuthorMain_Entity MainEntityData = AuthorMain_Entity.authorStaticEntity(author.getId(), author.getName(), author.getCountry(), childEnity);
		System.err.println("MAIN DATA----->" + MainEntityData);
		
		repo.save(MainEntityData);
		
		return "Data Hase Been Saved";
	}
/*---------------------------------------------------- SAVE DATA USING MODEL MEPPER ------------------------------------------------------------------------------*/
//	@Override
//	public String saveData(Author_DTO author) {
//		
//		AuthorMain_Entity main_Entity = helper.dtoToEntityMapper(author);
//		
//		System.err.println("Before Save -->>>>>>>" + main_Entity);
//		repo.save(main_Entity);
//		System.err.println("main Enitity After Save ------------->>>>>>>>>>>>>> " + main_Entity);
//		
//	return "Data Hase Been saved...";
//	}
/******************************************************** GET DATA BY ID ************************************************************************************/
	/*@Override
	public Author_DTO getAllById(Long id) {
		
		AuthorMain_Entity main_Entity = repo.findById(id).get();
		
		List<BookO_DTO> dummylist1 = new ArrayList<>();
		
		List<BookO_Entity> bookE = main_Entity.getBookE(); //All Data 
		System.err.println(bookE);
		
		for (BookO_Entity bookO_Entity : bookE) {
			BookO_DTO childDTOdata = BookO_DTO.bookStaticDTO(bookO_Entity.getId(), bookO_Entity.getName(), bookO_Entity.getPrice());
			dummylist1.add(childDTOdata);
		}
		Author_DTO pereAuthor_DTO_Data = Author_DTO.authorStaticDTO(main_Entity.getId(), main_Entity.getName(), main_Entity.getCountry(), dummylist1);
		System.err.println(pereAuthor_DTO_Data);
		return pereAuthor_DTO_Data;
	}

	*/

	@Override
	public Author_DTO getAllById(Long id) {
		// TODO Auto-generated method stub
		
		AuthorMain_Entity authorMain_Entity = repo.findById(id).get();
		
		Author_DTO convertIntoEntity = helper.entityToDtoMapper(authorMain_Entity);
		
		System.err.println("Get Data by I--------->>>>>>>>>>>> " + convertIntoEntity);
		return convertIntoEntity;
	}
}
