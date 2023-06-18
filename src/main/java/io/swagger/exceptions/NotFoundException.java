package io.swagger.exceptions;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-09T06:53:18.360717265Z[GMT]")
public class NotFoundException extends AbhaApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
