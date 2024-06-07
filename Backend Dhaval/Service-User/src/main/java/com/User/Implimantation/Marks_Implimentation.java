package com.User.Implimantation;

import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.User.Entity.Marks_Entity;
import com.User.REPOSITORY.Marks_Repo;
import com.User.Service.Marks_Service;

import jakarta.ws.rs.NotFoundException;

@Component
public class Marks_Implimentation implements Marks_Service {

	@Autowired
	private Marks_Repo  marks_Repo;
	
	@Override
	public String Add_Marks(Marks_Entity mEntity) 
	{
		marks_Repo.save(mEntity);
		return "Marks Has Been Saved...!!!";
/******************************************************* [ getmarks_ById ] *******************************************************************************/		
	}
	@Override
	public Marks_Entity getmarks_ById(Long id) 
	{
		Marks_Entity marks_Entity = marks_Repo.findById(id).get();
		return marks_Entity;
	}
/*******************************************************[ UpdateBy_id ]*******************************************************************************/	
	@Override
	public String UpdateBy_id(Long id  , Marks_Entity mEntity) 
	{
		Optional<Marks_Entity> marksData = marks_Repo.findById(id);
		
		if (marksData.isPresent()) {
			Marks_Entity marks_Entity = marksData.get();
			marks_Entity.setName(mEntity.getName());
			marks_Entity.setEconomics(mEntity.getEconomics());
			marks_Entity.setEnglish(mEntity.getEnglish());
			marks_Entity.setGrade(mEntity.getGrade());
			marks_Entity.setGujrati(mEntity.getGujrati());
			marks_Entity.setMaths(mEntity.getMaths());
			marks_Entity.setScience(marks_Entity.getScience());
			marks_Entity.setSum(mEntity.getSum());
			marks_Repo.save(marks_Entity);
		}
		return "Id Number ----> " + id+" Is Being Updated updated";
	}
	
/****************************************************** [ DELETE BY ID] *******************************************************************************************/	
//	@Override
//	public String DeleteBy_Id(Long id) 
//	{
//		 
//		marks_Repo.deleteById(id);
//		return "Id Number ----->  "+id+" Has Been Deleted";
//	}
	@Override
	public String DeleteBy_Id(Long id) {
	    Optional<Marks_Entity> optionalEntity = marks_Repo.findById(id);
	    if (optionalEntity.isPresent()) {
	        marks_Repo.deleteById(id);
	        return "Id Number ----->  " + id + " Has Been Deleted";
	    } else {
	    	 //throw new NotFoundException("ID NUMBER ----->  " + id + " NOT FOUND PLEASE ENTER VALID ID...!!!!");
	    	 return "ID NUMBER ----->  " + id + " NOT FOUND PLEASE ENTER VALID ID...!!!!";

	    }
	    
	}

	
}
