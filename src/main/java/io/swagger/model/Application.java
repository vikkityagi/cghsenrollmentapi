package io.swagger.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name="applications")  
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="application_type_code",nullable = true)
    private ApplicationType applicationType;

    @Column(name="application_number",nullable = true)
    private String applicationNumber;

    @Column(name="is_deleted",nullable=true, columnDefinition = "boolean default false")
	private boolean isDeleted;

    protected String getApplicationSignature(){
        return null;
    }
} 
  