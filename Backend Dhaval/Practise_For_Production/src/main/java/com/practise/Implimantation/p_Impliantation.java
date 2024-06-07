package com.practise.Implimantation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practise.DTO.p_DTO;
import com.practise.Entity.p_Entity;
import com.practise.HELPER.p_Helper;
import com.practise.Repository.p_Repo;
import com.practise.Service.p_Service;


@Component
public class p_Impliantation implements p_Service {

	
	@Autowired
	private p_Repo repo;
	
	@Autowired
	private p_Helper helper;
	
	@Override
	public String savdData(p_DTO dto) {
		
		System.err.println(dto);
		p_Entity dto_To_Entity = helper.Dto_To_Entity(dto);
		repo.save(dto_To_Entity);
		return "Data Has Been Saved ";
		
	}

	@Override
	public List<p_DTO> getAlldata() {
		List<p_Entity> all = repo.findAll();
		
		List<p_DTO> dummyList = new ArrayList<>();
		
		for (p_Entity p_Entity : all) {
			
			p_DTO entity_TO_DTO = helper.entity_TO_DTO(p_Entity);
			dummyList.add(entity_TO_DTO);
			
		}
		return dummyList;
	}

	public String UpdateBy_Id(Integer id  ,  p_DTO dto) 
	{
		System.err.println("Impli DTO - - - >" + dto);
		Optional<p_Entity> byId = repo.findById(id);
//		try {
			System.err.println("Impli--TRY Block----->" + byId);
			if (byId!=null) {
				
				p_Entity p_Entity = byId.get();
				p_Entity.setName(dto.getName());
				p_Entity.setCity(dto.getCity());
				p_Entity.setEmail(dto.getEmail());
				p_Entity.setPhoneNo(dto.getPhoneNo());
				repo.save(p_Entity);
				return "Id Number "+id+" Has Been Updated...!!! ";	
			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return "Check Again";
//		return null;
		
		
	}	
	
	
}
