package com.example.Pan.Repoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pan.Enitity.Pan_Entity;

@RestController
public interface Pan_Repoo extends JpaRepository<Pan_Entity, Long>{

}
