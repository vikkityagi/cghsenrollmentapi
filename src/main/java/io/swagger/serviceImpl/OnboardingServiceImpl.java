package io.swagger.serviceImpl;

import org.nic.eoffice.esign.EsignResponse;
import org.nic.eoffice.esign.hash.TextSigning;
import org.nic.eoffice.esign.model.DocSignatureResponse;
import org.nic.eoffice.esign.model.EsignRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

import io.swagger.model.OnboardingApplication;
import io.swagger.model.ParichayUser;
import io.swagger.model.SigningInfo;
import io.swagger.repository.ApplicationTypeRepo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import io.swagger.enums.ActionTypeEnum;
import io.swagger.enums.ApplicationLevel;
import io.swagger.enums.ApplicationTypeEnum;
import io.swagger.model.ActionType;
import io.swagger.model.ApprovingAuthority;
import io.swagger.model.ApprovingAuthorityUser;
import io.swagger.model.ApprovingPdf;
import io.swagger.model.CGHSCity;
import io.swagger.model.CghspayScaleBean;
import io.swagger.model.ESignCertificateDetail;
import io.swagger.model.ESignRequestObject;
import io.swagger.model.Movement;
import io.swagger.model.NodalApplicationDetail;
import io.swagger.model.ApplicationNodalOfficerDetail;
import io.swagger.model.ApplicationType;
import io.swagger.model.NodalPdf;
import io.swagger.model.NodalUser;
import io.swagger.model.Organization;
import io.swagger.model.OrganizationOffice;
import io.swagger.repository.ActionTypeRepo;
import io.swagger.repository.ApplicationNodalOfficerDetailRepo;
import io.swagger.repository.ApprovingAuthorityUserRepo;
import io.swagger.repository.ApprovingPdfRepo;
import io.swagger.repository.ApprovingRepo;
import io.swagger.repository.CGHSCityRepo;
import io.swagger.repository.DepartmentRepo;
import io.swagger.repository.ESignCertificateDetailRepository;
import io.swagger.repository.MinistryRepo;
import io.swagger.repository.MovementRepo;
import io.swagger.repository.NodalApplicationDetailRepo;
import io.swagger.repository.OrganizationOfficeRepo;
import io.swagger.repository.NodalPdfRepo;
import io.swagger.repository.NodalUserRepo;
import io.swagger.repository.OrganizationRepo;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.repository.PayscaleRepo;
import io.swagger.repository.SigningInfoRepo;
import io.swagger.repository.StateRepo;
import io.swagger.service.Detail;
import io.swagger.service.EsignClientServiceImp;
import io.swagger.service.OnboardingService;
import io.swagger.utils.ApplicationNumberGenerator;
import io.swagger.utils.CertificateIssueInfo;
import io.swagger.utils.CertificateSignerInfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

import org.apache.commons.codec.binary.Base64;
import org.modelmapper.ModelMapper;

@PropertySource(value = "classpath:global.properties")
@Service
public class OnboardingServiceImpl implements OnboardingService {
    @Value("${url.gatewayUrl}")
	String gatewayUrl;

	@Autowired
	private ModelMapper modelMapper;

    @Autowired
	ApplicationTypeRepo applicationTypeRepo;

	@Autowired
	private CGHSCityRepo cghsCityRepo;
	@Autowired
	private StateRepo stateRepo;
	@Autowired
	private MovementRepo movementRepo;

	@Autowired
	private ApprovingRepo approvingRepo;
	
	@Autowired
	private NodalApplicationDetailRepo nodalApplicationDetailRepo;
	@Autowired
	private OrganizationOfficeRepo organizationOfficeRepo;

	@Autowired
	private MinistryRepo ministryRepo;
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private OrganizationRepo organizationRepo;
	@Autowired
	private NodalPdfRepo nodalPdfRepo;

	@Autowired
	private ApprovingPdfRepo approvingPdfRepo;
	@Autowired
	private ActionTypeRepo actionTypeRepo;

	@Autowired
	private PayscaleRepo payscaleRepo;


	@Autowired
	EsignClientServiceImp clientService;

	@Autowired
	private ParichayUserRepo parichayRepo;

	@Autowired
	ApplicationNumberGenerator applicationNumberGenerator;

	@Autowired
	ApprovingAuthorityUserRepo approvingAuthorityUserRepo;

	@Autowired
	ApplicationNodalOfficerDetailRepo applicationNodalOfficerDetailRepo;

    @Autowired
	private ESignCertificateDetailRepository eSignCertificateDetailRepository;

    @Autowired
    private SigningInfoRepo signingInfoRepo;
    @Autowired
    private NodalUserRepo nodalUserRepo;

    @Autowired
	private Detail detailservice;

    private OnboardingApplication prepareOnboardingApplication(NodalApplicationDetail detail) {
        OnboardingApplication onboardingApplication = new OnboardingApplication();
		String title = "", firstname = "", middlename = "", lastname = "";
		if (detail == null) {
			return null; 
		}
		System.out.println("detail>>" + detail);
		if (detail != null) {
			String[] data = detail.getNodalOfficer().getName().split(" ");
			title = data[0];
			firstname = data[1];
			middlename = data[2];
			lastname = data[3];
		}

		System.out.println("title" + title);
		System.out.println("firstname" + firstname);
		System.out.println("middlename" + middlename);
		System.out.println("lastname" + lastname);
		// nodal detail
		long applicationId = detail.getId();
		onboardingApplication.setId(applicationId);
		onboardingApplication.setTitle(title);
		onboardingApplication.setSignedon(detail.getSignedOn());
		onboardingApplication.setIssigned(detail.isSigned());
		onboardingApplication.setSignedby(detail.getSignedBy());
		onboardingApplication.setApplicationnumber(detail.getApplicationNumber());
		onboardingApplication.setFirstname(firstname);
		onboardingApplication.setMiddlename(middlename);
		onboardingApplication.setLastname(lastname);
		onboardingApplication.setDesignation(detail.getNodalOfficer().getDesignation());
		onboardingApplication.setEmployeeid(detail.getNodalOfficer().getEmployeeid());



		onboardingApplication.setDob(detail.getNodalOfficer().getDob()); 
		onboardingApplication.setSuperannuation(detail.getNodalOfficer().getSuperannuation());
		onboardingApplication.setPayscaleCode(detail.getNodalOfficer().getPresentpaylevel().getId());
		onboardingApplication.setPayscaleName(detail.getNodalOfficer().getPresentpaylevel().getPayscale());

		onboardingApplication.setEmail(detail.getNodalOfficer().getEmail());
		onboardingApplication.setPhoneno1(detail.getNodalOfficer().getLandline());
		onboardingApplication.setPhoneno2(detail.getNodalOfficer().getMno());
		onboardingApplication.setMinistry(detail.getNodalOfficer().getMinistry().getMinistryCode());
		onboardingApplication.setDepartment(detail.getNodalOfficer().getDepartment().getDepartmentCode());
		onboardingApplication.setOrganization(detail.getNodalOfficer().getOrganization().getOrganizationCode());
		onboardingApplication.setOrganizationOfficeName(detail.getNodalOfficer().getOrganizationOffice().getOfficeName());
		
		onboardingApplication.setCity(detail.getNodalOfficer().getCity());
		onboardingApplication.setState(detail.getNodalOfficer().getState().getId());
		onboardingApplication.setDistrict(detail.getNodalOfficer().getDistrict());
		onboardingApplication.setPincode2(detail.getNodalOfficer().getPincode());
		onboardingApplication.setOaddress(detail.getNodalOfficer().getOaddress());
		// approving detail
		onboardingApplication.setEnglishname(detail.getApprovingAuthority().getName());
		onboardingApplication.setApprovingdesignation(detail.getApprovingAuthority().getDesignation());
		onboardingApplication.setApprovingemployeeid(detail.getApprovingAuthority().getEmployeeId());
		onboardingApplication.setApprovingemail(detail.getApprovingAuthority().getEmailAddress());
		onboardingApplication.setPhoneno3(detail.getApprovingAuthority().getLandline());
		onboardingApplication.setPhoneno4(detail.getApprovingAuthority().getMobileNo());

		onboardingApplication.setCreatedOn(detail.getCreatedOn());
		onboardingApplication.setUpdatedOn(detail.getUpdatedOn());

		Long[] cityIds = new Long[detail.getCghsCities().size()];
		int index = 0;
		for (CGHSCity city : detail.getCghsCities())
			cityIds[index++] = city.getId();

		onboardingApplication.setCghsCities(cityIds);
		onboardingApplication.setStrength(detail.getStrength());
		return onboardingApplication;
    }



    @Override
    public OnboardingApplication create(OnboardingApplication onboardingApplication) {
        // TODO Auto-generated method stub
        try{
            ParichayUser parichayUser = parichayRepo.findByParichayId(onboardingApplication.getParichayId()).get();
			NodalUser nodalUser = nodalUserRepo.findByParichayId(parichayUser.getId());
				ApplicationNodalOfficerDetail applicationNodalOfficerDetail = new ApplicationNodalOfficerDetail();
				ApprovingAuthority approving = new ApprovingAuthority();
				NodalApplicationDetail applicationdetail = new NodalApplicationDetail();
  
				NodalPdf nodalpdf = new NodalPdf();
				ApprovingPdf approvingpdf = new ApprovingPdf();

				// nodal officer data
				// ApplicationNodalOfficerDetail applicationNodalOfficerDetail = this.modelMapper.map(onboardingApplication,ApplicationNodalOfficerDetail.class);
				applicationNodalOfficerDetail.setTitle(onboardingApplication.getTitle());
				applicationNodalOfficerDetail.setFirstname(onboardingApplication.getFirstname());
				applicationNodalOfficerDetail.setMiddlename(onboardingApplication.getMiddlename());
				applicationNodalOfficerDetail.setLastname(onboardingApplication.getLastname());
				applicationNodalOfficerDetail.setName(onboardingApplication.getTitle() + " " + onboardingApplication.getFirstname() + " " + onboardingApplication.getMiddlename() + " "
						+ onboardingApplication.getLastname());
				// applicationNodalOfficerDetail.setDesignation(onboardingApplication.getDesignation());
				applicationNodalOfficerDetail.setDesignation(nodalUser.getDesignation());
				// applicationNodalOfficerDetail.setEmployeeid(onboardingApplication.getEmployeeid());
				applicationNodalOfficerDetail.setEmployeeid(nodalUser.getEmpCode());
				applicationNodalOfficerDetail.setDob(onboardingApplication.getDob());
				applicationNodalOfficerDetail.setSuperannuation(onboardingApplication.getSuperannuation());

				  

				Optional<CghspayScaleBean> optionalPay = payscaleRepo.findById(onboardingApplication.getPayscaleCode());
				if(!optionalPay.isPresent())
					throw new Exception("Data error: pay scale code is wrong");
				applicationNodalOfficerDetail.setPresentpaylevel(optionalPay.get());


				applicationNodalOfficerDetail.setEmail(onboardingApplication.getEmail());
				// applicationNodalOfficerDetail.setEmail(onboardingApplication.getEmail());
				applicationNodalOfficerDetail.setEmail(nodalUser.getEmail());
				applicationNodalOfficerDetail.setLandline(onboardingApplication.getPhoneno1());
				// applicationNodalOfficerDetail.setMno(onboardingApplication.getPhoneno2());
				applicationNodalOfficerDetail.setMno(nodalUser.getMobileNo());

				applicationNodalOfficerDetail.setMinistry(ministryRepo.findById(onboardingApplication.getMinistry()).get());
				applicationNodalOfficerDetail.setDepartment(departmentRepo.findById(onboardingApplication.getDepartment()).get());
				applicationNodalOfficerDetail.setOrganization(organizationRepo.findById(onboardingApplication.getOrganization()).get());
				
				// save orgofficeid
				Optional<OrganizationOffice> orgOfficeOptional= organizationOfficeRepo.findById(onboardingApplication.getOrganizationOfficeId());
				if(!orgOfficeOptional.isPresent())
					throw new Exception("Data error:invalid organization office id"+onboardingApplication.getOrganizationOfficeId());
				
				applicationNodalOfficerDetail.setOrganizationOffice(orgOfficeOptional.get());

				// save org office in parichay
				parichayUser.setOrganizationOffice(orgOfficeOptional.get());
				parichayRepo.save(parichayUser);

				applicationNodalOfficerDetail.setCity(onboardingApplication.getCity());
				applicationNodalOfficerDetail.setState(stateRepo.findById(onboardingApplication.getState()).get());
				applicationNodalOfficerDetail.setDistrict(onboardingApplication.getDistrict());
				applicationNodalOfficerDetail.setPincode(onboardingApplication.getPincode2());
				applicationNodalOfficerDetail.setOaddress(onboardingApplication.getOaddress());
				
				applicationNodalOfficerDetail.setCreatedOn(LocalDateTime.now());
				applicationNodalOfficerDetail.setCreatedBy(parichayUser);
				applicationNodalOfficerDetail.setUpdatedBy(parichayUser);
				applicationNodalOfficerDetail.setUpdatedOn(LocalDateTime.now());
				
				// save application_nodal_officer_details
				applicationNodalOfficerDetailRepo.save(applicationNodalOfficerDetail);


				System.out.println("ist>>>" + applicationNodalOfficerDetail.getId());
				System.out.println("2nd>>>" + applicationNodalOfficerDetail);

				// ApprovingAuthority approving = this.modelMapper.map(onboardingApplication,ApprovingAuthority.class);

				approving.setName(onboardingApplication.getEnglishname());
				approving.setDesignation(onboardingApplication.getApprovingdesignation());
				approving.setEmployeeId(onboardingApplication.getApprovingemployeeid());
				approving.setEmailAddress(onboardingApplication.getApprovingemail());
				approving.setLandline(onboardingApplication.getPhoneno3());
				approving.setMobileNo(onboardingApplication.getPhoneno4());

				approving.setEmployeeIdPath("");
				approving.setCreatedOn(LocalDateTime.now());
				approving.setUpdatedOn(LocalDateTime.now());

				approving.setCreatedBy(parichayUser);
				approving.setUpdatedBy(parichayUser);

				// save approving_authority
				approvingRepo.save(approving);

				// application data
				System.out.println("cityarray>>" + onboardingApplication.getCghsCities());
				Long[] cityArray = onboardingApplication.getCghsCities();
				List<CGHSCity> citylist = new ArrayList<CGHSCity>();
				for (Long id : cityArray) {
					System.out.println("cityid>>" + id);
					citylist.add(cghsCityRepo.findById(id).get());
				}

				System.out.println("citylist>>" + citylist);
				applicationdetail.setCghsCities(citylist);

				applicationdetail.setStrength(onboardingApplication.getStrength());
				ApplicationNodalOfficerDetail nodalofficer = new ApplicationNodalOfficerDetail();
				// modelMapper.map(applicationdetail, OnboardingApplication.class);
				applicationdetail.setParichayId(onboardingApplication.getParichayId());
				applicationdetail.setNodalOfficer(applicationNodalOfficerDetail);
				applicationdetail.setApprovingAuthority(approving);
				applicationdetail.setSigned(false);
				applicationdetail.setSignedBy("");
				applicationdetail.setSignedOn(null);
				applicationdetail.setCreatedOn(LocalDateTime.now());
				applicationdetail.setUpdatedOn(LocalDateTime.now());
				applicationdetail.setCreatedBy(parichayUser);
				applicationdetail.setUpdatedBy(parichayUser);

				// save application_detail
				applicationdetail = nodalApplicationDetailRepo.save(applicationdetail);
				nodalpdf.setNodalpath(onboardingApplication.getFile1());
				nodalpdf.setNodalofficerId(applicationdetail.getNodalOfficer().getId());
				approvingpdf.setApprovingpath(onboardingApplication.getFile2());
				approvingpdf.setApprovingauthorityId(applicationdetail.getNodalOfficer().getId());

				// save pdf 1
				nodalPdfRepo.save(nodalpdf);
				// save pdf 2
				approvingPdfRepo.save(approvingpdf);
				ApplicationType appType = applicationTypeRepo.findById(ApplicationTypeEnum.NodalOfficerEnrollmentApplication.getValue()).get();
				applicationdetail.setApplicationType(appType);
				applicationdetail.setApplicationNumber(applicationNumberGenerator
						.generateApplicationNumber(ApplicationTypeEnum.NodalOfficerEnrollmentApplication));
				// save the application_no, application_type code in application_detail
				nodalApplicationDetailRepo.save(applicationdetail);
				String parichayId = onboardingApplication.getParichayId();
				if (parichayId == null || parichayUser == null) {
					throw new Exception("Data error: Wrong parichay Id "+ onboardingApplication.getParichayId());
				} else {
					// Create movement
					Movement movement = new Movement();
					movement.setApplication(applicationdetail);
					movement.setCreatedBy(parichayUser);
					movement.setUpdatedBy(parichayUser);
					movement.setCreatedOn(LocalDateTime.now());
					movement.setUpdatedOn(LocalDateTime.now());
					movement.setLevelNo(ApplicationLevel.ZERO.getValue());
					movement.setApplicationType(applicationdetail.getApplicationType());
					
					//  get the action_type
					ActionType actionType = actionTypeRepo.findById(ActionTypeEnum.SUBMIT.getValue()).get();
					movement.setActionType(actionType);

					ParichayUser parichayUser2 = parichayRepo.findByParichayId(onboardingApplication.getParichayId()).get();
					movement.setFromUserId(parichayUser);
                	movement.setFromOffice(orgOfficeOptional.get());
					// get the approivng officer id from the database for the user's selected organization
					// set thatin  movement.setToUserId(
					Optional<Organization> orgOptional = organizationRepo.findById(onboardingApplication.getOrganization());
					if(!orgOptional.isPresent())
						throw new Exception("Data error: invalid organization code "+ onboardingApplication.getOrganization());
					// the main purpose of this to check the approving authority user to bind with only one organizatin id
					List<ApprovingAuthorityUser> approvingAuthorityUserList = approvingAuthorityUserRepo.findByOrganization(orgOptional.get());
					if(approvingAuthorityUserList.size()> 1)
						throw new Exception("DB error: there are multiple approving officer exist for the organization code "+ onboardingApplication.getOrganization());
					ApprovingAuthorityUser approvingAuthorityUser = approvingAuthorityUserList.get(0);

					ApprovingAuthorityUser approvingUser = approvingAuthorityUserRepo.findByOrganizationOffice(orgOfficeOptional.get());
					movement.setToOffice(approvingUser.getOrganizationOffice());
					movement.setNew(true);
					movementRepo.save(movement);

				} 
				OnboardingApplication onboardingApplication2 = prepareOnboardingApplication(applicationdetail);
				System.out.println("prepare----applicationdetail>>" + onboardingApplication);
                return onboardingApplication2;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
 
    public List<NodalApplicationDetail> finalApplication(String id) {
		List<NodalApplicationDetail> detailList = nodalApplicationDetailRepo.findByParichayId(id);
		return detailList;
	}

    @Override
    public OnboardingApplication getOnBoardingApplication(int applicationId, String[] fields) {
        // TODO Auto-generated method stub
		OnboardingApplication onboardingApplication = null;
        try{
            NodalApplicationDetail detail = detailservice.getdetail(applicationId);
			onboardingApplication = prepareOnboardingApplication(detail);
            if (fields != null && fields.length != 0) {
            for (String field : fields) {
                if (field.equalsIgnoreCase("nodalPdf")) {
                        // define a service which will have method to retrieve Nodal ID pdf from mongo
                        // repoistory
                    onboardingApplication.setFile(detailservice.getnodalpdf(applicationId));
                }
                if (field.equalsIgnoreCase("approvingpdf")) {
                    System.out.println("approvingpdf"
                            + approvingPdfRepo.findByApprovingauthorityId(applicationId).getApprovingpath());
                    onboardingApplication.setApprovingfile(
                            approvingPdfRepo.findByApprovingauthorityId(applicationId).getApprovingpath());
                }
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
		return onboardingApplication;
    }
    
    @Override
    public List<OnboardingApplication> list(){
        List<NodalApplicationDetail> list = nodalApplicationDetailRepo.findAll();
        List<OnboardingApplication> onboardingList = new ArrayList<OnboardingApplication>();
			for (NodalApplicationDetail nodal : list) {

				onboardingList.add(prepareOnboardingApplication(nodal));
			}
        return onboardingList;
    }

    @Override
    public NodalApplicationDetail eSignOnboardingApplication(Long applicationId){
		NodalApplicationDetail applicationDetail = nodalApplicationDetailRepo.findById(applicationId).get();
        return applicationDetail;
    }

    @Override
    public void eSignResponseOnboardingApplication(Long applicationId, String response){
		NodalApplicationDetail detailObj = nodalApplicationDetailRepo.findById(applicationId).get();
		System.out.println("respon-" + response);
		EsignResponse resp = new EsignResponse();
		EsignRequestResponse esignreqsp = null;
		try {
			esignreqsp = resp.getEsignResponse("text", null, response);
			if (esignreqsp.getRespStatus() == 0) {
				System.out.println("Error Message if failed :: " + esignreqsp.getErrorMessage());
				System.out.println("Error Code :: " + esignreqsp.getErrorCode());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/******************** to verify note content after eSign ********************/
		System.out.println("esignreqsp.getUserCert()- " + esignreqsp.getUserCert());
		System.out.println("esignreqsp.getReqTs()- " + esignreqsp.getReqTs());
		System.out.println("esignreqsp.getRespCode()- " + esignreqsp.getRespCode());
		X509Certificate x509Certificate;
		CertificateIssueInfo certificateIssueInfo = null;
		CertificateSignerInfo certificateSignerInfo = null;
		try {
			x509Certificate = X509Certificate.getInstance(Base64.decodeBase64(esignreqsp.getUserCert()));
			certificateIssueInfo = new CertificateIssueInfo(x509Certificate.getIssuerDN().getName());
			certificateSignerInfo = new CertificateSignerInfo(x509Certificate.getSubjectDN().getName());
			ESignCertificateDetail esignCertificateDetail = new ESignCertificateDetail();
			esignCertificateDetail.setBase64X509Certificate(esignreqsp.getUserCert());
			esignCertificateDetail.setCommonName(certificateSignerInfo.getSignerCommonName());
			esignCertificateDetail.setSerialNumber(x509Certificate.getSerialNumber().toString());
			esignCertificateDetail.setCountry(certificateSignerInfo.getSignerCountry());
			esignCertificateDetail.setEmail("");
			esignCertificateDetail.setOrganization(certificateIssueInfo.getIssuerOrg());
			esignCertificateDetail.setLocality(certificateIssueInfo.getIssuerAddress());
			esignCertificateDetail.setOrganizationUnit(certificateIssueInfo.getIssuerOrgUnit());
			eSignCertificateDetailRepository.save(esignCertificateDetail);

			SigningInfo signingInfo = new SigningInfo();

			signingInfo.setESignResponseXML(response);
			signingInfo.setESignCertificateDetail(esignCertificateDetail);

			DocSignatureResponse[] docSigResp = esignreqsp.getDocSigResp();
			boolean isVerified = false;

			for (int i = 0; i < docSigResp.length; i++) {

				isVerified = TextSigning.verifyPkcs7(Base64.decodeBase64(docSigResp[i].getPkcs7Resp()),
						detailObj.toString().getBytes());
				if (isVerified) {
					signingInfo.setPkcs7String(docSigResp[i].getPkcs7Resp());
					break;
				}
				System.out.println("Content verification status:: " + isVerified);
			}
			if (isVerified) {
				detailObj.setSigned(true);
				detailObj.setSignedOn(LocalDateTime.now());
				detailObj.setSignedBy(esignCertificateDetail.getCommonName());
				detailObj.setSubmitted(true);
				signingInfoRepo.save(signingInfo);
				detailObj.setSigningInfo(signingInfo);
			} else {
				detailObj.setSigned(false);
			}
			nodalApplicationDetailRepo.save(detailObj);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

    }
}
