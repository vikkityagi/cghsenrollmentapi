package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NavigationLink {
    @JsonProperty("nav_name")
    private String navigationName;
    @JsonProperty("nav_link")
    private String navigationLinkUrl;
    @JsonProperty("roleId")
    private Long roleId;

    public NavigationLink(String navigationName, String navigationLinkUrl) {
        this.navigationName = navigationName;
        this.navigationLinkUrl = navigationLinkUrl;
    }
    public String getNavigationName() {
        return navigationName;
    }
    public void setNavigationName(String navigationName) {
        this.navigationName = navigationName;
    }
    public String getNavigationLinkUrl() {
        return navigationLinkUrl;
    }
    public void setNavigationLinkUrl(String navigationLinkUrl) {
        this.navigationLinkUrl = navigationLinkUrl;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
}
