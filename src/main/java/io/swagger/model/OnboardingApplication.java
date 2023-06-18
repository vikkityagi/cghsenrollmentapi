package io.swagger.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * OnboardingApplication
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-18T12:17:29.581Z[GMT]")
@Data
@EqualsAndHashCode
@ToString

public class OnboardingApplication {

	@JsonProperty("id")
	private long id;

	@JsonProperty("parichayId")
	private String parichayId;

	@NotBlank
	@JsonProperty("title")
	private String title;

	@JsonProperty("applicationnumber")
	private String applicationnumber;
 
	@NotBlank
	@Size(min = 3, max = 100,message = " First Name Name must be between 3 and 100 characters")
	@JsonProperty("firstname")
	private String firstname;


	@NotBlank
	@Size(min = 3, max = 100,message = " Last Name Name must be between 3 and 100 characters")
	@JsonProperty("lastname")
	private String lastname;


	@Size(min = 4, max = 20,message = " Middle Name Name must be between 4 and 20 characters")
	@JsonProperty("middlename")
	private String middlename;

	@NotBlank
	@Size(min = 4, max = 20,message = " Designation must be between 4 and 20 characters")
	@JsonProperty("designation")
	private String designation;

	@NotBlank
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="it should be numeric")
	@JsonProperty("employeeid")
	private String employeeid;


	@NotNull
	@JsonProperty("dob")
	private LocalDate dob;

	@NotNull
	@JsonProperty("superannuation")
	private LocalDate superannuation;

	@NotNull
	@JsonProperty("payscaleCode")
	private Long payscaleCode;

	@JsonProperty("payscaleName")
	private String payscaleName;

    @Email(message = "Email  Should be Valid")
	@JsonProperty("email")
	private String email;

	@NotBlank
	@JsonProperty("phoneno1")
	private String phoneno1;

	@NotBlank
	@JsonProperty("phoneno2")
	private String phoneno2;

	@NotBlank
	@JsonProperty("ministry")
	private String ministry;

	@NotBlank
	@JsonProperty("department")
	private String department;

	@NotBlank
	@JsonProperty("organization")
	private String organization;

	@NotNull
	@JsonProperty("organizationOfficeId")
	private Long organizationOfficeId;

	@JsonProperty("organizationOfficeName")
	private String organizationOfficeName;


	@NotBlank
	@Size(min = 10, max = 1000,message = "Address must be between 10 and 1000 characters")
	@JsonProperty("oaddress")
	private String oaddress;

	@NotBlank
	@JsonProperty("city")
	private String city;

	@NotNull
	@JsonProperty("state")
	private Long state = 0l;

	@NotBlank
	@JsonProperty("district")
	private String district;

	@NotBlank
	@JsonProperty("pincode2")
	private String pincode2;

	@NotBlank
	@JsonProperty("file")
	private String file;

	@NotBlank
	@JsonProperty("englishname")
	private String englishname;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]*$")
	@JsonProperty("approvingdesignation")
	private String approvingdesignation;

	@NotBlank
	@Pattern(regexp = "^[0-9]*$")
	@JsonProperty("approvingemployeeid")
	private String approvingemployeeid;

	@NotBlank
	@Email(message = "Email  Should be Valid")
	@JsonProperty("approvingemail")
	private String approvingemail;

	@NotBlank
	@JsonProperty("phoneno3")
	private String phoneno3;

	@NotBlank
	@JsonProperty("phoneno4")
	private String phoneno4;

	@NotBlank
	@JsonProperty("approvingfile")
	private String approvingfile;

	@JsonProperty("nodalofficer")
	ApplicationNodalOfficerDetail nodalofficer;

	@JsonProperty("approving")
	ApprovingAuthority approving;

	@JsonProperty("checkbox1")
	private String checkbox1;

	@JsonProperty("checkbox2")
	private String checkbox2;

	@JsonProperty("checkbox3")
	private String checkbox3;

	@NotBlank
	@Pattern(regexp = "^[0-9]*$")
	@JsonProperty("strength")
	private String strength;

	@JsonProperty("file1")
	private String file1;


	@JsonProperty("file2")
	private String file2;

	@JsonProperty("formFlag")
	private int formFlag;

	@NotNull
	@JsonProperty("cghsCities")
	private Long[] cghsCities;

	@JsonProperty("issigned")
	private boolean issigned;

	@JsonProperty("signedon")
	private LocalDateTime signedon;

	@JsonProperty("signedby")
	private String signedby;

	@JsonProperty("createdon")
	private LocalDateTime createdOn;

	@JsonProperty("updatedon")
	private LocalDateTime updatedOn;


}
