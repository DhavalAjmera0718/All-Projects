package com.Admin.Repository;





import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Admin.Entity.FeeDetails_Entity;

@Repository
public interface FeeDetails_Repo  extends CrudRepository<FeeDetails_Entity, Long>{

	@Query("SELECT feeDetails FROM FeeDetails_Entity feeDetails WHERE feeDetails.student_enrollmentNo = :enrollmentNo")
	List<FeeDetails_Entity> findByEnrollmentNo(@Param("enrollmentNo") String enrollmentNo);
	
	
}
