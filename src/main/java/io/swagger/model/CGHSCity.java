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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "cghs_cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class CGHSCity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "city_name")
	private String cityName;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by")
    @JsonIgnore
    ParichayUser createdBy;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="updated_by")
    @JsonIgnore
    ParichayUser updatedBy;

    @Column(name="deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="updated_on")
    private LocalDateTime updatedOn;

}
