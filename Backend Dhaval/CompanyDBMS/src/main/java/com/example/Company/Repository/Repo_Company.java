package com.example.Company.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Company.Entity.CompanyEntity;

public interface Repo_Company extends CrudRepository<CompanyEntity, Integer> {

}
