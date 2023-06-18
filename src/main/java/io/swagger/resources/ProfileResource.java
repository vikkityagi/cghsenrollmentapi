package io.swagger.resources;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

/**
 * AdRoleResources
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")

public class ProfileResource {

    @JsonProperty("id")
    private Long id = null;

    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name should only contain alphabetic characters")
    @NotBlank(message="Name is required")
    @Size(min = 3, max = 100, message = "User Name must be between 3 and 100 characters")
    @JsonProperty("userName")
    private String userName;

    @Pattern(regexp = "^[a-zA-Z \\-]{2,}$",message="Designation should be valid")
    @NotBlank(message = "Designation is required")
    @Size(min = 2, max = 20, message = " Designation must be between 2 to 20 characters")
    @JsonProperty("designation")
    private String designation;

    @NotNull(message = "EmpCode is required")
    @Pattern(regexp = "^[0-9]{4,}",message="emp code must be digit and greater than 3 digit")
    @JsonProperty("empCode")
    private String empCode;

    @Email(regexp="[a-z0-9.a-z0-9]+@(gov|nic|[a-zA-Z]+.gov|[a-zA-Z]+.nic)+.in$",message = " Email Should be Valid")
    @NotBlank(message = "Email is required")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Mobile is required")
    @Pattern(regexp = "^[91][0-9]{10,}$",message="Mobile should be valid")
    @Size(max = 12, message = "Please check the length Mobile Number")
    @JsonProperty("mobile")
    private String mobile;

    
    @JsonProperty("ministry")
    private String ministry;

    @JsonProperty("ministryName")
    private String ministryName;

    
    @JsonProperty("department")
    private String department;

    @JsonProperty("departmentName")
    private String departmentName;

    
    @JsonProperty("organization")
    private String organization;

    @JsonProperty("organizationName")
    private String organizationName;


    @JsonProperty("roleId")
    private Long roleId;

    @JsonProperty("roleName")
    private String roleName;

    @JsonProperty("parichayUserId")
    private Long parichayUserId;

    @JsonProperty("createdOn")
    private LocalDateTime createdOn;

    @JsonProperty("updatedOn")
    private LocalDateTime updatedOn;

    @JsonProperty("organizationOfficeId")
    private Long organizationOfficeId;

    @JsonProperty("organizationOfficeName")
    private String organizationOfficeName;


    @JsonProperty("adCity")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> adCity;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMinistry() {
        return ministry;
    }

    public void setMinistry(String ministry) {
        this.ministry = ministry;
    }

    public String getMinistryName() {
        return ministryName;
    }

    public void setMinistryName(String ministryName) {
        this.ministryName = ministryName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getParichayUserId() {
        return parichayUserId;
    }

    public void setParichayUserId(Long parichayUserId) {
        this.parichayUserId = parichayUserId;
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

    public List<String> getAdCity() {
        return adCity;
    }

    public void setAdCity(List<String> adCity) {
        this.adCity = adCity;
    }

    // @AssertTrue(message = "Please check the Role")
    // public boolean isAdRoleThanAdCity() {
    //     System.out.println(adCity);
    //     if (roleId!=4 && adCity.size()==0) {    
    //         return true;
    //     }
    //     return false;
    // }

}
