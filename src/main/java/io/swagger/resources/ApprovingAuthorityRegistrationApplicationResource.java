package io.swagger.resources;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.bytebuddy.implementation.bind.annotation.Empty;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-30T07:07:34.520234324Z[GMT]")

public class ApprovingAuthorityRegistrationApplicationResource {
    
    @JsonProperty("id")
    private Long id;

    
    
    @NotBlank(message = "Name is Required")
    @Size(min = 4, max = 20,message = "Name must be between 4 and 20 character")
    @JsonProperty("name")
    private String name;

    @NotBlank(message="Email is Required")
    @Email(regexp="[a-z0-9.a-z0-9]+@(gov|nic|[a-zA-Z]+.gov|[a-zA-Z]+.nic)+.in$",message = " Email Should be Valid")
    @JsonProperty("email")
    private String email;

    
    @NotBlank(message="Mobile Number Required")
    @Pattern(regexp = "(?:\\+91|91)\\d{10}",message="Please Enter Valid Mobile Number (+91|917017xxx))")
    @JsonProperty("mobileNumber")
    private String mobileNumber;

    // @Pattern(regexp = "^[a-zA-Z \\-]{2,}$",message="Designation should be valid")
    
    @NotBlank
    @Size(min = 4, max = 20, message = "Designation length must be between 4 and 20 characters")
    @JsonProperty("designation")
    private String designation;

    
    @JsonProperty("ministry")
    private String ministry;

    
    @JsonProperty("department")
    private String department;

    
    @JsonProperty("organization")
    private String organization;

    @JsonProperty("createdBy")
    private Long createdBy;

    @JsonProperty("updatedBy")
    private Long updatedBy;

    @JsonProperty("createdOn")
    private LocalDateTime createdOn;

    @JsonProperty("updatedOn")
    private LocalDateTime updatedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getMinistry() {
        return ministry;
    }

    public void setMinistry(String ministry) {
        this.ministry = ministry;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    

}
