package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.swagger.model.Ministry;

public interface MinistryRepo extends JpaRepository<Ministry, String> {

	
	Ministry findByMinistryCode(String ministryCode);

	@Query(value="select id,name from levelone where id = ?1",nativeQuery=true)
	Ministry findByMinistryId(String ministryId);
}
