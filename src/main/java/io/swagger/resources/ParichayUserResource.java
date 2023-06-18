package io.swagger.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParichayUserResource {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mobileNo")
    private String mobileNo;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("parichayId")
    private String parichayId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("browserId")
    private String browserId;

    @JsonProperty("sessionId")
	private String sessionId;

    @JsonProperty("localTokenId")
	private String localTokenId;

    @JsonProperty("employeeCode")
    private String employeeCode;

    @JsonProperty("organiztionOfficeName")
    private String organiztionOfficeName;

    @JsonProperty("ip")
    private String ip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getParichayId() {
        return parichayId;
    }

    public void setParichayId(String parichayId) {
        this.parichayId = parichayId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBrowserId() {
        return browserId;
    }

    public void setBrowserId(String browserId) {
        this.browserId = browserId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLocalTokenId() {
        return localTokenId;
    }

    public void setLocalTokenId(String localTokenId) {
        this.localTokenId = localTokenId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOrganiztionOfficeName() {
        return organiztionOfficeName;
    }

    public void setOrganiztionOfficeName(String organiztionOfficeName) {
        this.organiztionOfficeName = organiztionOfficeName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
}
