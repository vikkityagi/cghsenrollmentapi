package io.swagger.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="org_offices")
@Entity
public class OrganizationOffice {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="office_name")
    private String officeName;
    
    @Column(name="office_short_name")
    private String  officeShortName;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="updated_on")
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name="created_by")
    private ParichayUser createdBy;
    
    @ManyToOne
    @JoinColumn(name="updated_by")
    private ParichayUser updatedBy;
    

    @Column(name="deleted")
    private boolean deleted;
    
    @Column(name="active")
    private boolean active;
    
    @ManyToOne
    @JoinColumn(name="organization_id")
    private Organization organization;

}
