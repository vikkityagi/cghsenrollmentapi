package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "application_signing_info")
@Data
public class SigningInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    ESignCertificateDetail eSignCertificateDetail;
    
    @Column(name = "esign_response_xml")
    private String eSignResponseXML;

    @Column(name = "pkcs7_string")
    private String pkcs7String;

}
