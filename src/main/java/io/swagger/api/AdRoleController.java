package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.AdRole;
 
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-02T11:40:29.581Z[GMT]")
@RestController
@CrossOrigin
@Service

@RequestMapping(value="/api/v1")
public class AdRoleController implements AdRoleApi {

    private final HttpServletRequest request;
    private final ObjectMapper objectMapper;

    @org.springframework.beans.factory.annotation.Autowired
    public AdRoleController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<List<AdRole>> getadCities(int cityid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getadCities'");
    }
    
}
