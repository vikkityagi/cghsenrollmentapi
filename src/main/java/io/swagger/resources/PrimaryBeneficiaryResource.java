package io.swagger.resources;
// package io.swagger.model;

import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * PrimaryBeneficiaryResource
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")

public class PrimaryBeneficiaryResource {

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("parichayId")
  private String parichayId;

  @JsonProperty("benRegistrationApplicationResource")
  private BenRegistrationApplicationResource benRegistrationApplication;

  @JsonProperty("applicationId")
  private Long applicationId = null;

  @JsonProperty("cardNo")
  private String cardNo = null;

  @NotNull
  @JsonProperty("cardTypeCode")
  private Long cardTypeCode;

  @JsonProperty("cardTypeName")
  private String cardTypeName;

  @JsonProperty("currentDispensaryCode")
  private Long currentDispensaryCode = null;

  @JsonProperty("noOfBeneficiaries")
  private Long noOfBeneficiaries = null;

  @NotNull
  @JsonProperty("dateOfJoining")
  private LocalDate dateOfJoining = null;

  @NotNull
  @JsonProperty("dateOfSuperannuation")
  private LocalDate dateOfSuperannuation = null;

  @JsonProperty("isPrimary")
  private Boolean isPrimary = null;

  @JsonProperty("icNo")
  private String icNo = null;

  @JsonProperty("benId")
  private String benId = null;

  @JsonProperty("currentDesignationCode")
  private String currentDesignationCode = null;

  @JsonProperty("depuationFlag")
  private Boolean depuationFlag = null;

  @JsonProperty("completionOfDeputation")
  private String completionOfDeputation = null;

  @JsonProperty("isTransfferable")
  private Boolean isTransfferable = null;

  @JsonProperty("penAuto")
  private Boolean penAuto = null;

  @NotNull
  @JsonProperty("payScaleCode")
  private long payScaleCode;

  @JsonProperty("payScaleName")
  private String payScaleName;

  @NotEmpty
  @NotBlank(message = "Field Cannot be Empty ")
  @JsonProperty("presentPay")
  private String presentPay = null;

  @JsonProperty("allowDependentOnly")
  private String allowDependentOnly = null;

  @NotEmpty
  @NotBlank(message = " English Name must be between 4 and 20 characters")
  @Size(min = 4, max = 20)
  @JsonProperty("englishname")
  private String englishname = null;

  @NotEmpty
  @NotBlank(message = " Hindi Name must be between 4 and 20 characters")
  @Size(min = 4, max = 20)
  @JsonProperty("hindiname")
  private String hindiname = null;

  @NotBlank
  @NotEmpty
  @Size(message = "Gender Cannot be empty")
  @JsonProperty("gender")
  private String gender = null;

  @NotNull
  @JsonProperty("dob")
  private LocalDate dob = null;

  
  @NotNull
  @JsonProperty("cghsCity")
  private Long cghsCity;

  @JsonProperty("cghsCityName")
  private String cghsCityName;

  @NotNull
  @JsonProperty("ministry")
  private String ministry = null;

  @NotNull
  @JsonProperty("department")
  private String department = null;

  @NotNull
  @JsonProperty("organization")
  private String organization = null;

  @NotNull
  @JsonProperty("wardentitlement")
  private String wardentitlement = null;

  @NotNull
  @JsonProperty("organizationOfficeId")
  private Long organizationOfficeId;

  @JsonProperty("organizationOfficeName")
  private String organizationOfficeName;

  @Lob
  @NotEmpty
  @NotBlank
  @Size(min = 4, max = 1000, message = "Office Address Must not be Empty")
  @JsonProperty("officeaddress")
  private String officeaddress = null;

  @JsonProperty("offAddresslineone")
  private String offAddresslineone = null;

  @JsonProperty("offAddresslinetwo")
  private String offAddresslinetwo = null;

  @NotNull
  @JsonProperty("officephoneno")
  private String officephoneno = null;

  @Email(message = "Email Cannot be Empty")
  @JsonProperty("officeemail")
  private String officeemail = null;

  @NotNull
  @JsonProperty("officepincode")
  private String officepincode = null;

  @JsonProperty("officeCity")
  private String officeCity = null;

  @JsonProperty("offDistrictCode")
  private Integer offDistrictCode = null;

  @JsonProperty("dispensary_code")
  private Integer dispensaryCode = null;

  @JsonProperty("indexCardId")
  private Integer indexCardId = null;

  @JsonProperty("resAddresslineone")
  private String resAddresslineone = null;

  @JsonProperty("resAddresslinetwo")
  private String resAddresslinetwo = null;

  @JsonProperty("resLocality")
  private String resLocality = null;

  @Lob
  @NotEmpty
  @NotBlank
  @Size(min = 4, max = 1000, message = "Residental Address Must not be Empty")
  @JsonProperty("residentialaddress")
  private String residentialaddress = null;

  @NotNull
  @JsonProperty("residentialplace")
  private String residentialplace = null;

  @NotNull
  @JsonProperty("residentialcity")
  private String residentialcity = null;


  @JsonProperty("resStateCode")
  private Integer resStateCode = null;

  @JsonProperty("resDistrictCode")
  private Integer resDistrictCode = null;

  @NotNull
  @JsonProperty("residentialpincode")
  private String residentialpincode = null;

  @NotNull
  @JsonProperty("residentialphone")
  private String residentialphone = null;

  @NotNull
  @JsonProperty("residentialmobile")
  private String residentialmobile = null;

  @JsonProperty("residentialemail")
  private String residentialemail = null;

  @JsonProperty("centraldeputation")
  private String centraldeputation = null;

  public PrimaryBeneficiaryResource id(Long id) {
    this.id = id;
    return this;
  }

  public Long getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(Long applicationId) {
    this.applicationId = applicationId;
  }

  /**
   * Get id
   * 
   * @return id
   **/
  @Schema(description = "")

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PrimaryBeneficiaryResource parichayId(String parichayId) {
    this.parichayId = parichayId;
    return this;
  }

  /**
   * Get parichayId
   * 
   * @return parichayId
   **/
  @Schema(description = "")

  public String getParichayId() {
    return parichayId;
  }

  public void setParichayId(String parichayId) {
    this.parichayId = parichayId;
  }

  public PrimaryBeneficiaryResource cardNo(String cardNo) {
    this.cardNo = cardNo;
    return this;
  }

  /**
   * Get cardNo
   * 
   * @return cardNo
   **/
  @Schema(description = "")

  public String getCardNo() {
    return cardNo;
  }

  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
  }

  public PrimaryBeneficiaryResource cardTypeCode(Long cardTypeCode) {
    this.cardTypeCode = cardTypeCode;
    return this;
  }

  /**
   * Get cardTypeCode
   * 
   * @return cardTypeCode
   **/
  @Schema(description = "")

  public Long getCardTypeCode() {
    return cardTypeCode;
  }

  public void setCardTypeCode(Long cardTypeCode) {
    this.cardTypeCode = cardTypeCode;
  }

  public PrimaryBeneficiaryResource currentDispensaryCode(Long currentDispensaryCode) {
    this.currentDispensaryCode = currentDispensaryCode;
    return this;
  }

  /**
   * Get currentDispensaryCode
   * 
   * @return currentDispensaryCode
   **/
  @Schema(description = "")

  public Long getCurrentDispensaryCode() {
    return currentDispensaryCode;
  }

  public void setCurrentDispensaryCode(Long currentDispensaryCode) {
    this.currentDispensaryCode = currentDispensaryCode;
  }

  public PrimaryBeneficiaryResource noOfBeneficiaries(Long noOfBeneficiaries) {
    this.noOfBeneficiaries = noOfBeneficiaries;
    return this;
  }

  /**
   * Get noOfBeneficiaries
   * 
   * @return noOfBeneficiaries
   **/
  @Schema(description = "")

  public Long getNoOfBeneficiaries() {
    return noOfBeneficiaries;
  }

  public void setNoOfBeneficiaries(Long noOfBeneficiaries) {
    this.noOfBeneficiaries = noOfBeneficiaries;
  }

  public PrimaryBeneficiaryResource isPrimary(Boolean isPrimary) {
    this.isPrimary = isPrimary;
    return this;
  }

  /**
   * Get isPrimary
   * 
   * @return isPrimary
   **/
  @Schema(description = "")

  public Boolean isIsPrimary() {
    return isPrimary;
  }

  public void setIsPrimary(Boolean isPrimary) {
    this.isPrimary = isPrimary;
  }

  public PrimaryBeneficiaryResource icNo(String icNo) {
    this.icNo = icNo;
    return this;
  }

  /**
   * Get icNo
   * 
   * @return icNo
   **/
  @Schema(description = "")

  public String getIcNo() {
    return icNo;
  }

  public void setIcNo(String icNo) {
    this.icNo = icNo;
  }

  public PrimaryBeneficiaryResource benId(String benId) {
    this.benId = benId;
    return this;
  }

  /**
   * Get benId
   * 
   * @return benId
   **/
  @Schema(description = "")

  public String getBenId() {
    return benId;
  }

  public void setBenId(String benId) {
    this.benId = benId;
  }

  public PrimaryBeneficiaryResource currentDesignationCode(String currentDesignationCode) {
    this.currentDesignationCode = currentDesignationCode;
    return this;
  }

  /**
   * Get currentDesignationCode
   * 
   * @return currentDesignationCode
   **/
  @Schema(description = "")

  public String getCurrentDesignationCode() {
    return currentDesignationCode;
  }

  public void setCurrentDesignationCode(String currentDesignationCode) {
    this.currentDesignationCode = currentDesignationCode;
  }

  public PrimaryBeneficiaryResource depuationFlag(Boolean depuationFlag) {
    this.depuationFlag = depuationFlag;
    return this;
  }

  /**
   * Get depuationFlag
   * 
   * @return depuationFlag
   **/
  @Schema(description = "")

  public Boolean isDepuationFlag() {
    return depuationFlag;
  }

  public void setDepuationFlag(Boolean depuationFlag) {
    this.depuationFlag = depuationFlag;
  }

  public PrimaryBeneficiaryResource completionOfDeputation(String completionOfDeputation) {
    this.completionOfDeputation = completionOfDeputation;
    return this;
  }

  /**
   * Get completionOfDeputation
   * 
   * @return completionOfDeputation
   **/
  @Schema(description = "")

  public String getCompletionOfDeputation() {
    return completionOfDeputation;
  }

  public void setCompletionOfDeputation(String completionOfDeputation) {
    this.completionOfDeputation = completionOfDeputation;
  }

  public PrimaryBeneficiaryResource isTransfferable(Boolean isTransfferable) {
    this.isTransfferable = isTransfferable;
    return this;
  }

  /**
   * Get isTransfferable
   * 
   * @return isTransfferable
   **/
  @Schema(description = "")

  public Boolean isIsTransfferable() {
    return isTransfferable;
  }

  public void setIsTransfferable(Boolean isTransfferable) {
    this.isTransfferable = isTransfferable;
  }

  public PrimaryBeneficiaryResource penAuto(Boolean penAuto) {
    this.penAuto = penAuto;
    return this;
  }

  /**
   * Get penAuto
   * 
   * @return penAuto
   **/
  @Schema(description = "")

  public Boolean isPenAuto() {
    return penAuto;
  }

  public void setPenAuto(Boolean penAuto) {
    this.penAuto = penAuto;
  }

  public PrimaryBeneficiaryResource payScaleCode(int payScaleCode) {
    this.payScaleCode = payScaleCode;
    return this;
  }

  /**
   * Get payScaleCode
   * 
   * @return payScaleCode
   **/
  @Schema(description = "")

  public long getPayScaleCode() {
    return payScaleCode;
  }

  public void setPayScaleCode(long payScaleCode) {
    this.payScaleCode = payScaleCode;
  }

  public PrimaryBeneficiaryResource allowDependentOnly(String allowDependentOnly) {
    this.allowDependentOnly = allowDependentOnly;
    return this;
  }

  /**
   * Get allowDependentOnly
   * 
   * @return allowDependentOnly
   **/
  @Schema(description = "")

  public String getAllowDependentOnly() {
    return allowDependentOnly;
  }

  public void setAllowDependentOnly(String allowDependentOnly) {
    this.allowDependentOnly = allowDependentOnly;
  }

  public PrimaryBeneficiaryResource englishname(String englishname) {
    this.englishname = englishname;
    return this;
  }

  /**
   * Get englishname
   * 
   * @return englishname
   **/
  @Schema(description = "")

  public String getEnglishname() {
    return englishname;
  }

  public void setEnglishname(String englishname) {
    this.englishname = englishname;
  }

  public PrimaryBeneficiaryResource hindiname(String hindiname) {
    this.hindiname = hindiname;
    return this;
  }

  /**
   * Get hindiname
   * 
   * @return hindiname
   **/
  @Schema(description = "")

  public String getHindiname() {
    return hindiname;
  }

  public void setHindiname(String hindiname) {
    this.hindiname = hindiname;
  }

  public PrimaryBeneficiaryResource gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * 
   * @return gender
   **/
  @Schema(description = "")

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public PrimaryBeneficiaryResource ministry(String ministry) {
    this.ministry = ministry;
    return this;
  }

  /**
   * Get ministry
   * 
   * @return ministry
   **/
  @Schema(description = "")

  public String getMinistry() {
    return ministry;
  }

  public void setMinistry(String ministry) {
    this.ministry = ministry;
  }

  public PrimaryBeneficiaryResource department(String department) {
    this.department = department;
    return this;
  }

  /**
   * Get department
   * 
   * @return department
   **/
  @Schema(description = "")

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public PrimaryBeneficiaryResource organization(String organization) {
    this.organization = organization;
    return this;
  }

  /**
   * Get organization
   * 
   * @return organization
   **/
  @Schema(description = "")

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public PrimaryBeneficiaryResource wardentitlement(String wardentitlement) {
    this.wardentitlement = wardentitlement;
    return this;
  }

  /**
   * Get wardentitlement
   * 
   * @return wardentitlement
   **/
  @Schema(description = "")

  public String getWardentitlement() {
    return wardentitlement;
  }

  public void setWardentitlement(String wardentitlement) {
    this.wardentitlement = wardentitlement;
  }

  public PrimaryBeneficiaryResource officeaddress(String officeaddress) {
    this.officeaddress = officeaddress;
    return this;
  }

  /**
   * Get officeaddress
   * 
   * @return officeaddress
   **/
  @Schema(description = "")

  public String getOfficeaddress() {
    return officeaddress;
  }

  public void setOfficeaddress(String officeaddress) {
    this.officeaddress = officeaddress;
  }

  public PrimaryBeneficiaryResource offAddresslineone(String offAddresslineone) {
    this.offAddresslineone = offAddresslineone;
    return this;
  }

  /**
   * Get offAddresslineone
   * 
   * @return offAddresslineone
   **/
  @Schema(description = "")

  public String getOffAddresslineone() {
    return offAddresslineone;
  }

  public void setOffAddresslineone(String offAddresslineone) {
    this.offAddresslineone = offAddresslineone;
  }

  public PrimaryBeneficiaryResource offAddresslinetwo(String offAddresslinetwo) {
    this.offAddresslinetwo = offAddresslinetwo;
    return this;
  }

  /**
   * Get offAddresslinetwo
   * 
   * @return offAddresslinetwo
   **/
  @Schema(description = "")

  public String getOffAddresslinetwo() {
    return offAddresslinetwo;
  }

  public void setOffAddresslinetwo(String offAddresslinetwo) {
    this.offAddresslinetwo = offAddresslinetwo;
  }

  public PrimaryBeneficiaryResource officephoneno(String officephoneno) {
    this.officephoneno = officephoneno;
    return this;
  }

  /**
   * Get officephoneno
   * 
   * @return officephoneno
   **/
  @Schema(description = "")

  public String getOfficephoneno() {
    return officephoneno;
  }

  public void setOfficephoneno(String officephoneno) {
    this.officephoneno = officephoneno;
  }

  public PrimaryBeneficiaryResource officeemail(String officeemail) {
    this.officeemail = officeemail;
    return this;
  }

  /**
   * Get officeemail
   * 
   * @return officeemail
   **/
  @Schema(example = "fehguy", description = "")

  public String getOfficeemail() {
    return officeemail;
  }

  public void setOfficeemail(String officeemail) {
    this.officeemail = officeemail;
  }

  public PrimaryBeneficiaryResource officepincode(String officepincode) {
    this.officepincode = officepincode;
    return this;
  }

  /**
   * Get officepincode
   * 
   * @return officepincode
   **/
  @Schema(description = "")

  public String getOfficepincode() {
    return officepincode;
  }

  public void setOfficepincode(String officepincode) {
    this.officepincode = officepincode;
  }

  public PrimaryBeneficiaryResource officeCity(String officeCity) {
    this.officeCity = officeCity;
    return this;
  }

  /**
   * Get officeCity
   * 
   * @return officeCity
   **/
  @Schema(description = "")

  public String getOfficeCity() {
    return officeCity;
  }

  public void setOfficeCity(String officeCity) {
    this.officeCity = officeCity;
  }

  public PrimaryBeneficiaryResource offDistrictCode(Integer offDistrictCode) {
    this.offDistrictCode = offDistrictCode;
    return this;
  }

  /**
   * Get offDistrictCode
   * 
   * @return offDistrictCode
   **/
  @Schema(description = "")

  public Integer getOffDistrictCode() {
    return offDistrictCode;
  }

  public void setOffDistrictCode(Integer offDistrictCode) {
    this.offDistrictCode = offDistrictCode;
  }

  public PrimaryBeneficiaryResource dispensaryCode(Integer dispensaryCode) {
    this.dispensaryCode = dispensaryCode;
    return this;
  }

  /**
   * Get dispensaryCode
   * 
   * @return dispensaryCode
   **/
  @Schema(description = "")

  public Integer getDispensaryCode() {
    return dispensaryCode;
  }

  public void setDispensaryCode(Integer dispensaryCode) {
    this.dispensaryCode = dispensaryCode;
  }

  public PrimaryBeneficiaryResource indexCardId(Integer indexCardId) {
    this.indexCardId = indexCardId;
    return this;
  }

  /**
   * Get indexCardId
   * 
   * @return indexCardId
   **/
  @Schema(description = "")

  public Integer getIndexCardId() {
    return indexCardId;
  }

  public void setIndexCardId(Integer indexCardId) {
    this.indexCardId = indexCardId;
  }

  public PrimaryBeneficiaryResource resAddresslineone(String resAddresslineone) {
    this.resAddresslineone = resAddresslineone;
    return this;
  }

  /**
   * Get resAddresslineone
   * 
   * @return resAddresslineone
   **/
  @Schema(description = "")

  public String getResAddresslineone() {
    return resAddresslineone;
  }

  public void setResAddresslineone(String resAddresslineone) {
    this.resAddresslineone = resAddresslineone;
  }

  public PrimaryBeneficiaryResource resAddresslinetwo(String resAddresslinetwo) {
    this.resAddresslinetwo = resAddresslinetwo;
    return this;
  }

  /**
   * Get resAddresslinetwo
   * 
   * @return resAddresslinetwo
   **/
  @Schema(description = "")

  public String getResAddresslinetwo() {
    return resAddresslinetwo;
  }

  public void setResAddresslinetwo(String resAddresslinetwo) {
    this.resAddresslinetwo = resAddresslinetwo;
  }

  public PrimaryBeneficiaryResource resLocality(String resLocality) {
    this.resLocality = resLocality;
    return this;
  }

  /**
   * Get resLocality
   * 
   * @return resLocality
   **/
  @Schema(description = "")

  public String getResLocality() {
    return resLocality;
  }

  public void setResLocality(String resLocality) {
    this.resLocality = resLocality;
  }

  public PrimaryBeneficiaryResource residentialaddress(String residentialaddress) {
    this.residentialaddress = residentialaddress;
    return this;
  }

  /**
   * Get residentialaddress
   * 
   * @return residentialaddress
   **/
  @Schema(description = "")

  public String getResidentialaddress() {
    return residentialaddress;
  }

  public void setResidentialaddress(String residentialaddress) {
    this.residentialaddress = residentialaddress;
  }

  public PrimaryBeneficiaryResource residentialplace(String residentialplace) {
    this.residentialplace = residentialplace;
    return this;
  }

  /**
   * Get residentialplace
   * 
   * @return residentialplace
   **/
  @Schema(description = "")

  public String getResidentialplace() {
    return residentialplace;
  }

  public void setResidentialplace(String residentialplace) {
    this.residentialplace = residentialplace;
  }

  public PrimaryBeneficiaryResource residentialcity(String residentialcity) {
    this.residentialcity = residentialcity;
    return this;
  }

  /**
   * Get residentialcity
   * 
   * @return residentialcity
   **/
  @Schema(description = "")

  public String getResidentialcity() {
    return residentialcity;
  }

  public void setResidentialcity(String residentialcity) {
    this.residentialcity = residentialcity;
  }

  public PrimaryBeneficiaryResource resStateCode(Integer resStateCode) {
    this.resStateCode = resStateCode;
    return this;
  }

  /**
   * Get resStateCode
   * 
   * @return resStateCode
   **/
  @Schema(description = "")

  public Integer getResStateCode() {
    return resStateCode;
  }

  public void setResStateCode(Integer resStateCode) {
    this.resStateCode = resStateCode;
  }

  public PrimaryBeneficiaryResource resDistrictCode(Integer resDistrictCode) {
    this.resDistrictCode = resDistrictCode;
    return this;
  }

  /**
   * Get resDistrictCode
   * 
   * @return resDistrictCode
   **/
  @Schema(description = "")

  public Integer getResDistrictCode() {
    return resDistrictCode;
  }

  public void setResDistrictCode(Integer resDistrictCode) {
    this.resDistrictCode = resDistrictCode;
  }

  public PrimaryBeneficiaryResource residentialpincode(String residentialpincode) {
    this.residentialpincode = residentialpincode;
    return this;
  }

  /**
   * Get residentialpincode
   * 
   * @return residentialpincode
   **/
  @Schema(description = "")

  public String getResidentialpincode() {
    return residentialpincode;
  }

  public void setResidentialpincode(String residentialpincode) {
    this.residentialpincode = residentialpincode;
  }

  public PrimaryBeneficiaryResource residentialphone(String residentialphone) {
    this.residentialphone = residentialphone;
    return this;
  }

  /**
   * Get residentialphone
   * 
   * @return residentialphone
   **/
  @Schema(description = "")

  public String getResidentialphone() {
    return residentialphone;
  }

  public void setResidentialphone(String residentialphone) {
    this.residentialphone = residentialphone;
  }

  public PrimaryBeneficiaryResource residentialmobile(String residentialmobile) {
    this.residentialmobile = residentialmobile;
    return this;
  }

  /**
   * Get residentialmobile
   * 
   * @return residentialmobile
   **/
  @Schema(description = "")

  public String getResidentialmobile() {
    return residentialmobile;
  }

  public void setResidentialmobile(String residentialmobile) {
    this.residentialmobile = residentialmobile;
  }

  public PrimaryBeneficiaryResource residentialemail(String residentialemail) {
    this.residentialemail = residentialemail;
    return this;
  }

  /**
   * Get residentialemail
   * 
   * @return residentialemail
   **/
  @Schema(description = "")

  public String getResidentialemail() {
    return residentialemail;
  }

  public void setResidentialemail(String residentialemail) {
    this.residentialemail = residentialemail;
  }

  public PrimaryBeneficiaryResource centraldeputation(String centraldeputation) {
    this.centraldeputation = centraldeputation;
    return this;
  }

  /**
   * Get centraldeputation
   * 
   * @return centraldeputation
   **/
  @Schema(description = "")

  public String getCentraldeputation() {
    return centraldeputation;
  }

  public void setCentraldeputation(String centraldeputation) {
    this.centraldeputation = centraldeputation;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrimaryBeneficiaryResource primaryBeneficiaryResource = (PrimaryBeneficiaryResource) o;
    return Objects.equals(this.id, primaryBeneficiaryResource.id) &&
        Objects.equals(this.parichayId, primaryBeneficiaryResource.parichayId) &&
        Objects.equals(this.cardNo, primaryBeneficiaryResource.cardNo) &&
        Objects.equals(this.cardTypeCode, primaryBeneficiaryResource.cardTypeCode) &&
        Objects.equals(this.currentDispensaryCode, primaryBeneficiaryResource.currentDispensaryCode) &&
        Objects.equals(this.noOfBeneficiaries, primaryBeneficiaryResource.noOfBeneficiaries) &&
        Objects.equals(this.dateOfJoining, primaryBeneficiaryResource.dateOfJoining) &&
        Objects.equals(this.dateOfSuperannuation, primaryBeneficiaryResource.dateOfSuperannuation) &&
        Objects.equals(this.isPrimary, primaryBeneficiaryResource.isPrimary) &&
        Objects.equals(this.icNo, primaryBeneficiaryResource.icNo) &&
        Objects.equals(this.benId, primaryBeneficiaryResource.benId) &&
        Objects.equals(this.currentDesignationCode, primaryBeneficiaryResource.currentDesignationCode) &&
        Objects.equals(this.depuationFlag, primaryBeneficiaryResource.depuationFlag) &&
        Objects.equals(this.completionOfDeputation, primaryBeneficiaryResource.completionOfDeputation) &&
        Objects.equals(this.isTransfferable, primaryBeneficiaryResource.isTransfferable) &&
        Objects.equals(this.penAuto, primaryBeneficiaryResource.penAuto) &&
        Objects.equals(this.payScaleCode, primaryBeneficiaryResource.payScaleCode) &&
        Objects.equals(this.allowDependentOnly, primaryBeneficiaryResource.allowDependentOnly) &&
        Objects.equals(this.englishname, primaryBeneficiaryResource.englishname) &&
        Objects.equals(this.hindiname, primaryBeneficiaryResource.hindiname) &&

        Objects.equals(this.gender, primaryBeneficiaryResource.gender) &&
        Objects.equals(this.dob, primaryBeneficiaryResource.dob) &&
        Objects.equals(this.cghsCity, primaryBeneficiaryResource.cghsCity) &&
        Objects.equals(this.ministry, primaryBeneficiaryResource.ministry) &&
        Objects.equals(this.department, primaryBeneficiaryResource.department) &&
        Objects.equals(this.organization, primaryBeneficiaryResource.organization) &&
        Objects.equals(this.wardentitlement, primaryBeneficiaryResource.wardentitlement) &&
        Objects.equals(this.officeaddress, primaryBeneficiaryResource.officeaddress) &&
        Objects.equals(this.offAddresslineone, primaryBeneficiaryResource.offAddresslineone) &&
        Objects.equals(this.offAddresslinetwo, primaryBeneficiaryResource.offAddresslinetwo) &&
        Objects.equals(this.officephoneno, primaryBeneficiaryResource.officephoneno) &&
        Objects.equals(this.officeemail, primaryBeneficiaryResource.officeemail) &&
        Objects.equals(this.officepincode, primaryBeneficiaryResource.officepincode) &&
        Objects.equals(this.officeCity, primaryBeneficiaryResource.officeCity) &&
        Objects.equals(this.offDistrictCode, primaryBeneficiaryResource.offDistrictCode) &&
        Objects.equals(this.dispensaryCode, primaryBeneficiaryResource.dispensaryCode) &&
        Objects.equals(this.indexCardId, primaryBeneficiaryResource.indexCardId) &&
        Objects.equals(this.resAddresslineone, primaryBeneficiaryResource.resAddresslineone) &&
        Objects.equals(this.resAddresslinetwo, primaryBeneficiaryResource.resAddresslinetwo) &&
        Objects.equals(this.resLocality, primaryBeneficiaryResource.resLocality) &&
        Objects.equals(this.residentialaddress, primaryBeneficiaryResource.residentialaddress) &&
        Objects.equals(this.residentialplace, primaryBeneficiaryResource.residentialplace) &&
        Objects.equals(this.residentialcity, primaryBeneficiaryResource.residentialcity) &&
        Objects.equals(this.resStateCode, primaryBeneficiaryResource.resStateCode) &&
        Objects.equals(this.resDistrictCode, primaryBeneficiaryResource.resDistrictCode) &&
        Objects.equals(this.residentialpincode, primaryBeneficiaryResource.residentialpincode) &&
        Objects.equals(this.residentialphone, primaryBeneficiaryResource.residentialphone) &&
        Objects.equals(this.residentialmobile, primaryBeneficiaryResource.residentialmobile) &&
        Objects.equals(this.residentialemail, primaryBeneficiaryResource.residentialemail) &&
        Objects.equals(this.centraldeputation, primaryBeneficiaryResource.centraldeputation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parichayId, cardNo, cardTypeCode, currentDispensaryCode,
        noOfBeneficiaries, dateOfJoining, dateOfSuperannuation, isPrimary, icNo, benId, currentDesignationCode,
        depuationFlag, completionOfDeputation, isTransfferable, penAuto, payScaleCode, allowDependentOnly, englishname,
        hindiname, gender, dob, cghsCity, ministry, department, organization,
        wardentitlement, officeaddress, offAddresslineone, offAddresslinetwo, officephoneno, officeemail,
        officepincode, officeCity, offDistrictCode, dispensaryCode, indexCardId, resAddresslineone, resAddresslinetwo,
        resLocality, residentialaddress, residentialplace, residentialcity, resStateCode, resDistrictCode,
        residentialpincode, residentialphone, residentialmobile, residentialemail, centraldeputation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrimaryBeneficiaryResource {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");

    sb.append("    parichayId: ").append(toIndentedString(parichayId)).append("\n");
    sb.append("    cardNo: ").append(toIndentedString(cardNo)).append("\n");
    sb.append("    cardTypeCode: ").append(toIndentedString(cardTypeCode)).append("\n");
    sb.append("    currentDispensaryCode: ").append(toIndentedString(currentDispensaryCode)).append("\n");
    sb.append("    noOfBeneficiaries: ").append(toIndentedString(noOfBeneficiaries)).append("\n");
    sb.append("    dateOfJoinning: ").append(toIndentedString(dateOfJoining)).append("\n");
    sb.append("    dateOfSuperannuation: ").append(toIndentedString(dateOfSuperannuation)).append("\n");
    sb.append("    isPrimary: ").append(toIndentedString(isPrimary)).append("\n");
    sb.append("    icNo: ").append(toIndentedString(icNo)).append("\n");
    sb.append("    benId: ").append(toIndentedString(benId)).append("\n");
    sb.append("    currentDesignationCode: ").append(toIndentedString(currentDesignationCode)).append("\n");
    sb.append("    depuationFlag: ").append(toIndentedString(depuationFlag)).append("\n");
    sb.append("    completionOfDeputation: ").append(toIndentedString(completionOfDeputation)).append("\n");
    sb.append("    isTransfferable: ").append(toIndentedString(isTransfferable)).append("\n");
    sb.append("    penAuto: ").append(toIndentedString(penAuto)).append("\n");
    sb.append("    payScaleCode: ").append(toIndentedString(payScaleCode)).append("\n");
    sb.append("    allowDependentOnly: ").append(toIndentedString(allowDependentOnly)).append("\n");
    sb.append("    englishname: ").append(toIndentedString(englishname)).append("\n");
    sb.append("    hindiname: ").append(toIndentedString(hindiname)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("    cghsCity: ").append(toIndentedString(cghsCity)).append("\n");
    sb.append("    ministry: ").append(toIndentedString(ministry)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    wardentitlement: ").append(toIndentedString(wardentitlement)).append("\n");
    sb.append("    officeaddress: ").append(toIndentedString(officeaddress)).append("\n");
    sb.append("    offAddresslineone: ").append(toIndentedString(offAddresslineone)).append("\n");
    sb.append("    offAddresslinetwo: ").append(toIndentedString(offAddresslinetwo)).append("\n");
    sb.append("    officephoneno: ").append(toIndentedString(officephoneno)).append("\n");
    sb.append("    officeemail: ").append(toIndentedString(officeemail)).append("\n");
    sb.append("    officepincode: ").append(toIndentedString(officepincode)).append("\n");
    sb.append("    officeCity: ").append(toIndentedString(officeCity)).append("\n");
    sb.append("    offDistrictCode: ").append(toIndentedString(offDistrictCode)).append("\n");
    sb.append("    dispensaryCode: ").append(toIndentedString(dispensaryCode)).append("\n");
    sb.append("    indexCardId: ").append(toIndentedString(indexCardId)).append("\n");
    sb.append("    resAddresslineone: ").append(toIndentedString(resAddresslineone)).append("\n");
    sb.append("    resAddresslinetwo: ").append(toIndentedString(resAddresslinetwo)).append("\n");
    sb.append("    resLocality: ").append(toIndentedString(resLocality)).append("\n");
    sb.append("    residentialaddress: ").append(toIndentedString(residentialaddress)).append("\n");
    sb.append("    residentialplace: ").append(toIndentedString(residentialplace)).append("\n");
    sb.append("    residentialcity: ").append(toIndentedString(residentialcity)).append("\n");
    sb.append("    resStateCode: ").append(toIndentedString(resStateCode)).append("\n");
    sb.append("    resDistrictCode: ").append(toIndentedString(resDistrictCode)).append("\n");
    sb.append("    residentialpincode: ").append(toIndentedString(residentialpincode)).append("\n");
    sb.append("    residentialphone: ").append(toIndentedString(residentialphone)).append("\n");
    sb.append("    residentialmobile: ").append(toIndentedString(residentialmobile)).append("\n");
    sb.append("    residentialemail: ").append(toIndentedString(residentialemail)).append("\n");
    sb.append("    centraldeputation: ").append(toIndentedString(centraldeputation)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public LocalDate getDateOfJoining() {
    return dateOfJoining;
  }

  public void setDateOfJoining(LocalDate dateOfJoining) {
    this.dateOfJoining = dateOfJoining;
  }

  public LocalDate getDateOfSuperannuation() {
    return dateOfSuperannuation;
  }

  public void setDateOfSuperannuation(LocalDate dateOfSuperannuation) {
    this.dateOfSuperannuation = dateOfSuperannuation;
  }

  public Boolean getIsPrimary() {
    return isPrimary;
  }

  public Boolean getDepuationFlag() {
    return depuationFlag;
  }

  public Boolean getIsTransfferable() {
    return isTransfferable;
  }

  public Boolean getPenAuto() {
    return penAuto;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public BenRegistrationApplicationResource getBenRegistrationApplication() {
    return benRegistrationApplication;
  }

  public void setBenRegistrationApplication(BenRegistrationApplicationResource benRegistrationApplication) {
    this.benRegistrationApplication = benRegistrationApplication;
  }

  public String getCardTypeName() {
    return cardTypeName;
  }

  public void setCardTypeName(String cardTypeName) {
    this.cardTypeName = cardTypeName;
  }

  public String getPresentPay() {
    return presentPay;
  }

  public void setPresentPay(String presentPay) {
    this.presentPay = presentPay;
  }

  public String getPayScaleName() {
    return payScaleName;
  }

  public void setPayScaleName(String payScaleName) {
    this.payScaleName = payScaleName;
  }

  public long getCghsCity() {
    return cghsCity;
  }

  public void setCghsCity(long cghsCity) {
    this.cghsCity = cghsCity;
  }

  public String getCghsCityName() {
    return cghsCityName;
  }

  public void setCghsCityName(String cghsCityName) {
    this.cghsCityName = cghsCityName;
  }

  public Long getOrganizationOfficeId() {
    return organizationOfficeId;
  }

  public void setOrganizationOfficeId(Long organizationOfficeId) {
    this.organizationOfficeId = organizationOfficeId;
  }

  public String getOrganizationOfficeName() {
    return organizationOfficeName;
  }

  public void setOrganizationOfficeName(String organizationOfficeName) {
    this.organizationOfficeName = organizationOfficeName;
  }

}
