package io.swagger.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.CGHSInchargeApplication;
import io.swagger.model.ESignRequestObject;
import io.swagger.repository.CGHSInchargeApplicationRepo;
import io.swagger.repository.ESignCertificateDetailRepository;
import io.swagger.repository.SigningInfoRepo;
import io.swagger.resources.CGHSInchargeRegistrationResource;
import io.swagger.service.CGHSInchargeApplicationService;
import io.swagger.service.EsignClientServiceImp;
import org.springframework.beans.factory.annotation.Value;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-04T12:17:29.581Z[GMT]")
@RestController
@RequestMapping(value = "/api/v1")
@PropertySource(value = "classpath:global.properties")

@CrossOrigin
public class CGHSInchargeRegistrationController implements CGHSInchargeRegistrationApi {
    @Value("${url.gatewayUrl}")
	String gatewayUrl;
    private static final Logger log = LoggerFactory.getLogger(CGHSInchargeRegistrationController.class);

    private final HttpServletRequest request;
    @Autowired
	EsignClientServiceImp clientService;
    @Autowired
    private CGHSInchargeApplicationService cghsInchargeApplicationService;
    @Autowired
    private CGHSInchargeApplicationRepo cghsInchargeApplicationRepo;
    @Autowired
    private SigningInfoRepo signingInfoRepo;
    @Autowired
    private ESignCertificateDetailRepository eSignCertificateDetailRepository;
    // @Autowired
    // private CGHSInchargeApplicationRepo cghsInchargeApplicationRepo;

    @Autowired
    private ModelMapper modelMapper;
    @org.springframework.beans.factory.annotation.Autowired
    public CGHSInchargeRegistrationController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<CGHSInchargeRegistrationResource> create(HttpServletRequest request,
            @Valid CGHSInchargeRegistrationResource cghsInchargeRegistrationResource) {
        // TODO Auto-generated method stub
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                CGHSInchargeRegistrationResource cghsInchargeApplication = cghsInchargeApplicationService
                    .create(request, cghsInchargeRegistrationResource);
                return new ResponseEntity<CGHSInchargeRegistrationResource>(cghsInchargeApplication, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<CGHSInchargeRegistrationResource>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<CGHSInchargeRegistrationResource> get(long id) {
        // TODO Auto-generated method stub
        String accept = request.getHeader("Accept");
        CGHSInchargeRegistrationResource resource = new CGHSInchargeRegistrationResource();
        if (accept != null && accept.contains("application/json")) {
            try {
                Optional<CGHSInchargeApplication> cghsInchargeApplicationOpt = cghsInchargeApplicationRepo.findById(id);
                if(!cghsInchargeApplicationOpt.isPresent()){
                    throw new Exception("Data error: invalid id");
                }
                CGHSInchargeApplication cghsInchargeApplication = cghsInchargeApplicationOpt.get();
                
                resource.setId(cghsInchargeApplication.getId());
                resource.setName(cghsInchargeApplication.getName());
                // resource.sete(cghsInchargeApplication.getName());
                resource.setDesignation(cghsInchargeApplication.getDesignation());
                resource.setEmail(cghsInchargeApplication.getEmail());
                resource.setMobile(cghsInchargeApplication.getMobile());
                resource.setCreated_on(cghsInchargeApplication.getCreatedOn());;
                return new ResponseEntity<CGHSInchargeRegistrationResource>(resource,HttpStatus.OK);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return new ResponseEntity<CGHSInchargeRegistrationResource>(HttpStatus.NOT_IMPLEMENTED);
    }



    @Override
    public ResponseEntity<ESignRequestObject> esign(Long applicationId) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("in createHash");
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
        String username = "testuser";
        Optional<CGHSInchargeApplication> cghsInchargeAppOptional = cghsInchargeApplicationRepo.findById(applicationId);
        if (!cghsInchargeAppOptional.isPresent())
            throw new Exception("Data error: applicationId " + applicationId + " is not present ");
    
    
            CGHSInchargeApplication cghsInchargeApplication = cghsInchargeAppOptional.get();
        try {
            String st = clientService.createHash(username, cghsInchargeApplication.toString(), "testing",
                    baseUrl, "/CGHSInchargeApplication/" + applicationId + "/esignresponse");

            ESignRequestObject requestObject = new ESignRequestObject(username, st, gatewayUrl + "acceptClient",
                    baseUrl + "/CGHSInchargeApplication/" + applicationId + "/esignresponse");

            return new ResponseEntity<ESignRequestObject>(requestObject, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ESignRequestObject>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<ESignRequestObject> esignresponse(Long applicationId, String respon) throws Exception {

    //     // Optional<Application> appObj = applicationRepo.findById(applicationId);
    //     // System.out.println("appObj-" + appObj.isPresent());
    //     // return null;

    //     String filePath = null;
    //     Optional<CGHSInchargeApplication> cghsInchargeAppOptional = cghsInchargeApplicationRepo.findById(applicationId);
    //     if (!cghsInchargeAppOptional.isPresent())
    //         throw new Exception("Data error: applicationId " + applicationId + " is not present ");
    //     CGHSInchargeApplication cghsInchargeApplication = cghsInchargeAppOptional.get();
    //     System.out.println("respon-" + respon);
    //     EsignResponse resp = new EsignResponse();
    //     EsignRequestResponse esignreqsp = null;
    //     try {
    //         esignreqsp = resp.getEsignResponse("text", null, respon);
    //         if (esignreqsp.getRespStatus() == 0) {
    //             System.out.println("Error Message if failed :: " + esignreqsp.getErrorMessage());
    //             System.out.println("Error Code :: " + esignreqsp.getErrorCode());
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     /******************** to verify note content after eSign ********************/
    //     System.out.println("esignreqsp.getUserCert()- " + esignreqsp.getUserCert());
    //     System.out.println("esignreqsp.getReqTs()- " + esignreqsp.getReqTs());
    //     System.out.println("esignreqsp.getRespCode()- " + esignreqsp.getRespCode());
    //     X509Certificate x509Certificate;
    //     CertificateIssueInfo certificateIssueInfo = null;
    //     CertificateSignerInfo certificateSignerInfo = null;
    //     try {
    //         x509Certificate = X509Certificate.getInstance(Base64.decodeBase64(esignreqsp.getUserCert()));
    //         certificateIssueInfo = new CertificateIssueInfo(x509Certificate.getIssuerDN().getName());
    //         certificateSignerInfo = new CertificateSignerInfo(x509Certificate.getSubjectDN().getName());
    //         ESignCertificateDetail esignCertificateDetail = new ESignCertificateDetail();
    //         esignCertificateDetail.setBase64X509Certificate(esignreqsp.getUserCert());
    //         esignCertificateDetail.setCommonName(certificateSignerInfo.getSignerCommonName());
    //         esignCertificateDetail.setSerialNumber(x509Certificate.getSerialNumber().toString());
    //         esignCertificateDetail.setCountry(certificateSignerInfo.getSignerCountry());
    //         esignCertificateDetail.setEmail("");
    //         esignCertificateDetail.setOrganization(certificateIssueInfo.getIssuerOrg());
    //         esignCertificateDetail.setLocality(certificateIssueInfo.getIssuerAddress());
    //         esignCertificateDetail.setOrganizationUnit(certificateIssueInfo.getIssuerOrgUnit());
    //         eSignCertificateDetailRepository.save(esignCertificateDetail);

    //         SigningInfo signingInfo = new SigningInfo();

    //         signingInfo.setESignResponseXML(respon);
    //         signingInfo.setESignCertificateDetail(esignCertificateDetail);

    //         DocSignatureResponse[] docSigResp = esignreqsp.getDocSigResp();
    //         boolean isVerified = false;

    //         for (int i = 0; i < docSigResp.length; i++) {

    //             isVerified = TextSigning.verifyPkcs7(Base64.decodeBase64(docSigResp[i].getPkcs7Resp()),
    //                     cghsInchargeApplication.toString().getBytes());
    //             if (isVerified) {
    //                 signingInfo.setPkcs7String(docSigResp[i].getPkcs7Resp());
    //                 break;
    //             }
    //             System.out.println("Content verification status:: " + isVerified);
    //         }
    //         if (isVerified) {
    //             cghsInchargeApplication.setSigned(true);
    //             cghsInchargeApplication.setSignedOn(LocalDateTime.now());
    //             cghsInchargeApplication.setSignedBy(esignCertificateDetail.getCommonName());

    //             signingInfoRepo.save(signingInfo);
    //             cghsInchargeApplication.setSigningInfo(signingInfo);
    //         } else {
    //             cghsInchargeApplication.setSigned(false);
    //         }
    //         cghsInchargeApplicationRepo.save(cghsInchargeApplication);

    //     } catch (Exception e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    //     // CertificateDetail certificateDetail = EsignService.getCertificateInfo();

        URI uri;
        try {
            // set rediection vikki
            uri = new URI("http://localhost:3000/cghsUserView?" + "applicationId=" + applicationId + "&message="
                    + "Application+esigned+successfully");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(uri);
            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // @Override
    // public ResponseEntity<ESignRequestObject> eSignBenRegistrationApplication(Long applicationId) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'eSignBenRegistrationApplication'");
    // }

    @Override
    public ResponseEntity<List<CGHSInchargeRegistrationResource>> list() {
      
        System.out.println("run");
     List<CGHSInchargeApplication> cghsInchargeApplications=cghsInchargeApplicationRepo.findAll();
     if(cghsInchargeApplications==null)
        return null;


      List<CGHSInchargeRegistrationResource> cghsInchargeRegistrationResources = cghsInchargeApplications.stream().map((cat) -> this.modelMapper.map(cat, CGHSInchargeRegistrationResource.class))
	 			.collect(Collectors.toList());

		return new ResponseEntity<List<CGHSInchargeRegistrationResource>>(cghsInchargeRegistrationResources, HttpStatus.OK);

        
    }

  

}
