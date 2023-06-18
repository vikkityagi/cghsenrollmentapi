package io.swagger.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AbhaOtpResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-09T06:53:18.360717265Z[GMT]")


public class AbhaOtpResponse   {
  @JsonProperty("expiresIn")
  private String expiresIn = null;

  @JsonProperty("refreshExpiresIn")
  private String refreshExpiresIn = null;

  @JsonProperty("refreshToken")
  private String refreshToken = null;

  @JsonProperty("token")
  private String token = null;

  public AbhaOtpResponse expiresIn(String expiresIn) {
    this.expiresIn = expiresIn;
    return this;
  }

  /**
   * Get expiresIn
   * @return expiresIn
   **/
  @Schema(description = "")
  
    public String getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(String expiresIn) {
    this.expiresIn = expiresIn;
  }

  public AbhaOtpResponse refreshExpiresIn(String refreshExpiresIn) {
    this.refreshExpiresIn = refreshExpiresIn;
    return this;
  }

  /**
   * Get refreshExpiresIn
   * @return refreshExpiresIn
   **/
  @Schema(description = "")
  
    public String getRefreshExpiresIn() {
    return refreshExpiresIn;
  }

  public void setRefreshExpiresIn(String refreshExpiresIn) {
    this.refreshExpiresIn = refreshExpiresIn;
  }

  public AbhaOtpResponse refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Get refreshToken
   * @return refreshToken
   **/
  @Schema(description = "")
  
    public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public AbhaOtpResponse token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   **/
  @Schema(description = "")
  
    public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbhaOtpResponse abhaOtpResponse = (AbhaOtpResponse) o;
    return Objects.equals(this.expiresIn, abhaOtpResponse.expiresIn) &&
        Objects.equals(this.refreshExpiresIn, abhaOtpResponse.refreshExpiresIn) &&
        Objects.equals(this.refreshToken, abhaOtpResponse.refreshToken) &&
        Objects.equals(this.token, abhaOtpResponse.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expiresIn, refreshExpiresIn, refreshToken, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbhaOtpResponse {\n");
    
    sb.append("    expiresIn: ").append(toIndentedString(expiresIn)).append("\n");
    sb.append("    refreshExpiresIn: ").append(toIndentedString(refreshExpiresIn)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
