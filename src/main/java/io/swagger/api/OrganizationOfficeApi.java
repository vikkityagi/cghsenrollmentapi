package io.swagger.api;

import io.swagger.model.OrganizationOffice;
import io.swagger.resources.ApprovingAuthorityUserResource;
import io.swagger.resources.OrganizationOfficeResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.media.ArraySchema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")
@Validated
public interface OrganizationOfficeApi {
    @Operation(summary = "OrganizationOffice", description = "", tags={ "OrganizationOffice" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationOffice.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/OrganizationOffice/{id}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<ApprovingAuthorityUserResource> get(@Parameter(in = ParameterIn.PATH, description = "Get OrganizationOffice by id", required=true, schema=@Schema()) @PathVariable("id") Long id);

    @Operation(summary = "OrganizationOffice", description = "", tags={ "OrganizationOffice" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationOffice.class))),
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/OrganizationOffices/{organizationId}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<OrganizationOfficeResource> getOrganizationOffice(@Parameter(in = ParameterIn.PATH, description = "Get Organization Offices", required=true, schema=@Schema()) @PathVariable("organizationId") long organizationId);


    @Operation(summary = "OrganizationOffice", description = "Get all org offices using organization id", tags={ "OrganizationOffice" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationOffice.class))),
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/OrganizationOffices",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<OrganizationOfficeResource>> list(@Parameter(in = ParameterIn.QUERY, description = "org id" ,required=false,schema=@Schema()) @Valid @RequestParam(value = "organizationId", required = true) String organizationId);

    @Operation(summary = "To create a new Organization office", description = "To create a new Organization office", tags={ "OrganizationOffice" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationOfficeResource.class))),
        @ApiResponse(responseCode = "400", description = "Invalid data supplied"),
        @ApiResponse(responseCode = "405", description = "Validation exception", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrganizationOfficeResource.class)))) })
    @RequestMapping(value = "/OrganizationOffices",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" }, 
        method = RequestMethod.POST)
    ResponseEntity<OrganizationOfficeResource> create(HttpServletRequest request,@Parameter(in = ParameterIn.DEFAULT, description = "To create a new Onboarding Application", required=true, schema=@Schema()) @Valid @RequestBody OrganizationOfficeResource body);
}
