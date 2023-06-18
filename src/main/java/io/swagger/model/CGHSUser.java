package io.swagger.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Entity
@Table(name="cghs_users")  
@Data
public class CGHSUser { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name")
    private String userName;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parichayuser_id")
    private ParichayUser parichayuser;
    

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @Column(name="designation")
    private String designation;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @Column(name="emp_code")
    private String empCode;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @Column(name="email")
    private String email;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @Column(name="mobile_number")
    private String mobileNo;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="min_id")
    private Ministry ministry;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="org_id")
    private Organization organization;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dept_id")
    private Department department;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id")
    Role role;


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
    @Column(name="created_on")
    private LocalDateTime createdOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Column(name="updated_on")
    private LocalDateTime updatedOn;
    
    @OneToMany(mappedBy = "cghsUser", fetch = FetchType.LAZY)
    private Set<CGHSIncharge> cghsInchage;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private OrganizationOffice organizationOffice;
} 
 
