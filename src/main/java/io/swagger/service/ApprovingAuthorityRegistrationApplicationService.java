package io.swagger.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import io.swagger.resources.ApprovingAuthorityRegistrationApplicationResource;
import io.swagger.resources.ApprovingAuthorityUserResource;


public interface ApprovingAuthorityRegistrationApplicationService {
    
    public ApprovingAuthorityRegistrationApplicationResource create(@Valid ApprovingAuthorityRegistrationApplicationResource approvingAuthorityRegistrationApplicationResource,HttpServletRequest request) throws Exception;
    public List<ApprovingAuthorityRegistrationApplicationResource> list();

}
