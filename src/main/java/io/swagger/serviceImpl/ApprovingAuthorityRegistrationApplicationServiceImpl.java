package io.swagger.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.enums.ActionTypeEnum;
import io.swagger.enums.ApplicationLevel;
import io.swagger.enums.ApplicationTypeEnum;
import io.swagger.model.ActionType;
import io.swagger.model.ApplicationType;
import io.swagger.model.ApprovingAuthorityRegistrationApplication;
import io.swagger.model.Department;
import io.swagger.model.Ministry;
import io.swagger.model.Movement;
import io.swagger.model.Organization;
import io.swagger.model.OrganizationOffice;
import io.swagger.model.ParichayUser;
import io.swagger.repository.ActionTypeRepo;
import io.swagger.repository.ApplicationTypeRepo;
import io.swagger.repository.ApprovingAuthorityRegistrationApplicationRepo;
import io.swagger.repository.DepartmentRepo;
import io.swagger.repository.MinistryRepo;
import io.swagger.repository.MovementRepo;
import io.swagger.repository.OrganizationOfficeRepo;
import io.swagger.repository.OrganizationRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.resources.ApprovingAuthorityRegistrationApplicationResource;
import io.swagger.resources.ApprovingAuthorityUserResource;
import io.swagger.service.ApprovingAuthorityRegistrationApplicationService;
import io.swagger.utils.ApplicationNumberGenerator;

@Service
public class ApprovingAuthorityRegistrationApplicationServiceImpl implements ApprovingAuthorityRegistrationApplicationService {

    @Autowired
    MinistryRepo ministryRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    OrganizationRepo organizationRepo;

    @Autowired
    ParichayUserRepo parichayUserRepo;

    @Autowired
    ActionTypeRepo actionTypeRepo;

    @Autowired
    MovementRepo movementRepo;

    @Autowired
    OrganizationOfficeRepo organizationOfficeRepo;

    @Autowired
    ApplicationTypeRepo applicationTypeRepo;

    @Autowired
    private ApplicationNumberGenerator applicationnumbergenerator;

    @Autowired
    ApprovingAuthorityRegistrationApplicationRepo approvingAuthorityRegistrationApplicationRepo;

    @Override
    public ApprovingAuthorityRegistrationApplicationResource create(ApprovingAuthorityRegistrationApplicationResource approvingAuthorityRegistrationApplicationResource,HttpServletRequest request) throws Exception{
        Long parichayUserId = (Long) request.getAttribute("currentUserId");
        Optional<ParichayUser> optionalParichayUser = parichayUserRepo.findById(parichayUserId);
		if (!optionalParichayUser.isPresent())
			throw new Exception("Data error: invalid parichay user id");
		ParichayUser parichayUser = optionalParichayUser.get();
        ApprovingAuthorityRegistrationApplication approvingAuthorityRegistrationApplication = new ApprovingAuthorityRegistrationApplication();
        approvingAuthorityRegistrationApplication.setName(approvingAuthorityRegistrationApplicationResource.getName());
        approvingAuthorityRegistrationApplication.setEmail(approvingAuthorityRegistrationApplicationResource.getEmail());
        approvingAuthorityRegistrationApplication.setMobileNumber(approvingAuthorityRegistrationApplicationResource.getMobileNumber());
        approvingAuthorityRegistrationApplication.setDesignataion(approvingAuthorityRegistrationApplicationResource.getDesignation());
        
        Optional<Ministry> minOptional = ministryRepo.findById(approvingAuthorityRegistrationApplicationResource.getMinistry());
		if (!minOptional.isPresent())
			throw new Exception("Data Error: Invalid ministry code");

        Optional<Department> deptOptional = departmentRepo.findById(approvingAuthorityRegistrationApplicationResource.getDepartment());
        if (!deptOptional.isPresent())
            throw new Exception("Data Error: Invalid department code");

        Optional<Organization> orgOptional = organizationRepo.findById(approvingAuthorityRegistrationApplicationResource.getOrganization());
        if (!orgOptional.isPresent())
            throw new Exception("Data Error: Invalid organization code");
        
        approvingAuthorityRegistrationApplication.setMinistry(minOptional.get());
        approvingAuthorityRegistrationApplication.setDepartment(deptOptional.get());
        approvingAuthorityRegistrationApplication.setOrganization(orgOptional.get());
        approvingAuthorityRegistrationApplication.setCreatedBy(parichayUser);
        approvingAuthorityRegistrationApplication.setUpdatedBy(parichayUser);
        approvingAuthorityRegistrationApplication.setCreatedOn(LocalDateTime.now());
        approvingAuthorityRegistrationApplication.setUpdatedOn(LocalDateTime.now());

        // set application_type here
        ApplicationType applicationType = applicationTypeRepo.findById(ApplicationTypeEnum.ApprovingAuthorityEnrollmentApplication.getValue()).get();
        approvingAuthorityRegistrationApplication.setApplicationType(applicationType);

         // generate application number for new applications
         approvingAuthorityRegistrationApplication.setApplicationNumber(applicationnumbergenerator
         .generateApplicationNumber(ApplicationTypeEnum.ApprovingAuthorityEnrollmentApplication));

        Movement movement = new Movement();
        movement.setApplication(approvingAuthorityRegistrationApplication);
		movement.setCreatedBy(parichayUser);
		movement.setUpdatedBy(parichayUser);
		movement.setCreatedOn(LocalDateTime.now());
		movement.setUpdatedOn(LocalDateTime.now());
		movement.setLevelNo(ApplicationLevel.ZERO.getValue());
		movement.setApplicationType(approvingAuthorityRegistrationApplication.getApplicationType());
        //  get the action_type
		ActionType actionType = actionTypeRepo.findById(ActionTypeEnum.SUBMIT.getValue()).get();
		movement.setActionType(actionType);
        // movement.setCghsCity(optionalCGHSCity.get());
		//set from office user Id
		movement.setFromUserId(parichayUser);
        movement.setFromOffice(parichayUser.getOrganizationOffice());
        // set to office here
        List<OrganizationOffice> organizationOfficeList = organizationOfficeRepo.findByOrganization(orgOptional.get());
        for(OrganizationOffice orgOfficeIter: organizationOfficeList){
            movement.setToOffice(orgOfficeIter);
        }
        
		movement.setNew(true);
        
        approvingAuthorityRegistrationApplicationRepo.save(approvingAuthorityRegistrationApplication);
        movementRepo.save(movement);

        return approvingAuthorityRegistrationApplicationResource;
    }

    @Override
    public List<ApprovingAuthorityRegistrationApplicationResource> list() {
        // TODO Auto-generated method stub
        List<ApprovingAuthorityRegistrationApplication> approvingAuthorityRegistrationApplication = approvingAuthorityRegistrationApplicationRepo.findAll();
        List<ApprovingAuthorityRegistrationApplicationResource> approvingAuthorityRegistrationApplicationList = new ArrayList<ApprovingAuthorityRegistrationApplicationResource>();
        ApprovingAuthorityRegistrationApplicationResource approvingAuthorityRegistrationApplicationResource = new ApprovingAuthorityRegistrationApplicationResource();
        for(ApprovingAuthorityRegistrationApplication approvingAuthorityRegistrationApplicationIter: approvingAuthorityRegistrationApplication){
            approvingAuthorityRegistrationApplicationResource.setId(null);
            approvingAuthorityRegistrationApplicationResource.setName(null);
            approvingAuthorityRegistrationApplicationResource.setDesignation(null);
            approvingAuthorityRegistrationApplicationResource.setEmail(null);
            approvingAuthorityRegistrationApplicationResource.setMobileNumber(null);
            approvingAuthorityRegistrationApplicationResource.setMinistry(null);
            approvingAuthorityRegistrationApplicationResource.setDepartment(null);
            approvingAuthorityRegistrationApplicationResource.setOrganization(null);

            approvingAuthorityRegistrationApplicationList.add(approvingAuthorityRegistrationApplicationResource);

        }

        return approvingAuthorityRegistrationApplicationList;
    }

        
}
