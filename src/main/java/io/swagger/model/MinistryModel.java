package io.swagger.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="cghs_ministry")
@Data
@EqualsAndHashCode
@ToString

public class MinistryModel {
	
	@Id
	@Column(name="serial_no")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="cghs_ministryname")
	private String ministryname;

}
