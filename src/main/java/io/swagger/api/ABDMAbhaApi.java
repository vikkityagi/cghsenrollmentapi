/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.40).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.dto.ABHABeneficaryInfo;
import io.swagger.dto.AbhaOTPAPIObject;
import io.swagger.dto.AbhaOtpResponse;
import io.swagger.dto.InlineResponse200;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-09T06:53:18.360717265Z[GMT]")
@Validated
public interface ABDMAbhaApi {

    @Operation(summary = "Get Abha beneficiary data", description = "Get Abha beneficiary data", tags={ "abha" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ABHABeneficaryInfo.class))) })
    @RequestMapping(value = "/abha/account/profile",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
        // ResponseEntity<ABHABeneficaryInfo> getAbhaDataByToken(@PathVariable String xTOkEN);
    ResponseEntity<ABHABeneficaryInfo> getAbhaDataByToken(@Parameter(in = ParameterIn.HEADER, description = "" ,schema=@Schema()) @RequestHeader(value="X-TOKEN", required=false) String xTOKEN);


    @Operation(summary = "GET Abha OTP and Txn Id", description = "GET Abha OTP and Txn Id", tags={ "abha" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Abha id not found"),
        @ApiResponse(responseCode = "405", description = "Validation exception") })
    @RequestMapping(value = "/api/abha/init/{abhaId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> getInitCall(@Parameter(in = ParameterIn.PATH, description = "abha id", required=true, schema=@Schema()) @PathVariable("abhaId") String abhaId);


    @Operation(summary = "Get Token using OTP and Txn Id", description = "Get Token using OTP and Txn Id", tags={ "abha" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AbhaOtpResponse.class))) })
    @RequestMapping(value = "/api/abha/otp",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<AbhaOtpResponse> getTokenByOTPAndTxnId(@Parameter(in = ParameterIn.DEFAULT, description = "Created user object",schema=@Schema()) @Valid @RequestBody AbhaOTPAPIObject body);


    
}

