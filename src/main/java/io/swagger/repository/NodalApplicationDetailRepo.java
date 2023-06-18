package io.swagger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.NodalApplicationDetail;
import io.swagger.model.ParichayUser;


@Repository
public interface NodalApplicationDetailRepo extends JpaRepository<NodalApplicationDetail, Long> {

    @Query(value="select * from application_detail order by id desc limit 1",nativeQuery = true)
    NodalApplicationDetail findIdOrderById();

    List<NodalApplicationDetail> findByParichayId(String id);

    // Optional<NodalApplicationDetail> findByNodalOfficer(Long movementId);

    // List<NodalApplicationDetail> findByCreatedByAndDraft(ParichayUser parichayUser, boolean draft);

	
}
