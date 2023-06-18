package io.swagger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.ParichayUser;

@Repository
public interface BenRegistrationApplicationRepo extends JpaRepository<BenRegistrationApplication,Long> {

    
    @Query("SELECT b FROM BenRegistrationApplication b WHERE b.id = ?1")
    BenRegistrationApplication findRecordById(Long id);

    @Query(value="select id from ben_registration_application order by id desc limit 1",nativeQuery = true)
    Long findByIdOrderByIdDesc();

    List<BenRegistrationApplication> findByParichayId(String id);

    List<BenRegistrationApplication> findByCreatedByAndIsDraft(ParichayUser createdBy, boolean isDraft);
    
}
