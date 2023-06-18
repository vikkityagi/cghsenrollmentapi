package io.swagger.service;

import io.swagger.model.FamilyMember;
import io.swagger.resources.FamilyMemberResource;
import io.swagger.resources.PrimaryBeneficiaryResource;

public interface BenRegistrationApplicationService {
    
    public PrimaryBeneficiaryResource saveBenRegistrationForm(PrimaryBeneficiaryResource benFormResource) throws Exception;
    
    public FamilyMember saveFamilyMember(FamilyMemberResource familyFormResource) throws Exception;
}

