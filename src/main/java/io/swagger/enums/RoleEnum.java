package io.swagger.enums;

public enum RoleEnum {
    Admin(5),beneficiary(1),nodal(2),approvingauthority(3), cghsuser(4);
    private long value;
    RoleEnum(long value){
        this.value = value;
    }
    public Long getValue(){
        return value;
    }

}
