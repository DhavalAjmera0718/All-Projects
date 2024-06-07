package com.practise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.Entity.p_Entity;

@Repository
public interface p_Repo extends JpaRepository<p_Entity, Integer> {

}
