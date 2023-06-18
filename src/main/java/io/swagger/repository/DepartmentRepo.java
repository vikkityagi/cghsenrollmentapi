package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.swagger.model.Department;
import io.swagger.model.Ministry;

public interface DepartmentRepo extends JpaRepository<Department, String> {

	
	List<Department> findByMinistryOrderByDepartmentName(Ministry ministry);
	
	Department findByDepartmentCode(String departmentCode);

	@Query(value="select * from leveltwo where id = ?1",nativeQuery=true)
	Department findByDepartmentId(String departmentID);


}
