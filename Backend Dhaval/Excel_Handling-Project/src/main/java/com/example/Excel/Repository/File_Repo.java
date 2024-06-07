package com.example.Excel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Excel.Main_Entity.Main_Enitity;
@Repository
public interface File_Repo extends JpaRepository<Main_Enitity, Long> {

}
