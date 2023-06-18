package io.swagger.resources;
import java.time.LocalDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
// import org.springframework.hateoas.RepresentationModel;

/**
 * BenRegistrationApplicationResource
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")
@Data
// public class BenRegistrationApplicationResource extends RepresentationModel<BenRegistrationApplicationResource>{ 
public class BenRegistrationApplicationResource { 
    
    @JsonProperty("id")
  private Long id = null;



  @NotNull
  @JsonProperty("application_type_code")
  private Integer applicationTypeCode = null;



  @NotEmpty
  @NotBlank
  @Size(min = 4, max = 20,message = " Application Type Name must be between 4 and 20 characters")
  @JsonProperty("application_type_name")
  private String applicationTypeName = null;



  @NotNull
  @JsonProperty("applicationnumber")
  private String applicationNumber = null;

  @JsonProperty("isDraft")
  private Boolean isDraft = null;

  @JsonProperty("isFinal")
  private Boolean isFinal = null;

  @JsonProperty("esignStatus")
  private Boolean esignStatus = null;

  @JsonProperty("esignedBy")
  private String esignedBy = null;


  @NotNull
  @JsonProperty("esigned_on")
  private LocalDateTime esignedOn = null;

  @JsonProperty("pkcs7")
  private String pkcs7;

  @JsonProperty("parichayId")
  private String parichayId = null;

  @JsonProperty("createdon")
  private LocalDateTime createdOn = null;

  @JsonProperty("updatedon")
  private LocalDateTime updatedOn = null;

  public BenRegistrationApplicationResource id(Long id) {
    this.id = id;
    return this;
  }
  

}
