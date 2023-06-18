package io.swagger.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.ParichayUser;
import io.swagger.model.Role;
import io.swagger.model.RoleRegistration;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.repository.RoleRegistrationRepo;
import io.swagger.repository.RoleRepo;
import org.springframework.web.bind.annotation.RequestMapping;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-18T12:17:29.581Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class RoleRegistrationApiController implements RoleRegistrationApi {

    private static final Logger log = LoggerFactory.getLogger(RoleRegistrationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    RoleRegistrationRepo roleRegistrationRepo;
    @Autowired
    ParichayUserRepo parichayUserRepo;

    @Autowired
    RoleRepo roleRepo;

    @org.springframework.beans.factory.annotation.Autowired
    public RoleRegistrationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        super();
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<RoleRegistration>> list(HttpServletRequest request, Long userId) {
        ParichayUser parichayUser = null;
        String accept = request.getHeader("Accept");
        Long parichayUserId = (Long) request.getAttribute("currentUserId");

        if (accept != null || accept.contains("application/json")) {
            if (parichayUserId != 0 && parichayUserId.equals(userId)) {
                parichayUser = parichayUserRepo.findById(parichayUserId).get();
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            List<RoleRegistration> list = roleRegistrationRepo.findAll();
            Set<Role> userRoleList = parichayUser.getRolelist();
            List<RoleRegistration> finalList = new ArrayList<RoleRegistration>();
            for (RoleRegistration roleRegistration : list) {
                if (!userRoleList.contains(roleRegistration.getRole())) {
                    finalList.add(roleRegistration);
                }
            }
            return new ResponseEntity<List<RoleRegistration>>(finalList, HttpStatus.OK);
        }

        else
            return new ResponseEntity<List<RoleRegistration>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<RoleRegistration>> listRoleName(HttpServletRequest request, Long userId) {
        ParichayUser parichayUser = null;
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            Long parichayUserId = (Long) request.getAttribute("currentUserId");
            if (userId != 0 && userId.equals(parichayUserId)) {
                parichayUser = parichayUserRepo.findById(parichayUserId).get();
                System.out.println(parichayUser);
            } else {
                return new ResponseEntity<List<RoleRegistration>>(HttpStatus.UNAUTHORIZED);
            }
            List<RoleRegistration> list = roleRegistrationRepo.findAll();
            Set<Role> userRoleList = parichayUser.getRolelist();
            List<RoleRegistration> finalList = new ArrayList<RoleRegistration>();
            for (RoleRegistration roleRegistration : list) {
                Role role = roleRegistration.getRole();
                if (userRoleList.contains(role)) {
                    finalList.add(roleRegistration);
                }
                role.setSubmodulemasterList(role.getSubmodulemasterList());
            }
            return new ResponseEntity<List<RoleRegistration>>(finalList, HttpStatus.OK);
        }
        return new ResponseEntity<List<RoleRegistration>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<RoleRegistration> getById(Long roleRegistrationId) {
        return new ResponseEntity<>(roleRegistrationRepo.findById(roleRegistrationId).get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Role>> listAll() {
        List<Role> role = (List<Role>) roleRepo.findAll();
        return new ResponseEntity<List<Role>>(role, HttpStatus.OK);
    }

}
