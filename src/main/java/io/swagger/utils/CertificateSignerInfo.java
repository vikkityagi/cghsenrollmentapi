package io.swagger.utils;

import lombok.Data;


@Data
public class CertificateSignerInfo {
    private String signerCommonName = null;
    private String signerCategory = null;
    private String signerState = null;
    private String signerCountry = null;
    public CertificateSignerInfo(String subjectDN){
        String[] subTokens = null;
        for (String token : subjectDN.split(",")) {
            subTokens = token.split("=");
            switch (subTokens[0].trim()){
                case "CN": signerCommonName = subTokens[1].trim(); break;
                case "O": signerCategory = subTokens[1].trim(); break;
                case "ST": signerState = subTokens[1].trim(); break;
                case "C": signerCountry = subTokens[1].trim(); break;
            }
            
        }
    }
}
