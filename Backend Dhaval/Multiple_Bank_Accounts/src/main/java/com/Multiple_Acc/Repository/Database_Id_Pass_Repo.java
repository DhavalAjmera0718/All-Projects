package com.Multiple_Acc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Multiple_Acc.Entity.DataBase_User_Id_Pass;

@Repository
public interface Database_Id_Pass_Repo extends JpaRepository<DataBase_User_Id_Pass, String>{

}
