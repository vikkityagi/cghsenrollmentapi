package io.swagger.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="cghs_incharge_registrations")  
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CGHSInchargeApplication extends Application{

    @Column(name="name")
    private String name;

    @Column(name="designation")
    private String designation;

    @Column(name="email")
    private String email;

    @Column(name="mobile")
    private String mobile;

    @ManyToOne
    @JoinColumn(name="ministry")
    private Ministry ministry;

    @ManyToOne
    @JoinColumn(name="department")
    private Department department;
    
    @ManyToOne
    @JoinColumn(name="organization")
    private Organization organization;

    @OneToMany
    @JoinColumn(name="cghs_city")
    private Set<CGHSCity> cghscity;

    @OneToOne
    @JoinColumn(name="created_by")
    private ParichayUser createdBy;

    @OneToOne
    @JoinColumn(name="updated_by")
    private ParichayUser updateBy;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="updated_on")
    private LocalDateTime updatedOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private OrganizationOffice organizationOffice;

    

    @Override
    protected String getApplicationSignature() {
        // TODO Auto-generated method stub
        return getApplicationNumber()+"";
    }

}