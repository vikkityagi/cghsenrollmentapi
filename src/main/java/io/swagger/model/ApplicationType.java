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


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name="application_types")
public class ApplicationType   {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="application_type_name")
  private String applicationTypeName = null;

  @Column(name="is_deleted", columnDefinition = "boolean default false")
  private boolean deleted;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="created_by")
  ParichayUser createdBy;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="updated_by")
  ParichayUser updatedBy;


  @Column(name="created_on")
  private LocalDateTime createdOn;

  @Column(name="updated_on")
  private LocalDateTime updatedOn;

}
