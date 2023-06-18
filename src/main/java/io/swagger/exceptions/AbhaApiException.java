package io.swagger.exceptions;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-09T06:53:18.360717265Z[GMT]")
public class AbhaApiException extends Exception {
    private int code;
    public AbhaApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
