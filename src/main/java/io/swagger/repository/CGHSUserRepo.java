package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.CGHSUser;
import io.swagger.model.ParichayUser;
import io.swagger.model.Role;

@Repository
public interface CGHSUserRepo extends JpaRepository<CGHSUser, Long>{

    CGHSUser findByUpdatedBy(ParichayUser parichayUser);

    
    @Query(value="select * from cghs_users where role_id=?1",nativeQuery=true)
    CGHSUser findByRoleId(long id);
    
}
