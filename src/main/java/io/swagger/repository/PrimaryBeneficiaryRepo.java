package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.PrimaryBeneficiary;

public interface PrimaryBeneficiaryRepo extends JpaRepository<PrimaryBeneficiary, Long>{

    PrimaryBeneficiary findByBenRegistrationApplication(BenRegistrationApplication benRegistrationApplication);
    
}