package io.swagger.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.ApprovingPdf;

@Repository
public interface ApprovingPdfRepo extends MongoRepository<ApprovingPdf, Integer>{

	
	ApprovingPdf findByApprovingauthorityId(int applicationId);

}
