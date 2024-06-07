package com.Auth.Repository;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Auth.ENTITY.Credential_Entity;

@Repository
public interface Credential_Repo  extends CrudRepository<Credential_Entity, String>{
	
	
//	@Query("SELECT s FROM Credential_Entity s WHERE s.email = :emailId")
//	Credential_Entity findEmailId(@Param("emailId") String emailId);
	
	Credential_Entity findByEmailAndDob(String email,LocalDate dob);
	
	Credential_Entity findByEmail(String email);
	
	Credential_Entity findByEmailAndOtpAndDob(String email , Integer otp,LocalDate date);
	

}
