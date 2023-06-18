package io.swagger.resources;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * PrimaryBeneficiaryResource
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-04T07:07:34.520234324Z[GMT]")

public class CGHSInchargeRegistrationResource {

 
    @JsonProperty("id")
    private Long id;
    

    @NotEmpty
    @NotBlank(message = " Name must be between 4 and 20 characters")
    @Size(min = 4, max = 20)
    @JsonProperty("name")
    private String name;



    @NotBlank
    @Size(min = 4, max = 20, message = " Designation must be between 4 to 20 characters")
    @JsonProperty("designation")
    private String designation;


    @Email(regexp="[a-z0-9.a-z0-9]+@(gov|nic|[a-zA-Z]+.gov|[a-zA-Z]+.nic)+.in$",message = " Email Should be Valid")
    @JsonProperty("email")
    private String email;



    @NotBlank
    @Pattern(regexp = "(?:\\+91|91)\\d{10}",message="Mobile should be start with +91 or 91 or Check the length")
    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("created_by")
    private long created_by;

    @JsonProperty("updated_by")
    private long updated_by;

    @JsonProperty("created_on")
    private LocalDateTime created_on;

    @JsonProperty("updated_on")
    private LocalDate updated_on;


    @NotNull(message = "Cghs City must be filled")
    @JsonProperty("cghscity")
    private List<String> cghscity;


    @NotNull
    @JsonProperty("ministry")
    private String ministry;


    @NotNull
    @JsonProperty("department")
    private String department;


    @NotNull
    @JsonProperty("organization")
    private String organization;

    @JsonProperty("parichayUserId")
    private Long parichayUserId;

    @JsonProperty("organizationOfficeId")
	private Long organizationOfficeId;

	@JsonProperty("organizationOfficeName")
	private String organizationOfficeName;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(long created_by) {
        this.created_by = created_by;
    }

    public long getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(long updated_by) {
        this.updated_by = updated_by;
    }

    

    public LocalDate getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(LocalDate updated_on) {
        this.updated_on = updated_on;
    }

    public List<String> getCghscity() {
        return cghscity;
    }

    public void setCghscity(List<String> cghscity) {
        this.cghscity = cghscity;
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

    public Long getParichayUserId() {
        return parichayUserId;
    }

    public void setParichayUserId(Long parichayUserId) {
        this.parichayUserId = parichayUserId;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    
    
    
    }

