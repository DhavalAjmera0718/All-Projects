package com.User.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.User.Entity.Student_Entity;

public interface Student_Repo extends CrudRepository<Student_Entity, String>{
	
	
/************************************************ MICROSERVICE *********************************************************************************/	
	
	@Query("SELECT s.securityKey, s.enrollmentNo FROM Student_Entity s WHERE s.enrollmentNo = :enrollmentNo")
	List<Object[]> findSecurityKeyAndEnrollmentNoByEnrollmentNo(@Param("enrollmentNo") String enrollmentNo);
	
	
	@Query("SELECT s.securityKey FROM Student_Entity s WHERE s.name= :name")
	String getOnly_SecurityKey_ByName(@Param("name") String name);
	
	@Query(value = "SELECT COUNT(*) FROM Student_Entity")
	String Count_Data();
	
	@Query(value =  "SELECT * FROM student_table WHERE name LIKE :character%" , nativeQuery = true)
	List<Student_Entity> Get_DataBy_Character(@Param("character") String character);
	


}