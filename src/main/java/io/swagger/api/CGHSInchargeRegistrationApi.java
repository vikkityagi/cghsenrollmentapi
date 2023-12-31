/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.36).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.model.CGHSInchargeApplication;
import io.swagger.model.ESignRequestObject;
import io.swagger.model.OnboardingApplication;
import io.swagger.model.OnboardingValidationError;
import io.swagger.resources.BenRegistrationApplicationResource;
import io.swagger.resources.CGHSInchargeRegistrationResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-04T12:17:29.581Z[GMT]")
@Validated
@Service
@CrossOrigin
public interface CGHSInchargeRegistrationApi {

  @Operation(summary = "To create a new CGHS Incharge Registration", description = "To create a new CGHS Incharge Registration", tags = {
      "CGHSInchargeRegistration" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CGHSInchargeApplication.class))),
      @ApiResponse(responseCode = "400", description = "Invalid data supplied"),
      @ApiResponse(responseCode = "405", description = "Validation exception", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OnboardingValidationError.class)))) })
  @RequestMapping(value = "/CGHSInchargeApplications", produces = { "application/json",
      "application/xml" }, consumes = { "application/json", "application/xml",
          "application/x-www-form-urlencoded" }, method = RequestMethod.POST)
  ResponseEntity<CGHSInchargeRegistrationResource> create(HttpServletRequest request,
      @Parameter(in = ParameterIn.DEFAULT, description = "To create a new Onboarding Application", required = true, schema = @Schema()) @Valid @RequestBody CGHSInchargeRegistrationResource cghsInchargeRegistrationResource);

  @Operation(summary = "To get the CGHS Incharge Registration", description = "To get the CGHS Incharge Registration", tags = {
      "CGHSInchargeRegistration" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CGHSInchargeApplication.class))),
      @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
  @RequestMapping(value = "/CGHSInchargeApplication/{id}", method = RequestMethod.GET)
  ResponseEntity<CGHSInchargeRegistrationResource> get(@PathVariable(value = "id") long id);

  @Operation(summary = "Get the CGHS Incharge Registration", description = "Get the cghsUserRegistration  list ", tags = {
      "CGHSInchargeRegistration" })
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CGHSInchargeApplication.class))),

      @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
  @RequestMapping(value = "/cghsinchargeapplications", method = RequestMethod.GET)
  ResponseEntity<List<CGHSInchargeRegistrationResource>> list();

  // @Operation(summary = "ESign BenRegistrationApplication", description = "ESign BenRegistrationApplication ", tags = {
  //                       "BenRegistrationApplication" })
  //       @ApiResponses(value = {
  //                       @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BenRegistrationApplicationResource.class))),

  @Operation(summary = "ESign BenRegistrationApplication", description = "ESign BenRegistrationApplication ", tags={ "BenRegistrationApplication" })
  @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CGHSInchargeApplication.class))),
      
//       @ApiResponse(responseCode = "400", description = "Bad Input"),
      
//       @ApiResponse(responseCode = "405", description = "Invalid input"),
      
//       @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
      
      @ApiResponse(responseCode = "500", description = "Internal Server Error") })
  @RequestMapping(value = "/CGHSInchargeApplication/{application_id}/esign",
      produces = { "application/json" },
      method = RequestMethod.GET)
  ResponseEntity<ESignRequestObject> esign(@Parameter(in = ParameterIn.PATH, description = "application id ", required=false, schema=@Schema()) @PathVariable("application_id") Long applicationId) throws Exception;

  @ApiResponse(responseCode = "405", description = "Invalid input")

  @Operation(summary = "BenRegistrationApplication ESign Response processor ", description = "ESign Response processor  ", tags={ "BenRegistrationApplication" })
  @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CGHSInchargeApplication.class))),
      

      @ApiResponse(responseCode = "500", description = "Internal Server Error") })
  @RequestMapping(value = "/CGHSInchargeApplication/{application_id}/esignresponse",
      produces = { "application/json" },
      method = RequestMethod.POST)
  ResponseEntity<ESignRequestObject> esignresponse(@Parameter(in = ParameterIn.PATH, description = "application id ", required=false, schema=@Schema()) @PathVariable("application_id") Long applicationId,@RequestParam(value = "respon", required = false) String respon) throws Exception;

 
}
