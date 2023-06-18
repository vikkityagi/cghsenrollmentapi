package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.ApprovingAuthority;


@Repository
public interface ApprovingRepo extends JpaRepository<ApprovingAuthority, Long> {

	@Query(value = "select *from approving_authority where id=?1", nativeQuery = true)
	ApprovingAuthority findByApprovingid(Integer applicationId);
	
	

}
