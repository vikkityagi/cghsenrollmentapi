package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.BloodGroup;
import io.swagger.model.RelationshipType;

public interface RelationshipTypeRepo extends  JpaRepository<RelationshipType, Long> {
    
}
