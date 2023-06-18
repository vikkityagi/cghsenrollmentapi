package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.AdRole;
import io.swagger.model.ApplicationType;

public interface ApplicationTypeRepo extends JpaRepository<ApplicationType,Long> {
    
}
