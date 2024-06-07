package com.DemoOld_Security.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.DemoOld_Security.Entity.Old_JWT_Entity;

@Repository
public interface Old_Jwt_Repository extends CrudRepository<Old_JWT_Entity, String>{

}
