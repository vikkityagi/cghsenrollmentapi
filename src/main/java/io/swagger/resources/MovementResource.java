package io.swagger.resources;

import java.time.LocalDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Movement
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T17:49:37.665755339Z[GMT]")


public class MovementResource   {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("fromOffice")
  private Long fromOffice = null;

  @JsonProperty("applicationNumber")
  private String applicationNumber;

  @JsonProperty("toOffice")
  private Long toOffice= null;

  @JsonProperty("actionType")
  private Long actionType = null;

  @JsonProperty("actionName")
  private String actionName = null;

  @JsonProperty("isNew")
  private boolean isNew = false;

  @JsonProperty("application")
  private Long application;

  @JsonProperty("createdBy")
  private Long createdBy;

  @JsonProperty("updatedBy")
  private Long updatedBy;

  @JsonProperty("levelNo")
  private Integer levelNo;

  @JsonProperty("createdOn")
  private LocalDateTime createdOn;

  @JsonProperty("updatedOn")
  private LocalDateTime updatedOn;

  @JsonProperty("applicationType")
  private Long applicationType;

  @JsonProperty("roleId")
  private Long roleId;

  @JsonProperty("cghsCity")
  private long cghsCity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFromOffice() {
    return fromOffice;
  }

  public void setFromOffice(Long fromOffice) {
    this.fromOffice = fromOffice;
  }

  public Long getToOffice() {
    return toOffice;
  }

  public void setToOffice(Long toOffice) {
    this.toOffice = toOffice;
  }

  public Long getActionType() {
    return actionType;
  }

  public void setActionType(Long actionType) {
    this.actionType = actionType;
  }

  public boolean isNew() {
    return isNew;
  }

  public void setNew(boolean isNew) {
    this.isNew = isNew;
  }

  public Long getApplication() {
    return application;
  }

  public void setApplication(Long application) {
    this.application = application;
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

  public Integer getLevelNo() {
    return levelNo;
  }

  public void setLevelNo(Integer levelNo) {
    this.levelNo = levelNo;
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

  public Long getApplicationType() {
    return applicationType;
  }

  public void setApplicationType(Long applicationType) {
    this.applicationType = applicationType;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getApplicationNumber() {
    return applicationNumber;
  }

  public void setApplicationNumber(String applicationNumber) {
    this.applicationNumber = applicationNumber;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public long getCghsCity() {
    return cghsCity;
  }

  public void setCghsCity(long cghsCity) {
    this.cghsCity = cghsCity;
  }

  
  
}
