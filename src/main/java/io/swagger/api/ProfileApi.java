package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.model.AdRole;
import io.swagger.model.CGHSUser;
import io.swagger.model.Role;
import io.swagger.resources.CGHSUserResource;
import io.swagger.resources.ParichayUserResource;
import io.swagger.resources.ProfileResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-18T12:17:29.581Z[GMT]")
@Validated
@Service
public interface ProfileApi{

    @Operation(summary = "Create a new profile", description = "create a new profile", tags={ "Profile" })
    @ApiResponses(value = { 
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfileResource.class))),        @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
    @RequestMapping(value = "/profile-resources",method = RequestMethod.POST)
    public ResponseEntity<ParichayUserResource> create(@Parameter(in = ParameterIn.DEFAULT, description = "To create a Profile", required = true, schema = @Schema()) @Valid @RequestBody ProfileResource profileResource,HttpServletRequest request);
    
    // @Operation(summary = "Edit a new profile", description = "To edit the profile using id", tags={ "Profile" })
    // @ApiResponses(value = { 
    // @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfileResource.class))),        @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
    // @RequestMapping(value = "/profile-resources/{id}",method = RequestMethod.POST)
    // public ResponseEntity<String> edit(@Parameter(in = ParameterIn.PATH, description = "To edit a Profile using id", required = true, schema = @Schema()) @PathVariable("id") long id,@RequestParam("roleId") long roleId,@Parameter(in = ParameterIn.DEFAULT, description = "To create a Profile", required = true, schema = @Schema()) @Valid @RequestBody ProfileResource profileResource);

    // @Operation(summary = "Edit a new profile", description = "create a new profile", tags={ "Profile" })
    // @ApiResponses(value = { 
    // @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfileResource.class))),        @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
    // @RequestMapping(value = "/profile-resources/{id}/{roleId}",method = RequestMethod.POST)
    // public ResponseEntity<String> edit(@Parameter(in = ParameterIn.DEFAULT, description = "To create a Profile", required = true, schema = @Schema()) @Valid @RequestBody ProfileResource profileResource,@PathVariable("id") long id,@PathVariable("roleId") long roleId);

    @Operation(summary = "To Edit a new profile", description = "To Edit a new profile", tags = {"Profile" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation"),
        @ApiResponse(responseCode = "400", description = "Invalid data supplied"),
        @ApiResponse(responseCode = "405", description = "Validation exception", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfileResource.class))) })
    @RequestMapping(value = "/ProfileResources",
    consumes = {"application/json"},
    produces = {"application/json"},
        method = RequestMethod.PUT)
    ResponseEntity<ProfileResource> edit(
    @Parameter(in = ParameterIn.DEFAULT, description = "To edit a Profile", required = true, schema = @Schema()) @Valid @RequestBody ProfileResource profileResource) throws Exception;
        
    @Operation(summary = "Get profile Details", description = "Get the profile details", tags={ "Profile" })
    @ApiResponses(value = { 
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfileResource.class))),    
    @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
    @RequestMapping(value = "/profile-resource",method = RequestMethod.GET)
    public ResponseEntity<ProfileResource> get(HttpServletRequest request);

    @Operation(summary = "Get profile Detail", description = "Get the profile detail", tags={ "Profile" })
    @ApiResponses(value = { 
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfileResource.class))),    
    @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
    @RequestMapping(value = "/profile-resource/{id}",method = RequestMethod.GET)
    public ResponseEntity<ProfileResource> patch(@PathVariable("id") long id,@RequestParam("roleId") long roleId);

    @Operation(summary = "Get profile Detail", description = "Get the profile detial", tags={ "Profile" })
    @ApiResponses(value = { 
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProfileResource.class))),    
    @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
    @RequestMapping(value = "/profile-resources",method = RequestMethod.GET)
    public ResponseEntity<List<ProfileResource>> list(HttpServletRequest request); 
    


    
}