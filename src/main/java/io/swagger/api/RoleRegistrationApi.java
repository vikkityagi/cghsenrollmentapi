package io.swagger.api;

import io.swagger.model.Role;
import io.swagger.model.RoleRegistration;
import io.swagger.model.State;
import io.swagger.model.StateModel;
import io.swagger.model.ValidationError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;


public interface RoleRegistrationApi {
    
    @Operation(summary = "Returns state", description = "", tags={ "RoleRegistration" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoleRegistration.class)))) })
    @RequestMapping(value = "/RoleRegistrations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<RoleRegistration>> list(HttpServletRequest request,@RequestParam(name="userId",required = false) Long userId);

    @Operation(summary = "Returns state", description = "", tags={ "RoleRegistration" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoleRegistration.class)))) })
    @RequestMapping(value = "/Roles",
        method = RequestMethod.GET)
    ResponseEntity<List<Role>> listAll();

    @Operation(summary = "Returns Role Name", description = "", tags={ "RoleRegistration" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoleRegistration.class)))) })
    @RequestMapping(value = "/RoleRegistrationsName",
        method = RequestMethod.GET)
    ResponseEntity<List<RoleRegistration>> listRoleName(HttpServletRequest request,@RequestParam(name="userId",required = false) Long userId);
    
    @Operation(summary = "Get state", description = "Get RoleRegistration Using RoleRegistration Id", tags={ "state" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoleRegistration.class)))),
        
        @ApiResponse(responseCode = "400", description = "Invalid data supplied") })
    @RequestMapping(value = "/RoleRegistration/{roleRegistrationId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<RoleRegistration> getById(@NotNull @Parameter(in = ParameterIn.PATH, description = "id of the RoleRegistration" 
    ,required=true,schema=@Schema()) @Valid @PathVariable(value = "roleRegistrationId", required = true) Long roleRegistrationId);



}
