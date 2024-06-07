package com.example.Company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Company.Entity.Upload_EntityMain;

public interface Image_Repo extends JpaRepository<Upload_EntityMain, Long> {

}
