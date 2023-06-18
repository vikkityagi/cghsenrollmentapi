package io.swagger.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
// this class is used for saving the nodal registration form data
@Entity
@Table(name = "application_nodal_officer_details")
@Data
@EqualsAndHashCode
@ToString

public class ApplicationNodalOfficerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnore
	@Column(name="title")
	private String title;


	@Column(name="firstname")
	private String firstname;

	@JsonIgnore
	@Column(name="middlename")
	private String middlename;
	@Column(name="lastname")
	private String lastname;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String designation;
	@Column(nullable = false)
	private String employeeid;
	@Column(nullable = false)
	private LocalDate dob;
	@Column(nullable = false)
	private LocalDate superannuation;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private CghspayScaleBean presentpaylevel;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String landline;
	
	@Column(nullable = false)
	private String mno;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private Ministry ministry;


	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private Organization organization;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private OrganizationOffice organizationOffice;
	
	@Column(nullable = false)
	private String oaddress;
	
	@JsonIgnore
	@Column(nullable = false)
	private String city;
		
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private StateModel state;
	
	@Column(nullable = false)
	private String district;

	@Column(nullable = false)
	private String pincode;

	@JsonIgnore
	@Column(name="created_on")
	private LocalDateTime createdOn;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 	
	@ManyToOne(fetch = FetchType.LAZY)
	ParichayUser createdBy;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	ParichayUser updatedBy;

	@JsonIgnore
	@Column(name="updated_on")
	private LocalDateTime updatedOn;

	@Override
	public String toString() {
		return "NodalOfficer [id=" + id + ", title=" + title + ", firstname=" + firstname + ", middlename=" + middlename
				+ ", lastname=" + lastname + ", name=" + name + ", designation=" + designation + ", employeeid="
				+ employeeid + ", dob=" + dob + ", superannuation=" + superannuation + ", email=" + email
				+ ", landline=" + landline + ", mno=" + mno + ", ministry=" + ministry + ", department=" + department
				+ ", organization=" + organization + ", officename=" + organizationOffice.getOfficeName() + ", oaddress=" + oaddress + ", city="
				+ city + ", state=" + state + ", district=" + district + ", pincode=" + pincode + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + "]";
	}

	

}
