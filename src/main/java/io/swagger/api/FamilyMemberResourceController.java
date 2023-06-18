package io.swagger.api;

import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.FamilyMember;
import io.swagger.repository.BenRegistrationApplicationRepo;
import io.swagger.repository.FamilyMemberRepo;
import io.swagger.repository.PrimaryBeneficiaryRepo;
import io.swagger.repository.RelationshipTypeRepo;
import io.swagger.resources.FamilyMemberResource;
import io.swagger.service.BenRegistrationApplicationService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.internal.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import io.swagger.model.PrimaryBeneficiary;
import io.swagger.model.RelationshipType;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/")
public class FamilyMemberResourceController implements FamilyMemberResourceApi {

    private static final Logger log = LoggerFactory.getLogger(FamilyMemberResourceController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PrimaryBeneficiaryRepo pbrepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FamilyMemberRepo familyRepo;

    @Autowired
    private BenRegistrationApplicationService benservice;

    @Autowired
    private RelationshipTypeRepo relationshipTypeRepo;
    @Autowired
    private BenRegistrationApplicationRepo benRegistrationApplicationRepo;

    @org.springframework.beans.factory.annotation.Autowired
    public FamilyMemberResourceController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @CrossOrigin
    public ResponseEntity<FamilyMemberResource> create(
            @Parameter(in = ParameterIn.PATH, description = "application id ", required = true, schema = @Schema()) @PathVariable("id") Long applicationId,
            @Parameter(in = ParameterIn.DEFAULT, description = "Create a new beneficiary family", required = true, schema = @Schema()) @Valid @RequestBody FamilyMemberResource body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            FamilyMember familyMember = new FamilyMember();
            try {
                if (applicationId != null) {
                    System.out.println("applicationId - " + applicationId);
                    Optional<BenRegistrationApplication> benOptional = benRegistrationApplicationRepo
                            .findById(applicationId);
                    if (!benOptional.isPresent())
                        throw new Exception("Data error: Invalid application Id parameter");
                    BenRegistrationApplication benRegistrationApplication = benOptional.get();
                    body.setApplicationId(benRegistrationApplication.getId());
                }

                System.out.println(body);

                familyMember = benservice.saveFamilyMember(body);
                System.out.println("api>>>" + familyMember);
                return new ResponseEntity<FamilyMemberResource>(HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FamilyMemberResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FamilyMemberResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    @CrossOrigin
    public ResponseEntity<List<FamilyMemberResource>> list(
            @Parameter(in = ParameterIn.PATH, description = "application Id", required = true, schema = @Schema()) @PathVariable("id") Long applicationId)
            throws Exception {
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            if (applicationId != null) {
                try {
                    System.out.println("applicationId - " + applicationId);

                    benRegistrationApplicationRepo.findRecordById(applicationId);

                    Optional<BenRegistrationApplication> benOptional = benRegistrationApplicationRepo
                            .findById(applicationId);
                    if (!benOptional.isPresent())
                        throw new Exception("Data error: Invalid application Id parameter");
                    BenRegistrationApplication benRegistrationApplication = benOptional.get();
                    PrimaryBeneficiary primaryBeneficiary = benRegistrationApplication.getPrimaryBeneficiary();

                    List<FamilyMember> familyMemberList = primaryBeneficiary.getFamilyMemberList();
                    List<FamilyMemberResource> lists = new ArrayList<>();
                    for (FamilyMember familyMember : familyMemberList) {

                        lists.add(this.modelMapper.map(familyMember, FamilyMemberResource.class));
                    }


                        // modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
                        // TypeMap<FamilyMember, FamilyMemberResource> typeMap = modelMapper.createTypeMap(FamilyMember.class, FamilyMemberResource.class);
                        // typeMap.addMappings(new PropertyMap<FamilyMember, FamilyMemberResource>() {
                        //     @Override
                        //     protected void configure() {
                        //         map().setRelationName(source.getRelationshipType().getRelationName());
                        //         map().setRelationName(accept);
                        //     }
                        // });
                       
                    
                        
                    // })
                    // List<FamilyMemberResource> lists = familyMemberList.stream()
                    // .map((list) -> this.modelMapper.map(list, FamilyMemberResource.class))
                    // .collect(Collectors.toList());
                    // List<FamilyMemberResource> resourceList = new
                    // ArrayList<FamilyMemberResource>();

                    // for (FamilyMember familyMemberObject : familyMemberList) {
                    // FamilyMemberResource resourceObject = new FamilyMemberResource();
                    // resourceObject.setId(familyMemberObject.getId());
                    // resourceObject.setBloodGroupName(familyMemberObject.getBloodGroup().getGroupName());
                    // resourceObject.setDateOfBirth(familyMemberObject.getDateOfBirth());
                    // resourceObject.setEnglishName(familyMemberObject.getEnglishName());
                    // resourceObject.setGender(familyMemberObject.getGender());
                    // resourceObject.setHindiName(familyMemberObject.getHindiName());
                    // resourceObject.setMobile(familyMemberObject.getMobile());
                    // resourceObject.setOtpVerify(familyMemberObject.getOtpVerify());
                    // resourceObject.setEmail(familyMemberObject.getEmail());
                    // resourceObject.setRelationName(familyMemberObject.getRelationshipType().getRelationName());
                    // resourceObject.setIsPrimary(familyMemberObject.isPrimary());
                    // resourceList.add(resourceObject);

                    // System.out.println("data - " + familyMemberList);
                    return new ResponseEntity<List<FamilyMemberResource>>(lists, HttpStatus.OK);
                } catch (Exception e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<List<FamilyMemberResource>>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                throw new Exception("Data error: Invalid application Id parameter");
            }

        }

        return new ResponseEntity<List<FamilyMemberResource>>(HttpStatus.NOT_IMPLEMENTED);

    }

    @CrossOrigin
    public ResponseEntity<FamilyMemberResource> get(
            @Parameter(in = ParameterIn.PATH, description = "application Id", required = true, schema = @Schema()) @PathVariable("id") Long applicationId,
            @Parameter(in = ParameterIn.PATH, description = "Member_Id of the family member", required = true, schema = @Schema()) @PathVariable("member_id") Long memberId) {
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {

            try {
                FamilyMember familyMember = familyRepo.findById(memberId).get();
                FamilyMemberResource familyResource = new FamilyMemberResource();
                familyResource.setId(familyMember.getId());
                familyResource.setEnglishName(familyMember.getEnglishName());
                familyResource.setHindiName(familyMember.getHindiName());

                familyResource.setDateOfBirth(familyMember.getDateOfBirth());
                familyResource.setGender(familyMember.getGender());
                familyResource.setBloodGroupName(familyMember.getBloodGroup().getGroupName());
                familyResource.setBloodGroupCode(familyMember.getBloodGroup().getId());

                familyResource.setRelationCode(familyMember.getRelationshipType().getId());
                familyResource.setRelationName(familyMember.getRelationshipType().getRelationName());
                familyResource.setMobile(familyMember.getMobile());
                return new ResponseEntity<FamilyMemberResource>(familyResource, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FamilyMemberResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<FamilyMemberResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<FamilyMemberResource> delete(Long applicationId, Long memberId) {
        // TODO Auto-generated method stub
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {

            try {

                FamilyMember familyMember = familyRepo.findById(memberId).get();
                familyRepo.delete(familyMember);
                return new ResponseEntity<FamilyMemberResource>(HttpStatus.OK);

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<FamilyMemberResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<FamilyMemberResource>(HttpStatus.NOT_IMPLEMENTED);
    }
}
