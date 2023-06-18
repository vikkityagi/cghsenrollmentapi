package io.swagger.service;

import javax.servlet.http.HttpServletRequest;

import io.swagger.model.CGHSInchargeApplication;
import io.swagger.resources.CGHSInchargeRegistrationResource;

public interface CGHSInchargeApplicationService {

    public CGHSInchargeRegistrationResource  create(HttpServletRequest request,CGHSInchargeRegistrationResource resource);
    
}
