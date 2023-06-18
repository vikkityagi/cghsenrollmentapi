package io.swagger.service;

import java.util.List;

import org.springframework.http.HttpHeaders;

import io.swagger.model.ESignRequestObject;
import io.swagger.model.NodalApplicationDetail;
import io.swagger.model.OnboardingApplication;

public interface OnboardingService {

    public OnboardingApplication create(OnboardingApplication onboardingApplication);

    public List<NodalApplicationDetail> finalApplication(String id);

    public OnboardingApplication getOnBoardingApplication(int applicationId,String fields[]);

    public List<OnboardingApplication> list();

    public NodalApplicationDetail eSignOnboardingApplication(Long applicationId);

    public void eSignResponseOnboardingApplication(Long applicationId, String response);
    
}
