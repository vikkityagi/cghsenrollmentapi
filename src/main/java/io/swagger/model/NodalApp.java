package io.swagger.model;

import javax.persistence.*;

import lombok.Data;


@Entity
@Table(name="nodal_app")  
@Data
public class NodalApp extends App {
    // @Id
    // @GeneratedValue(strategy = GenerationType.TABLE)
    // private long id;

    @Column(name="nodal_type",nullable = true)
    private String nodalType;

    @Column(name="nodal_name",nullable = true)
    private String nodalName;

    @Column(name="is_deleted",nullable=true, columnDefinition = "boolean default false")
	private boolean isDeleted;

    protected String getApplicationSignature(){
        return null;
    }
} 
  