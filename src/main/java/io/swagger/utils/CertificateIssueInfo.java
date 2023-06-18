package io.swagger.utils;

import lombok.Data;

@Data
public class CertificateIssueInfo {
    private String issueDNString;
    private String issuerCommonName = null;
    private String issuerOrgUnit = null;
    private String issuerOrg = null;
    private String issuerAddress = null;
    private String issuerState = null;
    private String issuerCountry = null;

    public CertificateIssueInfo(String issueDNString){
        String subTokens[] = null;
        for (String token : issueDNString.split(",")) {
            subTokens = token.split("=");
            switch (subTokens[0].trim()){
                case "CN": issuerCommonName = subTokens[1].trim(); break;
                case "OU": issuerOrgUnit = subTokens[1].trim(); break;
                case "O": issuerOrg = subTokens[1].trim(); break;
                case "L": issuerAddress = subTokens[1].trim(); break;
                case "ST": issuerState = subTokens[1].trim(); break;
                case "C": issuerCountry = subTokens[1].trim(); break;

            }

        }

    }

}
