package io.swagger.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.NodalUser;
import io.swagger.model.ParichayUser;
import io.swagger.repository.NodalUserRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.resources.NodalUserResource;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/api/v1/")
public class NodalUserApiController implements NodalUserApi {
    private static final Logger log = LoggerFactory.getLogger(NodalUserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    @Autowired
    private ParichayUserRepo parichayRepo;

    @Autowired
    private NodalUserRepo nodalUserRepo;

    @Autowired
    private ModelMapper modelMapper;

    @org.springframework.beans.factory.annotation.Autowired
    public NodalUserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<NodalUserResource>> getNodalUserByOrganizationId(
        @Parameter(in = ParameterIn.QUERY, description = "organization is used  to get the Nodal Officer", schema = @Schema()) @Valid @RequestParam(value = "organization_id", required = false) String organizationId) {
    String accept = request.getHeader("Accept");
    if (accept != null || accept.contains("application/json")) {
        try {
            System.out.println(organizationId);
            List<NodalUser> nodalUserList = nodalUserRepo.findByOrganization(organizationId);

            System.out.println("nodalUserList size>>>" + nodalUserList.size());
            // List<NodalUserResource> resourceList = new ArrayList<>();
            // for(NodalUser nodalUser : nodalUserList){
            //     NodalUserResource resource = new NodalUserResource();    
            //     resource.setParichayUserId(nodalUser.getParichayuser().getId());
            //     resource.setUserName(nodalUser.getUserName());
            //     resource.setDesignation(nodalUser.getDesignation());
            //     resource.setCreatedOn(nodalUser.getCreatedOn());
            //     resource.setUpdatedOn(nodalUser.getUpdatedOn());
            //     resource.setOrganizationId(nodalUser.getOrganization().getOrganizationCode());
            //     resourceList.add(resource);
            // }
          List<NodalUserResource>  resourceList =  nodalUserList.stream().map((nodal)->this.modelMapper.map(nodal, NodalUserResource.class)).collect(Collectors.toList());
    
            return new ResponseEntity<List<NodalUserResource>>(resourceList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<List<NodalUserResource>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    return new ResponseEntity<List<NodalUserResource>>(HttpStatus.NOT_IMPLEMENTED);
}

    // public NodalOfficer getOnboarding(@RequestBody NodalOfficer body) {
    // // System.out.println(body.getEmployeeid());
    // NodalOfficer nodal = repo1.findByEmployeeid(body.getEmployeeid());
    // if (nodal != null) {
    // if (nodal.getEmail().equals(body.getEmail()) &&
    // nodal.getMno().equals(body.getMno())) {
    // return nodal;
    // } else {
    // return null;
    // }
    // }
    // return null;
    // }

}
