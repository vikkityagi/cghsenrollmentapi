package io.swagger.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.model.NodalUser;
import io.swagger.resources.NodalUserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-20T10:29:16.504Z[GMT]")
@Validated
public interface NodalUserApi {    

    @Operation(summary = "OnboardingApplication", description = "this will provide filtered data of nodal officer", tags={ "Onboarding" })
            @ApiResponses(value = { 
                @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = NodalUser.class)))),
                
                @ApiResponse(responseCode = "400", description = "Bad Input"),
                
                @ApiResponse(responseCode = "405", description = "Invalid input"),
                
                @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
                
                @ApiResponse(responseCode = "500", description = "Internal Server Error") })
            @RequestMapping(value = "/nodal-users",
                produces = { "application/json", "application/xml" }, 
                method = RequestMethod.GET)
            ResponseEntity<List<NodalUserResource>> getNodalUserByOrganizationId(@Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "organization_id", required = false) String organization_id);
        
    // @RequestMapping(value = "/onboardingdata",method=RequestMethod.POST,consumes="application/json", produces="application/json")
    // NodalUserResource getOnboarding(@RequestBody ApplicationNodal body);
    





}
