package io.swagger.api;

import io.swagger.model.ModuleMaster;
import io.swagger.model.NavigationLink;
import io.swagger.model.ParichayUser;
import io.swagger.model.Role;
import io.swagger.model.SubModuleMaster;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.repository.RoleRepo;
import io.swagger.resources.RoleResource;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-28T07:07:34.520234324Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/")
public class NavigationApiController implements NavigationApi {

    private static final Logger log = LoggerFactory.getLogger(NavigationApiController.class);

    private final ObjectMapper objectMapper;
    @Autowired
    private ParichayUserRepo parichayUserRepo;
    @Autowired
    private RoleRepo roleRepo;

    private final HttpServletRequest request;

    @Autowired
    private ModelMapper modelMapper;

    @org.springframework.beans.factory.annotation.Autowired
    public NavigationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        super();
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // @Override
    // public ResponseEntity<Map<String, List<NavigationLink>>>
    // get(HttpServletRequest request,Long userId,long roleId) {
    // // TODO Auto-generated method stub
    // System.out.println("roleId>>"+roleId);
    // String accept = request.getHeader("Accept");
    // if (accept != null || accept.contains("application/json")) {
    // try {
    // Long parichayUserId = (Long) request.getAttribute("currentUserId");
    // if(userId == parichayUserId){
    // Optional<ParichayUser> optionalParichayUser =
    // parichayUserRepo.findById(parichayUserId);
    // if (!optionalParichayUser.isPresent())
    // throw new Exception("Data error: user id is invalid");
    // ParichayUser parichayUser = optionalParichayUser.get();
    // Set<Role> roleList = parichayUser.getRolelist();
    // // if(roleList.contains(roleId)){

    // // }
    // Map<String, List<NavigationLink>> respMap= new HashMap<String,
    // List<NavigationLink>>();

    // for(Role role : roleList){
    // Set<SubModuleMaster> subModuleSet = role.getSubmodulemasterList();

    // for(SubModuleMaster subModule:subModuleSet){
    // ModuleMaster moduleMaster = subModule.getModuleId();

    // List<NavigationLink> navList= null;
    // if(respMap.get(moduleMaster.getModuleName())== null){
    // navList = new ArrayList<NavigationLink>();
    // respMap.put(moduleMaster.getModuleName(), navList);
    // }
    // else{
    // navList = respMap.get(moduleMaster.getModuleName());
    // }
    // NavigationLink navLink = new
    // NavigationLink(subModule.getSubmoudleName(),subModule.getMoudlePath());
    // navLink.setRoleId(userId);
    // navList.add(navLink);
    // System.out.println("navlist>>"+navList);
    // }
    // }
    // return new ResponseEntity<>(respMap, HttpStatus.OK);
    // }

    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // return null;
    // } else
    // return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    // }

    @Override
    public ResponseEntity<List<NavigationLink>> get(HttpServletRequest request, Long userId, long roleId) {
        // TODO Auto-generated method stub
        System.out.println("roleId>>" + roleId);
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
                Long parichayUserId = (Long) request.getAttribute("currentUserId");
                if (userId == parichayUserId) {
                    Optional<ParichayUser> optionalParichayUser = parichayUserRepo.findById(parichayUserId);
                    if (!optionalParichayUser.isPresent())
                        throw new Exception("Data error: user id is invalid");
                    Optional<Role> roleOptional = roleRepo.findById(roleId);
                    if (!roleOptional.isPresent()) {
                        throw new Exception("Data error: role id " + roleId + " is invalid");
                    }
                    Role role = roleOptional.get();
                    // if(roleList.contains(roleId)){

                    // }
                    List<NavigationLink> navList = new ArrayList<NavigationLink>();

                    Set<SubModuleMaster> subModuleSet = role.getSubmodulemasterList();

                    for (SubModuleMaster subModule : subModuleSet) {
                        ModuleMaster moduleMaster = subModule.getModuleId();

                      
                        NavigationLink navLink = new NavigationLink(subModule.getSubmoudleName(),
                                subModule.getMoudlePath());
                        navLink.setRoleId(roleId);
                        navList.add(navLink);
                        System.out.println("navlist>>" + navList);
                    }

                    return new ResponseEntity<>(navList, HttpStatus.OK);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        } else
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    @Override
    public ResponseEntity<List<RoleResource>> getRole(HttpServletRequest request, Long userId) {
        // TODO Auto-generated method stub
        Long currentUserId = (Long) request.getAttribute("currentUserId");
        if (currentUserId == userId) {
            String accept = request.getHeader("Accept");

            if (accept != null || accept.contains("application/json")) {
                try {
                    Optional<ParichayUser> parichayUser = parichayUserRepo.findById(userId);
                    if (!parichayUser.isPresent()) {
                        throw new Exception("Data error, invalid parichayUser");
                    }
                    List<Role> roleList = new ArrayList<Role>();
                    List<RoleResource> roleResourceList = null;
                    Set<Role> rolelistOld = parichayUser.get().getRolelist();
                    RoleResource roleResource = null;
                    // System.out.println()
                    roleResourceList = new ArrayList<RoleResource>();
                    for (Role role : rolelistOld) {
                        roleResource = new RoleResource();
                        roleResource.setId(role.getId());
                        roleResource.setRoleName(role.getRoleName());
                        // roleResource  = this.modelMapper.createTypeMap(role,RoleResource.class);
                        roleResourceList.add(roleResource);
                    }
                    System.out.println(roleResourceList);

                    return new ResponseEntity<List<RoleResource>>(roleResourceList, HttpStatus.OK);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new ResponseEntity<List<RoleResource>>(HttpStatus.NOT_EXTENDED);
                }
            }
            return new ResponseEntity<List<RoleResource>>(HttpStatus.NOT_IMPLEMENTED);
        }
        return new ResponseEntity<List<RoleResource>>(HttpStatus.NOT_IMPLEMENTED);
    }

    // @Override
    // public ResponseEntity<List<NavigationLink>> get(HttpServletRequest
    // request,Long userId) {
    // // TODO Auto-generated method stub
    // String accept = request.getHeader("Accept");

    // if (accept != null || accept.contains("application/json")) {
    // try {
    // Long parichayUserId = (Long) request.getAttribute("currentUserId");
    // List<NavigationLink> navList = new ArrayList<NavigationLink>();
    // if(userId == parichayUserId){
    // Optional<ParichayUser> optionalParichayUser =
    // parichayUserRepo.findById(parichayUserId);
    // if (!optionalParichayUser.isPresent())
    // throw new Exception("Data error: user id is invalid");
    // ParichayUser parichayUser = optionalParichayUser.get();
    // Set<Role> roleList = parichayUser.getRolelist();
    // List<NavigationLink> respMap = new ArrayList<NavigationLink>();
    // for(Role role : roleList){
    // Set<SubModuleMaster> subModuleSet = role.getSubmodulemasterList();
    // for(SubModuleMaster subModule:subModuleSet){
    // ModuleMaster moduleMaster = subModule.getModuleId();
    // NavigationLink navLink = new
    // NavigationLink(subModule.getSubmoudleName(),subModule.getMoudlePath());
    // navLink.setRoleId(role.getId());
    // navList.add(navLink);
    // System.out.println("navlist>>"+navList);
    // }
    // }

    // return new ResponseEntity<List<NavigationLink>>(navList, HttpStatus.OK);
    // }

    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // return new ResponseEntity<List<NavigationLink>>(HttpStatus.NOT_FOUND);
    // }

    // } else{
    // return new ResponseEntity<List<NavigationLink>>(HttpStatus.NOT_IMPLEMENTED);
    // }
    // return null;
    // }

}
