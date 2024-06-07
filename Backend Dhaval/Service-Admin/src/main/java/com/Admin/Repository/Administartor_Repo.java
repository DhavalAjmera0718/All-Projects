package com.Admin.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Admin.Entity.Administartor_Entity;

@Repository
public interface Administartor_Repo extends CrudRepository<Administartor_Entity, Long> {

}
