package io.swagger.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.Department;
import io.swagger.model.Organization;
import io.swagger.repository.DepartmentRepo;
import io.swagger.repository.OrganizationRepo;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-20T10:29:16.504Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class OrganizationsApiController implements OrganizationsApi {

    private static final Logger log = LoggerFactory.getLogger(OrganizationsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private OrganizationRepo repo;

    @Autowired
    private DepartmentRepo deptrepo;

    @org.springframework.beans.factory.annotation.Autowired
    public OrganizationsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Organization>> organizationsGet(
            @NotNull @Parameter(in = ParameterIn.QUERY, description = "Code of the Depratment", required = true, schema = @Schema()) @Valid @RequestParam(value = "departmentCode", required = true) String departmentCode) {
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
                Department department = deptrepo.findByDepartmentCode(departmentCode);
                List<Organization> org = repo.findByDepartmentOrderByOrganizationName(department);
                return new ResponseEntity<List<Organization>>(org, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Organization>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Organization>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Organization> getOrganizationById(@PathVariable String organizationcode) {
        Optional<Organization> organizationOptional = repo.findById(organizationcode);
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
                if (!organizationOptional.isPresent())
                    throw new Exception("Data error: invalid organization id " + organizationcode);
                return new ResponseEntity<Organization>(organizationOptional.get(), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<Organization>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<Organization>(HttpStatus.NOT_IMPLEMENTED);
        }

    }

}
