package io.swagger.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.model.AdRole;
import io.swagger.v3.oas.annotations.Operation;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-18T12:17:29.581Z[GMT]")
@Validated
@Service
public interface AdRoleApi{

    @Operation(summary = "Get the Ad List", description = "Get the cities", tags={ "AdRole" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AdRole.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
    @RequestMapping(value = "/adCities",
        method = RequestMethod.GET)
    ResponseEntity<List<AdRole>> getadCities
    (@RequestParam(value="cityid", required=false) int cityid);


    
}