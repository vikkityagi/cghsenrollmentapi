package io.swagger.enums;

import io.swagger.model.CGHSIncharge;

public enum ApplicationTypeEnum {
    NodalOfficerEnrollmentApplication(10),
    BeneficiaryEnrollmentApplication(11),
    PensionerEnrollmentApplication(12),
    ApprovingAuthorityEnrollmentApplication(13),
    CGHSInchargeEnrollmentApplication(14);
    private long value;

    ApplicationTypeEnum(long value){
        this.value = value;
    }
    public long getValue(){
        return value;
    }

}
