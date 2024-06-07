package com.practise.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practise.DTO.p_DTO;

@Service
public interface p_Service {

	
	public String savdData(p_DTO dto);
	
	public List<p_DTO> getAlldata();
	
	
	public String UpdateBy_Id(Integer id  ,  p_DTO dto) ;
}
