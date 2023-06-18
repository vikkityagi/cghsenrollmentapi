package io.swagger.api;

import io.swagger.enums.ActionTypeEnum;
import io.swagger.enums.ApplicationLevel;
import io.swagger.model.ActionType;
import io.swagger.model.Application;
import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.CGHSCity;
import io.swagger.model.ESignRequestObject;
import io.swagger.model.Movement;
import io.swagger.model.NodalApplicationDetail;
import io.swagger.model.OrganizationOffice;
import io.swagger.model.ParichayUser;
import io.swagger.model.PrimaryBeneficiary;
import io.swagger.repository.ActionTypeRepo;
import io.swagger.repository.BenRegistrationApplicationRepo;
import io.swagger.repository.CGHSCityRepo;
import io.swagger.repository.CGHSInchargeRepo;
import io.swagger.repository.MovementRepo;
import io.swagger.repository.NodalApplicationDetailRepo;
import io.swagger.repository.OrganizationOfficeRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.resources.MovementResource;
import io.swagger.resources.MovementResponseResource;
import io.swagger.service.MovementService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import org.modelmapper.ModelMapper;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-20T17:49:37.665755339Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class MovementsApiController implements MovementsApi {

    private static final Logger log = LoggerFactory.getLogger(MovementsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private MovementRepo movementRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CGHSInchargeRepo cghsInchargeRepo;
    @Autowired
    private NodalApplicationDetailRepo nodalApplicationDetailRepo;
    @Autowired
    private OrganizationOfficeRepo organizationOfficeRepo;
    @Autowired
    private BenRegistrationApplicationRepo benRegistrationApplicationRepo;

    @Autowired
    private ParichayUserRepo parichayUserRepo;

    @Autowired
    private ActionTypeRepo actionTypeRepo;

    @Autowired
    private MovementService movementService;

    @org.springframework.beans.factory.annotation.Autowired
    public MovementsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        super();
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<MovementResponseResource> create(HttpServletRequest request,
            @Parameter(in = ParameterIn.DEFAULT, description = "Create a new movement", required = true, schema = @Schema()) @Valid @RequestBody MovementResource body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                // Long parichayUserId = (Long) request.getAttribute("currentUserId");
                // Optional<BenRegistrationApplication> optionalBenRegistrationApplication = null;
                // if (body.getFromUserId() == parichayUserId) {
                //     optionalBenRegistrationApplication = benRegistrationApplicationRepo
                //             .findById(body.getApplicationId());
                //     if (!optionalBenRegistrationApplication.isPresent())
                //         throw new Exception("Data error: Invalid application Id parameter value");
                // }
                //     else
                //         return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

                //     System.out.println(body);
                //     BenRegistrationApplication benRegistrationApplication = optionalBenRegistrationApplication.get();
                //     PrimaryBeneficiary primaryBeneficiary = benRegistrationApplication.getPrimaryBeneficiary();
                //     Movement movementModel = new Movement();
                //     ActionType actionType = actionTypeRepo.findById(ActionTypeEnum.SUBMIT.getValue()).get();
                //     movementModel.setActionType(actionType);
                //     Optional<ParichayUser> optionalParichayUser = parichayUserRepo.findById(parichayUserId);
                //     if (!optionalParichayUser.isPresent())
                //         throw new Exception("Data error: Invalid parichay user ID");
                //     ParichayUser fromUser = optionalParichayUser.get();

                //     optionalParichayUser = parichayUserRepo.findById(parichayUserId);
                //     if (!optionalParichayUser.isPresent())
                //         throw new Exception("Data error: Invalid parichay user ID");

                //     ParichayUser toUser = optionalParichayUser.get();
                //     movementModel.setFromOffice(fromUser.getOrganizationOffice());
                //     movementModel.setToOffice(toUser.getOrganizationOffice());
                //     movementModel.setCreatedOn(LocalDateTime.now());
                //     movementModel.setUpdatedOn(LocalDateTime.now());
                //     movementModel.setCreatedBy(fromUser);
                //     movementModel.setUpdatedBy(fromUser);
                //     movementModel.setApplication(benRegistrationApplication);
                //     movementModel.setLevelNo(ApplicationLevel.ZERO.getValue());
                //     movementModel.setNew(true);
                //     Optional<ActionType> actionTypeOptional = actionTypeRepo.findById(ActionTypeEnum.SUBMIT.getValue());

                //     movementModel.setActionType(actionTypeOptional.get());
                //     movementRepo.save(movementModel);
                

                // return new ResponseEntity<MovementResponseResource>(HttpStatus.OK);

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MovementResponseResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            // return new ResponseEntity<MovementResponseResource>(HttpStatus.OK);
        }
        return new ResponseEntity<MovementResponseResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<MovementResource>> tasklist(Long toUserId,long roleId) {
        
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {

                List<Movement> movement = movementRepo.findAllByToOffice(toUserId,roleId);
                Optional<ParichayUser> parichayUser = parichayUserRepo.findById(toUserId);
                if(!parichayUser.isPresent()){
                    throw new Exception("Data error, wrong to user id");
                }

                System.out.println(movement);
                List<MovementResource> resourceList = new ArrayList<MovementResource>();
                for (Movement addmovment : movement) {
                    MovementResource resource = new MovementResource();
                    resource.setId(addmovment.getId());
                    resource.setToOffice(addmovment.getToOffice().getId());
                    resource.setFromOffice(addmovment.getFromOffice().getId());
                    resource.setApplicationType(addmovment.getApplicationType().getId());
                    resource.setRoleId(roleId);
                    Optional<OrganizationOffice> optional = organizationOfficeRepo.findById(addmovment.getToOffice().getId());
                    if(!optional.isPresent())
                        throw new Exception("Data error:"+" organization Office wrong");
                        // set application here
                    resource.setApplication(addmovment.getApplication().getId());
                    // Optional<BenRegistrationApplication> benRegistraitonApplication = benRegistrationApplicationRepo.findById(addmovment.getApplication().getId());
                    // if(!benRegistraitonApplication.isPresent()){
                    //     throw new Exception("Data Error, BenRegistrationApplication Id wrong");
                    // }
                    resource.setApplicationNumber(addmovment.getApplication().getApplicationNumber());
                    if(addmovment.getActionType().getId()==1){
                        resource.setActionType(ActionTypeEnum.SUBMIT.getValue());
                        resource.setActionName("SUBMIT");
                    }else if(addmovment.getActionType().getId()==2){
                        resource.setActionType(ActionTypeEnum.FORWARD.getValue());
                        resource.setActionName("FORWARD");
                    }else if(addmovment.getActionType().getId()==3){
                        resource.setActionType(ActionTypeEnum.APPROVE.getValue());
                        resource.setActionName("APPROVE");
                    }else if(addmovment.getActionType().getId()==4){
                        resource.setActionType(ActionTypeEnum.REJECT.getValue());
                        resource.setActionName("REJECT");
                    }else if(addmovment.getActionType().getId()==5){
                        resource.setActionType(ActionTypeEnum.RETURN.getValue());
                        resource.setActionName("RETURN");
                    }

                    resource.setCreatedOn(addmovment.getCreatedOn());
                    resource.setLevelNo(addmovment.getLevelNo());
                    resourceList.add(resource);
                }
                return new ResponseEntity<List<MovementResource>>(resourceList, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<MovementResource>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<MovementResource>>(HttpStatus.NOT_IMPLEMENTED);

    }

    /*
     * This method return the activity list of the role @roleId of the user @fromUserId
     * @param userId  id of the user
     * @param roleId role of the user 
     * application_type_level_role
     * Description: It will query the movement table where fromUserId is equal to the userId parameter and 
     * level id of movement table & role Id param is matched with the application_type_level_role based on the application type 
     */
    public ResponseEntity<List<MovementResource>> activitylist(Long userId,long roleId) {
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
                if(userId==null){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                // List<Movement> movement = repo.findAllByToUserId(to);
                MovementResource resource  = null;
                List<Movement> movementList = movementRepo.activitylist(userId,roleId);
                // System.out.println(movementList);
                List<MovementResource> resourceList = new ArrayList<MovementResource>();
                for(Movement movement: movementList){
                    resource = new MovementResource();
                    resource.setId(movement.getId());
                    resource.setToOffice(movement.getToOffice().getId());
                    resource.setFromOffice(movement.getFromOffice().getId());
                    resource.setRoleId(roleId);
                    Optional<OrganizationOffice> optional = organizationOfficeRepo.findById(movement.getToOffice().getId());
                    if(!optional.isPresent())
                        throw new Exception("Data error:"+" organization Office wrong");
                    resource.setApplication(movement.getApplication().getId());
                    resource.setApplicationNumber(movement.getApplication().getApplicationNumber());
                    if(movement.getActionType().getId()==1){
                        resource.setActionType(ActionTypeEnum.SUBMIT.getValue());
                        resource.setActionName("SUBMIT");
                    }else if(movement.getActionType().getId()==2){
                        resource.setActionType(ActionTypeEnum.FORWARD.getValue());
                        resource.setActionName("FORWARD");
                    }else if(movement.getActionType().getId()==3){
                        resource.setActionType(ActionTypeEnum.APPROVE.getValue());
                        resource.setActionName("APPROVE");
                    }else if(movement.getActionType().getId()==4){
                        resource.setActionType(ActionTypeEnum.REJECT.getValue());
                        resource.setActionName("REJECT");
                    }else if(movement.getActionType().getId()==5){
                        resource.setActionType(ActionTypeEnum.RETURN.getValue());
                        resource.setActionName("RETURN");
                    }

                    resource.setCreatedOn(movement.getCreatedOn());
                    resource.setLevelNo(movement.getLevelNo());
                    resourceList.add(resource);
                }

               
                return new ResponseEntity<List<MovementResource>>(resourceList, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<MovementResource>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<MovementResource>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<MovementResponseResource> forward(Long movementId,long roleId) throws Exception {

        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            if (movementId != null) {
                movementService.forward(movementId,roleId);
            }
            return new ResponseEntity<MovementResponseResource>(HttpStatus.OK);
        }
        return new ResponseEntity<MovementResponseResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ESignRequestObject> eSignMovement(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eSignMovement'");
    }

    @Override
    public ResponseEntity<ESignRequestObject> eSignResponsebenRegistrationApplication(Long id, String respon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eSignResponsebenRegistrationApplication'");
    }

}
