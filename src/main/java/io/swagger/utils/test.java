package io.swagger.utils;
import java.io.IOException;
public class test {
	public static String  login(String Service,String clientUrl) throws InterruptedException, IOException 
	{
		    System.out.println("Login Func called.");
		    long timeStamp = System.currentTimeMillis();
		    
			System.out.println("timeStamp : "+timeStamp);
			String hmac_sign = hmacFunc(timeStamp,Service,clientUrl);
			
			System.out.println("hmac_response : " + hmac_sign);
			String  encrpt_sign = encrptFunc(clientUrl);
	        
			System.out.println("encryption_response : " + encrpt_sign);
	        
			String loginURL = "https://parichay.staging.nic.in/pnv1/api/login?sid=" + Service + "&tid="
					+ timeStamp + "&cs=" + hmac_sign + "&string=" + encrpt_sign + "&lang=ma";
			System.out.println(loginURL );
			
			return loginURL;
	     					
	}

	public static String encrptFunc(String clientUrl) throws IOException, InterruptedException {
				
		// System.out.println("encrptFunc called");
		// String ENCR_URL = clientUrl+"/encryption";
		// String requestBody = "{\"AESString\":\"Parichay12345\"}";
		// HttpClient client = HttpClient.newHttpClient();
		// HttpRequest request = HttpRequest.newBuilder()
		//          .uri(URI.create(ENCR_URL))
		//          .POST(BodyPublishers.ofString(requestBody))
		//          .build();			   
		// HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());	   			
		// String str =response.body();
		// System.out.println(str);
		
	    // Object obj=JSONValue.parse(str);  
	    // JSONObject json =(JSONObject) obj  ;
	    // String encrptReturnReponse = ((JSONObject) json.get("data")).get("signature").toString();
	    // System.out.println("encrptReturnReponse :- " + encrptReturnReponse);
		// return encrptReturnReponse;
		return null;
	}

	public static String hmacFunc(long timeStamp, String SERVICE,String clientUrl) throws IOException, InterruptedException {
		// System.out.println("hmac function called");
		// String hmacString = "Parichay"+timeStamp+"https://parichay.staging.nic.in" +"/pnv1/api/login"+SERVICE;
		// String requestBody = "{\"HmacString\":\"" + hmacString + "\"}";
		// System.out.println("requestBody= "+requestBody);
		// String HMAC_URL = clientUrl+"/hmac";
		// System.out.println("HMAC_URL- "+HMAC_URL);
		// HttpClient client = HttpClient.newHttpClient();
		// HttpRequest request = HttpRequest.newBuilder()
		//          .uri(URI.create(HMAC_URL))
		//          .POST(BodyPublishers.ofString(requestBody))
		//          .build();
   		// HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());	
   		// String str =response.body();
	    // System.out.println(str);
	    // Object obj=JSONValue.parse(str);  
	    // JSONObject json =(JSONObject) obj  ;
	    // String encrptReturnReponse = ((JSONObject) json.get("data")).get("signature").toString();
	    // System.out.println("hmacReturnReponse :- " + encrptReturnReponse);
	    // return encrptReturnReponse ;
		return null;
	}	
	
	public static void main(String[] args) throws InterruptedException, IOException {  
	    

		// String service = "CGHS";
		// String clientUrl = "http://127.0.0.1:9001";
		// String loginURL = login(service,clientUrl);
		// HttpClient client = HttpClient.newHttpClient();
		// HttpRequest request = HttpRequest.newBuilder()
		//          .uri(URI.create(loginURL)).GET().build();
		        
   		// HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());	
   		// String str =response.body();
   		// HttpHeaders responseHeader  =  response.headers();
   		// for(String key: responseHeader.map().keySet()) {
   		// 	System.out.println(key+" - "+responseHeader.map().get(key));
   		// }
   		// System.out.println("str-"+str);
		
	}

	
}
 