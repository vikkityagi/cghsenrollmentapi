package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.swagger.model.Role;

//@RepositoryRestResource(collectionResourceRel = "Role", path = "Role")
public interface RoleRepo extends CrudRepository<Role,Long>{

    @Query(value="select *from role_master where id=?1",nativeQuery= true)
    List<Role> findAllById(long roleId);
    
}
