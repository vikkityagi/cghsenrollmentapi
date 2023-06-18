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
@Table(name="cghsdept")
@Data
@EqualsAndHashCode
@ToString

public class DeptModel {
	
	@Id
	@Column(name="serialno")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int did;
	
	@Column(name = "dept_name")
	private String deptname;


}
