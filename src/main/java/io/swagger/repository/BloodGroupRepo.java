package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.BloodGroup;

public interface BloodGroupRepo extends  JpaRepository<BloodGroup, Long> {
    
}
