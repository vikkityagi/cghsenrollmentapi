package io.swagger.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="esign_certificate_details")
public class ESignCertificateDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    private java.lang.String serialNumber;

    private java.lang.String commonName;

    private java.lang.String organization;

    private java.lang.String organizationUnit;

    private java.lang.String houseName;

    private java.lang.String street;

    private java.lang.String locality;

    private java.lang.String state;

    private java.lang.String country;

    private java.lang.String postalCode;

    private java.lang.String gender;

    private java.lang.String phone;

    private java.lang.String email;

    private java.lang.String issuedBy;

    private java.lang.String expiryDate;

    private java.lang.String validFrom;

    private java.lang.String dnQualifier;

    private java.lang.String yearOfBirth;

    private java.lang.String hashOfPhoto;

    private java.lang.String title;

    private String base64X509Certificate;
}
