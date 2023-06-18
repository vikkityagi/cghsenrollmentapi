package io.swagger.model;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="approving_authority")
@Data
@EqualsAndHashCode
@ToString

public class ApprovingAuthority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String designation;
	
	@Column(nullable=false)
	private String employeeId;
	
	@Column(nullable=false)
	private String emailAddress;
	
	@Column(nullable=false)
	private String landline;
	
	@Column(nullable=false)
	private String mobileNo;
	
	@Column(nullable=false)
	private String employeeIdPath;

	@Column(name="created_on")
	private LocalDateTime createdOn;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="created_by")
	ParichayUser createdBy;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="updated_by", nullable=true)
	ParichayUser updatedBy;
 
	@Column(name="updated_on")
	private LocalDateTime updatedOn;
	
}
