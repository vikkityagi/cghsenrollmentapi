package io.swagger.api;

import io.swagger.model.ParichayUser;
import io.swagger.resources.ParichayUserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")
@Validated
public interface ParichayUserApi {

    @Operation(summary = "parichayId", description = "", tags={ "parichayId" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParichayUser.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/parichay-user/{id}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<ParichayUserResource> get(@Parameter(in = ParameterIn.PATH, description = "get by id", required=true, schema=@Schema()) @PathVariable("id") Long id);


    @Operation(summary = "parichayId", description = "", tags={ "parichayId" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ParichayUser.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/parichay-users",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ParichayUserResource>> list(
        @Parameter(in = ParameterIn.QUERY, description = "parichayId", required=true, schema=@Schema()) @RequestParam("parichayId") String parichayId);


}
