package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.ActionType;
import io.swagger.model.PrimaryBeneficiary;
import io.swagger.model.PrimaryBeneficiaryAddress;

@Repository
public interface ActionTypeRepo extends JpaRepository<ActionType,Long>{

    
    
}
