package io.swagger.api;

import io.swagger.model.CardType;
import io.swagger.model.CghspayScaleBean;
import io.swagger.model.Payscale;
import io.swagger.repository.CardTypeRepo;
import io.swagger.repository.PayscaleRepo;
import io.swagger.resources.ApprovingAuthorityRegistrationApplicationResource;
import io.swagger.service.ApprovingAuthorityRegistrationApplicationService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-18T12:17:29.581Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class ApprovingAuthorityRegistrationApplicationController implements ApprovingAuthorityRegistrationApplicationApi {

    private static final Logger log = LoggerFactory.getLogger(CardTypeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private ApprovingAuthorityRegistrationApplicationService approvingAuthorityRegistrationApplicationService;

    @org.springframework.beans.factory.annotation.Autowired
    public ApprovingAuthorityRegistrationApplicationController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ApprovingAuthorityRegistrationApplicationResource> create(HttpServletRequest request,@Valid ApprovingAuthorityRegistrationApplicationResource approvingAuthorityRegistrationApplicationResource)
            throws Exception {
        // TODO Auto-generated method stub
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                ApprovingAuthorityRegistrationApplicationResource approvingAuthorityRegistrationApplicationResourceDemo = approvingAuthorityRegistrationApplicationService.create(approvingAuthorityRegistrationApplicationResource,request);
                return new ResponseEntity<ApprovingAuthorityRegistrationApplicationResource>(approvingAuthorityRegistrationApplicationResourceDemo,HttpStatus.OK);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<ApprovingAuthorityRegistrationApplicationResource>> list() {
        String accept = request.getHeader("Accept");
        if// TODO Auto-generated method stub
         (accept != null && accept.contains("application/json")) {
            try {
                List<ApprovingAuthorityRegistrationApplicationResource> approvingAuthorityRegistrationApplicationResourceDemo = approvingAuthorityRegistrationApplicationService.list();
                return new ResponseEntity<List<ApprovingAuthorityRegistrationApplicationResource>>(approvingAuthorityRegistrationApplicationResourceDemo,HttpStatus.OK);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ApprovingAuthorityRegistrationApplicationResource> get(@NotNull @Valid String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    
}
