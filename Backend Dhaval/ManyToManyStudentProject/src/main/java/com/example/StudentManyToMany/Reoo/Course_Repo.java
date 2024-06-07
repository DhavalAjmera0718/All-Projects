package com.example.StudentManyToMany.Reoo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManyToMany.Entity.Course_Entity;

public interface Course_Repo extends JpaRepository<Course_Entity, Long> {

	//  @Query("SELECT c.students FROM Course_Entity c WHERE c.cid = :cid")
//	    List<Student_Entity> findStudentsByCid(@Param("cid") Long cid);
}

