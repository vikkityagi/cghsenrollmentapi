package io.swagger.api;

import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.ParichayUser;
import io.swagger.model.PrimaryBeneficiary;
import io.swagger.model.PrimaryBeneficiaryAddress;
import io.swagger.model.Role;
import io.swagger.model.RoleRegistration;
import io.swagger.repository.AddressRepo;
import io.swagger.repository.ApplicationNumberSequenceRepo;
import io.swagger.repository.BenRegistrationApplicationRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.repository.PrimaryBeneficiaryRepo;
import io.swagger.repository.RoleRegistrationRepo;
import io.swagger.repository.RoleRepo;
import io.swagger.resources.BenRegistrationApplicationResource;
import io.swagger.resources.PrimaryBeneficiaryResource;
import io.swagger.service.BenRegistrationApplicationService;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class PrimaryBeneficiaryResourceController implements PrimaryBeneficiaryResourceApi {

    private static final Logger log = LoggerFactory.getLogger(PrimaryBeneficiaryResourceController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private BenRegistrationApplicationService benregistrationapplicationservice;

    @Autowired
    private BenRegistrationApplicationRepo benRegistrationRepo;

    @Autowired
    private PrimaryBeneficiaryRepo repo;

    @Autowired
    private AddressRepo benaddressrepo;



    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ParichayUserRepo parichayRepo;

    @Autowired
    private RoleRepo rolerepo;

    @Autowired
    private RoleRegistrationRepo roleRegistrationRepo;
    @Autowired
    private ApplicationNumberSequenceRepo applicationNumberSequenceRepo;
    @Autowired
    private PrimaryBeneficiaryRepo primaryBeneficiaryRepo;

    

    @org.springframework.beans.factory.annotation.Autowired
    public PrimaryBeneficiaryResourceController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PrimaryBeneficiaryResource> create(
            @Parameter(in = ParameterIn.DEFAULT, description = "Create a new beneficiaries", required = true, schema = @Schema()) @Valid @RequestBody PrimaryBeneficiaryResource body) {
        System.out.println("controller run");
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                System.out.println("body.id" + body.getId());
                PrimaryBeneficiaryResource primarybenresource = benregistrationapplicationservice
                        .saveBenRegistrationForm(body);
                if(primarybenresource==null){
                    return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
                }

                String parichayId = body.getParichayId(); // get parichay id of logged in user
                ParichayUser parichayUser = parichayRepo.findByParichayId(parichayId).get();
                RoleRegistration roleRegistration = new RoleRegistration();

                System.out.println(
                        "**********************************************Parichayuser in primary beneficiary**********"
                                + parichayUser);
                if (parichayId == null || parichayUser == null) {
                    return new ResponseEntity<PrimaryBeneficiaryResource>(HttpStatus.INTERNAL_SERVER_ERROR);
                } else {
                    // get the role befor
                    Role benRole = rolerepo.findById(1l).get();
                    System.out.println("beforebenrole>>" + benRole);
                    if (!parichayUser.getRolelist().contains(benRole)) {
                        parichayUser.getRolelist().add(benRole);
                        parichayRepo.save(parichayUser);

                    }

                }

                return new ResponseEntity<PrimaryBeneficiaryResource>(primarybenresource, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PrimaryBeneficiaryResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PrimaryBeneficiaryResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<PrimaryBeneficiaryResource>> list(
            @Parameter(in = ParameterIn.QUERY, description = "Ben registration Id" ,schema=@Schema()) @Valid @RequestParam(value = "ben_registration_id", required = false) Long benRegistrationId) {
        String accept = request.getHeader("Accept");
        List<PrimaryBeneficiaryResource> list = new ArrayList<>();
        if (accept != null || accept.contains("application/json")) {
            try {
                if(benRegistrationId!=null && benRegistrationId!=0){
                    Optional<BenRegistrationApplication> benRegistrationAppOptional = benRegistrationRepo.findById(benRegistrationId);
                    if(!benRegistrationAppOptional.isPresent())
                        throw new Exception("Data error: invalid ben registration id");
                    BenRegistrationApplication  benRegistrationApp = benRegistrationAppOptional.get();
                    PrimaryBeneficiary primaryBeneficiary = primaryBeneficiaryRepo.findByBenRegistrationApplication(benRegistrationApp);
                    PrimaryBeneficiaryResource resource = new PrimaryBeneficiaryResource();
                    copyEntityDataToAPIResource(primaryBeneficiary,resource);
                    list.add(resource);
                }
                return new ResponseEntity<List<PrimaryBeneficiaryResource>>(list,HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<PrimaryBeneficiaryResource>>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<List<PrimaryBeneficiaryResource>>(HttpStatus.NOT_IMPLEMENTED);
    }

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

        resource.setBenRegistrationApplication(benresource);

        resource.setId(primaryBeneficiary.getId());
        resource.setCardTypeCode(primaryBeneficiary.getCardType().getId());
        resource.setCardTypeName(primaryBeneficiary.getCardType().getCardType());
        resource.setPresentPay(primaryBeneficiary.getPresentPay());
        resource.setCentraldeputation(primaryBeneficiary.getCentralDeputation());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        resource.setDob(primaryBeneficiary.getDob());
        resource.setDateOfJoining(primaryBeneficiary.getDateOfJoining());
        resource.setDateOfSuperannuation(primaryBeneficiary.getDateOfSuperannuation());
        resource.setEnglishname(primaryBeneficiary.getEnglishname());
        resource.setGender(primaryBeneficiary.getGender());
        resource.setHindiname(primaryBeneficiary.getHindiname());
        resource.setMinistry(primaryBeneficiary.getMinistry());
        resource.setOfficeaddress(benAddress.getOffAddressLineOne());
        resource.setOfficeemail(primaryBeneficiary.getOfficeEmail());
        resource.setOfficephoneno(benAddress.getOfficePhoneno());
        resource.setOfficepincode(primaryBeneficiary.getOfficepincode());
        resource.setOrganization(primaryBeneficiary.getOrganization());
        resource.setPayScaleCode(primaryBeneficiary.getPayScale().getId());
        resource.setPayScaleName(primaryBeneficiary.getPayScale().getPayscale());

        resource.setCghsCityName(primaryBeneficiary.getCghsCity().getCityName());
        resource.setCghsCity(primaryBeneficiary.getCghsCity().getId());
        
        resource.setWardentitlement(primaryBeneficiary.getWardentitlement());
        resource.setDepartment(Integer.toString(primaryBeneficiary.getDeptCode()));
        resource.setIsTransfferable(primaryBeneficiary.isTransfferable());
        resource.setDepuationFlag(primaryBeneficiary.isDepuationFlag());
        resource.setPenAuto(primaryBeneficiary.isPenAuto());


        resource.setResidentialemail(benAddress.getEmail());

        resource.setResidentialpincode(benAddress.getPinCode());
        resource.setResidentialaddress(benAddress.getResAddressLineOne());
        resource.setResidentialcity(benAddress.getResCity());
        resource.setResidentialplace(benAddress.getResLacality());
        resource.setResidentialphone(benAddress.getResPhoneNo());
        resource.setResidentialmobile(benAddress.getResidentialmobile());
    }

    public ResponseEntity<PrimaryBeneficiaryResource> get(
            @Parameter(in = ParameterIn.PATH, description = "GEt details of primary card holder", required = true, schema = @Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
                if (id != null) {
                    Optional<PrimaryBeneficiary> primaryBeneficiaryRepo = repo.findById(id);
                    if (!primaryBeneficiaryRepo.isPresent())
                        throw new Exception("Data error: invalid primary beneficary id");
                    PrimaryBeneficiary primaryBeneficiary = primaryBeneficiaryRepo.get();
                    BenRegistrationApplication benRegistrationApplication = primaryBeneficiary
                            .getBenRegistrationApplication();
                    String applicationNumber = benRegistrationApplication.getApplicationNumber();

                    PrimaryBeneficiaryResource resource = new PrimaryBeneficiaryResource();

                    copyEntityDataToAPIResource(primaryBeneficiary, resource);
                    
                    System.out.println(resource);
                    return new ResponseEntity<PrimaryBeneficiaryResource>(resource, HttpStatus.OK);
                } else {
                    return new ResponseEntity<PrimaryBeneficiaryResource>(HttpStatus.OK);
                }

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PrimaryBeneficiaryResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<PrimaryBeneficiaryResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    
}
