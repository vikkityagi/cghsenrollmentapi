package io.swagger.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Application;

@Repository
@Primary
public interface ApplicationRepo extends CrudRepository<Application, Long> {
    
}
