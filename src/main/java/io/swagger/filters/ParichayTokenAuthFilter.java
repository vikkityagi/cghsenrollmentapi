package io.swagger.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ReaderEventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.conditional.ElseAction;
import io.swagger.model.ParichayUser;
import io.swagger.repository.ActionTypeRepo;
import io.swagger.repository.ParichayUserRepo;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.ResourceBundle;


@Component
public class ParichayTokenAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic
    }

    @Autowired
    private ParichayUserRepo parichayUserRepo;

    @Autowired
    private ActionTypeRepo actionTypeRepo;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
                request.setAttribute("currentUserId", 1l);

                chain.doFilter(request, response);

        //         Optional<ParichayUser> parichay = parichayUserRepo.findById(1L);
        // HttpServletRequest httpRequest = (HttpServletRequest) request;
        // HttpServletResponse httpResponse = (HttpServletResponse) response;
        // Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        // String tokenValue = "", browserId = "", sessionId = "", userName= "";
        // System.out.println("in filter code ");
        // String referer = httpRequest.getHeader("Referer");
        // System.out.println("referer-"+referer);
        // // check if request is for protected api resources 
        // if (httpRequest.getRequestURI().startsWith("/api/")) {

        //     if(httpRequest.getRequestURI().endsWith("/home") || httpRequest.getRequestURI().endsWith("/login") || httpRequest.getRequestURI().endsWith("/RoleRegistrationsName")){
        //         chain.doFilter(request, response);
    //             Optional<ParichayUser> parichay = parichayUserRepo.findById(1L);
    //     HttpServletRequest httpRequest = (HttpServletRequest) request;
    //     HttpServletResponse httpResponse = (HttpServletResponse) response;
    //     Cookie[] cookies = ((HttpServletRequest) request).getCookies();
    //     String tokenValue = "", browserId = "", sessionId = "", userName= "";
    //     System.out.println("in filter code ");
    //     String referer = httpRequest.getHeader("Referer");
    //     System.out.println("referer-"+referer);
    //     // check if request is for protected api resources 
    //     if (httpRequest.getRequestURI().startsWith("/api/")) {

    //         if(httpRequest.getRequestURI().endsWith("/home") || httpRequest.getRequestURI().endsWith("/login") || httpRequest.getRequestURI().endsWith("/RoleRegistrationsName")){
    //             chain.doFilter(request, response);
    //        }else{
    //         // get cookies from the request

    //         if(httpRequest.getCookies()!= null){
    //         for (Cookie cookie : cookies) {
    //             System.out.println("run this" + cookie.getName() + ":" + cookie.getValue());
    //             if (cookie.getName().equalsIgnoreCase("localTokenId")) {
    //                 tokenValue = cookie.getValue();
    //             } else if (cookie.getName().equalsIgnoreCase("sessionId")) {
    //                 sessionId = cookie.getValue();
    //             } else if (cookie.getName().equalsIgnoreCase("browserId")) {
    //                 browserId = cookie.getValue();
    //             }
    //             else if (cookie.getName().equalsIgnoreCase("userName")) {
    //                 userName = cookie.getValue();
    //             }
    //         }
    //     }
        
            // check if token is null 
            // if (tokenValue.equals("")) {
            //     httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied"); // Reject the request
            // } else {
                // check if token is valid
                // if (isTokenValid(userName, "CGHS", sessionId, browserId, tokenValue)) {
                    // get User id from the database by the token value
                    // set userId to request object
                    //request.setAttribute("currentUserId", userId);
                    

                    // ParichayUser parichayUser = parichayUserRepo.findByLocalTokenId(tokenValue);
                    // if(parichayUser!=null){
                    //     throw new Exception("Data error: " + tokenValue+ " not found");
                    // }else{, Exception
                    //     request.setAttribute("currentUserId", parichayUser.getId());
                    // }
                //     System.out.println("tokenValue"+tokenValue);

                //     Optional<ParichayUser> parichayUser1 = parichayUserRepo.findById(1L);
                //     System.out.println("this:::"+parichayUser1);
                //     ParichayUser parichayUser = parichayUserRepo.findByLocalTokenId(tokenValue);
                //     if(parichayUser!=null)
                //         httpRequest.setAttribute("currentUserId", parichayUser.getId());
                    
                //     System.out.println("httpRequest.getCurrentUserId()="+httpRequest.getAttribute("currentUserId"));

                //     chain.doFilter(request, response);
                // } else {
                //     // send error if token if token is invalid
                    // httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
    //             }
    //         }
    //     }
    // }else{
    //     chain.doFilter(request, response);
    //     }
    }

    private boolean isTokenValid(String userName, String SERVICE, String sessionId, String browserId,
            String localTokenId) throws IOException {

        System.out.println("=============Hmac hmac_istokenvalid Function Called==================");

        HttpGet httpGet = new HttpGet(ResourceBundle.getBundle("config").getString("Token_validate")
        +"?userName="+ URLEncoder.encode(userName, StandardCharsets.UTF_8)
        +"&service="+ URLEncoder.encode("CGHS", StandardCharsets.UTF_8)
        +"&sessionId="+ URLEncoder.encode(sessionId, StandardCharsets.UTF_8)
        +"&browserId="+ URLEncoder.encode(browserId, StandardCharsets.UTF_8)
        +"&localTokenId="+ URLEncoder.encode(localTokenId, StandardCharsets.UTF_8)
        );
        System.out.println("httpPost : " + httpGet);
      

        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse clientResponse = httpClient.execute(httpGet);
        String result = EntityUtils.toString(clientResponse.getEntity());
        System.out.println("API response:- " + result.toString());
        Object obj = JSONValue.parse(result);
        JSONObject json = (JSONObject) obj;
        String statusMessage =  json.get("status").toString();
        String tokenValidString = json.get("tokenValid").toString();
        System.out.println("statusMessage-"+statusMessage+" tokenValidString-"+ tokenValidString);
        if (tokenValidString.equalsIgnoreCase("true"))
            return true;
        else
            return false;
    }

    @Override
    public void destroy() {
        // Cleanup logic
    }
}
