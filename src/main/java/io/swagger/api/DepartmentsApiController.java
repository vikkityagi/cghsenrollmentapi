package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Department;
import io.swagger.model.Ministry;
import io.swagger.repository.DepartmentRepo;
import io.swagger.repository.MinistryRepo;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-20T10:29:16.504Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class DepartmentsApiController implements DepartmentsApi {

    private static final Logger log = LoggerFactory.getLogger(DepartmentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private DepartmentRepo repo;

    @Autowired
    private MinistryRepo ministryRepo;

    @org.springframework.beans.factory.annotation.Autowired
    public DepartmentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Department>> departmentsGet(@NotNull @Parameter(in = ParameterIn.QUERY, description = "code of the Ministry" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "ministryCode", required = true) String ministryCode) {
        String accept = request.getHeader("Accept");
        System.out.println("run");
        System.out.println(ministryCode);
        if (accept != null || accept.contains("application/json")) {
            try {
            	Ministry ministry = ministryRepo.findByMinistryCode(ministryCode);
            	List<Department> dept = repo.findByMinistryOrderByDepartmentName(ministry);
            	System.out.println(dept);
                return new ResponseEntity<List<Department>>(dept, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Department>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Department>>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    public ResponseEntity<Department> getDeparmentById(@PathVariable String deparmentcode){
    	Department department = repo.findByDepartmentCode(deparmentcode);
    	return new ResponseEntity<Department>(department,HttpStatus.OK);
    }

}
