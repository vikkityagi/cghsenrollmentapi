package io.swagger.api;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.resources.ParichayUserResource;
import io.swagger.resources.ProfileResource;
import io.swagger.service.ProfileService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegetgen.v3.generators.java.SpringCodegen", date = "2023-03-18T12:17:29.581Z[GMT]")
@RestController
@PropertySource(value = "classpath:global.properties")
@RequestMapping(value="/api/v1")
public class ProfileApiController implements ProfileApi {
	@Value("${url.gatewayUrl}")
	String gatewayUrl;
	private static final Logger log = LoggerFactory.getLogger(ProfileResource.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;
	
	@Autowired
	private ProfileService profileService;
	
	

	@org.springframework.beans.factory.annotation.Autowired
	public ProfileApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		super();
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<ParichayUserResource> create(@Parameter(in = ParameterIn.DEFAULT, description = "To create a Profile", required = true, schema = @Schema()) @Valid @RequestBody ProfileResource profileResource,HttpServletRequest request) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				ParichayUserResource parichayResource = profileService.create(profileResource,request);
				return new ResponseEntity<ParichayUserResource>(parichayResource,HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ParichayUserResource>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<ParichayUserResource>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ProfileResource> get(HttpServletRequest request) {
		String accept = request.getHeader("Accept");
		ProfileResource resource = new ProfileResource();
		if (accept != null && accept.contains("application/json")) {
			try {
				Long parichayUserId = (Long) request.getAttribute("currentUserId");
				resource = profileService.get(parichayUserId);
				return new ResponseEntity<ProfileResource>(resource,HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ProfileResource>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<ProfileResource>(HttpStatus.NOT_IMPLEMENTED);
	}

		// TODO Auto-generated method stub
	

	
	@Override
	public ResponseEntity<List<ProfileResource>> list(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		Long parichayUserId = (Long) request.getAttribute("currentUserId");
		List<ProfileResource> profileList = new ArrayList<>();
		if (accept != null || accept.contains("application/json")) {
			try{
				if(parichayUserId!=null){
					profileList = profileService.list(parichayUserId);
				}else{
					throw new Exception("Data error! Invalid parichayUserId");
				}

				return new ResponseEntity<>(profileList, HttpStatus.OK);
			}catch(Exception e){
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	public ResponseEntity<ProfileResource> edit(@RequestBody ProfileResource profileResource) {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		if (accept != null || accept.contains("application/json")) {
			try{
				String message = profileService.edit(profileResource.getId(),profileResource.getRoleId(),profileResource);
				ProfileResource profile = new ProfileResource();
				return new ResponseEntity<ProfileResource>(profile,HttpStatus.OK);
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<ProfileResource> patch(long id, long roleId) {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		if (accept != null || accept.contains("application/json")) {
			try{
				ProfileResource profileResource = profileService.patch(id,roleId);
				return new ResponseEntity<ProfileResource>(profileResource,HttpStatus.OK);
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}


}