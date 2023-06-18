package io.swagger.model;

import javax.persistence.*;

import lombok.Data;


@Entity
@Table(name="ben_app")  
@Data
public class BeneficiaryApp extends App {
    // @Id
    // @GeneratedValue(strategy = GenerationType.TABLE)
    // private long id;

    @Column(name="ben_type",nullable = true)
    private String beneficiaryType;

    @Column(name="ben_name",nullable = true)
    private String beneficiaryName;

    @Column(name="is_deleted",nullable=true, columnDefinition = "boolean default false")
	private boolean isDeleted;

    protected String getApplicationSignature(){
        return null;
    }
} 
  