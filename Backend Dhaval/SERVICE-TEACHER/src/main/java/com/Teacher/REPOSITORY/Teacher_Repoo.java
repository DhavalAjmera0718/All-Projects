package com.Teacher.REPOSITORY;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Teacher.Entity.Teacher_Entity;

@Repository
public interface Teacher_Repoo  extends CrudRepository<Teacher_Entity, Long>{

	
}
