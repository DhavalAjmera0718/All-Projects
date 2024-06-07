package com.example.BookOneToMany.Utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BookOneToMany.DTO.Author_DTO;
import com.example.BookOneToMany.DTO.BookO_DTO;
import com.example.BookOneToMany.Entity.AuthorMain_Entity;
import com.example.BookOneToMany.Entity.BookO_Entity;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Helper {
	
	@Autowired
	private ObjectMapper objectMapper;
	//private ModelMapper mapper;
/*	public AuthorMain_Entity convertIntoDto(Author_DTO author_DTO) 
	{
		List<BookO_Entity> childEntityData = new ArrayList<>();
		List<BookO_DTO> childBookO_DTOs = author_DTO.getBookE();
		
		for (BookO_DTO childEntity : childBookO_DTOs) {
			
			BookO_Entity.bookStaticEntity(childEntity.getId(), childEntity.getName(), childEntity.getPrice(),childEntity.get);
		}
		
		
		System.err.println("Child ENityt ---->>>>>>>>>>>>>  " + childEntity);
		
		AuthorMain_Entity authorStaticEntity = AuthorMain_Entity.authorStaticEntity(author_DTO.getId(), author_DTO.getName(), author_DTO.getCountry(), childEntity);
		
		return authorStaticEntity;
		
	}
	
	public Author_DTO convertIntoEntity(AuthorMain_Entity enity) 
	{
		BookO_DTO bookStaticDTO = BookO_DTO.bookStaticDTO(enity.getBookE().getId(),
				enity.getBookE().getName(), enity.getBookE().getPrice());
		
		Author_DTO authorStaticDTO = Author_DTO.authorStaticDTO(enity.getId(),
				enity.getName(), enity.getCountry(), bookStaticDTO);
		
		return authorStaticDTO;
		
	}*/
	
	public AuthorMain_Entity dtoToEntityMapper(Author_DTO author_DTO) 
	{
		//return mapper.map(author_DTO, AuthorMain_Entity.class);
		return objectMapper.convertValue(author_DTO, AuthorMain_Entity.class);
	}
	public Author_DTO entityToDtoMapper(AuthorMain_Entity entity) 
	{
		//return mapper.map(entity, Author_DTO.class);
		return objectMapper.convertValue(entity, Author_DTO.class);
	}

}
