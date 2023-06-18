package io.swagger.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Organization;
import io.swagger.model.OrganizationOffice;

@Repository
public interface OrganizationOfficeRepo extends JpaRepository<OrganizationOffice, Long>{

    List<OrganizationOffice> findByOrganization(Organization organization);
    // OrganizationOffice findByOrganization(Organization organization);

    



    
}

