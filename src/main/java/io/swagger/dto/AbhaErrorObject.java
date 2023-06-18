package io.swagger.dto;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * AbhaOTPAPIObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-09T06:53:18.360717265Z[GMT]")
@Data
public class AbhaErrorObject {
    @JsonProperty("status")
    private String status = null;
    @JsonProperty("successMessage")
    private Object successMessage = null;
    @JsonProperty("errorMessage")
    private Object errorMessage = null;
    


    
}
