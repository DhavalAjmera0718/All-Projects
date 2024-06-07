package com.DemoOld_Security.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.DemoOld_Security.Entity.JWT_Entity;

@Repository
public interface JWT_Repooo extends CrudRepository<JWT_Entity, String>{

}
