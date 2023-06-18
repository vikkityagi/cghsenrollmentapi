package io.swagger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.ApprovingAuthorityUser;
import io.swagger.model.Organization;
import io.swagger.model.OrganizationOffice;
import io.swagger.model.ParichayUser;

@Repository
public interface ApprovingAuthorityUserRepo extends JpaRepository<ApprovingAuthorityUser, Long>{
    
    List<ApprovingAuthorityUser> findByOrganization(Organization organization);
    List<ApprovingAuthorityUser> findByParichayUser(ParichayUser parichayuser);
    Optional<ApprovingAuthorityUser> findByParichayUser(Optional<ParichayUser> findById);
    ApprovingAuthorityUser findByOrganizationOffice(OrganizationOffice organizationOffice);
    
    

}
