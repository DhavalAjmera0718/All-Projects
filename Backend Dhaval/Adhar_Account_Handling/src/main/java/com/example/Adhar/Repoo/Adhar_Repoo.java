package com.example.Adhar.Repoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Adhar.Entity.Adhar_Entity;

@Repository
public interface Adhar_Repoo extends JpaRepository<Adhar_Entity, Long> {

}
