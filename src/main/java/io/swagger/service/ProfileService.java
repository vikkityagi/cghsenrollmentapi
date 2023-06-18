package io.swagger.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.swagger.resources.ParichayUserResource;
import io.swagger.resources.ProfileResource;

public interface ProfileService {
    
    public ParichayUserResource create(ProfileResource profileResource,HttpServletRequest request) throws Exception;

    public ProfileResource get(Long parichayUserId) throws Exception;

    public List<ProfileResource> list(Long parichayUserId) throws Exception;

    public String edit(long id,long RoleId,ProfileResource profileResource);

    public ProfileResource patch(long id,long roleId);
}
