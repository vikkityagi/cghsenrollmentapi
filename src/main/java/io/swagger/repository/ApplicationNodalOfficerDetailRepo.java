package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.ApplicationNodalOfficerDetail;
import io.swagger.model.ApplicationNodalOfficerDetail;

@Repository
public interface ApplicationNodalOfficerDetailRepo extends JpaRepository<ApplicationNodalOfficerDetail, Long> {


    @Query(value = "select *from application_nodal_officer_details where employeeid=?1", nativeQuery = true)
	ApplicationNodalOfficerDetail findByEmployeeid(String eid);

	@Query(value = "select *from application_nodal_officer_details where id=?1", nativeQuery = true)
	ApplicationNodalOfficerDetail findByNodalid(Integer applicationId);

	@Query(value = "select *from application_nodal_officer_details where organization_id=?1 limit 1",nativeQuery = true)
    ApplicationNodalOfficerDetail findByOrganization(String organization_id);

	@Query(value = "select *from application_nodal_officer_details where organization_office_id=?1",nativeQuery = true)
    ApplicationNodalOfficerDetail findByOrganizationOffice(Long organizationOfficeId);

}
