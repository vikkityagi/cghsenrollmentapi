package io.swagger.enums;

public enum ApplicationLevel {
    ZERO(0),ONE(1),TWO(2);
    private int value;
    ApplicationLevel(int level){
        this.value = level;

    }
    public int getValue(){
        return value;
    }
}
