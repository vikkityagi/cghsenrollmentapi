package io.swagger.api;

import io.swagger.model.SigningInfo;
import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.ESignCertificateDetail;
import io.swagger.model.ESignRequestObject;
import io.swagger.model.ParichayUser;
import io.swagger.repository.SigningInfoRepo;
import io.swagger.repository.BenRegistrationApplicationRepo;
import io.swagger.repository.ESignCertificateDetailRepository;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.resources.BenRegistrationApplicationResource;
import io.swagger.service.EsignClientServiceImp;
import io.swagger.utils.CertificateIssueInfo;
import io.swagger.utils.CertificateSignerInfo;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;
import org.modelmapper.ModelMapper;
import org.nic.eoffice.esign.EsignResponse;
import org.nic.eoffice.esign.hash.TextSigning;
import org.nic.eoffice.esign.model.CertificateDetail;
import org.nic.eoffice.esign.model.DocSignatureResponse;
import org.nic.eoffice.esign.model.EsignRequestResponse;
import org.nic.eoffice.esign.service.EsignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")
@RestController
@CrossOrigin
@PropertySource(value = "classpath:global.properties")
@RequestMapping(value="/api/v1/")
public class BenRegistrationApplicationResourceController implements BenRegistrationApplicationResourceApi {
    @Value("${url.gatewayUrl}")
	String gatewayUrl;
    private static final Logger log = LoggerFactory.getLogger(BenRegistrationApplicationResourceController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private BenRegistrationApplicationRepo benRegistrationApplicationRepo;
	@Autowired
	EsignClientServiceImp clientService;
    @Autowired
	private SigningInfoRepo signingInfoRepo;

    @Autowired
    private ParichayUserRepo parichayUserRepo;
    @Autowired
	private ESignCertificateDetailRepository eSignCertificateDetailRepository;
    @org.springframework.beans.factory.annotation.Autowired
    public BenRegistrationApplicationResourceController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public Long getLastId(){
        return benRegistrationApplicationRepo.findByIdOrderByIdDesc();
    }

    // used for submit to movement
	public ResponseEntity<BenRegistrationApplicationResource> benRegistrationApplication(
        @Parameter(in = ParameterIn.PATH, description = "Post detail of beneficiary", required=false, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
                BenRegistrationApplication benRegistrationApplication = benRegistrationApplicationRepo.findById(id).get();
                System.out.println("before>>"+benRegistrationApplication);
                benRegistrationApplication.setDraft(false);
                benRegistrationApplication.setFinal(true);
                // benRegistrationApplication.setModifiedBy(id.toString());
                LocalDateTime datetime1 = LocalDateTime.now();   
                benRegistrationApplication.setModifiedOn(datetime1);
                benRegistrationApplicationRepo.save(benRegistrationApplication);
                BenRegistrationApplication benRegistrationApplicationUpdated = benRegistrationApplicationRepo.findById(id).get();
                System.out.println("after>>"+benRegistrationApplicationUpdated);
                BenRegistrationApplicationResource benregistrationResource = new BenRegistrationApplicationResource();
                benregistrationResource.setId(benRegistrationApplicationUpdated.getId());
                benregistrationResource.setIsDraft(benRegistrationApplicationUpdated.isDraft());
                benregistrationResource.setIsFinal(benRegistrationApplicationUpdated.isFinal());
                benregistrationResource.setParichayId(benRegistrationApplication.getParichayId());
                benregistrationResource.setUpdatedOn(benRegistrationApplication.getModifiedOn());

                return new ResponseEntity<BenRegistrationApplicationResource>(benregistrationResource, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BenRegistrationApplicationResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BenRegistrationApplicationResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BenRegistrationApplicationResource> get(@Parameter(in = ParameterIn.PATH, description = "GEt details of primary card holder", required=false, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null || accept.contains("application/json")) {
            try {
                Optional<BenRegistrationApplication> benregistrationOptional = benRegistrationApplicationRepo.findById(id);
                if(!benregistrationOptional.isPresent()){
                    return new ResponseEntity<BenRegistrationApplicationResource>(new BenRegistrationApplicationResource(), HttpStatus.OK);
                }
                BenRegistrationApplication benregistration = benregistrationOptional.get();
                System.out.println(benregistration);
                BenRegistrationApplicationResource benresources = new BenRegistrationApplicationResource();
                benresources.setId(benregistration.getId());
                benresources.setIsDraft(benregistration.isDraft());
                benresources.setEsignStatus(benregistration.isSigned());
                benresources.setEsignedOn(benregistration.getSignedOn());
                benresources.setEsignedBy(benregistration.getSignedBy());
                benresources.setIsFinal(benregistration.isFinal());
                benresources.setUpdatedOn(benregistration.getModifiedOn());
                benresources.setCreatedOn(benregistration.getCreatedOn());
                benresources.setParichayId(benregistration.getParichayId());
                System.out.println(benregistration.getApplicationType());
                benresources.setApplicationTypeName(benregistration.getApplicationType().getApplicationTypeName());
                
                return new ResponseEntity<BenRegistrationApplicationResource>(benresources, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BenRegistrationApplicationResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BenRegistrationApplicationResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BenRegistrationApplicationResource> create(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody BenRegistrationApplicationResource body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BenRegistrationApplicationResource>(objectMapper.readValue("{\n  \"application_type_code\" : 0,\n  \"applicationNumber\" : \"198772\",\n  \"esignedOn\" : \"esignedOn\",\n  \"esignStatus\" : true,\n  \"isDraft\" : true,\n  \"id\" : 10,\n  \"isFinal\" : true,\n  \"parichayId\" : \"parichayId\",\n  \"esignedBy\" : \"esignedBy\"\n}", BenRegistrationApplicationResource.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BenRegistrationApplicationResource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BenRegistrationApplicationResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<BenRegistrationApplicationResource>> list(HttpServletRequest request,boolean isDraft) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Long parichayUserId = (Long) request.getAttribute("currentUserId");
                Optional<ParichayUser> parichayUserOptional  = parichayUserRepo.findById(parichayUserId);
                if(!parichayUserOptional.isPresent())
                    return new ResponseEntity<List<BenRegistrationApplicationResource>>(HttpStatus.INTERNAL_SERVER_ERROR);

                ParichayUser parichayUser = parichayUserOptional.get();
                List<BenRegistrationApplication> benAppRegistrationList = null;
                benAppRegistrationList = benRegistrationApplicationRepo.findByCreatedByAndIsDraft(parichayUser, isDraft);
                
                List<BenRegistrationApplicationResource> list = new ArrayList<BenRegistrationApplicationResource>(benAppRegistrationList.size());
                for(BenRegistrationApplication benRegistrationApplication : benAppRegistrationList){
                    BenRegistrationApplicationResource resource = new BenRegistrationApplicationResource();
                    resource.setId(benRegistrationApplication.getId());
                    resource.setApplicationNumber(benRegistrationApplication.getApplicationNumber());
                    resource.setIsDraft(benRegistrationApplication.isDraft());
                    resource.setParichayId(benRegistrationApplication.getParichayId());
                    resource.setEsignedBy(benRegistrationApplication.getSignedBy());

                    if(benRegistrationApplication.getSignedOn()!=null)
                        resource.setEsignedOn(benRegistrationApplication.getSignedOn());
                    if(benRegistrationApplication.getModifiedOn()!=null)
                        resource.setUpdatedOn(benRegistrationApplication.getModifiedOn());
                    if(benRegistrationApplication.getCreatedOn()!=null)
                        resource.setCreatedOn(benRegistrationApplication.getCreatedOn());
                    
                    list.add(resource);
                }
                return new ResponseEntity<List<BenRegistrationApplicationResource>>(list, HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<BenRegistrationApplicationResource>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<List<BenRegistrationApplicationResource>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<ESignRequestObject> eSignBenRegistrationApplication(
        Long applicationId) {
        // TODO Auto-generated method stub
        System.out.println("in createHash");
		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		String username = "testuser";
		BenRegistrationApplication applicationDetail = benRegistrationApplicationRepo.findById(applicationId).get();
		try {
			String st = clientService.createHash(username, applicationDetail.toString(), "testing",
			baseUrl,"/ben_registration_applications/"+applicationId+"/esignresponse");

			ESignRequestObject requestObject = new ESignRequestObject(username, st, gatewayUrl + "acceptClient",
					baseUrl + "/ben_registration_applications/"+applicationId+"/esignresponse");

			return new ResponseEntity<ESignRequestObject>(requestObject, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ESignRequestObject>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
    }

    @Override
    public ResponseEntity<ESignRequestObject> eSignResponsebenRegistrationApplication(Long applicationId, String respon) {

        String filePath = null;
        BenRegistrationApplication detailObj = benRegistrationApplicationRepo.findById(applicationId).get();	
        System.out.println("respon-" + respon);
		EsignResponse resp = new EsignResponse();
		EsignRequestResponse esignreqsp = null;
		try {
			esignreqsp = resp.getEsignResponse("text", null, respon);
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

			signingInfo.setESignResponseXML(respon);
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
                
				signingInfoRepo.save(signingInfo);
				detailObj.setSigningInfo(signingInfo);
			} else {
				detailObj.setSigned(false);
			}
			benRegistrationApplicationRepo.save(detailObj);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// CertificateDetail certificateDetail = EsignService.getCertificateInfo();

		URI uri;
		try {

			uri = new URI("http://localhost:3000/beneficiaryCard?"+"applicationId=" +applicationId+"&message="+"Application+esigned+successfully");
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(uri);
			return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}


		
	}

}
