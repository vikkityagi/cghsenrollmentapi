package io.swagger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.swagger.model.State;
import io.swagger.model.StateModel;

public interface StateRepo extends JpaRepository<StateModel, Long>{

	@Query(value="select * from cghs_state where serial_no = ?1",nativeQuery = true)
	StateModel findByStateName(int stateid);


}
