package io.swagger.api;

import io.swagger.model.ESignRequestObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.NodalApplicationDetail;
import io.swagger.model.OnboardingApplication;
import io.swagger.model.ParichayUser;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.service.EsignClientServiceImp;
import io.swagger.service.OnboardingService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-18T12:17:29.581Z[GMT]")
@RestController
@PropertySource(value = "classpath:global.properties")
@RequestMapping(value="/api/v1/")
public class OnboardingApiController implements OnboardingApi {
	@Value("${url.gatewayUrl}")
	String gatewayUrl;
	private static final Logger log = LoggerFactory.getLogger(OnboardingApiController.class);

	private final HttpServletRequest request;

	@Autowired
	EsignClientServiceImp clientService;
		

	@Autowired
	OnboardingService onboardingService;

	@Autowired
	ParichayUserRepo parichayUserRepo;

	@org.springframework.beans.factory.annotation.Autowired
	public OnboardingApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.request = request;
	}

	public ResponseEntity<OnboardingApplication> create(
			@Parameter(in = ParameterIn.DEFAULT, description = "To create a new Onboarding Application", required = true, schema = @Schema()) @Valid @RequestBody OnboardingApplication onboardingApplicationDto) throws Exception{

		String accept = request.getHeader("Accept");
		ParichayUser parichayUser = parichayUserRepo.findByParichayId(onboardingApplicationDto.getParichayId()).get();
		Optional<ParichayUser> parichayOpt = parichayUserRepo.findById(parichayUser.getId());
		if(!parichayOpt.isPresent()){
			throw new Exception("Data error: Invalid ParichayOpt");
		}
		if (accept != null && accept.contains("application/json")) {
			try {
				OnboardingApplication onboardingApplication = onboardingService.create(onboardingApplicationDto);
				return new ResponseEntity<OnboardingApplication>(onboardingApplication, HttpStatus.OK);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<OnboardingApplication>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<OnboardingApplication>(HttpStatus.NOT_IMPLEMENTED);
	}

	public long finalApplication(@PathVariable String id) {
		List<NodalApplicationDetail> detailList = onboardingService.finalApplication(id);
		if (detailList.size() > 0)
			return detailList.get(0).getId();
		else
			return 0l;
	}

	public ResponseEntity<OnboardingApplication> getOnBoardingApplication(
			@PathVariable(value = "applicationId") int applicationId,
			@RequestParam(value = "fields", required = false) String[] fields) {
		System.out.println("getOnBoardingApplication called");

		String accept = request.getHeader("Accept");
		OnboardingApplication onboardingApplication = null;
		if (accept != null && accept.contains("application/json")) {
			return new ResponseEntity<OnboardingApplication>(onboardingService.getOnBoardingApplication(applicationId,fields), HttpStatus.OK);
		}
		return new ResponseEntity<OnboardingApplication>(onboardingApplication, HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<ESignRequestObject> eSignOnboardingApplication(
			Long applicationId) {
		// TODO Auto-generated method stub
		System.out.println("in createHash");
		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		String username = "testuser";
		NodalApplicationDetail applicationDetail = onboardingService.eSignOnboardingApplication(applicationId);
		try {
			String st = clientService.createHash(username, applicationDetail.toString(), "testing",
					baseUrl, "/onboarding/" + applicationId + "/esignresponse");

			ESignRequestObject requestObject = new ESignRequestObject(username, st, gatewayUrl + "acceptClient",
					baseUrl + "/onboarding/" + applicationId + "/esignresponse");

			return new ResponseEntity<ESignRequestObject>(requestObject, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ESignRequestObject>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@Override
	public ResponseEntity<ESignRequestObject> eSignResponseOnboardingApplication(Long applicationId, String respon) {
		// TODO Auto-generated method stub
		onboardingService.eSignOnboardingApplication(applicationId);
		URI uri;
		try {
			uri = new URI("http://localhost:3000/print/" + applicationId);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setLocation(uri);
			return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<List<OnboardingApplication>> list() {
		try {
			List<OnboardingApplication> list = onboardingService.list();
			return new ResponseEntity<List<OnboardingApplication>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<OnboardingApplication>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
