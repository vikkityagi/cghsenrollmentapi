package io.swagger.resources;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.model.PrimaryBeneficiary;
import io.swagger.model.RelationshipType;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FamilyMemberResource
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")

public class FamilyMemberResource {

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("applicationId")
  private long applicationId;

  @JsonProperty("parichayId")
  private String parichayId;

  @JsonProperty("primaryBeneficiaryId")
  private long primaryBeneficiaryId;

  @JsonProperty("familyId")
  private Long familyId = null;

  @JsonProperty("benId")
  private String benId = null;

  @AssertTrue
  @JsonProperty("isPrimary")
  private Boolean isPrimary = null;

  @JsonProperty("gender")
  @NotEmpty
  @Size(message = "Invalid Gender")
  private String gender = null;


  @Min(value=1,message="Not a valid relation code")
  @JsonProperty("relationCode")
  private long relationCode = 0;
 
  //output param
  @JsonProperty("relationName")
  private String relationName = null;

  //output param
  @JsonProperty("bloodGroupName")
  private String bloodGroupName = null;

    
  @JsonProperty("bloodGroupCode")
  @Min(value=1,message="Not a valid blood group code")
  private long bloodGroupCode = 0;

  @NotNull(message = "DOB Cannot be Null")
  @JsonProperty("dateOfBirth")
  private LocalDate dateOfBirth = null;

 
  @JsonProperty("photoUrl")
  private String photoUrl = null;


  @JsonProperty("isDisabled")
  private String isDisabled = null;

  @NotBlank
  @NotEmpty
  @Size(min = 10,max=12,message = "Invalid Mobile")
  @JsonProperty("mobile")
  private String mobile = null;

  @Email(message = "Invalid Email")
  @JsonProperty("email")
  private String email = null;

  @NotEmpty
  @NotBlank(message = "Invalid Name")
  @Size(min = 4, max = 20)
  @JsonProperty("englishname")
  private String englishName = null;

  @NotEmpty
  @NotBlank(message = "Invalid Name")
  @Size(min = 4, max = 20)
  @JsonProperty("hindiname")
  private String hindiName = null;

  
  @JsonProperty("otpverify")
  private String otpVerify;



  protected Object set;

  public FamilyMemberResource id(Long id) {
    this.id = id;
    return this;
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

  public FamilyMemberResource indexCardId(long indexCardId) {
    this.primaryBeneficiaryId = indexCardId;
    return this;
  }

  public long getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(long applicationId) {
    this.applicationId = applicationId;
  }

  public long getPrimaryBeneficiaryId() {
    return primaryBeneficiaryId;
  }

  public void setPrimaryBeneficiaryId(long primaryBeneficiaryId) {
    this.primaryBeneficiaryId = primaryBeneficiaryId;
  }

  public Boolean getIsPrimary() {
    return isPrimary;
  }

  public FamilyMemberResource familyId(Long familyId) {
    this.familyId = familyId;
    return this;
  }

  /**
   * Get familyId
   * 
   * @return familyId
   **/
  @Schema(description = "")

  public Long getFamilyId() {
    return familyId;
  }

  public void setFamilyId(Long familyId) {
    this.familyId = familyId;
  }

  public FamilyMemberResource benId(String benId) {
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

  public FamilyMemberResource isPrimary(Boolean isPrimary) {
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

  public FamilyMemberResource gender(String gender) {
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

  public void setGender(String c) {
    this.gender = c;
  }

  public FamilyMemberResource relationCode(int relationCode) {
    this.relationCode = relationCode;
    return this;
  }

  /**
   * Get relationCode
   * 
   * @return relationCode
   **/
  @Schema(description = "")

  public long getRelationCode() {
    return relationCode;
  }

  public void setRelationCode(long relationCode) {
    this.relationCode = relationCode;
  }

  public String getBloodGroupName() {
    return bloodGroupName;
  }

  public void setBloodGroupName(String bloodGroupName) {
    this.bloodGroupName = bloodGroupName;
  }

  public long getBloodGroupCode() {
    return bloodGroupCode;
  }

  public void setBloodGroupCode(long bloodGroupCode) {
    this.bloodGroupCode = bloodGroupCode;
  }

  public FamilyMemberResource photoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
    return this;
  }

  /**
   * Get photoUrl
   * 
   * @return photoUrl
   **/
  @Schema(description = "")

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public FamilyMemberResource isDisabled(String isDisabled) {
    this.isDisabled = isDisabled;
    return this;
  }

  /**
   * Get isDisabled
   * 
   * @return isDisabled
   **/
  @Schema(description = "")

  public String getIsDisabled() {
    return isDisabled;
  }

  public void setIsDisabled(String isDisabled) {
    this.isDisabled = isDisabled;
  }

  public FamilyMemberResource mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * Get mobile
   * 
   * @return mobile
   **/
  @Schema(description = "")

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public FamilyMemberResource email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * 
   * @return email
   **/
  @Schema(description = "")

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEnglishName() {
    return englishName;
  }

  public void setEnglishName(String englishName) {
    this.englishName = englishName;
  }

  public String getHindiName() {
    return hindiName;
  }

  public void setHindiName(String hindiName) {
    this.hindiName = hindiName;
  }

  public String getOtpVerify() {
    return otpVerify;
  }

  public void setOtpVerify(String otpVerify) {
    this.otpVerify = otpVerify;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FamilyMemberResource familyMemberResource = (FamilyMemberResource) o;
    return Objects.equals(this.id, familyMemberResource.id) &&
        Objects.equals(this.primaryBeneficiaryId, familyMemberResource.primaryBeneficiaryId) &&
        Objects.equals(this.familyId, familyMemberResource.familyId) &&
        Objects.equals(this.benId, familyMemberResource.benId) &&
        Objects.equals(this.isPrimary, familyMemberResource.isPrimary) &&
        Objects.equals(this.gender, familyMemberResource.gender) &&
        Objects.equals(this.relationCode, familyMemberResource.relationCode) &&
        Objects.equals(this.bloodGroupName, familyMemberResource.bloodGroupName) &&
        Objects.equals(this.dateOfBirth, familyMemberResource.dateOfBirth) &&
        Objects.equals(this.photoUrl, familyMemberResource.photoUrl) &&
        Objects.equals(this.isDisabled, familyMemberResource.isDisabled) &&
        Objects.equals(this.mobile, familyMemberResource.mobile) &&
        Objects.equals(this.email, familyMemberResource.email) &&
        Objects.equals(this.englishName, familyMemberResource.englishName) &&
        Objects.equals(this.hindiName, familyMemberResource.hindiName) &&
        Objects.equals(this.otpVerify, familyMemberResource.otpVerify);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, primaryBeneficiaryId, familyId, benId, isPrimary, gender, relationCode, bloodGroupName,
        dateOfBirth, photoUrl, isDisabled, mobile, email, englishName, hindiName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FamilyMemberResource {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    indexCardId: ").append(toIndentedString(primaryBeneficiaryId)).append("\n");
    sb.append("    familyId: ").append(toIndentedString(familyId)).append("\n");
    sb.append("    benId: ").append(toIndentedString(benId)).append("\n");
    sb.append("    isPrimary: ").append(toIndentedString(isPrimary)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    relationCode: ").append(toIndentedString(relationCode)).append("\n");
    sb.append("    bloodGroup: ").append(toIndentedString(bloodGroupName)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    photoUrl: ").append(toIndentedString(photoUrl)).append("\n");
    sb.append("    isDisabled: ").append(toIndentedString(isDisabled)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    englishname: ").append(toIndentedString(englishName)).append("\n");
    sb.append("    hindiname: ").append(toIndentedString(hindiName)).append("\n");
    sb.append("    otpverify: ").append(toIndentedString(otpVerify)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  public String getParichayId() {
    return parichayId;
  }

  public void setParichayId(String parichayId) {
    this.parichayId = parichayId;
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

  public String getRelationName() {
    return relationName;
  }

  public void setRelationName(String relationName) {
    this.relationName = relationName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }


}
