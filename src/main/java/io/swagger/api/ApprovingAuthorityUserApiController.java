package io.swagger.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.ApprovingAuthorityUser;
import io.swagger.model.ApprovingOfficer;
import io.swagger.model.Organization;
import io.swagger.model.ParichayUser;
import io.swagger.repository.ApprovingAuthorityUserRepo;
import io.swagger.repository.ApprovingOfficerRepo;
import io.swagger.repository.OrganizationRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.resources.ApprovingAuthorityUserResource;



@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-07T11:40:29.581Z[GMT]")
@RestController
@CrossOrigin
@Service
@RequestMapping(value="/api/v1/")
public class ApprovingAuthorityUserApiController implements ApprovingAuthorityUserApi {

    private static final Logger log = LoggerFactory.getLogger(ApprovingAuthorityUserApiController.class);

    private final ObjectMapper objectMapper;

    @Autowired
	private ModelMapper modelMapper;
    private final HttpServletRequest request;
	@Autowired
	private OrganizationRepo organizationRepo;
    
    @Autowired
	private ApprovingAuthorityUserRepo approvingAuthorityUserRepo;

	@Autowired
	private ParichayUserRepo parichayUserRepo;
    
    @org.springframework.beans.factory.annotation.Autowired
    public ApprovingAuthorityUserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
	@Override
	public ResponseEntity<List<ApprovingAuthorityUserResource>> getApprovingAuthorityUsers(String organizationId) {
		System.out.println("controller call");
		String accept = request.getHeader("Accept");
		
		if (accept != null || accept.contains("application/json")) {
			try{
				List<ApprovingAuthorityUserResource> resourceList = new ArrayList<ApprovingAuthorityUserResource>();

				Optional<Organization> orgOptional = organizationRepo.findById(organizationId);		
				if(!orgOptional.isPresent())
					throw new Exception("Data error: invalid org id "+ organizationId);
				
				List<ApprovingAuthorityUser> approvingAuthorityUserList = approvingAuthorityUserRepo.findByOrganization(orgOptional.get());
				if(approvingAuthorityUserList.size()>1)
					throw new Exception("Db error: muitple active approving officer for one organization not allowed");
				for(ApprovingAuthorityUser approvingAuthorityUser: approvingAuthorityUserList){
					ApprovingAuthorityUserResource resource = this.modelMapper.map(approvingAuthorityUser, ApprovingAuthorityUserResource.class);

				//	resource.setId(approvingAuthorityUser.getId());
				//	resource.setUserName(approvingAuthorityUser.getUserName());
					resource.setParichayUserId(approvingAuthorityUser.getParichayUser().getId());
					//resource.setDesignation(approvingAuthorityUser.getDesignation());
					//resource.setEmail(approvingAuthorityUser.getEmail());
					//resource.setMobileNo(approvingAuthorityUser.getMobileNo());
					resource.setOrganizationId(approvingAuthorityUser.getOrganization().getOrganizationCode());
					resourceList.add(resource);
				}
				
				System.out.println("aprovingofficer>>>"+approvingAuthorityUserList);
				return new ResponseEntity<List<ApprovingAuthorityUserResource>>(resourceList,HttpStatus.OK);
			}catch(Exception e){
				e.printStackTrace();
				return new ResponseEntity<List<ApprovingAuthorityUserResource>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}else {
			return new ResponseEntity<List<ApprovingAuthorityUserResource>>(HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	@Override
	public ResponseEntity<ApprovingAuthorityUserResource> getApprovingAuthorityUser(Long id) {
		System.out.println("controller call 2");
		String accept = request.getHeader("Accept");
		if (accept != null || accept.contains("application/json")) {
			try{
			ApprovingAuthorityUser approvingAuthorityUser = approvingAuthorityUserRepo.findById(id).get();
			// ApprovingAuthorityUserResource resource = this.modelMapper.map(approvingAuthorityUser, ApprovingAuthorityUserResource.class);
			ApprovingAuthorityUserResource resource = new ApprovingAuthorityUserResource();
			resource.setId(approvingAuthorityUser.getId());
			resource.setDesignation(approvingAuthorityUser.getDesignation());
			resource.setEmpCode(approvingAuthorityUser.getEmpCode());
			resource.setUserName(approvingAuthorityUser.getUserName());
			resource.setEmail(approvingAuthorityUser.getEmail());
			resource.setParichayUserId(approvingAuthorityUser.getParichayUser().getId());
			resource.setMobileNo(approvingAuthorityUser.getMobileNo());
			resource.setOrganizationId(approvingAuthorityUser.getOrganization().getOrganizationCode());
			return new ResponseEntity<ApprovingAuthorityUserResource>(resource,HttpStatus.OK); 
			}catch(Exception e){
				e.printStackTrace();
				return new ResponseEntity<ApprovingAuthorityUserResource>(HttpStatus.INTERNAL_SERVER_ERROR); 
			}
		}else {
			return new ResponseEntity<ApprovingAuthorityUserResource>(HttpStatus.BAD_REQUEST);
		}
		
	}

    
    
}
