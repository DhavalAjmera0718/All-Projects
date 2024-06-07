package com.User.Service;

import org.springframework.stereotype.Service;

import com.User.Entity.Marks_Entity;

@Service
public interface Marks_Service {
	public Marks_Entity getmarks_ById(Long id);
	public String Add_Marks(Marks_Entity mEntity);
	public String UpdateBy_id(Long id  , Marks_Entity mEntity);
	public String DeleteBy_Id(Long id);

}
