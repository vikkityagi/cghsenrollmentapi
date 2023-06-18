package io.swagger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.swagger.model.Department;
import io.swagger.model.Organization;

public interface OrganizationRepo extends JpaRepository<Organization, String > {

	//@Query(value="select *from organization where departmentcode = ?1 order by ",nativeQuery = true)
	List<Organization> findByDepartmentOrderByOrganizationName(Department department);


	@Query(value="select * from levelthree where id = ?1",nativeQuery=true)
	Organization findByOrganizationname(String name);

}
