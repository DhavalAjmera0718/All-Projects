package com.example.StudentManyToMany.Reoo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManyToMany.Entity.Student_Entity;

public interface Student_Repo extends JpaRepository<Student_Entity, Long>{
	
		

}
