package com.Admin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Admin.Entity.Administartor_Entity;
import com.Admin.Proxi.Administartor_DTOO;

@Service
public interface Admin_Service {
	
	public String registerWithDetails(Administartor_DTOO dto) ;
	
	public Administartor_DTOO getAdmin(Long id) ;
	
	public String updateAdminDetails( Long id , Administartor_DTOO dtoo) ;
	
	public List<Administartor_Entity> getAllAdminData();
	
	public String Delete_AdminBy_Id( Long id);
}
