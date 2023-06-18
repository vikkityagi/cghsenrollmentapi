package io.swagger.serviceImpl;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.enums.ActionTypeEnum;
import io.swagger.enums.ApplicationLevel;
import io.swagger.enums.ApplicationTypeEnum;
import io.swagger.model.ActionType;
import io.swagger.model.ApplicationType;
import io.swagger.model.CGHSCity;
import io.swagger.model.CGHSInchargeApplication;
import io.swagger.model.Department;
import io.swagger.model.Ministry;
import io.swagger.model.Movement;
import io.swagger.model.Organization;
import io.swagger.model.OrganizationOffice;
import io.swagger.model.ParichayUser;
import io.swagger.repository.ActionTypeRepo;
import io.swagger.repository.ApplicationTypeRepo;
import io.swagger.repository.CGHSCityRepo;
import io.swagger.repository.CGHSInchargeApplicationRepo;
import io.swagger.repository.DepartmentRepo;
import io.swagger.repository.MinistryRepo;
import io.swagger.repository.MovementRepo;
import io.swagger.repository.OrganizationOfficeRepo;
import io.swagger.repository.OrganizationRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.resources.CGHSInchargeRegistrationResource;
import io.swagger.service.CGHSInchargeApplicationService;
import io.swagger.utils.ApplicationNumberGenerator;

@Service
public class CGHSInchargeApplicationServiceImpl implements CGHSInchargeApplicationService {

    @Autowired
    private MinistryRepo ministryRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private OrganizationRepo organizationRepo;

    @Autowired
    private ParichayUserRepo parichayUserRepo;

    @Autowired
    private CGHSCityRepo cghsCityRepo;

    @Autowired
    private CGHSInchargeApplicationRepo cghsInchargeApplicationRepo;

    @Autowired
    private OrganizationOfficeRepo organizationOfficeRepo;

    @Autowired
    private ActionTypeRepo actionTypeRepo;

    @Autowired
    private MovementRepo movementRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ApplicationNumberGenerator applicationnumbergenerator;

    @Autowired
    ApplicationTypeRepo applicationTypeRepo;

    @Override
    public CGHSInchargeRegistrationResource create(HttpServletRequest request,
            CGHSInchargeRegistrationResource resource) {
        CGHSInchargeRegistrationResource retCghsInchargeApplication = new CGHSInchargeRegistrationResource();

        CGHSInchargeApplication cghsInchargeApplication = new CGHSInchargeApplication();

        Optional<ParichayUser> parichayUser = parichayUserRepo.findById(resource.getParichayUserId());
        if (!parichayUser.isPresent()) {
            try {
                throw new Exception("Invalid parichayUserId");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {
            cghsInchargeApplication.setName(resource.getName());
            cghsInchargeApplication.setDesignation(resource.getDesignation());
            cghsInchargeApplication.setEmail(resource.getEmail());
            cghsInchargeApplication.setMobile(resource.getMobile());

            Optional<Organization> orgOptional = organizationRepo.findById(resource.getOrganization());
            if (!orgOptional.isPresent())
                throw new Exception("Data Error: Invalid organization code");
            cghsInchargeApplication.setOrganization(orgOptional.get());
            Optional<Department> deptOptional = departmentRepo.findById(resource.getDepartment());
            if (!deptOptional.isPresent())
                throw new Exception("Data Error: Invalid department code");
            cghsInchargeApplication.setDepartment(deptOptional.get());
            Optional<Ministry> ministryOptional = ministryRepo.findById(resource.getMinistry());
            if (!ministryOptional.isPresent())
                throw new Exception("Data Error: Invalid ministry code");
            cghsInchargeApplication.setMinistry(ministryOptional.get());
            Long parichayUserId = (Long) request.getAttribute("currentUserId");
            if (parichayUserId == resource.getParichayUserId()) {
                Optional<ParichayUser> parichayOptional = parichayUserRepo.findById(parichayUserId);
                if (!parichayOptional.isPresent())
                    throw new Exception("Data error: " + "invalid parichay user Id");
                cghsInchargeApplication.setCreatedBy(parichayOptional.get());
                cghsInchargeApplication.setUpdateBy(parichayOptional.get());
                cghsInchargeApplication.setCreatedOn(LocalDateTime.now());
                cghsInchargeApplication.setUpdatedOn(LocalDateTime.now());
                Optional<OrganizationOffice> orgOfficeOptional = organizationOfficeRepo
                        .findById(resource.getOrganizationOfficeId());
                if (!orgOfficeOptional.isPresent())
                    throw new Exception(
                            "Data error:invalid organization office id" + resource.getOrganizationOfficeId());

                cghsInchargeApplication.setOrganizationOffice(orgOfficeOptional.get());
                List<String> cghscity = resource.getCghscity();
                Set<CGHSCity> cghsCitySet = new HashSet<CGHSCity>();
                for (String cityId : cghscity) {
                    Optional<CGHSCity> cityOptional = cghsCityRepo.findById(Long.valueOf(cityId + ""));
                    if (!cityOptional.isPresent())
                        throw new Exception("Data Error: Invalid city code");
                    cghsCitySet.add(cityOptional.get());
                }
                cghsInchargeApplication.setCghscity(cghsCitySet);

                // set application_type here
                ApplicationType applicationType = applicationTypeRepo
                        .findById(ApplicationTypeEnum.CGHSInchargeEnrollmentApplication.getValue()).get();
                cghsInchargeApplication.setApplicationType(applicationType);

                // generate application number for new applications
                cghsInchargeApplication.setApplicationNumber(applicationnumbergenerator
                        .generateApplicationNumber(ApplicationTypeEnum.CGHSInchargeEnrollmentApplication));

                cghsInchargeApplicationRepo.save(cghsInchargeApplication);

                // retCghsInchargeApplication =
                // cghsInchargeApplicationRepo.findByCreatedBy(parichayOptional.get());
                cghsInchargeApplication = cghsInchargeApplicationRepo.findByCreatedBy(parichayOptional.get());

                retCghsInchargeApplication.setId(cghsInchargeApplication.getId());
                System.out.println("resource>>" + retCghsInchargeApplication.getId());

                Movement movement = new Movement();
                // movement.setApplication();
                movement.setApplication(cghsInchargeApplication);
                movement.setCreatedBy(parichayOptional.get());
                movement.setUpdatedBy(parichayOptional.get());
                movement.setCreatedOn(LocalDateTime.now());
                movement.setUpdatedOn(LocalDateTime.now());
                movement.setLevelNo(ApplicationLevel.ZERO.getValue());
                movement.setApplicationType(cghsInchargeApplication.getApplicationType());

                ActionType actionType = actionTypeRepo.findById(ActionTypeEnum.SUBMIT.getValue()).get();
                movement.setActionType(actionType);

                CGHSInchargeApplication cghsinchargeApplication = cghsInchargeApplicationRepo
                        .findByCreatedBy(parichayOptional.get());
                movement.setFromOffice(parichayUser.get().getOrganizationOffice());

                Optional<OrganizationOffice> orgOfficeOptional2 = organizationOfficeRepo
                        .findById(cghsinchargeApplication.getOrganizationOffice().getId());
                if (!orgOfficeOptional2.isPresent())
                    throw new Exception(
                            "Data error:invalid organization office id" + resource.getOrganizationOfficeId());

                // movement.setToOffice(cghsinchargeApplication.getOrganizationOffice());
                movement.setToOffice(orgOfficeOptional2.get());

                movementRepo.save(movement);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retCghsInchargeApplication;
    }

}
