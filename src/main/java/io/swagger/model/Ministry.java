package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;;

/**
 * Ministry
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-20T10:29:16.504Z[GMT]")

@Entity
@Table(name="levelone")
@Data
@EqualsAndHashCode
@ToString
public class Ministry {

	@Id
	@Column(name = "id")
	private String ministryCode;
	@Column(name = "name")
	private String ministryName;

}
