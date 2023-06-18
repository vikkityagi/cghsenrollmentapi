package io.swagger.resources;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;



/**
 * AdRoleResources
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-14T07:07:34.520234324Z[GMT]")


public class AdRoleResources {

    @JsonProperty("id")
  private Long id = null;

  @JsonProperty("parichayUser")
  private Long parichayUser;

  @JsonProperty("cghsCity")
  private int cghsCity;

  

  public AdRoleResources id(Long id) {
    this.id = id;
    return this;
  }


  @Schema(description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AdRoleResources parichayUser(Long parichayUser) {
    this.parichayUser = parichayUser;
    return this;
  }

  /**
   * Get parichayUser
   * @return parichayUser
   **/
  @Schema(description = "")
  
    public Long getparichayUser() {
    return parichayUser;
  }

  public void setparichayUser(Long parichayUser) {
    this.parichayUser = parichayUser;
  }

  public AdRoleResources cghsCity(int cghsCity) {
    this.cghsCity = cghsCity;
    return this;
  }

  /**
   * Get cghsCity
   * @return cghsCity
   **/
  @Schema(description = "")
  
    public int getcghsCity() {
    return cghsCity;
  }

  public void setcghsCity(int cghsCity) {
    this.cghsCity = cghsCity;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdRoleResources AdRoleResources = (AdRoleResources) o;
    return Objects.equals(this.id, AdRoleResources.id) &&
        Objects.equals(this.parichayUser, AdRoleResources.parichayUser) &&
        Objects.equals(this.cghsCity, AdRoleResources.cghsCity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parichayUser, cghsCity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdRoleResources {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    parichayUser: ").append(toIndentedString(parichayUser)).append("\n");
    sb.append("    cghsCity: ").append(toIndentedString(cghsCity)).append("\n");
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
