package io.swagger.enums;

public enum ActionTypeEnum {
    SUBMIT(1),FORWARD(2),APPROVE(3),REJECT(4),RETURN(5);
    // SUBMIT(0),FORWARD(1),APPROVE(2),REJECT(3),RETURN(4);
    private long actionType;
    ActionTypeEnum(long value){
        this.actionType = value;
    }
    public Long getValue(){
        return this.actionType;
    }
}
