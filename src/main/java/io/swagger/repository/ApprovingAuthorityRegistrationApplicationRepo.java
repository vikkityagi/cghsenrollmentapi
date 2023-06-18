package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.ApprovingAuthorityRegistrationApplication;

@Repository
public interface ApprovingAuthorityRegistrationApplicationRepo extends JpaRepository<ApprovingAuthorityRegistrationApplication,Long> {
    
}
