package io.swagger.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * Department
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-20T10:29:16.504Z[GMT]")

@Entity
@Data
@EqualsAndHashCode
@Table(name="leveltwo")
public class Department {

	@Id
	@Column(name = "id")
	private String departmentCode;

	@Column(name = "name")
	private String departmentName;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentid")
	Ministry ministry;

}
