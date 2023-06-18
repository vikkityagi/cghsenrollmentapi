package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.WardEntitlement;

public interface WardEntitlementRepo extends JpaRepository<WardEntitlement, Long> {
    
}
