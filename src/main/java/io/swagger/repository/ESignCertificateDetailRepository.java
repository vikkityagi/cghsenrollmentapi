package io.swagger.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.ESignCertificateDetail;

public interface ESignCertificateDetailRepository extends JpaRepository<ESignCertificateDetail, Long>{
    
}
