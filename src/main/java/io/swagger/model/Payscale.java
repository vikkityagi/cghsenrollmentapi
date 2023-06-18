package io.swagger.model;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Payscale
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-18T12:17:29.581Z[GMT]")
@Data
@EqualsAndHashCode
@ToString


public class Payscale   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("payscale")
  private String payscale = null;

}
