package io.swagger.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.joran.conditional.ElseAction;
import io.swagger.enums.ApplicationTypeEnum;
import io.swagger.repository.ApplicationNumberSequenceRepo;

@Component
public class ApplicationNumberGenerator {
    
    @Autowired
    ApplicationNumberSequenceRepo applicationNumberSequenceRep;

    private final int NUMBERLENGTH = 8;

    public  ApplicationNumberGenerator(){
    }
    
    public String generateApplicationNumber(ApplicationTypeEnum applicationType){

        Date date = new Date();
        String appTypeString = (applicationType.getValue()/100==0)?""+applicationType.getValue():null;

        int nextValue = applicationNumberSequenceRep.getNextValue().intValue();
        int len = String.valueOf(nextValue).length();
        String prefix ="";
        int temp = NUMBERLENGTH-len;
        while(temp-- > 0){prefix +="0";}
        
        if(appTypeString!=null)
            return appTypeString + prefix + nextValue;
        else
            return null;

    }




}
