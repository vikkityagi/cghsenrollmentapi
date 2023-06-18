package io.swagger.api;

import io.swagger.model.CardType;
import io.swagger.model.CghspayScaleBean;
import io.swagger.model.Payscale;
import io.swagger.repository.CardTypeRepo;
import io.swagger.repository.PayscaleRepo;


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
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-18T12:17:29.581Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class CardTypeApiController implements CardTypeApi {

    private static final Logger log = LoggerFactory.getLogger(CardTypeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private CardTypeRepo repo;

    @org.springframework.beans.factory.annotation.Autowired
    public CardTypeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CardType> post(@Parameter(in = ParameterIn.DEFAULT, description = "To create a new Onboarding payscale", required=true, schema=@Schema()) @Valid @RequestBody Payscale body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CardType>(objectMapper.readValue("{\n  \"id\" : 10,\n  \"payscale\" : \"jhfjhj\"\n}", CardType.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CardType>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CardType>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<CardType>> list() {
        System.out.println("card type controller run");
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
            	System.out.println("yes");
                return new ResponseEntity<List<CardType>>(repo.findAll(), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<CardType>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<CardType>>(repo.findAll(),HttpStatus.OK);
    }
    
    public ResponseEntity<CardType> get(long id){
    	CardType cardType = repo.findById(id).get();
    	return new ResponseEntity<CardType>(cardType,HttpStatus.OK);
    	
    }
}
