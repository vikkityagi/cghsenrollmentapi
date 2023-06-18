package io.swagger.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.swagger.model.ModuleMaster;

//@RepositoryRestResource(collectionResourceRel = "ModuleMaster", path = "ModuleMaster")
public interface ModuleMasterRepo extends CrudRepository<ModuleMaster,Integer>{
    
}
