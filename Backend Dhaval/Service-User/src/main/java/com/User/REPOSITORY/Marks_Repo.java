package com.User.REPOSITORY;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.User.Entity.Marks_Entity;

@Repository
public interface Marks_Repo extends CrudRepository<Marks_Entity, Long> {

}
