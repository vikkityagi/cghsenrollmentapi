package io.swagger.api;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.repository.SigningInfoRepo;
import io.swagger.repository.NodalApplicationDetailRepo;
import io.swagger.service.EsignClientServiceImp;

@RestController
@PropertySource(value = "classpath:global.properties")
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class ClientController {

	@Value("${url.gatewayUrl}")
	String gatewayUrl;

	@Autowired
	EsignClientServiceImp clientService;

	@Autowired
	private NodalApplicationDetailRepo detailsRepo;

	@Autowired
	private SigningInfoRepo applicationSigningInfoRepo;
	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("index1");
	}

	// @RequestMapping(value = "/esign/application/{applicationId}/request", consumes = {
	// 		"application/json" }, produces = { "application/json" })
	// @ResponseBody
	// public ResponseEntity<ESignRequestObject> createHash(HttpSession session,
	// 		@PathVariable(value = "applicationId") Integer applicationId,
	// 		@RequestParam(value = "username", required = false) String username,
	// 		@RequestParam(value = "clientId", required = false) String clientId,
	// 		@RequestParam(value = "userId", required = false) String userId,
			
	// 		HttpServletRequest request) {
	// 	System.out.println("in createHash");
	// 	String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	// 			+ request.getContextPath();
		
	// 	NodalApplicationDetail applicationDetail = detailsRepo.findById(applicationId).get();
	// 	try {
	// 		String st = clientService.createHash(username, clientId, userId, applicationDetail.toString(), "testing",
	// 		baseUrl,"/esign/application/"+applicationId+"/response");

	// 		ESignRequestObject requestObject = new ESignRequestObject(username, st, gatewayUrl + "acceptClient",
	// 				baseUrl + "/esign/application/"+applicationId+"/response");

	// 		return new ResponseEntity<ESignRequestObject>(requestObject, HttpStatus.OK);

	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 		return new ResponseEntity<ESignRequestObject>(HttpStatus.INTERNAL_SERVER_ERROR);

	// 	}

	// }

	// @RequestMapping(value = "/esign/application/{applicationId}/response")
	// public ResponseEntity<Object> response(@PathVariable(value = "applicationId") Integer applicationId,@RequestParam(value = "respon", required = false) String respon,
	// 		HttpServletResponse response,
	// 		HttpSession session, HttpServletRequest request) throws Exception, FileNotFoundException {
	// 	String filePath = null;
	// 	NodalApplicationDetail detailObj = detailsRepo.findById(applicationId).get();
	// 	System.out.println("respon-" + respon);
	// 	EsignResponse resp = new EsignResponse();
	// 	EsignRequestResponse esignreqsp = resp.getEsignResponse("text", null, respon);

	// 	if (esignreqsp.getRespStatus() == 0) {
	// 		System.out.println("Error Message if failed :: " + esignreqsp.getErrorMessage());
	// 		System.out.println("Error Code :: " + esignreqsp.getErrorCode());
	// 	}
	// 	/******************** to verify note content after eSign ********************/
	// 	System.out.println("esignreqsp.getUserCert()- " + esignreqsp.getUserCert());
	// 	System.out.println("esignreqsp.getReqTs()- " + esignreqsp.getReqTs());
	// 	System.out.println("esignreqsp.getRespCode()- " + esignreqsp.getRespCode());
	// 	X509Certificate cert = X509Certificate.getInstance(Base64.decodeBase64(esignreqsp.getUserCert()));
	// 	String issuerDNName = cert.getIssuerDN().getName();
	// 	System.out.println("issuerDNName-"+issuerDNName);
	// 	CertificateIssueInfo certificateIssueInfo = new CertificateIssueInfo(issuerDNName);
	// 	String signerDNName = cert.getSubjectDN().getName();
	// 	System.out.println("signerDNName-"+signerDNName);
	// 	CertificateSignerInfo certificateSignerInfo = new CertificateSignerInfo(signerDNName);
	// 	SigningInfo applicationSigningInfo = new SigningInfo();
	// 	applicationSigningInfo.setApplicationDetail(detailObj);
	// 	copyCertificateInfo(applicationSigningInfo,certificateSignerInfo,certificateIssueInfo);
	// 	applicationSigningInfo.setESignResponseXML(respon);

	// 	applicationSigningInfoRepo.save(applicationSigningInfo);

	// 	DocSignatureResponse[] docSigResp = esignreqsp.getDocSigResp();
	// 	for (int i = 0; i < docSigResp.length; i++) {

	// 		boolean isVerified =

	// 				TextSigning.verifyPkcs7(Base64.decodeBase64(docSigResp[i].getPkcs7Resp()), detailObj.toString().getBytes());
	// 				if(isVerified){
	// 					applicationSigningInfo.setPkcs7String(docSigResp[i].getPkcs7Resp());
	// 				}

	// 		System.out.println("Content verification status:: " + isVerified);
	// 	}
	// 	detailObj.setSigned(true);
	// 	detailObj.setSignedOn(new Date());
	// 	detailObj.setSignedBy(applicationSigningInfo.getSignerCommonName());
		
	// 	detailsRepo.save(detailObj);
	// 	URI uri = new URI("http://localhost:3000/print/"+applicationId);
	// 	HttpHeaders httpHeaders = new HttpHeaders();
	// 	httpHeaders.setLocation(uri);
	// 	return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	// }

	// private void copyCertificateInfo(SigningInfo applicationSigningInfo,
	// 		CertificateSignerInfo certificateSignerInfo, CertificateIssueInfo certificateIssueInfo) {
	// 			applicationSigningInfo.setSignerCommonName(certificateSignerInfo.getSignerCommonName());
	// 			applicationSigningInfo.setSignerCategory(certificateSignerInfo.getSignerCategory());
	// 			applicationSigningInfo.setSignerCountry(certificateSignerInfo.getSignerCountry());
	// 			applicationSigningInfo.setSignerState(certificateSignerInfo.getSignerState());
				
	// 			applicationSigningInfo.setIssuerCommonName(certificateIssueInfo.getIssuerCommonName());
	// 			applicationSigningInfo.setIssuerOrgUnit(certificateIssueInfo.getIssuerOrgUnit());
	// 			applicationSigningInfo.setIssuerOrg(certificateIssueInfo.getIssuerOrg());
	// 			applicationSigningInfo.setIssuerAddress(certificateIssueInfo.getIssuerAddress());
	// 			applicationSigningInfo.setIssuerState(certificateIssueInfo.getIssuerState());
	// 			applicationSigningInfo.setSignerCountry(certificateIssueInfo.getIssuerCountry());


	// }

	// public static void main(String[] args) throws FileNotFoundException {
	// 	FileReader reader = new FileReader(new File("/home/vikram/cghs-dev/responsexml.txt"));
	// 	BufferedReader br = new BufferedReader(reader);
	// 	String line = null;
	// 	StringBuilder stringbuilder = new StringBuilder();
	// 	try {
	// 		while ((line = br.readLine()) != null) {
	// 			stringbuilder.append(line);
	// 		}
	// 		EsignResponse resp = new EsignResponse();
	// 		EsignRequestResponse esignreqsp = resp.getEsignResponse("text", null, stringbuilder.toString());

	// 		if (esignreqsp.getRespStatus() == 0) {
	// 			System.out.println("Error Message if failed :: " + esignreqsp.getErrorMessage());
	// 			System.out.println("Error Code :: " + esignreqsp.getErrorCode());
	// 		}
	// 		String certContent = esignreqsp.getUserCert();
	// 		/******************** to verify note content after eSign ********************/
	// 		System.out.println("esignreqsp.getUserCert()- " + certContent);
	// 		System.out.println("esignreqsp.getReqTs()- " + esignreqsp.getReqTs());
	// 		System.out.println("esignreqsp.getRespCode()- " + esignreqsp.getRespCode());

	// 		X509Certificate cert = X509Certificate.getInstance(Base64.decodeBase64(certContent));
	// 		String issuerDNName = cert.getIssuerDN().getName();
	// 		CertificateIssueInfo certificateIssueInfo = new CertificateIssueInfo(issuerDNName);
	// 		String signerDNName = cert.getSubjectDN().getName();
	// 		CertificateSignerInfo certificateSignerInfo = new CertificateSignerInfo(signerDNName);



	// 		DocSignatureResponse[] docSigResp = esignreqsp.getDocSigResp();
	// 		for (int i = 0; i < docSigResp.length; i++) {

	// 			boolean isVerified =

	// 					TextSigning.verifyPkcs7(Base64.decodeBase64(docSigResp[i].getPkcs7Resp()), "8-8".getBytes());

	// 			System.out.println("Content verification status:: " + isVerified);
	// 		}

	// 	} catch (IOException e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	} catch (Exception e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}

	// }
}
