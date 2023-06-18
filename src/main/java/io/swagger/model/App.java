package io.swagger.model;

import javax.persistence.*;

import lombok.Data;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name="app")  

@Data
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(name="application_type_code",nullable = true)
    private long application_type_code;

    @Column(name="application_number",nullable = true)
    private String applicationNumber;

    @Column(name="is_deleted",nullable=true, columnDefinition = "boolean default false")
	private boolean isDeleted;

    protected String getApplicationSignature(){
        return null;
    }
} 
  