package io.swagger.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.swagger.model.PrimaryBeneficiaryAddress;
import io.swagger.model.RelationshipType;
import io.swagger.model.PrimaryBeneficiary;
import io.swagger.enums.ActionTypeEnum;
import io.swagger.enums.ApplicationLevel;
import io.swagger.enums.ApplicationTypeEnum;
import io.swagger.model.ActionType;
import io.swagger.model.ApplicationNodalOfficerDetail;
import io.swagger.model.ApplicationType;
import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.BloodGroup;
import io.swagger.model.CGHSCity;
import io.swagger.model.CardType;
import io.swagger.model.CghspayScaleBean;
import io.swagger.model.FamilyMember;
import io.swagger.model.Movement;
import io.swagger.model.NodalApplicationDetail;
import io.swagger.model.Organization;
import io.swagger.model.OrganizationOffice;
import io.swagger.model.ParichayUser;
import io.swagger.repository.*;
import io.swagger.resources.PrimaryBeneficiaryResource;
import io.swagger.service.BenRegistrationApplicationService;
import io.swagger.utils.ApplicationNumberGenerator;
import io.swagger.resources.BenRegistrationApplicationResource;
// import io.swagger.resources.FamilyMemberResource.GenderEnum;
import io.swagger.resources.FamilyMemberResource;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

@Service
public class BenRegistrationApplicationServiceImpl implements BenRegistrationApplicationService {

    @Autowired
    private AddressRepo addressrepo;

    @Autowired
    private BenRegistrationApplicationRepo benregistrationrepo;

    @Autowired
    private PrimaryBeneficiaryRepo primarybeneficiaryrepo;

    @Autowired
    private FamilyMemberRepo familymemberepo;
    @Autowired
    private PayscaleRepo payscaleRepo;
    @Autowired
    private ApplicationNumberGenerator applicationnumbergenerator;
    @Autowired
    private ParichayUserRepo parichayRepo;
    @Autowired
    private BenRegistrationApplicationRepo benRegistrationApplicationRepo;
    @Autowired
    private AddressRepo benaddressrepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CardTypeRepo cardTypeRepo;
    @Autowired
    private BloodGroupRepo bloodGroupRepo;
    @Autowired
    private RelationshipTypeRepo relationshipTypeRepo;
    @Autowired
    private ApplicationTypeRepo applicationTypeRepo;
    @Autowired
    private CGHSCityRepo cghsCityRepo;

    @Autowired
	private OrganizationOfficeRepo organizationOfficeRepo;
    @Autowired
	private ActionTypeRepo actionTypeRepo;
    @Autowired
	private MovementRepo movementRepo;

    @Autowired
	private ApplicationNodalOfficerDetailRepo applicationNodalOfficerDetailRepo;

    


    void copyEntityDataToAPIResource(PrimaryBeneficiary primaryBeneficiary, PrimaryBeneficiaryResource resource)
            throws Exception {

        PrimaryBeneficiaryAddress benAddress = benaddressrepo.findByPrimaryBeneficiary(primaryBeneficiary);
        if (benAddress == null)
            throw new Exception("Data inconsistency error - Primary Beneficiary Address can't be found in database");
        BenRegistrationApplicationResource benresource = new BenRegistrationApplicationResource();
        BenRegistrationApplication benRegistrationApplication = primaryBeneficiary.getBenRegistrationApplication();

        benresource.setId(benRegistrationApplication.getId());
        benresource.setApplicationNumber(benRegistrationApplication.getApplicationNumber());
        benresource.setIsDraft(benRegistrationApplication.isDraft());
        benresource.setParichayId(benRegistrationApplication.getParichayId());
        benresource.setEsignedBy(benRegistrationApplication.getSignedBy());

        if (benRegistrationApplication.getSignedOn() != null)
            benresource.setEsignedOn(benRegistrationApplication.getSignedOn());
        if (benRegistrationApplication.getModifiedOn() != null)
            benresource.setUpdatedOn(benRegistrationApplication.getModifiedOn());
        if (benRegistrationApplication.getCreatedOn() != null)
            benresource.setCreatedOn(benRegistrationApplication.getCreatedOn());

        resource.setBenRegistrationApplication(benresource);
        
        resource.setId(primaryBeneficiary.getId());
        resource.setCghsCity(primaryBeneficiary.getCghsCity().getId());
        resource.setCghsCityName(primaryBeneficiary.getCghsCity().getCityName());
        
        resource.setCardTypeCode(primaryBeneficiary.getCardType().getId());
        resource.setCardTypeName(primaryBeneficiary.getCardType().getCardType());
        resource.setPresentPay(primaryBeneficiary.getPresentPay());
        resource.setCentraldeputation(primaryBeneficiary.getCentralDeputation());
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd",
        // Locale.ENGLISH);

        resource.setDob(primaryBeneficiary.getDob());
        resource.setDateOfJoining(primaryBeneficiary.getDateOfJoining());
        resource.setDateOfSuperannuation(primaryBeneficiary.getDateOfSuperannuation());

        resource.setCardTypeCode(primaryBeneficiary.getCardType().getId());
        resource.setCardTypeName(primaryBeneficiary.getCardType().getCardType());

        resource.setEnglishname(primaryBeneficiary.getEnglishname());
        resource.setGender(primaryBeneficiary.getGender());
        resource.setHindiname(primaryBeneficiary.getHindiname());
        resource.setMinistry(primaryBeneficiary.getMinistry());
        resource.setOfficeaddress(benAddress.getOffAddressLineOne());
        resource.setOfficeemail(primaryBeneficiary.getOfficeEmail());
        resource.setOfficephoneno(benAddress.getOfficePhoneno());
        resource.setOfficepincode(primaryBeneficiary.getOfficepincode());
        resource.setOrganization(primaryBeneficiary.getOrganization());
        resource.setPresentPay(primaryBeneficiary.getPresentPay());
        resource.setWardentitlement(primaryBeneficiary.getWardentitlement());
        resource.setDepartment(Integer.toString(primaryBeneficiary.getDeptCode()));
        resource.setIsTransfferable(primaryBeneficiary.isTransfferable());

        resource.setDepuationFlag(primaryBeneficiary.isDepuationFlag());
        resource.setPayScaleCode(primaryBeneficiary.getPayScale().getId());
        resource.setPayScaleName(primaryBeneficiary.getPayScale().getPayscale());
        resource.setPenAuto(primaryBeneficiary.isPenAuto());

        resource.setPresentPay(primaryBeneficiary.getPresentPay());


        resource.setResidentialemail(benAddress.getEmail());

        resource.setResidentialpincode(benAddress.getPinCode());
        resource.setResidentialaddress(benAddress.getResAddressLineOne());
        resource.setResidentialcity(benAddress.getResCity());
        resource.setResidentialplace(benAddress.getResLacality());
        resource.setResidentialphone(benAddress.getResPhoneNo());
        resource.setResidentialmobile(benAddress.getResidentialmobile());

    }

    public PrimaryBeneficiaryResource saveBenRegistrationForm(PrimaryBeneficiaryResource benFormResource) throws Exception {

        System.out.println("benFormResource.getDateOfJoining())-" + benFormResource.getDateOfJoining());
        System.out.println("benFormResource.getdate of supperannuation())-" + benFormResource.getDateOfSuperannuation());

        String parichayId = benFormResource.getParichayId(); // get parichay id of logged in user
        ParichayUser parichayUser = parichayRepo.findByParichayId(parichayId).get();
        PrimaryBeneficiary primarybeneficiarymodel = null;
        try {
            if (benFormResource.getApplicationId() != null) {
                Optional<BenRegistrationApplication> benRegistrationModelOptional = benregistrationrepo
                        .findById(benFormResource.getApplicationId());
                if (!benRegistrationModelOptional.isPresent()) {
                    throw new Exception("Data Error - Invalid Application Id passed in the form data");
                }
                BenRegistrationApplication benregistrationmodel = benRegistrationModelOptional.get();
                primarybeneficiarymodel = benregistrationmodel.getPrimaryBeneficiary();
                if (primarybeneficiarymodel == null) {
                    throw new Exception("Data Error - Primary beneficiary not present in the application");
                }

                // edit and save benregistrationmodel
                benregistrationmodel = primarybeneficiarymodel.getBenRegistrationApplication();
                benregistrationmodel.setModifiedOn(LocalDateTime.now());
                benregistrationmodel.setModifiedBy(parichayUser);
                ApplicationType applicationType = applicationTypeRepo.findById(ApplicationTypeEnum.BeneficiaryEnrollmentApplication.getValue()).get();
                
                benregistrationmodel.setApplicationType(applicationType);
                benregistrationrepo.save(benregistrationmodel);

                // edit and save primaryBeneficiary
                Optional<CardType> optionalCardType = cardTypeRepo.findById(benFormResource.getCardTypeCode());
                if(!optionalCardType.isPresent())
                throw new Exception("Data error: invalid card type code");

                primarybeneficiarymodel.setCardType(optionalCardType.get());
                primarybeneficiarymodel.setCentralDeputation(benFormResource.getCentraldeputation());
                
                primarybeneficiarymodel.setDob(benFormResource.getDob());

                primarybeneficiarymodel.setEnglishname(benFormResource.getEnglishname());
                primarybeneficiarymodel.setGender(benFormResource.getGender());
                primarybeneficiarymodel.setHindiname(benFormResource.getHindiname());
                primarybeneficiarymodel.setMinistry(benFormResource.getMinistry());
                primarybeneficiarymodel.setOfficeAddress(benFormResource.getOfficeaddress());
                primarybeneficiarymodel.setOfficeEmail(benFormResource.getOfficeemail());
                primarybeneficiarymodel.setOfficePhoneno(benFormResource.getOfficephoneno());
                primarybeneficiarymodel.setOfficepincode(benFormResource.getOfficepincode());
                primarybeneficiarymodel.setOrganization(benFormResource.getOrganization());

                // save org office here
                Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(benFormResource.getOrganizationOfficeId());
				if(!orgOfficeOptional.isPresent())
					throw new Exception("Data error:invalid organization office id"+benFormResource.getOrganizationOfficeId());
				
                primarybeneficiarymodel.setOrganizationOffice(orgOfficeOptional.get());

                // save org office in parichay User
                parichayUser.setOrganizationOffice(orgOfficeOptional.get());
				parichayRepo.save(parichayUser);

                Optional<CghspayScaleBean> optionalPayBean = payscaleRepo.findById(benFormResource.getPayScaleCode());
                if(!optionalPayBean.isPresent())
                    throw new Exception("Data error: invalid pay scale code");
                primarybeneficiarymodel.setPayScale(optionalPayBean.get());
                primarybeneficiarymodel.setPresentPay(benFormResource.getPresentPay());
                
                Optional<CGHSCity> optionalCGHSCity = cghsCityRepo.findById(benFormResource.getCghsCity());
                if(!optionalCGHSCity.isPresent())
                    throw new Exception("Data error: invalid CGHS City code");
                    
                primarybeneficiarymodel.setCghsCity(optionalCGHSCity.get());

                primarybeneficiarymodel.setWardentitlement(benFormResource.getWardentitlement());
                primarybeneficiarymodel.setBenRegistrationApplication(benregistrationmodel);
                primarybeneficiarymodel.setDeptCode(Integer.parseInt(benFormResource.getDepartment()));
                primarybeneficiarymodel.setModifiedOn(LocalDateTime.now());
                primarybeneficiarymodel.setModifiedBy(parichayUser);
                primarybeneficiarymodel.setDateOfJoining(benFormResource.getDateOfJoining());
                primarybeneficiarymodel.setDateOfSuperannuation(benFormResource.getDateOfSuperannuation());

                // if (benFormResource.getDateOfJoining().length() > 10)
                // primarybeneficiarymodel.setDateOfJoining(LocalDate.parse(benFormResource.getDateOfJoining(),
                // formatterLong));
                // else
                // primarybeneficiarymodel.setDateOfJoining(LocalDate.parse(benFormResource.getDateOfJoining(),
                // formatterShort));

                // if (benFormResource.getDateOfSuperannuation().length() > 10)
                // primarybeneficiarymodel
                // .setDateOfSuperannuation(LocalDate.parse(benFormResource.getDateOfSuperannuation(),
                // formatterLong));
                // else
                // primarybeneficiarymodel
                // .setDateOfSuperannuation(LocalDate.parse(benFormResource.getDateOfSuperannuation(),
                // formatterShort));
                
                primarybeneficiarymodel = primarybeneficiaryrepo.save(primarybeneficiarymodel);
               // PrimaryBeneficiaryAddress addressmodel = this.modelMapper.map(benFormResource, PrimaryBeneficiaryAddress.class);
                // save address model
                PrimaryBeneficiaryAddress addressmodel = primarybeneficiarymodel.getPrimaryBeneficiaryAddress();
                addressmodel.setPrimaryBeneficiary(primarybeneficiarymodel);
                addressmodel.setResAddressLineOne(benFormResource.getResidentialaddress());
                addressmodel.setResLacality(benFormResource.getResidentialplace());
                addressmodel.setResCity(benFormResource.getResidentialcity());
                addressmodel.setPinCode(benFormResource.getResidentialpincode());
                addressmodel.setResPhoneNo(benFormResource.getResidentialphone());
                addressmodel.setEmail(benFormResource.getResidentialemail());
                addressmodel.setOfficePhoneno(benFormResource.getOfficephoneno());
                addressmodel.setResidentialmobile(benFormResource.getResidentialmobile());
                addressmodel.setOffAddressLineOne(benFormResource.getOfficeaddress());
                addressmodel.setModifiedOn(LocalDateTime.now());
                addressmodel.setModifiedBy(parichayUser);

                addressrepo.save(addressmodel);
                benregistrationrepo.save(benregistrationmodel);
                benregistrationmodel.setApplicationNumber(applicationnumbergenerator
                        .generateApplicationNumber(ApplicationTypeEnum.BeneficiaryEnrollmentApplication));
                benregistrationrepo.save(benregistrationmodel);

                Optional<Movement> movementOpt = movementRepo.findByApplication(benregistrationmodel);
                if(movementOpt.isPresent()){
                    throw new Exception("Data error, Movement already created");
                }
                Movement movement = new Movement();
                movement.setApplication(benregistrationmodel);
				movement.setCreatedBy(parichayUser);
				movement.setUpdatedBy(parichayUser);
				movement.setCreatedOn(LocalDateTime.now());
				movement.setUpdatedOn(LocalDateTime.now());
				movement.setLevelNo(ApplicationLevel.ZERO.getValue());
				movement.setApplicationType(benregistrationmodel.getApplicationType());

                //  get the action_type
				ActionType actionType = actionTypeRepo.findById(ActionTypeEnum.SUBMIT.getValue()).get();
				movement.setActionType(actionType);
                // movement.setCghsCity(optionalCGHSCity.get());
				//set from office here
				movement.setFromUserId(parichayUser);
                movement.setFromOffice(orgOfficeOptional.get());
                // set to office here
                ApplicationNodalOfficerDetail applicationNodalOfficerDetail = applicationNodalOfficerDetailRepo.findByOrganizationOffice(benFormResource.getOrganizationOfficeId());
                if(applicationNodalOfficerDetail == null){
                    throw new Exception("Data error, Nodal Office not existing.");
                }
                movement.setToOffice(applicationNodalOfficerDetail.getOrganizationOffice());
				movement.setNew(true);
                movementRepo.save(movement);

            } else {

                // create primary beneficiary model
                primarybeneficiarymodel = new PrimaryBeneficiary();
                // create BenRegistrationModel
                BenRegistrationApplication benregistrationmodel = new BenRegistrationApplication();
                primarybeneficiarymodel.setBenRegistrationApplication(benregistrationmodel);



                // save the created BenRegistrationModel

                benregistrationmodel.setDraft(true);
                benregistrationmodel.setParichayId(benFormResource.getParichayId());
                benregistrationmodel.setFinal(false);
                benregistrationmodel.setCreatedOn(LocalDateTime.now());
                benregistrationmodel.setModifiedOn(LocalDateTime.now());
                benregistrationmodel.setCreatedBy(parichayUser);
                benregistrationmodel.setModifiedBy(parichayUser);

                // benregistrationmodel.setEsignedBy(null);(false);
                // set application_type here
                ApplicationType applicationType = applicationTypeRepo.findById(ApplicationTypeEnum.BeneficiaryEnrollmentApplication.getValue()).get();
                
                benregistrationmodel.setApplicationType(applicationType);
                benregistrationrepo.save(benregistrationmodel);
                // benFormResource.setBenRegistrationApplication(benregistrationmodel);

                // save the created primary beneficiary model
                Optional<CardType> optionalCardType = cardTypeRepo.findById(benFormResource.getCardTypeCode());
                if(!optionalCardType.isPresent())
                    throw new Exception("Data error: invalid card type code");
                primarybeneficiarymodel.setCardType(optionalCardType.get());
                primarybeneficiarymodel.setCentralDeputation(benFormResource.getCentraldeputation());
            
                primarybeneficiarymodel.setDob(benFormResource.getDob());

                primarybeneficiarymodel.setEnglishname(benFormResource.getEnglishname());
                primarybeneficiarymodel.setGender(benFormResource.getGender());
                primarybeneficiarymodel.setHindiname(benFormResource.getHindiname());
                primarybeneficiarymodel.setMinistry(benFormResource.getMinistry());
                primarybeneficiarymodel.setOfficeAddress(benFormResource.getOfficeaddress());
                primarybeneficiarymodel.setOfficeEmail(benFormResource.getOfficeemail());
                primarybeneficiarymodel.setOfficePhoneno(benFormResource.getOfficephoneno());
                primarybeneficiarymodel.setOfficepincode(benFormResource.getOfficepincode());
                primarybeneficiarymodel.setOrganization(benFormResource.getOrganization());
                Optional<CghspayScaleBean> optionalPayBean = payscaleRepo.findById(benFormResource.getPayScaleCode());
                if(!optionalPayBean.isPresent())
                    throw new Exception("Data error: invalid pay scale code");

                primarybeneficiarymodel.setPayScale(optionalPayBean.get());
                primarybeneficiarymodel.setPresentPay(benFormResource.getPresentPay());

                Optional<CGHSCity> optionalCGHSCity = cghsCityRepo.findById(benFormResource.getCghsCity());
                if(!optionalCGHSCity.isPresent())
                    throw new Exception("Data error: invalid CGHS City code");

                primarybeneficiarymodel.setCghsCity(optionalCGHSCity.get());
                primarybeneficiarymodel.setWardentitlement(benFormResource.getWardentitlement());
                primarybeneficiarymodel.setBenRegistrationApplication(benregistrationmodel);
                primarybeneficiarymodel.setDeptCode(Integer.parseInt(benFormResource.getDepartment()));

                primarybeneficiarymodel.setCreatedBy(parichayUser);
                primarybeneficiarymodel.setModifiedBy(parichayUser);
                primarybeneficiarymodel.setCreatedOn(LocalDateTime.now());
                primarybeneficiarymodel.setModifiedOn(LocalDateTime.now());

                primarybeneficiarymodel.setDateOfJoining(benFormResource.getDateOfJoining());
                primarybeneficiarymodel.setDateOfSuperannuation(benFormResource.getDateOfSuperannuation());

                // set organization office here
                Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(benFormResource.getOrganizationOfficeId());
				if(!orgOfficeOptional.isPresent())
					throw new Exception("Data error:invalid organization office id"+benFormResource.getOrganizationOfficeId());
				
                primarybeneficiarymodel.setOrganizationOffice(orgOfficeOptional.get());

                // primarybeneficiarymodel = primarybeneficiaryrepo.save(primarybeneficiarymodel);

                primarybeneficiarymodel = primarybeneficiaryrepo.save(primarybeneficiarymodel);
                benFormResource.setId(primarybeneficiarymodel.getId());

                // save address model
                PrimaryBeneficiaryAddress addressmodel =new PrimaryBeneficiaryAddress();
                addressmodel.setPrimaryBeneficiary(primarybeneficiarymodel);

                addressmodel.setResAddressLineOne(benFormResource.getResidentialaddress());
                addressmodel.setResLacality(benFormResource.getResidentialplace());
                addressmodel.setResCity(benFormResource.getResidentialcity());
                addressmodel.setPinCode((benFormResource.getResidentialpincode()));
                addressmodel.setResPhoneNo(benFormResource.getResidentialphone());
                addressmodel.setEmail(benFormResource.getResidentialemail());
                addressmodel.setOfficePhoneno(benFormResource.getOfficephoneno());
                addressmodel.setResidentialmobile(benFormResource.getResidentialmobile());
                addressmodel.setOffAddressLineOne(benFormResource.getOfficeaddress());
                addressmodel.setCreatedBy(parichayUser);
                addressmodel.setModifiedBy(parichayUser);
                addressmodel.setCreatedOn(LocalDateTime.now());
                addressmodel.setModifiedOn(LocalDateTime.now());
                addressrepo.save(addressmodel);

                // generate application number for new applications
                benregistrationmodel.setApplicationNumber(applicationnumbergenerator
                        .generateApplicationNumber(ApplicationTypeEnum.BeneficiaryEnrollmentApplication));
                // updaten the application number in the database

                benregistrationrepo.save(benregistrationmodel);

                Movement movement = new Movement();
				movement.setApplication(benregistrationmodel);
				movement.setCreatedBy(parichayUser);
				movement.setUpdatedBy(parichayUser);
				movement.setCreatedOn(LocalDateTime.now());
				movement.setUpdatedOn(LocalDateTime.now());
				movement.setLevelNo(ApplicationLevel.ZERO.getValue());
				movement.setApplicationType(benregistrationmodel.getApplicationType());

                //  get the action_type
				ActionType actionType = actionTypeRepo.findById(ActionTypeEnum.SUBMIT.getValue()).get();
				movement.setActionType(actionType);

				//set from office here
				movement.setFromUserId(parichayUser);
                movement.setFromOffice(orgOfficeOptional.get());
				// set thatin  movement.setToUserId(
                // Optional<OrganizationOffice> orgOfficeOptional2 = organizationOfficeRepo.findById(benFormResource.getOrganizationOfficeId());
				// if(!orgOfficeOptional2.isPresent())
				// 	throw new Exception("Data error: invalid organization code "+ benFormResource.getOrganization());
                // set to office here
                ApplicationNodalOfficerDetail applicationNodalOfficerDetail = applicationNodalOfficerDetailRepo.findByOrganizationOffice(benFormResource.getOrganizationOfficeId());
                if(applicationNodalOfficerDetail == null){
                    throw new Exception("Data error, Nodal Office not existing.");
                }
                movement.setToOffice(applicationNodalOfficerDetail.getOrganizationOffice());
				movement.setNew(true);
                // movement.setCghsCity(optionalCGHSCity.get());
				movementRepo.save(movement);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {

        }
        // create new resource object
        benFormResource = new PrimaryBeneficiaryResource();
        copyEntityDataToAPIResource(primarybeneficiarymodel, benFormResource);

        // primarybeneficiaryrepo.save(primarybeneficiarymodel);
        System.out.println("save all");

        return benFormResource;

    }

    public FamilyMember saveFamilyMember(FamilyMemberResource familyFormResource) throws Exception {
        System.out.println("familyFormResource call");
        System.out.println("familyFormResource.getId>>>" + familyFormResource.getId());
        System.out.println("familyFormResource.dob>>>" + familyFormResource.getDateOfBirth());
        BenRegistrationApplication benRegistrationApplication = benRegistrationApplicationRepo
                .findById(familyFormResource.getApplicationId()).get();
        PrimaryBeneficiary primaryObject = benRegistrationApplication.getPrimaryBeneficiary();

        System.out.println(primaryObject);

        String parichayId = familyFormResource.getParichayId(); // get parichay id of logged in user
        ParichayUser parichayUser = parichayRepo.findByParichayId(parichayId).get();
        FamilyMember familyObject = new FamilyMember();

        
        if (familyFormResource.getId() != null) {
            familyObject = familymemberepo.findById(familyFormResource.getId()).get();
            System.out.println("familyObject>>." + familyObject);
            familyObject.setEnglishName(familyFormResource.getEnglishName());
            familyObject.setHindiName(familyFormResource.getHindiName());
            familyObject.setDateOfBirth(familyFormResource.getDateOfBirth());
            familyObject.setOtpVerify(familyFormResource.getOtpVerify());
            familyObject.setCreatedOn(LocalDateTime.now());
            familyObject.setModifiedOn(LocalDateTime.now());
           familyObject.setGender(familyFormResource.getGender());
            Optional<BloodGroup> optional = bloodGroupRepo.findById(familyFormResource.getBloodGroupCode());
            if (!optional.isPresent())
                throw new Exception("Data error: Invalid blood group code ");

            Optional<RelationshipType> optional1 = relationshipTypeRepo.findById(familyFormResource.getRelationCode());
            if (!optional1.isPresent())
                throw new Exception("Data error: Invalid relationship code ");

            familyObject.setBloodGroup(optional.get());
            familyObject.setRelationshipType(optional1.get());

            familymemberepo.save(familyObject);
        } else {
            familyObject = new FamilyMember();
            BeanUtils.copyProperties(familyFormResource, familyObject);

            familyObject.setDateOfBirth(familyFormResource.getDateOfBirth());
            familyObject.setOtpVerify(familyFormResource.getOtpVerify());

            Optional<BloodGroup> optional = bloodGroupRepo.findById(familyFormResource.getBloodGroupCode());
            if (!optional.isPresent())
                throw new Exception("Data error: Invalid blood group code ");

            familyObject.setBloodGroup(optional.get());
            Optional<RelationshipType> optional1 = relationshipTypeRepo.findById(familyFormResource.getRelationCode());

            if (!optional1.isPresent())
                throw new Exception("Data error: Invalid relationship code ");
            familyObject.setRelationshipType(optional1.get());
            familyObject.setCreatedBy(parichayUser);
            familyObject.setModifiedBy(parichayUser);
            familyObject.setCreatedOn(LocalDateTime.now());
            familyObject.setModifiedOn(LocalDateTime.now());
            familyObject.setPrimaryBeneficiary(primaryObject);
            familymemberepo.save(familyObject);
        }
        return familyObject;
    }
}
