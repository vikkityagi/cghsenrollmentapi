package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.FamilyMember;
import io.swagger.model.PrimaryBeneficiary;

@Repository
public interface FamilyMemberRepo extends JpaRepository<FamilyMember,Long> {

    // @Query(value="from FamilyMember where primaryBeneficiary.id=:id")
     List<FamilyMember> findByPrimaryBeneficiaryOrderById(PrimaryBeneficiary primaryBeneficiary);

    
}
