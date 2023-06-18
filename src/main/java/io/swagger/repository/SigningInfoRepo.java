package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.NodalApplicationDetail;
import io.swagger.model.SigningInfo;


@Repository
public interface SigningInfoRepo extends JpaRepository<SigningInfo, Integer> {

	
}
