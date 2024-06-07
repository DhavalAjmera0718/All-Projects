package com.example.Adhar.Repoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Adhar.Entity.User_Input_Data_ForAngular;

@Repository
public interface User_Input_Repository extends JpaRepository<User_Input_Data_ForAngular, Long> {

}
