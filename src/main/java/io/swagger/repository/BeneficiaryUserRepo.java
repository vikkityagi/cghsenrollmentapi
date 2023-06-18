package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.BeneficiaryUser;

@Repository
public interface BeneficiaryUserRepo extends JpaRepository<BeneficiaryUser,Long> {
    
}
