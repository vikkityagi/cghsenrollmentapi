package io.swagger.api;

import io.swagger.resources.PrimaryBeneficiaryResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")
@Validated
public interface PrimaryBeneficiaryResourceApi {
    
    @Operation(summary = "beneficiaries", description = "Add a beneficiaries", tags={ "beneficiary" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PrimaryBeneficiaryResource.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/primary_beneficiaries",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" }, 
        method = RequestMethod.POST)
    ResponseEntity<PrimaryBeneficiaryResource> create(@Parameter(in = ParameterIn.DEFAULT, description = "Create a new beneficiaries", required=true, schema=@Schema()) @Valid @RequestBody PrimaryBeneficiaryResource body);


    @Operation(summary = "beneficiary", description = "this will provide filtered data if there is any parameter present in the query string", tags={ "beneficiary" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PrimaryBeneficiaryResource.class)))),
        
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/primary_beneficiaries",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PrimaryBeneficiaryResource>> list(
    @Parameter(in = ParameterIn.QUERY, description = "Ben registration Id" ,schema=@Schema()) @Valid @RequestParam(value = "ben_registration_id", required = false) Long benRegistrationId);

    @Operation(summary = "beneficiary", description = "", tags={ "beneficiary" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PrimaryBeneficiaryResource.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/primary_beneficiary/{id}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<PrimaryBeneficiaryResource> get(@Parameter(in = ParameterIn.PATH, description = "GEt details of primary card holder", required=true, schema=@Schema()) @PathVariable("id") Long id);


}
