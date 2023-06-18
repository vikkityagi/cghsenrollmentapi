package io.swagger.resources;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")


public class ApprovingAuthorityUserResource {
    @JsonProperty("id")
    private Long id = null;


    @NotEmpty
    @NotBlank
    @Size(min = 4, max = 20,message = " User Name must be between 4 and 20 characters")
    @JsonProperty("userName")
    private String userName;  
    
    @JsonProperty("parichayUserId")
    private Long parichayUserId;
    

    @NotNull
    @JsonProperty("designation")
    private String designation;
    

    @NotNull
    @JsonProperty("empCode")
    private String empCode;
    

    
    @Email(message = " Email Should be Valid")
    @JsonProperty("email")
    private String email;
    

    @NotBlank
    @NotEmpty
    @Size(min = 10,max=12,message = "Please check the Mobile Number")
    @JsonProperty("mobileNo")
    private String mobileNo;
    
    @JsonProperty("organizationId")
    private String organizationId;

    @JsonProperty("organization")
    private String organization;
    
    @JsonProperty("created_on")
    private LocalDateTime createdOn;

    @JsonProperty("updated_on")
    private LocalDateTime updatedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getParichayUserId() {
        return parichayUserId;
    }

    public void setParichayUserId(Long parichayUserId) {
        this.parichayUserId = parichayUserId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    

}
