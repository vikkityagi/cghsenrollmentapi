package io.swagger.model;

import java.time.LocalDateTime;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="index_card_address")
public class PrimaryBeneficiaryAddress {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="dispensary_code")
    private int dispensaryCode;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="index_card_id")
    PrimaryBeneficiary primaryBeneficiary;

    @Column(name="res_addresslineone") 
    private String resAddressLineOne;

    @Column(name="res_addresslinetwo")
    private String resAddressLineTwo;

    @Column(name="res_locality")
    private String resLacality;

    @Column(name="res_city")
    private String resCity;

    @Column(name="res_state_code")
    private int resStateCode;

    @Column(name="cghs_state_code")
    private int cghsCityCode;

    @Column(name="res_district_code")
    private int resDistrictCode;

    @Column(name="pincode")
    private String pinCode;

    @Column(name="office_phone_no")
    private String officePhoneno;

    @Column(name="res_phone_no")
    private String resPhoneNo;

    @Column(name="email")
    private String email;

    @Column(name="off_addresslineone")
    private String offAddressLineOne;

    @Column(name="off_addresslinetwo")
    private String offAddressLineTwo;

    @Column(name="offCity")
    private String offCity;

    @Column(name="off_district_code")
    private int offDistrictcode;

    @Column(name="off_state_code")
    private int offStateCode;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by")
    ParichayUser createdBy;

    @Column(name="modified_on")
    LocalDateTime modifiedOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="modified_by")
    ParichayUser modifiedBy;

    @Column(name="residential_mobile")
    private String residentialmobile;

    @Override
    public String toString() {
        return "PrimaryBeneficiaryAddress [id=" + id + ", dispensaryCode=" + dispensaryCode + ", resAddressLineOne="
                + resAddressLineOne + ", resAddressLineTwo=" + resAddressLineTwo + ", resLacality=" + resLacality
                + ", resCity=" + resCity + ", resStateCode=" + resStateCode + ", cghsCityCode=" + cghsCityCode
                + ", resDistrictCode=" + resDistrictCode + ", pinCode=" + pinCode + ", officePhoneno=" + officePhoneno
                + ", resPhoneNo=" + resPhoneNo + ", email=" + email + ", offAddressLineOne=" + offAddressLineOne
                + ", offAddressLineTwo=" + offAddressLineTwo + ", offCity=" + offCity + ", offDistrictcode="
                + offDistrictcode + ", offStateCode=" + offStateCode + ", createdOn=" + createdOn + ", createdBy="
                + createdBy + ", modifiedOn=" + modifiedOn + ", modifiedBy=" + modifiedBy +  ", residentialmobile=" + residentialmobile + "]";
    }

}
