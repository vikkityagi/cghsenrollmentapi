package io.swagger.api;
import io.swagger.resources.FamilyMemberResource;
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

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")
@Validated
public interface FamilyMemberResourceApi {
    
    @Operation(summary = "Add a family member ", description = "Add a beneficiariry Family", tags={ "familymembers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FamilyMemberResource.class))),
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/ben_registration_application/{id}/family_members",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" }, 
        method = RequestMethod.POST)
    ResponseEntity<FamilyMemberResource> create( @Parameter(in = ParameterIn.PATH, description = "application id ", required=true, schema=@Schema()) @PathVariable("id") Long applicationId,
     @Parameter(in = ParameterIn.DEFAULT, description = "Create a new beneficiary family", required=true, schema=@Schema()) @Valid @RequestBody FamilyMemberResource body);


    @Operation(summary = "beneficiary", description = "", tags={ "familymembers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FamilyMemberResource.class)))),
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/ben_registration_application/{id}/family_members",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<FamilyMemberResource>> list(@Parameter(in = ParameterIn.PATH, description = "Get family of primary card holder", required=true, schema=@Schema()) @PathVariable("id") Long applicationId)
    throws Exception;


    
    @Operation(summary = "beneficiaries", description = "Get a beneficiaries", tags={ "familymembers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FamilyMemberResource.class))),
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/ben_registration_application/{id}/family_member/{member_id}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<FamilyMemberResource> get(@Parameter(in = ParameterIn.PATH, description = "Id of the beneficiary", required=true, schema=@Schema()) @PathVariable("id") Long applicationId, @Parameter(in = ParameterIn.PATH, description = "Member_Id of the family member", required=true, schema=@Schema()) @PathVariable("member_id") Long memberId);



    @Operation(summary = "beneficiaries", description = "Delete a beneficiaries", tags={ "familymembers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = FamilyMemberResource.class))),
        @ApiResponse(responseCode = "400", description = "Bad Input"),
        @ApiResponse(responseCode = "405", description = "Invalid input"),
        @ApiResponse(responseCode = "422", description = "Unporcessable Entity"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error") })
    @RequestMapping(value = "/ben_registration_application/{id}/family_member/{member_id}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<FamilyMemberResource> delete(@Parameter(in = ParameterIn.PATH, description = "Id of the beneficiary", required=true, schema=@Schema()) @PathVariable("id") Long applicationId, @Parameter(in = ParameterIn.PATH, description = "Member_Id of the family member", required=true, schema=@Schema()) @PathVariable("member_id") Long memberId);


}
