package io.swagger.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.swagger.model.SubModuleMaster;

//@RepositoryRestResource(collectionResourceRel = "SubModuleMaster", path = "SubModuleMasters")
public interface SubModuleMasterRepo extends CrudRepository<SubModuleMaster,Integer>{
    
}
