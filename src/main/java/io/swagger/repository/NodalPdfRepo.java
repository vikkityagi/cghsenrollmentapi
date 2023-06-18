package io.swagger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import io.swagger.model.NodalPdf;

@Repository
public interface NodalPdfRepo extends MongoRepository<NodalPdf, Long> {

	@Query("{'nodalofficerId' : ?0}")
	NodalPdf findByNodalPdf(Integer applicationId);

}
