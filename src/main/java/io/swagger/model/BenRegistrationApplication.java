package io.swagger.model;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode; 
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name="ben_registration_application")
public class BenRegistrationApplication  extends Application{

    // @Id
    // @GeneratedValue(strategy = GenerationType.TABLE)
    // private long id;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @OneToOne(mappedBy = "benRegistrationApplication", fetch = FetchType.LAZY)
    PrimaryBeneficiary primaryBeneficiary;

    @Column(name="parichay_id")
    private String parichayId;
          
    @Column(name="is_draft")
    private boolean isDraft;
          
    @Column(name="is_final")   
    private boolean isFinal;

    @Column(name="is_signed",nullable=true)
	private boolean isSigned;

  

	@Column(name="signed_by",nullable=true)
	private String signedBy;

	@Column(name="signed_on")
	private LocalDateTime signedOn;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @OneToOne(fetch = FetchType.LAZY)
	SigningInfo signingInfo;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by")
    ParichayUser createdBy;

    @Column(name="modified_on")
    private LocalDateTime modifiedOn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="modified_by")
    ParichayUser modifiedBy;

    @Override
    protected String getApplicationSignature() {
        // TODO Auto-generated method stub
        return getApplicationNumber()+"";
    }

    @Override
    public String toString() {
        return "BenRegistrationApplication [primaryBeneficiary=" + primaryBeneficiary + ", parichayId=" + parichayId
                + ", isDraft=" + isDraft + ", isFinal=" + isFinal + ", isSigned=" + isSigned + ", signedBy=" + signedBy
                + ", signedOn=" + signedOn + ", signingInfo=" + signingInfo + ", createdOn=" + createdOn
                + ", createdBy=" + createdBy + ", modifiedOn=" + modifiedOn + ", modifiedBy=" + modifiedBy + "]";
    }

    // @Override
    // public String toString() {
    //     return "BenRegistrationApplication [id=" + id + ", parichayId=" + parichayId + ", isDraft=" + isDraft
    //             + ", isFinal=" + isFinal + ", isSigned=" + isSigned + ", signedBy=" + signedBy + ", signedOn="
    //             + signedOn + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + "]";
    // }

    

}
