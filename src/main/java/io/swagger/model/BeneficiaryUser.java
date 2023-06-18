package io.swagger.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Entity
@Table(name="ben_users")  
@Data
public class BeneficiaryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parichayuser_id")
    private ParichayUser parichayuser;


    @Column(name="user_name")
    private String userName;

    @Column(name="designation")
    private String designation;

    @Column(name="emp_code")
    private String empCode;

    @Column(name="email")
    private String email;

    @Column(name="mobile_number")
    private String mobileNo;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="min_id")
    private Ministry ministry;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dept_id")
    private Department department;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="org_id")
    private Organization organization;

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

    @Column(name="deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="updated_on")
    private LocalDateTime updatedOn;

    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
	private OrganizationOffice organizationOffice;

} 
  