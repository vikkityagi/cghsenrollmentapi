package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.swagger.model.NodalUser;

@Repository
public interface NodalUserRepo extends JpaRepository<NodalUser, Long>{

    @Query(value = "select *from nodal_users where parichayuser_id=?1", nativeQuery = true)
	NodalUser findByParichayId(Long parichayId);

    @Query(value = "select *from nodal_users where org_id=?1 and is_verified='true'",nativeQuery = true)
    List<NodalUser> findByOrganization(String orgId);

}

