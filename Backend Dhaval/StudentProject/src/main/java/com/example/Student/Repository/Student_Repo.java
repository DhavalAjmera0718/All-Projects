package com.example.Student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Student.Enitity.Student_Enitity;

import jakarta.transaction.Transactional;

@Repository
public interface Student_Repo  extends CrudRepository<Student_Enitity , Long>{

	
	@Query("SELECT s FROM Student_Enitity s")
	List<Student_Enitity> GetAlldata();
	
	@Query("SELECT s FROM Student_Enitity s WHERE s.RollNo=:sid")
	Student_Enitity GetDataById(@Param("sid") Long sid);
	
	@Query("SELECT s FROM Student_Enitity s WHERE s.RollNo = :sid AND s.Name = :name")
	Student_Enitity GetSingleData_ByName(@Param("sid") Long sid, @Param("name") String name);

	@Query("SELECT s.Name ,s.address FROM Student_Enitity s WHERE s.RollNo = :sid")
	String Get_Only_Name_Using_Id(@Param("sid") Long sid);
	
	//@Query(value =  "DELETE FROM Student_Enitity  WHERE roll_no= :sid" , nativeQuery = true)
	@Modifying
	@Transactional
	@Query("DELETE FROM Student_Enitity s WHERE s.RollNo = :sid")
	void DeleteBy_ID(@Param("sid") Long sid);
	
	/*@Modifying
	@Transactional
	@Query("UPDATE Student_Enitity s SET s.name = :newName WHERE s.rollNo = :sid")
	void Update_By_Id(@Param("sid") Long sidLong , @Param("name") String name);
	*/
	@Modifying
	@Transactional
	@Query("UPDATE Student_Enitity s SET s.Name = :newName, s.address= :address, s.age= :age WHERE s.RollNo = :sid")
	void updateNameByRollNo(@Param("sid") Long sid, @Param("newName") String newName 
			,@Param("address") String address , @Param("age") int age );
	
	
	@Query(value = "SELECT COUNT(*) FROM Student_Enitity")
	Student_Enitity Count_Data();
	
	@Query(value = "SELECT * FROM Student_Enitity WHERE address= :city" , nativeQuery = true)
	List<Student_Enitity> FindData_byAdress(@Param("city") String city);
	
	@Query(value = "SELECT * FROM Student_Enitity WHERE name LIKE :name%" , nativeQuery = true)
	List<Student_Enitity> FindData_By_Character(@Param("name") String name);

	@Query(value = "SELECT * FROM Student_Enitity ORDER BY age" , nativeQuery = true)
	List<Student_Enitity> Ordered_By_age();
	
}






















