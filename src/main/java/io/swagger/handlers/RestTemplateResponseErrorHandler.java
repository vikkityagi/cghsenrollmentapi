package io.swagger.handlers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import io.swagger.api.NotFoundException;

@Component
public class RestTemplateResponseErrorHandler   implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) 
      throws IOException {

        return !httpResponse.getStatusCode().equals(HttpStatus.OK);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) 
      throws IOException {

        if (httpResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
            // handle SERVER_ERROR
        } else if (httpResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
            // handle CLIENT_ERROR
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
              System.out.println("error occured");
            }
        }
    }
}
