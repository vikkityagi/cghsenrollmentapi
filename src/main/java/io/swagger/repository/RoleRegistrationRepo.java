package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.RoleRegistration;

public interface RoleRegistrationRepo extends JpaRepository<RoleRegistration, Long> {
    
}
