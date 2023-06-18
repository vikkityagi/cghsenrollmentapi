package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.CGHSCity;

@Repository
public interface CGHSCityRepo extends JpaRepository<CGHSCity, Long>{

}
