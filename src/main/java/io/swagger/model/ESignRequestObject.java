package io.swagger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class ESignRequestObject {
    private String username;
    private String xml;
    private String acceptClientAction;
    private String responseUrl;

}
