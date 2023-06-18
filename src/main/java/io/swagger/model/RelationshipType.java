package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@Entity
@Table(name="relationship_types")

public class RelationshipType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column(name= "relation_name")
    private String relationName;

    @Column(name= "is_deleted", columnDefinition = "boolean default false")
    private boolean deleted;

}
