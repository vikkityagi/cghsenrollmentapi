package io.swagger.resources;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.ParichayUser;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;



/**
 * AdRoleResources
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")
public class NodalUserResource {

    @JsonProperty("parichayUserId")
    private Long parichayUserId;


    @NotBlank
    @NotEmpty
    @Size(min = 4,max=20,message = " UserName must be between 4 and 20 characters")
    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("designation")
    private String designation;

    
    
    @JsonProperty("orgId")
    private String organizationId;

    @JsonProperty("createdOn")
    private LocalDateTime createdOn;
  
    @JsonProperty("updatedOn")
    private LocalDateTime updatedOn;

    public Long getParichayUserId() {
        return parichayUserId;
    }

    public void setParichayUserId(Long parichayUserId) {
        this.parichayUserId = parichayUserId;
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
  
    
}

  

//   @JsonProperty("organization")
//   private String organization;

//   @JsonProperty("organizationName")
//   private String organizationName;

  

//   @JsonProperty("roleId")
//   private Long roleId;

//   @JsonProperty("roleName")
//   private String roleName;

 

//   @JsonProperty("createdOn")
//   private LocalDateTime createdOn;

//   @JsonProperty("updatedOn")
//   private LocalDateTime updatedOn;



  