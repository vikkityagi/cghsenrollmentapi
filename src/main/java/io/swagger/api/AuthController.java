package io.swagger.api;

import java.io.IOException;
import java.net.URI;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class AuthController {
	
	
	@GetMapping("/logout")
	String logout(HttpServletRequest request, HttpServletResponse response) {

		String PARICHAY_URL = ResourceBundle.getBundle("config").getString("PARICHAY_URL");
		String SERVICE = ResourceBundle.getBundle("config").getString("SERVICE");
		System.out.println("SERVICE : "+SERVICE);
		System.out.println("PARICHAY_URL : "+PARICHAY_URL);
		System.out.println("Logout Function called . ");
		long timeStamp = System.currentTimeMillis();
		System.out.println("timeStamp124 : "+timeStamp);
		HttpSession session = request.getSession(false);
//		System.out.println("session is new -"+session.isNew());
		String userName="";  
		String sessionId="";  
		String hmac_sign = "", logoutURL = "";
		try {
			hmac_sign = (String) hmac_logout(timeStamp,userName,sessionId,PARICHAY_URL,SERVICE);
			logoutURL = PARICHAY_URL+"/pnv1/salt/api/client/logout?userName="+userName+"&service="+SERVICE+"&sessionId="+sessionId+"&tid="+timeStamp+"&cs="+hmac_sign;
			System.out.println("logoutURL -"+logoutURL );
			return "{\""+"url\":"+"\""+logoutURL+"\""+"}";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\""+"url\":"+"\""+logoutURL+"\""+"}";


	}
	
	private Object hmac_logout(long timeStamp, String userName, String sessionId,String PARICHAY_URL,String SERVICE) throws  IOException {

		System.out.println("=============Hmac Logout Function Called==================");
		
		//Parichay1622544184996https://PARICHAY_url/pnv1/salt/api/client/logout
		String hmacString = "Parichay"+timeStamp+PARICHAY_URL+"/pnv1/salt/api/client/logout"+userName+SERVICE+sessionId;
		System.out.println("hmacString : "+hmacString);
		HttpPost httpPost = new HttpPost(ResourceBundle.getBundle("config").getString("HMAC_URL"));
		System.out.println("httpPost : "+httpPost);
		String requestBody = "{\"HmacString\":\"" + hmacString + "\"}";
		System.out.println("Request Body :- " + requestBody);
		StringEntity entity = new StringEntity(requestBody);
		httpPost.setEntity(entity);
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse clientResponse = httpClient.execute(httpPost);
		String result = EntityUtils.toString(clientResponse.getEntity());
		System.out.println("API response:- " + result.toString());
		 Object obj=JSONValue.parse(result);  
		JSONObject json =(JSONObject) obj  ;
	    String hmacReturnReponse = ((JSONObject) json.get("data")).get("signature").toString();
	    System.out.println("hmacReturnReponse :- " + hmacReturnReponse);
	    return hmacReturnReponse ;
		
	}



		
	
	@GetMapping("/login")
	String login() {
		System.out.println("login call");
		String service = "CGHS";
		String clientUrl = "http://127.0.0.1:9001";

	    System.out.println("Login Func called.");
	    long timeStamp = System.currentTimeMillis();
	    
		System.out.println("timeStamp : "+timeStamp);
		String hmac_sign="", encrpt_sign ="";
		try {
			hmac_sign = hmacFunc(timeStamp,service,clientUrl);
			System.out.println("hmac_response : " + hmac_sign);
			encrpt_sign = encrptFunc(clientUrl);
			System.out.println("encryption_response : " + encrpt_sign);

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String loginURL = "https://parichay.staging.nic.in/pnv1/api/login?sid=" + service + "&tid="
				+ timeStamp + "&cs=" + hmac_sign + "&string=" + encrpt_sign + "&lang=en";
		System.out.println(loginURL );
		
		return "{\""+"url\":"+"\""+loginURL+"\""+"}";
	}
	

	public String encrptFunc(String clientUrl) throws IOException, InterruptedException {
				
		System.out.println("encrptFunc called");
		String ENCR_URL = clientUrl+"/encryption";

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(ENCR_URL);
	 
		String params = "{\"AESString\":\"Parichay12345\"}";

		StringEntity entity = new StringEntity(params);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
	 
		CloseableHttpResponse response = client.execute(httpPost);
		client.close();
		HttpEntity resentity = response.getEntity();
		String responseString = EntityUtils.toString(resentity, "UTF-8");
		String str =responseString;
		System.out.println(str);
		
	    Object obj=JSONValue.parse(str);  
	    JSONObject json =(JSONObject) obj  ;
	    String encrptReturnReponse = ((JSONObject) json.get("data")).get("signature").toString();
	    System.out.println("encrptReturnReponse :- " + encrptReturnReponse);
		return encrptReturnReponse;
	}

	public String hmacFunc(long timeStamp, String SERVICE,String clientUrl) throws IOException, InterruptedException {
		System.out.println("hmac function called");
		String hmacString = "Parichay"+timeStamp+"https://parichay.staging.nic.in" +"/pnv1/api/login"+SERVICE;
		
		String HMAC_URL = clientUrl+"/hmac";
		System.out.println("HMAC_URL- "+HMAC_URL);
		// java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
		// java.net.http.HttpRequest request = HttpRequest.newBuilder()
		//          .uri(URI.create(HMAC_URL))
		//          .POST(BodyPublishers.ofString(requestBody))
		//          .build();
		// java.net.http.HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());	

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(HMAC_URL);
	 
		String requestBody = "{\"HmacString\":\"" + hmacString + "\"}";

		StringEntity entity = new StringEntity(requestBody);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
	 
		CloseableHttpResponse response = client.execute(httpPost);
		client.close();
		HttpEntity resentity = response.getEntity();
		String responseString = EntityUtils.toString(resentity, "UTF-8");

   		String str =responseString;
	    System.out.println(str);
	    Object obj=JSONValue.parse(str);  
	    JSONObject json =(JSONObject) obj  ;
	    String encrptReturnReponse = ((JSONObject) json.get("data")).get("signature").toString();
	    System.out.println("hmacReturnReponse :- " + encrptReturnReponse);
	    return encrptReturnReponse ; 
	}	
	
}
