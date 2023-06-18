package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.CGHSInchargeApplication;
import io.swagger.model.ParichayUser;

@Repository
public interface CGHSInchargeApplicationRepo extends JpaRepository<CGHSInchargeApplication,Long> {

    CGHSInchargeApplication findByCreatedBy(ParichayUser parichayUser);
    
}
