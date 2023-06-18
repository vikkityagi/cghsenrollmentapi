
package io.swagger.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "cghs_incharge")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CGHSIncharge {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    private CGHSCity cghsCity;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    private CGHSUser cghsUser;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by") 
    ParichayUser createdBy;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="updated_by")
    ParichayUser updatedBy;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @Column(name="deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @Column(name="active", columnDefinition = "boolean default false")
    private boolean active;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @Column(name="created_on")
    private LocalDateTime createdOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @Column(name="updated_on")
    private LocalDateTime updatedOn;

    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private OrganizationOffice organizationOffice;


}
