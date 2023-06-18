package io.swagger.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import io.swagger.resources.MovementResource;
import io.swagger.resources.MovementResponseResource;

public interface MovementService {
    
    public MovementResponseResource create(HttpServletRequest request,MovementResource body);
    public List<MovementResponseResource> tasklist(Long toUserId);
    public List<MovementResponseResource> activitylist(Long fromUserId);
    public MovementResponseResource forward(Long movementId,long roleId) throws Exception;
    
}
