package io.swagger.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ABHABeneficaryInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-09T06:53:18.360717265Z[GMT]")


public class ABHABeneficaryInfo   {
  @JsonProperty("address")
  private String address = null;

  @JsonProperty("dayOfBirth")
  private String dayOfBirth = null;

  @JsonProperty("districtCode")
  private String districtCode = null;

  @JsonProperty("districtName")
  private String districtName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("emailVerified")
  private String emailVerified = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("gender")
  private String gender = null;

  @JsonProperty("healthId")
  private String healthId = null;

  @JsonProperty("healthIdNumber")
  private String healthIdNumber = null;

  @JsonProperty("kycPhoto")
  private String kycPhoto = null;

  @JsonProperty("kycVerified")
  private String kycVerified = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("mobile")
  private String mobile = null;

  @JsonProperty("monthOfBirth")
  private String monthOfBirth = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("pincode")
  private String pincode = null;

  @JsonProperty("profilePhoto")
  private String profilePhoto = null;

  @JsonProperty("stateCode")
  private String stateCode = null;

  @JsonProperty("stateName")
  private String stateName = null;

  @JsonProperty("subDistrictCode")
  private String subDistrictCode = null;

  @JsonProperty("subdistrictName")
  private String subdistrictName = null;

  @JsonProperty("townCode")
  private String townCode = null;

  @JsonProperty("townName")
  private String townName = null;

  @JsonProperty("verificationStatus")
  private String verificationStatus = null;

  @JsonProperty("verificationType")
  private String verificationType = null;

  @JsonProperty("villageCode")
  private String villageCode = null;

  @JsonProperty("villageName")
  private String villageName = null;

  @JsonProperty("wardCode")
  private String wardCode = null;

  @JsonProperty("wardName")
  private String wardName = null;

  @JsonProperty("yearOfBirth")
  private String yearOfBirth = null;

  public ABHABeneficaryInfo address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  @Schema(description = "")
  
    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public ABHABeneficaryInfo dayOfBirth(String dayOfBirth) {
    this.dayOfBirth = dayOfBirth;
    return this;
  }

  /**
   * Get dayOfBirth
   * @return dayOfBirth
   **/
  @Schema(description = "")
  
    public String getDayOfBirth() {
    return dayOfBirth;
  }

  public void setDayOfBirth(String dayOfBirth) {
    this.dayOfBirth = dayOfBirth;
  }

  public ABHABeneficaryInfo districtCode(String districtCode) {
    this.districtCode = districtCode;
    return this;
  }

  /**
   * Get districtCode
   * @return districtCode
   **/
  @Schema(description = "")
  
    public String getDistrictCode() {
    return districtCode;
  }

  public void setDistrictCode(String districtCode) {
    this.districtCode = districtCode;
  }

  public ABHABeneficaryInfo districtName(String districtName) {
    this.districtName = districtName;
    return this;
  }

  /**
   * Get districtName
   * @return districtName
   **/
  @Schema(description = "")
  
    public String getDistrictName() {
    return districtName;
  }

  public void setDistrictName(String districtName) {
    this.districtName = districtName;
  }

  public ABHABeneficaryInfo email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(description = "")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ABHABeneficaryInfo emailVerified(String emailVerified) {
    this.emailVerified = emailVerified;
    return this;
  }

  /**
   * Get emailVerified
   * @return emailVerified
   **/
  @Schema(description = "")
  
    public String getEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(String emailVerified) {
    this.emailVerified = emailVerified;
  }

  public ABHABeneficaryInfo firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   **/
  @Schema(description = "")
  
    public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public ABHABeneficaryInfo gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
   **/
  @Schema(description = "")
  
    public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public ABHABeneficaryInfo healthId(String healthId) {
    this.healthId = healthId;
    return this;
  }

  /**
   * Get healthId
   * @return healthId
   **/
  @Schema(description = "")
  
    public String getHealthId() {
    return healthId;
  }

  public void setHealthId(String healthId) {
    this.healthId = healthId;
  }

  public ABHABeneficaryInfo healthIdNumber(String healthIdNumber) {
    this.healthIdNumber = healthIdNumber;
    return this;
  }

  /**
   * Get healthIdNumber
   * @return healthIdNumber
   **/
  @Schema(description = "")
  
    public String getHealthIdNumber() {
    return healthIdNumber;
  }

  public void setHealthIdNumber(String healthIdNumber) {
    this.healthIdNumber = healthIdNumber;
  }

  public ABHABeneficaryInfo kycPhoto(String kycPhoto) {
    this.kycPhoto = kycPhoto;
    return this;
  }

  /**
   * Get kycPhoto
   * @return kycPhoto
   **/
  @Schema(description = "")
  
    public String getKycPhoto() {
    return kycPhoto;
  }

  public void setKycPhoto(String kycPhoto) {
    this.kycPhoto = kycPhoto;
  }

  public ABHABeneficaryInfo kycVerified(String kycVerified) {
    this.kycVerified = kycVerified;
    return this;
  }

  /**
   * Get kycVerified
   * @return kycVerified
   **/
  @Schema(description = "")
  
    public String getKycVerified() {
    return kycVerified;
  }

  public void setKycVerified(String kycVerified) {
    this.kycVerified = kycVerified;
  }

  public ABHABeneficaryInfo lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  @Schema(description = "")
  
    public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public ABHABeneficaryInfo middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Get middleName
   * @return middleName
   **/
  @Schema(description = "")
  
    public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public ABHABeneficaryInfo mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * Get mobile
   * @return mobile
   **/
  @Schema(description = "")
  
    public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public ABHABeneficaryInfo monthOfBirth(String monthOfBirth) {
    this.monthOfBirth = monthOfBirth;
    return this;
  }

  /**
   * Get monthOfBirth
   * @return monthOfBirth
   **/
  @Schema(description = "")
  
    public String getMonthOfBirth() {
    return monthOfBirth;
  }

  public void setMonthOfBirth(String monthOfBirth) {
    this.monthOfBirth = monthOfBirth;
  }

  public ABHABeneficaryInfo name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(description = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ABHABeneficaryInfo pincode(String pincode) {
    this.pincode = pincode;
    return this;
  }

  /**
   * Get pincode
   * @return pincode
   **/
  @Schema(description = "")
  
    public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

  public ABHABeneficaryInfo profilePhoto(String profilePhoto) {
    this.profilePhoto = profilePhoto;
    return this;
  }

  /**
   * Get profilePhoto
   * @return profilePhoto
   **/
  @Schema(description = "")
  
    public String getProfilePhoto() {
    return profilePhoto;
  }

  public void setProfilePhoto(String profilePhoto) {
    this.profilePhoto = profilePhoto;
  }

  public ABHABeneficaryInfo stateCode(String stateCode) {
    this.stateCode = stateCode;
    return this;
  }

  /**
   * Get stateCode
   * @return stateCode
   **/
  @Schema(description = "")
  
    public String getStateCode() {
    return stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  public ABHABeneficaryInfo stateName(String stateName) {
    this.stateName = stateName;
    return this;
  }

  /**
   * Get stateName
   * @return stateName
   **/
  @Schema(description = "")
  
    public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public ABHABeneficaryInfo subDistrictCode(String subDistrictCode) {
    this.subDistrictCode = subDistrictCode;
    return this;
  }

  /**
   * Get subDistrictCode
   * @return subDistrictCode
   **/
  @Schema(description = "")
  
    public String getSubDistrictCode() {
    return subDistrictCode;
  }

  public void setSubDistrictCode(String subDistrictCode) {
    this.subDistrictCode = subDistrictCode;
  }

  public ABHABeneficaryInfo subdistrictName(String subdistrictName) {
    this.subdistrictName = subdistrictName;
    return this;
  }

  /**
   * Get subdistrictName
   * @return subdistrictName
   **/
  @Schema(description = "")
  
    public String getSubdistrictName() {
    return subdistrictName;
  }

  public void setSubdistrictName(String subdistrictName) {
    this.subdistrictName = subdistrictName;
  }

  public ABHABeneficaryInfo townCode(String townCode) {
    this.townCode = townCode;
    return this;
  }

  /**
   * Get townCode
   * @return townCode
   **/
  @Schema(description = "")
  
    public String getTownCode() {
    return townCode;
  }

  public void setTownCode(String townCode) {
    this.townCode = townCode;
  }

  public ABHABeneficaryInfo townName(String townName) {
    this.townName = townName;
    return this;
  }

  /**
   * Get townName
   * @return townName
   **/
  @Schema(description = "")
  
    public String getTownName() {
    return townName;
  }

  public void setTownName(String townName) {
    this.townName = townName;
  }

  public ABHABeneficaryInfo verificationStatus(String verificationStatus) {
    this.verificationStatus = verificationStatus;
    return this;
  }

  /**
   * Get verificationStatus
   * @return verificationStatus
   **/
  @Schema(description = "")
  
    public String getVerificationStatus() {
    return verificationStatus;
  }

  public void setVerificationStatus(String verificationStatus) {
    this.verificationStatus = verificationStatus;
  }

  public ABHABeneficaryInfo verificationType(String verificationType) {
    this.verificationType = verificationType;
    return this;
  }

  /**
   * Get verificationType
   * @return verificationType
   **/
  @Schema(description = "")
  
    public String getVerificationType() {
    return verificationType;
  }

  public void setVerificationType(String verificationType) {
    this.verificationType = verificationType;
  }

  public ABHABeneficaryInfo villageCode(String villageCode) {
    this.villageCode = villageCode;
    return this;
  }

  /**
   * Get villageCode
   * @return villageCode
   **/
  @Schema(description = "")
  
    public String getVillageCode() {
    return villageCode;
  }

  public void setVillageCode(String villageCode) {
    this.villageCode = villageCode;
  }

  public ABHABeneficaryInfo villageName(String villageName) {
    this.villageName = villageName;
    return this;
  }

  /**
   * Get villageName
   * @return villageName
   **/
  @Schema(description = "")
  
    public String getVillageName() {
    return villageName;
  }

  public void setVillageName(String villageName) {
    this.villageName = villageName;
  }

  public ABHABeneficaryInfo wardCode(String wardCode) {
    this.wardCode = wardCode;
    return this;
  }

  /**
   * Get wardCode
   * @return wardCode
   **/
  @Schema(description = "")
  
    public String getWardCode() {
    return wardCode;
  }

  public void setWardCode(String wardCode) {
    this.wardCode = wardCode;
  }

  public ABHABeneficaryInfo wardName(String wardName) {
    this.wardName = wardName;
    return this;
  }

  /**
   * Get wardName
   * @return wardName
   **/
  @Schema(description = "")
  
    public String getWardName() {
    return wardName;
  }

  public void setWardName(String wardName) {
    this.wardName = wardName;
  }

  public ABHABeneficaryInfo yearOfBirth(String yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
    return this;
  }

  /**
   * Get yearOfBirth
   * @return yearOfBirth
   **/
  @Schema(description = "")
  
    public String getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(String yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ABHABeneficaryInfo abHABeneficaryInfo = (ABHABeneficaryInfo) o;
    return Objects.equals(this.address, abHABeneficaryInfo.address) &&
        Objects.equals(this.dayOfBirth, abHABeneficaryInfo.dayOfBirth) &&
        Objects.equals(this.districtCode, abHABeneficaryInfo.districtCode) &&
        Objects.equals(this.districtName, abHABeneficaryInfo.districtName) &&
        Objects.equals(this.email, abHABeneficaryInfo.email) &&
        Objects.equals(this.emailVerified, abHABeneficaryInfo.emailVerified) &&
        Objects.equals(this.firstName, abHABeneficaryInfo.firstName) &&
        Objects.equals(this.gender, abHABeneficaryInfo.gender) &&
        Objects.equals(this.healthId, abHABeneficaryInfo.healthId) &&
        Objects.equals(this.healthIdNumber, abHABeneficaryInfo.healthIdNumber) &&
        Objects.equals(this.kycPhoto, abHABeneficaryInfo.kycPhoto) &&
        Objects.equals(this.kycVerified, abHABeneficaryInfo.kycVerified) &&
        Objects.equals(this.lastName, abHABeneficaryInfo.lastName) &&
        Objects.equals(this.middleName, abHABeneficaryInfo.middleName) &&
        Objects.equals(this.mobile, abHABeneficaryInfo.mobile) &&
        Objects.equals(this.monthOfBirth, abHABeneficaryInfo.monthOfBirth) &&
        Objects.equals(this.name, abHABeneficaryInfo.name) &&
        Objects.equals(this.pincode, abHABeneficaryInfo.pincode) &&
        Objects.equals(this.profilePhoto, abHABeneficaryInfo.profilePhoto) &&
        Objects.equals(this.stateCode, abHABeneficaryInfo.stateCode) &&
        Objects.equals(this.stateName, abHABeneficaryInfo.stateName) &&
        Objects.equals(this.subDistrictCode, abHABeneficaryInfo.subDistrictCode) &&
        Objects.equals(this.subdistrictName, abHABeneficaryInfo.subdistrictName) &&
        Objects.equals(this.townCode, abHABeneficaryInfo.townCode) &&
        Objects.equals(this.townName, abHABeneficaryInfo.townName) &&
        Objects.equals(this.verificationStatus, abHABeneficaryInfo.verificationStatus) &&
        Objects.equals(this.verificationType, abHABeneficaryInfo.verificationType) &&
        Objects.equals(this.villageCode, abHABeneficaryInfo.villageCode) &&
        Objects.equals(this.villageName, abHABeneficaryInfo.villageName) &&
        Objects.equals(this.wardCode, abHABeneficaryInfo.wardCode) &&
        Objects.equals(this.wardName, abHABeneficaryInfo.wardName) &&
        Objects.equals(this.yearOfBirth, abHABeneficaryInfo.yearOfBirth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, dayOfBirth, districtCode, districtName, email, emailVerified, firstName, gender, healthId, healthIdNumber, kycPhoto, kycVerified, lastName, middleName, mobile, monthOfBirth, name, pincode, profilePhoto, stateCode, stateName, subDistrictCode, subdistrictName, townCode, townName, verificationStatus, verificationType, villageCode, villageName, wardCode, wardName, yearOfBirth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ABHABeneficaryInfo {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    dayOfBirth: ").append(toIndentedString(dayOfBirth)).append("\n");
    sb.append("    districtCode: ").append(toIndentedString(districtCode)).append("\n");
    sb.append("    districtName: ").append(toIndentedString(districtName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    emailVerified: ").append(toIndentedString(emailVerified)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    healthId: ").append(toIndentedString(healthId)).append("\n");
    sb.append("    healthIdNumber: ").append(toIndentedString(healthIdNumber)).append("\n");
    sb.append("    kycPhoto: ").append(toIndentedString(kycPhoto)).append("\n");
    sb.append("    kycVerified: ").append(toIndentedString(kycVerified)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    monthOfBirth: ").append(toIndentedString(monthOfBirth)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    pincode: ").append(toIndentedString(pincode)).append("\n");
    sb.append("    profilePhoto: ").append(toIndentedString(profilePhoto)).append("\n");
    sb.append("    stateCode: ").append(toIndentedString(stateCode)).append("\n");
    sb.append("    stateName: ").append(toIndentedString(stateName)).append("\n");
    sb.append("    subDistrictCode: ").append(toIndentedString(subDistrictCode)).append("\n");
    sb.append("    subdistrictName: ").append(toIndentedString(subdistrictName)).append("\n");
    sb.append("    townCode: ").append(toIndentedString(townCode)).append("\n");
    sb.append("    townName: ").append(toIndentedString(townName)).append("\n");
    sb.append("    verificationStatus: ").append(toIndentedString(verificationStatus)).append("\n");
    sb.append("    verificationType: ").append(toIndentedString(verificationType)).append("\n");
    sb.append("    villageCode: ").append(toIndentedString(villageCode)).append("\n");
    sb.append("    villageName: ").append(toIndentedString(villageName)).append("\n");
    sb.append("    wardCode: ").append(toIndentedString(wardCode)).append("\n");
    sb.append("    wardName: ").append(toIndentedString(wardName)).append("\n");
    sb.append("    yearOfBirth: ").append(toIndentedString(yearOfBirth)).append("\n");
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
}
