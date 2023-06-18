package io.swagger.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.ApprovingOfficer;
import io.swagger.model.Organization;

@Repository
public interface ApprovingOfficerRepo extends JpaRepository<ApprovingOfficer, Long> {

    
    List<ApprovingOfficer> findByOrganization(Organization organization);

}
