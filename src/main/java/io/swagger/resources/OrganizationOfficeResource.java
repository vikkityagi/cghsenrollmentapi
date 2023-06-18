package io.swagger.resources;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.Organization;

public class OrganizationOfficeResource {
    

    @JsonProperty("id")
    private long id;


    @NotBlank
    @NotEmpty
    @Size( message = "Office Name must be filled")
    @JsonProperty("officeName")
    private String officeName;
    

    @NotBlank
    @NotEmpty
    @Size( message = "Office ShortName must be filled")
    @JsonProperty("officeShortName")
    private String  officeShortName;

    @JsonProperty("created_on")
    private LocalDateTime createdOn;

    @JsonProperty("updated_on")
    private LocalDateTime updatedOn;

    @JsonProperty("isDeleted")
    private boolean deleted;
    
    @JsonProperty("isActive")
    private boolean active;



    @JsonProperty("organizationName")
    private String organizationName;


    @NotNull
    @JsonProperty("organizationId")
    private String organizationId;

    @JsonProperty("parichayId")
    private Long parichayId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeShortName() {
        return officeShortName;
    }

    public void setOfficeShortName(String officeShortName) {
        this.officeShortName = officeShortName;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationId() {
        return organizationId;
    }
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Long getParichayId() {
        return parichayId;
    }
    
    public void setParichayId(Long parichayId) {
        this.parichayId = parichayId;
    }



    


    
}
