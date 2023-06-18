package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.DeptModel;

public interface DeptRepo extends JpaRepository<DeptModel, Long> {

}
