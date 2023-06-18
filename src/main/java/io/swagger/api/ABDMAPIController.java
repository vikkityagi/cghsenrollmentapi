package io.swagger.api;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.dto.ABHABeneficaryInfo;
import io.swagger.dto.AbhaOtpResponse;
import io.swagger.dto.InlineResponse200;
import io.swagger.handlers.RestTemplateResponseErrorHandler;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;



@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ABDMAPIController implements ABDMAbhaApi {

    private static final Logger log = LoggerFactory.getLogger(ABDMAPIController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private RestTemplate restTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public ABDMAPIController(ObjectMapper objectMapper, HttpServletRequest request,
            RestTemplateBuilder builder) {
                
        restTemplate = builder.build();
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ABHABeneficaryInfo> getAbhaDataByToken(
            @Parameter(in = ParameterIn.HEADER, description = "", schema = @Schema()) @RequestHeader(value = "xTOKEN", required = false) String xTOKEN) {

        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
                String uri = "https://api.rch.gov.in/v1/account/profile";
                HttpHeaders headers = new HttpHeaders();
                HttpServletResponse response;
                headers.set("X-Token", xTOKEN);
                headers.set("Content-Type", "application/json");
                System.out.println("X-Token" + xTOKEN);
                HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
                restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
                ResponseEntity<ABHABeneficaryInfo> personResultAsJsonStr = restTemplate.exchange(uri, HttpMethod.GET,
                        requestEntity,
                        ABHABeneficaryInfo.class);
                        System.out.println(personResultAsJsonStr);
                if (personResultAsJsonStr.getStatusCode().equals(HttpStatus.OK))
                    return new ResponseEntity<ABHABeneficaryInfo>(personResultAsJsonStr.getBody(), HttpStatus.OK);
                else if (personResultAsJsonStr.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
                    return new ResponseEntity<ABHABeneficaryInfo>(HttpStatus.UNAUTHORIZED);
                else
                    return new ResponseEntity<ABHABeneficaryInfo>(HttpStatus.BAD_REQUEST);

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ABHABeneficaryInfo>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ABHABeneficaryInfo>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse200> getInitCall(
            @Parameter(in = ParameterIn.PATH, description = "abha id", required = true, schema = @Schema()) @PathVariable("abhaId") String abhaId) {
        System.out.println("run");
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
                String uri = "https://api.rch.gov.in/v1/auth/init";
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                JSONObject jsonBody = new JSONObject();
                System.out.println("abhaId-" + abhaId);
                jsonBody.put("authMethod", "AADHAAR_OTP");
                jsonBody.put("healthid", abhaId);
                HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
                restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
                ResponseEntity<InlineResponse200> txnIdResponse = restTemplate.exchange(uri, HttpMethod.POST,
                        request,
                        InlineResponse200.class);
                if (txnIdResponse.getStatusCode().equals(HttpStatus.OK))
                    return new ResponseEntity<InlineResponse200>(txnIdResponse.getBody(), HttpStatus.OK);

                else if (txnIdResponse.getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY))
                    return new ResponseEntity<InlineResponse200>(HttpStatus.UNPROCESSABLE_ENTITY);
                else
                    return new ResponseEntity<InlineResponse200>(HttpStatus.BAD_REQUEST);

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse200>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<AbhaOtpResponse> getTokenByOTPAndTxnId(
            @Parameter(in = ParameterIn.DEFAULT, description = "Created user object", schema = @Schema()) @Valid @RequestBody io.swagger.dto.AbhaOTPAPIObject body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

            try {
                String uri = "https://api.rch.gov.in/v1/auth/confirmWithAadhaarOtp";
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                JSONObject jsonBody = new JSONObject();
                System.out.println("abhaOTPAPIObject--" + body);
                jsonBody.put("otp", body.getOtp());
                jsonBody.put("txnId", body.getTxnId());

                HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(), headers);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
                ResponseEntity<AbhaOtpResponse> abhaOtpResponseEntity = restTemplate.exchange(uri, HttpMethod.POST,
                        request,
                        AbhaOtpResponse.class);
                if (abhaOtpResponseEntity.getStatusCode().equals(HttpStatus.OK)){
                    if(abhaOtpResponseEntity.getBody()==null)
                    System.out.println("Body is null so otp is wrng");
                    return new ResponseEntity<AbhaOtpResponse>(abhaOtpResponseEntity.getBody(), HttpStatus.OK);
                }
                else{
                    return new ResponseEntity<AbhaOtpResponse>(abhaOtpResponseEntity.getBody(),HttpStatus.BAD_REQUEST);
                }
            } catch (Exception e) {
                log.error("Exception occured in -" + e.getClass().getName() + " Message-" + e.getMessage());
                e.printStackTrace();
                return new ResponseEntity<AbhaOtpResponse>(HttpStatus.INTERNAL_SERVER_ERROR);

            }
        } else {
            return new ResponseEntity<AbhaOtpResponse>(HttpStatus.BAD_REQUEST);
        }
    }

    // @RequestMapping("/api/abha/{abha_id}")
    // public ResponseEntity<String> getInitCall(@PathVariable("abha_id") String
    // abhaId ){
    // String uri = "https://api.rch.gov.in/v1/auth/init";
    // HttpHeaders headers = new HttpHeaders();
    // headers.setContentType(MediaType.APPLICATION_JSON);
    // JSONObject jsonBody = new JSONObject();
    // jsonBody.put("authMethod", "AADHAAR_OTP");
    // jsonBody.put("healthid", abhaId);
    // HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(),
    // headers);
    // RestTemplate restTemplate = new RestTemplate();
    // String personResultAsJsonStr =
    // restTemplate.postForObject(uri, request, String.class);
    // System.out.println(personResultAsJsonStr );
    // return new ResponseEntity<String>(personResultAsJsonStr, HttpStatus.OK);
    // }

    // @RequestMapping(value= "/api/abha/otp",method = RequestMethod.POST, consumes
    // = {"application/json"},produces = {"application/json"})
    // @ResponseBody
    // public ResponseEntity<AbhaOtpResponse> confirmWithAadhaarOtp(
    // @Parameter(in = ParameterIn.DEFAULT, description = "To fetch ABHA Data ",
    // required=true, schema=@Schema())
    // @RequestBody AbhaOTPAPIObject abhaOTPAPIObject){
    // String uri = "https://api.rch.gov.in/v1/auth/confirmWithAadhaarOtp";
    // HttpHeaders headers = new HttpHeaders();
    // headers.setContentType(MediaType.APPLICATION_JSON);
    // JSONObject jsonBody = new JSONObject();
    // System.out.println("abhaOTPAPIObject--"+abhaOTPAPIObject);
    // jsonBody.put("otp", abhaOTPAPIObject.getOtp());
    // jsonBody.put("txnId", abhaOTPAPIObject.getTxnId());

    // HttpEntity<String> request = new HttpEntity<String>(jsonBody.toString(),
    // headers);
    // RestTemplate restTemplate = new RestTemplate();
    // AbhaOtpResponse personResultAsJsonStr =
    // restTemplate.postForObject(uri, request, AbhaOtpResponse.class);
    // System.out.println(personResultAsJsonStr );
    // return new ResponseEntity<AbhaOtpResponse>(personResultAsJsonStr,
    // HttpStatus.OK);
    // }
}
