package io.swagger.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.model.NavigationLink;
import io.swagger.model.Role;
import io.swagger.resources.RoleResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




public interface NavigationApi {
    

    @Operation(summary = "To get list of role for the loggedin user ", description = "To get list of role for the loggedin user ", tags={ "userId" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Role.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/navigationLink/{user_id}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<RoleResource>> getRole(HttpServletRequest request,@Parameter(in = ParameterIn.PATH, description = "GET details of user Role", required=true, schema=@Schema()) @PathVariable("user_id") Long userId);

    @Operation(summary = "To get list of menu items for the loggedin user ", description = "To get list of menu items for the loggedin user ", tags={ "userId" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Role.class))),
        
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/navigationLinks/{user_id}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<NavigationLink>> get(HttpServletRequest request,@Parameter(in = ParameterIn.PATH, description = "GET details of user Role", required=true, schema=@Schema()) @PathVariable("user_id") Long userId,@RequestParam("roleId") long roleId);

}
