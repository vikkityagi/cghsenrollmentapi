package io.swagger.api;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.hibernate.loader.plan.build.spi.ReturnGraphTreePrinter;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.OnboardingApplication;
import io.swagger.model.ParichayUser;
import io.swagger.repository.ParichayUserRepo;
import io.swagger.resources.ParichayUserResource;

/**
 * Home redirection to swagger api documentation
 */
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class HomeController {

	@Autowired
	private ParichayUserRepo parichayUserRepo;

	@RequestMapping(value = "/home")
	public ResponseEntity<ParichayUserResource> index(@RequestParam("string") String encrString,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			if (request.getCookies() != null) {
				for (Cookie cookies : request.getCookies()) {
					System.out.println("cokkies>>>>>>>>>>>>>>>>>>>>>>>" + cookies.getName() + ":" + cookies.getValue());
				}
			}

			Optional<ParichayUser> parichayUserCehck = parichayUserRepo.findById(1L);
			System.out.println(parichayUserCehck.get().getLocalTokenId());

			ParichayUser parichayUserCehck2 = parichayUserRepo.findByLocalTokenId(parichayUserCehck.get().getLocalTokenId());
			System.out.println(parichayUserCehck2.getId());

			Optional<ParichayUser> parichayUserCehck3 = parichayUserRepo.findById(1L);
			System.out.println(parichayUserCehck3);

			System.out.println("/swagger-ui/index.html");
			System.out.println("Encrypted string: " + encrString);
			String handshakResponse = "", dcrptResponse = "";
			handshakResponse = hsFunc(encrString);
			System.out.println("handshakResponse string: " + handshakResponse);
			dcrptResponse = dcrptFunc(handshakResponse);
			System.out.println("dcrptResponse string: " + dcrptResponse);
			System.out.println("==========Get method home servlet ==========");

			Object obj = JSONValue.parse(dcrptResponse);
			JSONObject jsonObject = (JSONObject) obj;
			String parichayId = null;
			if (jsonObject != null) {
				System.out.println("jsonObject" + jsonObject);
				JSONObject data = (JSONObject) jsonObject.get("data");
				System.out.println("data" + data);
				JSONObject signature = (JSONObject) data.get("signature");
				System.out.println("signature" + signature);
				String userName = (String) signature.get("userName");
				String firstName = (String) signature.get("firstName");
				String lastName = (String) signature.get("lastName");
				String city = (String) signature.get("city");
				String employeeCode = (String) signature.get("employeeCode");
				String email = (String) signature.get("email");
				String fullName = (String) signature.get("fullName");
				String mobileNo = (String) signature.get("mobileNo");
				String designation = (String) signature.get("designation");
				String ip = (String) signature.get("ip");

				String sessionId = (String) signature.get("sessionId");
				String browserId = (String) signature.get("browserId");
				String localTokenId = (String) signature.get("localTokenId");
				String ua = (String) signature.get("ua");
				parichayId = (String) signature.get("parichayId");
				String serviceName = "ParichayClient";
				System.out.print("userName : " + userName + " sessionId : " + sessionId + " browserId : " + browserId
						+ " localTokenId : " + localTokenId);
				Cookie cookie0 = new Cookie("userName", email);

				// expires in 7 days
				cookie0.setMaxAge(7 * 24 * 60 * 60);
				// optional properties
				cookie0.setSecure(true);
				cookie0.setHttpOnly(true);
				cookie0.setPath("/");
				// add cookie to response
				response.addCookie(cookie0);

				// set cookie here

				Cookie cookie1 = new Cookie("localTokenId", localTokenId);

				// expires in 7 days
				cookie1.setMaxAge(7 * 24 * 60 * 60);

				// optional properties
				cookie1.setSecure(true);
				cookie1.setHttpOnly(true);
				cookie1.setPath("/");

				// add cookie to response
				response.addCookie(cookie1);

				// set IInd cookies here

				Cookie cookie2 = new Cookie("browserId", browserId);

				// optional properties
				cookie2.setSecure(true);
				cookie2.setHttpOnly(true);
				cookie2.setPath("/");

				// add cookie to response
				response.addCookie(cookie2);

				// set IIIrd cookies here

				Cookie cookie3 = new Cookie("sessionId", sessionId);

				// optional properties
				cookie3.setSecure(true);
				cookie3.setHttpOnly(true);
				cookie3.setPath("/");

				// add cookie to response
				response.addCookie(cookie3);

				HttpSession session = request.getSession();
				System.out.println("home controller session is new -" + session.isNew());

				session.setAttribute("userName", userName);
				session.setAttribute("sessionId", sessionId);
				session.setAttribute("browserId", browserId);
				session.setAttribute("localTokenId", localTokenId);
				session.setAttribute("ua", ua);
				session.setAttribute("parichayId", parichayId);
				session.setAttribute("serviceName", serviceName);

				ParichayUser parichayUser = new ParichayUser();
				ParichayUser parichayresult = null;
				Optional<ParichayUser> temp = parichayUserRepo.findByParichayId(parichayId);
				if (temp.isPresent())
					parichayresult = temp.get();
				if (parichayresult == null) {
					parichayUser.setUserName(userName);
					parichayUser.setParichayId(parichayId);
					parichayUser.setFullName(fullName);
					parichayUser.setEmail(email);
					parichayUser.setMobileNo(mobileNo);
					parichayUser.setSessionId(sessionId);
					parichayUser.setLocalTokenId(localTokenId);
					parichayUser.setBrowserId(browserId);
					parichayUser.setEmployeeCode(employeeCode);
					parichayUser.setIp(ip);
					LocalDateTime now = LocalDateTime.now();
					parichayUser.setCreatedon(now);

					parichayUserRepo.save(parichayUser);
				} else {
					parichayresult.setSessionId(sessionId);
					parichayresult.setLocalTokenId(localTokenId);
					parichayresult.setBrowserId(browserId);
					LocalDateTime now = LocalDateTime.now();
					parichayresult.setUpdateon(now);

					parichayUserRepo.save(parichayresult);
				}
			} else {
				throw new Exception("Runtime error: no response from Parichay server");
			}

			ParichayUser user = parichayUserRepo.findByParichayId(parichayId).get();

			ParichayUserResource resource = new ParichayUserResource();
			resource.setUserName(user.getUserName());
			resource.setParichayId(user.getParichayId());
			resource.setEmail(user.getEmail());
			resource.setMobileNo(user.getMobileNo());
			resource.setSessionId(user.getSessionId());
			resource.setLocalTokenId(user.getLocalTokenId());
			resource.setBrowserId(user.getBrowserId());

			return new ResponseEntity<ParichayUserResource>(resource, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ParichayUserResource>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	private String dcrptFunc(String strHandshak) throws IOException, IOException {
		System.out.println("=============Decrypt Function Called==================");
		HttpPost httpPost = new HttpPost(ResourceBundle.getBundle("config").getString("DEC_URL"));
		System.out.println("httpPost : " + httpPost);
		String requestBody = "{\"EncryptedString\":\"" + strHandshak + "\"}";
		System.out.println("Request Body decrypt :- " + requestBody);
		StringEntity entity = new StringEntity(requestBody);
		httpPost.setEntity(entity);
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse clientResponse = httpClient.execute(httpPost);
		String result = EntityUtils.toString(clientResponse.getEntity());
		System.out.println("Dcrypt API response:- " + result.toString());
		return result;
	}

	private String hsFunc(String encrString) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub

		System.out.println("=============Handshaking Function Called==================");
		HttpGet httpGet = new HttpGet(
				ResourceBundle.getBundle("config").getString("HANDSHAKING_URL") + "/" + encrString + "/"
						+ ResourceBundle.getBundle("config").getString("SERVICE"));

		System.out.println("HttpGet : " + httpGet);
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse clientResponse = httpClient.execute(httpGet);
		String result = EntityUtils.toString(clientResponse.getEntity());
		System.out.println("Encrypt API response:- " + result.toString());
		return result;

	}

}
