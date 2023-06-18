package io.swagger.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.model.ParichayUser;

@Repository
public interface ParichayUserRepo extends JpaRepository<ParichayUser,Long>
{
    Optional<ParichayUser> findByParichayId(String parichayId);

    // @Query(value="select *from parichay_user p where p.local_token_id = :tokenValue",nativeQuery = true)
    ParichayUser findByLocalTokenId(String tokenValue);
    
}
