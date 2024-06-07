package com.example.Mapping.Repo;

import org.springframework.data.repository.CrudRepository;

import com.example.Mapping.Entity.Emp_Entity;

public interface Repo_Emp extends CrudRepository<Emp_Entity, Long> {

}
