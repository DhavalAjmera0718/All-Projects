package com.example.Form.Implimantation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.Form.DTO.DTO_Form;
import com.example.Form.Enity.Entity_Form;
import com.example.Form.Repository.Repo_Form;
import com.example.Form.Service.Service_Form;

@Component
public class Impli_Form implements Service_Form {

	@Autowired
	private Repo_Form repo;
	@Override
	public List<DTO_Form> GetAllform() {
		
		List<Entity_Form> allData = (List<Entity_Form>) repo.findAll();
		System.out.println("ALL DATA >>>>>>>>>>>>>>>> " + allData);
		
		List<DTO_Form> dtos = new ArrayList<>();
		
		for (Entity_Form formdata: allData) {
			DTO_Form formdto = new DTO_Form();
			System.out.println(formdto);
			formdto.setName(formdata.getName());
			formdto.setAge(formdata.getAge());
			formdto.setEmail(formdata.getEmail());
			formdto.setGender(formdata.getGender());
			formdto.setId(formdata.getId());
			formdto.setMobilNo(formdata.getMobilNo());
			formdto.setNation(formdata.getNation());
			formdto.setAddress(formdata.getAddress());
			formdto.setDate(formdata.getDate());
			
			
			dtos.add(formdto);
			System.out.println("List dtos  in Get All ........." + dtos);
		}
		
		//System.out.println("List Book DTO in Get All ........." + bookdto);
		//System.out.println("List dtos  in Get All ........." + dtos);

		return dtos;
	}
/*****************************************************SAVE DATA****************************************************************************************/

	@Override
	public String SaveData(DTO_Form form) {
		
		Entity_Form Fentity = new Entity_Form();
		Fentity.setId(form.getId());
		Fentity.setName(form.getName());
		Fentity.setEmail(form.getEmail());
		Fentity.setAge(form.getAge());
		Fentity.setGender(form.getGender());
		Fentity.setNation(form.getNation());
		Fentity.setMobilNo(form.getMobilNo());
		Fentity.setAddress(form.getAddress());
		Fentity.setDate(form.getDate());
		repo.save(Fentity);
		
		return "..........DATA HAS BEEN SAVED..........";
	}

	@Override
	public String DeleteByid(int fid) {

		try {
			
		repo.deleteById(fid);
		return "Data Deleted...";
		}
		catch(Exception e) {
			System.out.println(e);
			return "Enter Valid Id for Delete"; 
		}
	}

	@Override
	public String FingByid(int fid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String UpdateById(int fid, DTO_Form form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DeleAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
