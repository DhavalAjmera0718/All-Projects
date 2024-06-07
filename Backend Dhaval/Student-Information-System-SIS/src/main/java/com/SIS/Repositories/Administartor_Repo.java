package com.SIS.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SIS.Entities.Administartor_Entity;

@Repository
public interface Administartor_Repo extends CrudRepository<Administartor_Entity, String>{

	
	Optional<Administartor_Entity> findByName(String name);
	
}
