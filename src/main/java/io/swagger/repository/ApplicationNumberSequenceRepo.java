package io.swagger.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import io.swagger.model.NodalApplicationDetail;

@Component
public interface ApplicationNumberSequenceRepo  extends JpaRepository<NodalApplicationDetail, Long>{
    
    @Query(value = "SELECT nextval('application_number_generator') ", nativeQuery = true)
    public Long getNextValue();
}
