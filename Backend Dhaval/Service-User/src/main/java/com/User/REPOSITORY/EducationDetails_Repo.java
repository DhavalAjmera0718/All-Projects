package com.User.REPOSITORY;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.User.Entity.EducationDetails_Entity;

@Repository
public interface EducationDetails_Repo extends CrudRepository<EducationDetails_Entity, Long>{

}
