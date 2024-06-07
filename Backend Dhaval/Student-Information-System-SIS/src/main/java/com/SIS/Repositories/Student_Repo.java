package com.SIS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.SIS.Entities.FeeDetails_Entity;
import com.SIS.Entities.Student_Entity;

public interface Student_Repo extends CrudRepository<Student_Entity, String>{
	
	
	@Query("SELECT s.securityKey, s.enrollmentNo FROM Student_Entity s WHERE s.enrollmentNo = :enrollmentNo")
	List<Object[]> findSecurityKeyAndEnrollmentNoByEnrollmentNo(@Param("enrollmentNo") String enrollmentNo);


}
