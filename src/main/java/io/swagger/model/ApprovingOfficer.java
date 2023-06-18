package io.swagger.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="approving_officer")
@Data
@EqualsAndHashCode
@ToString

public class ApprovingOfficer{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	@Column(name="designation")
	private String designation;
	@Column(name="email",unique=true)
	private String email;
	@Column(name="mobilenumber")
	private String mobileNumber;
	@Column(name="ministry")
	private String ministry;
	@Column(name="department")
	private String department;
	@Column(name="organization")
	private String organization;
	@Column(name="is_active")
	private boolean isActive;
	@Column(name="deactivation_code")
	private String deactivationDate;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="created_by")
	private ParichayUser createdBy;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="updated_by")
	private ParichayUser updatedBy;

	@Column(name="created_on")
	private LocalDateTime createdOn;
	
	@Column(name="updated_on")
	private LocalDateTime updatedOn;

}
