package io.swagger.serviceImpl;

import io.swagger.service.MovementService;
import io.swagger.enums.ActionTypeEnum;
import io.swagger.enums.ApplicationLevel;
import io.swagger.enums.ApplicationTypeEnum;
import io.swagger.model.ActionType;
import io.swagger.model.Application;
import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.CGHSCity;
import io.swagger.model.CGHSIncharge;
import io.swagger.model.CGHSUser;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    private BenRegistrationApplicationRepo benRegistrationApplicationRepo;
    @Autowired
    private ActionTypeRepo actionTypeRepo;;

    @Autowired
    private ParichayUserRepo parichayUserRepo;
    @Autowired
    private MovementRepo movementRepo;

    @Autowired
    private CGHSInchargeRepo cghsInchargeRepo;
    @Autowired
    private NodalApplicationDetailRepo nodalApplicationDetailRepo;
    @Autowired
    private OrganizationOfficeRepo organizationOfficeRepo;
    @Autowired
    private CGHSCityRepo cghsCityRepo;


    @Override
    public MovementResponseResource create(HttpServletRequest request,MovementResource body) {
            try {
                // Optional<BenRegistrationApplication> optionalBenRegistrationApplication = benRegistrationApplicationRepo
                //         .findById(body.getApplicationId());
                // if (!optionalBenRegistrationApplication.isPresent())
                //     throw new Exception("Data error: Invalid application Id parameter value");
                // System.out.println(body);
                // BenRegistrationApplication benRegistrationApplication = optionalBenRegistrationApplication.get();
                // PrimaryBeneficiary primaryBeneficiary = benRegistrationApplication.getPrimaryBeneficiary();
                // Movement movementModel = new Movement();
                // ActionType actionType = actionTypeRepo.findById(ActionTypeEnum.SUBMIT.getValue()).get();
                // movementModel.setActionType(actionType);
                // Long parichayUserId = (Long) request.getAttribute("currentUserId");
                // if(body.getFromUserId()==parichayUserId && body.getToUserId() == parichayUserId){
                //     Optional<ParichayUser> optionalParichayUser = parichayUserRepo.findById(parichayUserId);
                // if (!optionalParichayUser.isPresent())
                //     throw new Exception("Data error: Invalid parichay user ID");
                // ParichayUser fromUser = optionalParichayUser.get();

                // optionalParichayUser = parichayUserRepo.findById(parichayUserId);
                // if (!optionalParichayUser.isPresent())
                //     throw new Exception("Data error: Invalid parichay user ID");

                // ParichayUser toUser = optionalParichayUser.get();
                // movementModel.setFromOffice(fromUser.getOrganizationOffice());
                // movementModel.setToOffice(toUser.getOrganizationOffice());
                // movementModel.setCreatedOn(LocalDateTime.now());
                // movementModel.setUpdatedOn(LocalDateTime.now());
                // movementModel.setCreatedBy(fromUser);
                // movementModel.setUpdatedBy(fromUser);
                // movementModel.setApplication(benRegistrationApplication);
                // movementModel.setLevelNo(ApplicationLevel.ZERO.getValue());
                // movementModel.setNew(true);
                // Optional<ActionType> actionTypeOptional = actionTypeRepo.findById(ActionTypeEnum.SUBMIT.getValue());

                // movementModel.setActionType(actionTypeOptional.get());
                // movementRepo.save(movementModel);

                // }
                
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        
        return null;
    }

    @Override
    public List<MovementResponseResource> tasklist(Long toUserId) {
        // List<MovementResponseResource> resourceList = new ArrayList<MovementResponseResource>();
        //     try {
        //         List<Movement> movement = movementRepo.findAllByToOffice(toUserId,);
        //         System.out.println(movement);
        //         for (Movement addmovment : movement) {
        //             MovementResponseResource resource = new MovementResponseResource();

        //             resource.setId(addmovment.getId());
        //             resource.setToUserId(addmovment.getToOffice().getId());
        //             resource.setFromUserId(addmovment.getFromOffice().getId());
        //             Optional<OrganizationOffice> optional = organizationOfficeRepo.findById(addmovment.getToOffice().getId());
        //             resource.setToUserRoles(
        //                     optional.get().getCreatedBy().getRolelist().stream().map(obj -> obj.getId()).toArray(Long[]::new));
        //             resource.setFromUserRoles(optional.get().getCreatedBy().getRolelist().stream().map(obj -> obj.getId())
        //                     .toArray(Long[]::new));
        //             resource.setFromUserName(optional.get().getCreatedBy().getFullName());
        //             resource.setToUserName(optional.get().getCreatedBy().getFullName());
        //             resource.setApplicationNumber(addmovment.getApplication().getApplicationNumber());
        //             resource.setActionTypeName(addmovment.getActionType().getActionName());
        //             resource.setApplicationTypeName(
        //                     addmovment.getApplication().getApplicationType().getApplicationTypeName());

        //             resource.setApplicationId(addmovment.getApplication().getId());
        //             resource.setCreated_on(addmovment.getCreatedOn());
        //             resource.setUpdated_on(addmovment.getUpdatedOn());
        //             resourceList.add(resource);
        //         }
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //         System.out.println("Couldn't serialize response for content type application/json"+ e);
        //     }
            return null;
    }

    @Override
    public List<MovementResponseResource> activitylist(Long fromUserId) {
        List<MovementResponseResource> resourceList = new ArrayList<MovementResponseResource>();
            try {
                List<Movement> movement = movementRepo.findAllByFromUserId(fromUserId);
                System.out.println(movement);
                for (Movement addmovment : movement) {
                    MovementResponseResource resource = new MovementResponseResource();
                    resource.setId(addmovment.getId());
                    resource.setToUserId(addmovment.getToOffice().getId());
                    resource.setFromUserId(addmovment.getFromOffice().getId());
                    Optional<OrganizationOffice> optional = organizationOfficeRepo.findById(addmovment.getToOffice().getId());
                    resource.setToUserRoles(
                        optional.get().getCreatedBy().getRolelist().stream().map(obj -> obj.getId()).toArray(Long[]::new));
                    resource.setFromUserRoles(optional.get().getCreatedBy().getRolelist().stream().map(obj -> obj.getId())
                            .toArray(Long[]::new));
                    resource.setFromUserName(optional.get().getCreatedBy().getFullName());
                    resource.setToUserName(optional.get().getCreatedBy().getFullName());
                    resource.setApplicationNumber(addmovment.getApplication().getApplicationNumber());
                    resource.setActionTypeName(addmovment.getActionType().getActionName());
                    resource.setApplicationTypeName(addmovment.getApplication().getApplicationType().getApplicationTypeName());
                    resource.setApplicationId(addmovment.getApplication().getId());
                    resource.setCreated_on(addmovment.getCreatedOn());
                    resource.setUpdated_on(addmovment.getUpdatedOn());
                    resourceList.add(resource);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Couldn't serialize response for content type application/json"+ e);
            }
        return resourceList;
    }

    @Override
    public MovementResponseResource forward(Long movementId,long roleId) throws Exception {
        Optional<Movement> movementOptional = movementRepo.findById(movementId);
        Movement newMovement = new Movement();
        try {
            if(!movementOptional.isPresent())
                throw new Exception("Data error: invalid movement id");
            Movement movement = movementOptional.get();
            if(roleId==1){
                System.out.println(movement.getToOffice());
                movement.setFromOffice(movement.getToOffice());
                // Optional<CGHSCity> cGHSCity = cghsCityRepo.findById(movement.getCghsCity().getId());
                // if(!cGHSCity.isPresent()){
                //     throw new Exception("Invalid city id");
                // }
                // CGHSIncharge cghsIncharge = cghsInchargeRepo.findByCghsCity(cGHSCity.get());
                // CGHSUser cghsUser = cghsIncharge.getCghsUser();
                // if(cghsUser==null){
                //     throw new Exception("cghs User is not present to the corresponding city");
                // }
                // movement.setToOffice(cghsUser.getOrganizationOffice());
                movement.setLevelNo(ApplicationLevel.ONE.getValue());
                movement.setCreatedOn(LocalDateTime.now());
                movement.setUpdatedOn(LocalDateTime.now());
                movement.setCreatedBy(movement.getCreatedBy());
                movement.setUpdatedBy(movement.getUpdatedBy());
                ActionType actionType = actionTypeRepo.findById(ActionTypeEnum.FORWARD.getValue()).get();

                // movement.setActionType(actionType);
                // movementRepo.save(movement);
            }
            
            
                    
                
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    
    public ResponseEntity<ESignRequestObject> eSignMovement(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eSignMovement'");
    }

    
    public ResponseEntity<ESignRequestObject> eSignResponsebenRegistrationApplication(Long id, String respon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eSignResponsebenRegistrationApplication'");
    }

    
}
