package io.swagger.api;

import io.swagger.model.State;
import io.swagger.model.StateModel;
import io.swagger.model.ValidationError;
import io.swagger.repository.StateRepo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-18T12:17:29.581Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class StateApiController implements StateApi {

    private static final Logger log = LoggerFactory.getLogger(StateApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private StateRepo repo;
    
    @org.springframework.beans.factory.annotation.Autowired
    public StateApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<StateModel> poststate(@Parameter(in = ParameterIn.DEFAULT, description = "To create a new Onboarding minister", required=true, schema=@Schema()) @Valid @RequestBody StateModel body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<StateModel>(objectMapper.readValue("{\n  \"id\" : 10,\n  \"statename\" : \"uttarpradesh\"\n}", StateModel.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<StateModel>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<StateModel>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<StateModel>> returnState() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<StateModel>>(repo.findAll(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<StateModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<StateModel>>(repo.findAll(),HttpStatus.OK);
    }
    
    public ResponseEntity<StateModel> getStateById(Long stateid){
    	StateModel state  = repo.findById(stateid).get();
    	return new ResponseEntity<StateModel>(state,HttpStatus.OK);
    }

	@Override
	public ResponseEntity<StateModel> poststate(State body) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
