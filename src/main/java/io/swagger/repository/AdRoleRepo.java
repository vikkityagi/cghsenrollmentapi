package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.AdRole;

public interface AdRoleRepo extends JpaRepository<AdRole,Long> {
    
}
