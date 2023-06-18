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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Movement   {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="from_user_id")
  private ParichayUser fromUserId = null;


  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="from_office")
  private OrganizationOffice fromOffice= null;


  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="to_office")
  private OrganizationOffice toOffice= null;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="action_type")
  private ActionType actionType = null;

  @JoinColumn(name="is_new", columnDefinition = "boolean default false")
  private boolean isNew = false;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="application_id")
  private Application application;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="created_by")
  private ParichayUser createdBy;
 
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="updated_by")
  private ParichayUser updatedBy;

  @Column(name="level_no")
  private Integer levelNo;

  @Column(name="created_on")
  private LocalDateTime createdOn;

  @Column(name="updated_on")
  private LocalDateTime updatedOn;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="application_type")
  private ApplicationType applicationType;

  /**
   * this is used to send the data of nodal officer to cghsUser
  **/
  // @ManyToOne(fetch = FetchType.LAZY)
  // private CGHSCity cghsCity;



}
