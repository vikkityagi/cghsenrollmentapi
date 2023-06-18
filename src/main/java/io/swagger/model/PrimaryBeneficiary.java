package io.swagger.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="index_card")
public class PrimaryBeneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="application_id")
    BenRegistrationApplication benRegistrationApplication;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "primaryBeneficiary", fetch = FetchType.LAZY)
    PrimaryBeneficiaryAddress primaryBeneficiaryAddress;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @OneToMany(mappedBy = "primaryBeneficiary", fetch = FetchType.LAZY)
    @OrderBy("id ASC")
    private List<FamilyMember> familyMemberList;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="card_type_code")
    private CardType cardType;
          
    @Column(name="current_dispensary_code")
    private int currentDispensaryCode;
          
    @Column(name="no_of_beneficiary")
    private int noOfBeneficiaries;
          
    
    @Column(name="department_code")
    private int deptCode;

    @Column(name="ic_no")
    private int icNo;
        
    @Column(name="ben_id")
    private String benId;

    @Column(name="current_designation_code")
    private String currentDesignationCode;

    @Column(name="deputation_flag")
    private boolean depuationFlag;

    @Column(name="completion_of_deputation")
    private LocalDate completionOfDeputation;

    @Column(name="is_transfferable")
    private boolean isTransfferable;

    @Column(name="pen_auto")
    private boolean penAuto;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pay_scale_code")
    CghspayScaleBean payScale;

    @Column(name="present_pay")
    private String presentPay;

    @Column(name="allow_dependent_only")
    private String allowDependentOnly;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by")
    ParichayUser createdBy;

    @Column(name="modified_on")
    private LocalDateTime modifiedOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="modified_by")
    ParichayUser modifiedBy;

    @Column(name="central_deputation")
    private String centralDeputation;

    @Column(name="department")
    private String department;

    @Column(name="date_of_birth")
    private LocalDate dob;

    @Column(name="english_name")
    private String englishname;

    @Column(name="gender")
    private String gender;

    @Column(name="hindi_name")
    private String hindiname;

    @Column(name="ministry")
    private String ministry;

    @Column(name="office_address")
    private String officeAddress;

    @Column(name="office_eamil")
    private String officeEmail;

    @Column(name="office_phoneno")
    private String officePhoneno;

    @Column(name="office_pincode")
    private String officepincode;

    @Column(name="organization")
    private String organization;

    @Column(name="payscale")
    private String payscale;

    @ManyToOne
    @JoinColumn(name="cghs_city_id")
    private CGHSCity cghsCity;

    @Column(name="wardentitlement")
    private String wardentitlement;

    @Column(name="date_of_joining")
    private LocalDate dateOfJoining;

    @Column(name="date_of_superannuation")
    private LocalDate dateOfSuperannuation;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private OrganizationOffice organizationOffice;

    @Override
    public String toString() {
        return "";
        // return "PrimaryBeneficiary [id=" + id + ", benRegistrationApplication=" + benRegistrationApplication
        //         + ", primaryBeneficiaryAddress=" + primaryBeneficiaryAddress + ", familyMemberList=" + familyMemberList
        //         + ", cardTypeCode=" + cardType + ", currentDispensaryCode="
        //         + currentDispensaryCode + ", noOfBeneficiaries=" + noOfBeneficiaries + ", deptCode=" + deptCode
        //         + ", icNo=" + icNo + ", benId=" + benId + ", currentDesignationCode=" + currentDesignationCode
        //         + ", depuationFlag=" + depuationFlag + ", completionOfDeputation=" + completionOfDeputation
        //         + ", isTransfferable=" + isTransfferable + ", penAuto=" + penAuto + ", payScaleCode=" + payscale
        //         + ", presentPay=" + presentPay +  ", allowDependentOnly="
        //         + allowDependentOnly + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", modifiedOn="
        //         + modifiedOn + ", modifiedBy=" + modifiedBy + ", centralDeputation=" + centralDeputation
        //         + ", department=" + department + ", dob=" + dob + ", englishname=" + englishname + ", gender=" + gender
        //         + ", hindiname=" + hindiname + ", ministry=" + ministry + ", officeAddress=" + officeAddress
        //         + ", officeEmail=" + officeEmail + ", officePhoneno=" + officePhoneno + ", officepincode="
        //         + officepincode + ", organization=" + organization + ", payscale=" + payscale +  ", toadofcity=" + toadofcity
        //         + ", wardentitlement=" + wardentitlement + "]";
    }
}
