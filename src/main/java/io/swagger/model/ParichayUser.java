package io.swagger.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ParichayUser {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToMany( fetch = FetchType.LAZY)
	private Set<Role> rolelist;
	
	@Column(unique = true,name="parichay_id")
	private String parichayId;

	@Column(unique = true,name="user_name")
	private String userName;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(mappedBy = "parichayuser", fetch = FetchType.LAZY)
	BeneficiaryUser beneficiaryUser;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(mappedBy = "parichayuser", fetch = FetchType.LAZY)
	NodalUser nodalUser;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(mappedBy = "parichayuser", fetch = FetchType.LAZY)
	CGHSUser cghsUser;

	@OneToOne(mappedBy = "parichayUser", fetch = FetchType.LAZY )
	ApprovingAuthorityUser approvingAuthorityUser;

	@Column(unique = true,name="browser_id")
	private String browserId;
	private String sessionId;
	private String localTokenId;
	private String firstName;
	private String lastName;

	@Column(unique = true,name="mobile_no")
	private String mobileNo;
	private String city;
	private String employeeCode;
	private String fullName;
	private String designation;

	@Column(unique = true,name="email")
	private String email;
	private LocalDateTime createdon;
	private LocalDateTime updateon;
	@Column(unique = true,name="ip")
	private String ip;

	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private OrganizationOffice organizationOffice;

	

	public boolean equals(Object o) {
      
		ParichayUser parichayUser = (ParichayUser) o;
		if (this.id == parichayUser.getId())
			return true;
		else
		return false;
 
 
	}
 
	@Override
    public String toString() {
        return "ParichayUser [id=" + id +  "]";
    }

	
	
}
