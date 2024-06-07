package com.example.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.Enitity.Users_Entity;

public interface User_Details_Repo extends JpaRepository<Users_Entity, Long>{

}
