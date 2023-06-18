package io.swagger.api;

import io.swagger.model.OrganizationOffice;
import io.swagger.model.ParichayUser;
import io.swagger.repository.OrganizationOfficeRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.repository.RoleRepo;
import io.swagger.resources.ParichayUserResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-28T07:07:34.520234324Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class ParichayUserApiController implements ParichayUserApi {

    private static final Logger log = LoggerFactory.getLogger(ParichayUserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private ParichayUserRepo parichayUserRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private OrganizationOfficeRepo organizationOfficeRepo;

    @org.springframework.beans.factory.annotation.Autowired
    public ParichayUserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        super();
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ParichayUserResource> get(Long id) {
        // TODO Auto-generated method stub
        String accept = request.getHeader("Accept");

        if (accept != null || accept.contains("application/json")) {
            try {
                Optional<ParichayUser> optional = parichayUserRepo.findById(id);
                ParichayUser user = null;
                ParichayUserResource resource = new ParichayUserResource();
                if (!optional.isPresent()) {
                    throw new Exception("Data error: invalid parichay Id");
                }
                user = optional.get();
                resource.setId(user.getId());
                resource.setParichayId(user.getParichayId());
                resource.setUserName(user.getUserName());
                
                if (user != null) {
                    return new ResponseEntity<>(resource, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
         else
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<ParichayUserResource>> list(String parichayId) {
        // TODO Auto-generated method stub
        String accept = request.getHeader("Accept");
        if(parichayId == null || parichayId.isEmpty())
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (accept != null || accept.contains("application/json")) {
            try {
                Optional<ParichayUser> optional = parichayUserRepo.findByParichayId(parichayId);
                ParichayUser user = null;
                ParichayUserResource resource = new ParichayUserResource();
                if (!optional.isPresent()) {
                    throw new Exception("Data error: invalid parichay Id");
                }
                user = optional.get();
                resource.setId(user.getId());
                resource.setFullName(user.getFullName());
                resource.setParichayId(user.getParichayId());
                resource.setUserName(user.getUserName());
                List<ParichayUserResource> list = new ArrayList<>();
                list.add(resource);
                if (user != null) {
                   return new ResponseEntity<>(list, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
         else
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
