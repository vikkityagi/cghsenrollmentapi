package io.swagger.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// import io.swagger.resources.FamilyMemberResource.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="family_detail")
@SQLDelete(sql = "UPDATE family_detail SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class FamilyMember {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="index_card_id")
    PrimaryBeneficiary primaryBeneficiary;


  
    @Column(name="englishname")
    private String englishName;
     

    
    @Column(name="hindiname")
    private String hindiName;

          
    @Column(name="family_id")
    private int familyId;
          
    @Column(name="ben_id")
    private String  benId;
          
   
          
    @Column(name="is_primary")
    private boolean isPrimary;
          
   
    @Column(name="deleted", columnDefinition = "boolean default false")
    private boolean deleted;
          
   
          
    @Column(name="sex")
    private String gender; 
          
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="relationship_type_code")
    private RelationshipType  relationshipType;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="blood_group_code")
    private BloodGroup  bloodGroup;

  
    @Column(name="date_of_birth",nullable=true)
    private LocalDate dateOfBirth;
          
    @Column(name="photo_url")
    private String photoUrl;
          
    @Column(name="is_disabled")
    private String isDisabled;
          
    @Column(name="mobile")
    private String mobile;
          
    @Column(name="email")
    private String email;

    @Column(name="created_on",nullable=true)
    private LocalDateTime createdOn;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by")
    ParichayUser createdBy;

    @Column(name="modified_on",nullable=true)
    private LocalDateTime modifiedOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="modified_by")
    ParichayUser modifiedBy;

    @Column(name="otp_verification")
    private String otpVerify;
          
    
}
