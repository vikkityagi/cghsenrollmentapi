package io.swagger.resources;

import java.time.LocalDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.model.ActionType;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MovementResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T17:49:37.665755339Z[GMT]")


public class MovementResponseResource    {

  @JsonProperty("id")
  private Long id ;

  @JsonProperty("fromUserId")
  private Long fromUserId = null;

  @JsonProperty("fromUserName")
  private String fromUserName = null;

  @JsonProperty("toUserRoles")
  private Long[] toUserRoles = null;

  @JsonProperty("fromUserRoles")
  private Long[] fromUserRoles = null;

  @JsonProperty("toUserId")
  private Long toUserId = null;

  @JsonProperty("toUserName")
  private String toUserName = null;

  @JsonProperty("actionType")
  private Long actionTypeId = null;

  @JsonProperty("actionTypeName")
  private String actionTypeName = null;

  @JsonProperty("applicationId")
  private Long applicationId = null;

  @JsonProperty("applicationNumber")
  private String applicationNumber = null;


  @JsonProperty("applicationTypeName")
  private String applicationTypeName = null;


  @JsonProperty("created_by")
  private int created_by;

  @JsonProperty("updated_by")
  private int updated_by;

  @JsonProperty("created_on")
  private LocalDateTime created_on;

  @JsonProperty("updated_on")
  private LocalDateTime updated_on;

  public MovementResponseResource id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public MovementResponseResource fromUserId(Long fromUserId) {
    this.fromUserId = fromUserId;
    return this;
  }

  /**
   * Get fromUserId
   * @return fromUserId
   **/
  @Schema(description = "")
  
    public Long getFromUserId() {
    return fromUserId;
  }

  public void setFromUserId(Long fromUserId) {
    this.fromUserId = fromUserId;
  }

  public MovementResponseResource toUserId(Long toUserId) {
    this.toUserId = toUserId;
    return this;
  }

  /**
   * Get toUserId
   * @return toUserId
   **/
  @Schema(description = "")
  
    public Long getToUserId() {
    return toUserId;
  }

  public void setToUserId(Long toUserId) {
    this.toUserId = toUserId;
  }


  public MovementResponseResource applicationId(Long applicationId) {
    this.applicationId = applicationId;
    return this;
  }

  /**
   * Get applicationId
   * @return applicationId
   **/
  @Schema(description = "")
  
    public Long getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(Long applicationId) {
    this.applicationId = applicationId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MovementResponseResource movementResponse = (MovementResponseResource) o;
    return Objects.equals(this.id, movementResponse.id) &&
        Objects.equals(this.fromUserId, movementResponse.fromUserId) &&
        Objects.equals(this.toUserId, movementResponse.toUserId) &&
        Objects.equals(this.applicationId, movementResponse.applicationId);
  }

 

  public int getCreated_by() {
    return created_by;
  }

  public void setCreated_by(int created_by) {
    this.created_by = created_by;
  }

  public int getUpdated_by() {
    return updated_by;
  }

  public void setUpdated_by(int updated_by) {
    this.updated_by = updated_by;
  }

  public LocalDateTime getCreated_on() {
    return created_on;
  }

  public void setCreated_on(LocalDateTime created_on) {
    this.created_on = created_on;
  }

  public LocalDateTime getUpdated_on() {
    return updated_on;
  }

  public void setUpdated_on(LocalDateTime updated_on) {
    this.updated_on = updated_on;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fromUserId, toUserId,  applicationId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MovementResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    fromUserId: ").append(toIndentedString(fromUserId)).append("\n");
    sb.append("    toUserId: ").append(toIndentedString(toUserId)).append("\n");
    sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
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

  public String getApplicationNumber() {
    return applicationNumber;
  }

  public void setApplicationNumber(String applicationNumber) {
    this.applicationNumber = applicationNumber;
  }

  public Long getActionTypeId() {
    return actionTypeId;
  }

  public void setActionTypeId(Long actionTypeId) {
    this.actionTypeId = actionTypeId;
  }

  public String getActionTypeName() {
    return actionTypeName;
  }

  public void setActionTypeName(String actionTypeName) {
    this.actionTypeName = actionTypeName;
  }

  public String getFromUserName() {
    return fromUserName;
  }

  public void setFromUserName(String fromUserName) {
    this.fromUserName = fromUserName;
  }

  public String getToUserName() {
    return toUserName;
  }

  public void setToUserName(String toUserName) {
    this.toUserName = toUserName;
  }

  public Long[] getToUserRoles() {
    return toUserRoles;
  }

  public void setToUserRoles(Long[] toUserRoles) {
    this.toUserRoles = toUserRoles;
  }

  public Long[] getFromUserRoles() {
    return fromUserRoles;
  }

  public void setFromUserRoles(Long[] fromUserRoles) {
    this.fromUserRoles = fromUserRoles;
  }

  public String getApplicationTypeName() {
    return applicationTypeName;
  }

  public void setApplicationTypeName(String applicationTypeName) {
    this.applicationTypeName = applicationTypeName;
  }


}
