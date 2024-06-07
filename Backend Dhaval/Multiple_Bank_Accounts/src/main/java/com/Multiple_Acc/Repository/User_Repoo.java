package com.Multiple_Acc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Multiple_Acc.Entity.User_Entity;

@Repository
public interface User_Repoo extends JpaRepository<User_Entity, Long> {

	@Query("SELECT a.accBalance, a.bankName FROM User_Entity u JOIN u.accDetails  a WHERE u.id = :userId")
    List<Long> getAccountBalancesByUserId(@Param("userId") Long userId);

//	 @Query("SELECT new com.Multiple_Acc.Entity(a.accBalance, a.bankName) FROM User_Entity u JOIN u.accDetails a WHERE u.userId = :userId")
//    List<User_Entity> getAccountBalancesByUserId(@Param("userId") Long userId);

}
