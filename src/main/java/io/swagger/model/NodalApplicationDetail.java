package io.swagger.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="application_detail")
@AllArgsConstructor
@NoArgsConstructor
public class NodalApplicationDetail extends Application{
	 
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY)
	ApplicationNodalOfficerDetail nodalOfficer;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY)
	ApprovingAuthority approvingAuthority;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY)
	SigningInfo signingInfo;

	@Column(nullable=true)
	private String parichayId;
	
	@Column(nullable=false)
	private String strength;

	
	@Column(name="created_on",nullable=true)
	private LocalDateTime createdOn;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private ParichayUser createdBy;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private ParichayUser updatedBy;


	@Column(name="updated_on",nullable=true)
	private LocalDateTime updatedOn;

	@Column(name="is_signed",nullable=true)
	private boolean isSigned;

	@Column(name="is_submitted",nullable=true)
	private boolean isSubmitted;


	@Column(name="signed_by",nullable=true)
	private String signedBy;

	@Column(name="signed_on",nullable=true)
	private LocalDateTime signedOn;

	
	@ManyToMany
	@JoinTable(
			  name = "application_cities", 
			  joinColumns = @JoinColumn(name = "application_detail_id"), 
			  inverseJoinColumns = @JoinColumn(name = "cghs_city_id"))
	List<CGHSCity> cghsCities = new ArrayList<CGHSCity>();
 
   
	@Override
	public String toString() {
		return "NodalApplicationDetail [parichayId=" + parichayId + ", strength=" + strength
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", isSigned=" + isSigned + ", signedBy="
				+ signedBy + ", signedOn=" + signedOn + "]";
	}
	@Override
    protected String getApplicationSignature() {
        return getApplicationNumber()+"";
    }


	
		
}
