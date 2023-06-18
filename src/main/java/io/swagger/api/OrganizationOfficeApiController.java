package io.swagger.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.ApprovingAuthority;
import io.swagger.model.ApprovingAuthorityUser;
import io.swagger.model.Organization;
import io.swagger.model.OrganizationOffice;
import io.swagger.model.ParichayUser;
import io.swagger.repository.ApprovingAuthorityUserRepo;
import io.swagger.repository.OrganizationOfficeRepo;
import io.swagger.repository.OrganizationRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.resources.ApprovingAuthorityUserResource;
import io.swagger.resources.OrganizationOfficeResource;
import io.swagger.resources.ProfileResource;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-18T12:17:29.581Z[GMT]")
@RestController
@PropertySource(value = "classpath:global.properties")
@CrossOrigin
@RequestMapping(value="/api/v1")
public class OrganizationOfficeApiController implements OrganizationOfficeApi {
    @Value("${url.gatewayUrl}")
    String gatewayUrl;
    private static final Logger log = LoggerFactory.getLogger(ProfileResource.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    ParichayUserRepo parichayUserRepo;

    @Autowired
    ApprovingAuthorityUserRepo approvingAuthoirtyUserRepo;

    @Autowired
    OrganizationRepo organizationRepo;

    @Autowired
    OrganizationOfficeRepo organizationOfficeRepo;

    @org.springframework.beans.factory.annotation.Autowired
    public OrganizationOfficeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ApprovingAuthorityUserResource> get(Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try { 
                Optional<ApprovingAuthorityUser> approvingauthorityuserOptional = approvingAuthoirtyUserRepo.findByParichayUser(parichayUserRepo.findById(id));
                // Optional<OrganizationOffice> orgOfficeOptional = organizationOfficeRepo.findById(id);
                if (!approvingauthorityuserOptional.isPresent())
                    throw new Exception("Data error: invalid id " + id);
                    ApprovingAuthorityUserResource resource = new ApprovingAuthorityUserResource();
                    resource.setOrganization(approvingauthorityuserOptional.get().getOrganization().getOrganizationName()+"");
                    resource.setOrganizationId(approvingauthorityuserOptional.get().getOrganization().getOrganizationCode()+"");
                // OrganizationOffice organizationOffice = orgOfficeOptional.get();
                // resource.setId(organizationOffice.getId());
                // resource.setOfficeName(organizationOffice.getOfficeName());
                // resource.setOfficeShortName(organizationOffice.getOfficeShortName());
                // resource.setCreatedOn(organizationOffice.getCreatedOn());
                // resource.setUpdatedOn(organizationOffice.getUpdatedOn());
                return new ResponseEntity<>(resource, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }

    }

    @Override

    public ResponseEntity<OrganizationOfficeResource> create(HttpServletRequest request,@Valid OrganizationOfficeResource body) {
        // TODO Auto-generated method stub
        OrganizationOfficeResource resource = new OrganizationOfficeResource();
        try {
            Long parichayUserId = (Long) request.getAttribute("currentUserId");
            if(body.getParichayId()==parichayUserId){
                OrganizationOffice orgOffice = new OrganizationOffice();
            orgOffice.setOfficeName(body.getOfficeName());
            orgOffice.setOfficeShortName(body.getOfficeShortName());
            orgOffice.setCreatedOn(LocalDateTime.now());
            orgOffice.setUpdatedOn(LocalDateTime.now());
            Organization optional = organizationRepo.findById(body.getOrganizationId()).get();
            orgOffice.setOrganization(optional);
            Optional<ParichayUser> parichayId = parichayUserRepo.findById(parichayUserId);
            if (!parichayId.isPresent())
                throw new Exception("ParichayUser, is not Found");
            orgOffice.setCreatedBy(parichayId.get());
            orgOffice.setUpdatedBy(parichayId.get());
            organizationOfficeRepo.save(orgOffice);

            resource.setOrganizationId(body.getOrganizationId());

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<OrganizationOfficeResource>(resource,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrganizationOfficeResource>> list(@Valid String organizationId) {
        // TODO Auto-generated method stub
        String accept = request.getHeader("Accept");
        List<OrganizationOffice> orgOfficeList = null;
        if (accept != null && accept.contains("application/json")) {
            try {
                if (organizationId != null && !organizationId.equals("")) {
                    Optional<Organization> orgOptional = organizationRepo.findById(organizationId);
                    if (!orgOptional.isPresent())
                        throw new Exception("Data error: organization id is invalid " + organizationId);
                    orgOfficeList = organizationOfficeRepo.findByOrganization(orgOptional.get());
                } else {
                    orgOfficeList = organizationOfficeRepo.findAll();
                }
                List<OrganizationOfficeResource> resourceList = new ArrayList<OrganizationOfficeResource>();
                for (OrganizationOffice organizationOffice : orgOfficeList) {
                    OrganizationOfficeResource resource = new OrganizationOfficeResource();
                    resource.setId(organizationOffice.getId());
                    resource.setOfficeName(organizationOffice.getOfficeName());
                    resource.setOfficeShortName(organizationOffice.getOfficeShortName());
                    resource.setCreatedOn(organizationOffice.getCreatedOn());
                    resource.setUpdatedOn(organizationOffice.getUpdatedOn());
                    resourceList.add(resource);
                }
                return new ResponseEntity<List<OrganizationOfficeResource>>(resourceList, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<List<OrganizationOfficeResource>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<List<OrganizationOfficeResource>>(HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @Override
    public ResponseEntity<OrganizationOfficeResource> getOrganizationOffice(long organizationId) {
        // TODO Auto-generated method stub
        String accept = request.getHeader("Accept");
        
        if (accept != null || accept.contains("application/json")) {
            try {
                OrganizationOfficeResource resource = new OrganizationOfficeResource();
                Optional<OrganizationOffice> orgOfficeOptional = organizationOfficeRepo.findById(organizationId);
                if(!orgOfficeOptional.isPresent()){
                    throw new Exception("Data error: invalid organiztionOffice");
                }
                resource.setOrganizationName(orgOfficeOptional.get().getOfficeName());
                return new ResponseEntity<OrganizationOfficeResource>(resource, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<OrganizationOfficeResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<OrganizationOfficeResource>(HttpStatus.NOT_IMPLEMENTED);
        }
    }
}