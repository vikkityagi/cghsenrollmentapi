package io.swagger.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AbhaOTPAPIObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-09T06:53:18.360717265Z[GMT]")


public class AbhaOTPAPIObject   {
  @JsonProperty("otp")
  private String otp = null;

  @JsonProperty("txnId")
  private String txnId = null;

  public AbhaOTPAPIObject otp(String otp) {
    this.otp = otp;
    return this;
  }

  /**
   * Get otp
   * @return otp
   **/
  @Schema(example = "106745", description = "")
  
    public String getOtp() {
    return otp;
  }

  public void setOtp(String otp) {
    this.otp = otp;
  }

  public AbhaOTPAPIObject txnId(String txnId) {
    this.txnId = txnId;
    return this;
  }

  /**
   * Get txnId
   * @return txnId
   **/
  @Schema(example = "23-2345-1234-2345", description = "")
  
    public String getTxnId() {
    return txnId;
  }

  public void setTxnId(String txnId) {
    this.txnId = txnId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbhaOTPAPIObject abhaOTPAPIObject = (AbhaOTPAPIObject) o;
    return Objects.equals(this.otp, abhaOTPAPIObject.otp) &&
        Objects.equals(this.txnId, abhaOTPAPIObject.txnId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(otp, txnId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbhaOTPAPIObject {\n");
    
    sb.append("    otp: ").append(toIndentedString(otp)).append("\n");
    sb.append("    txnId: ").append(toIndentedString(txnId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
