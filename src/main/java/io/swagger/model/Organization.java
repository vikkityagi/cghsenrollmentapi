package io.swagger.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Organization
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-20T10:29:16.504Z[GMT]")

@Entity
@Table(name="levelthree")
@Data
@EqualsAndHashCode
@ToString

public class Organization {

	@Id
	@Column(name = "id")
	private String organizationCode;

	@Column(name = "name")
	private String organizationName;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentid")
	Department department;


	
}
