package io.swagger.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="sub_module_master")
public class SubModuleMaster {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="sub_module_name")
    private String submoudleName;

    @Column(name="module_path")
    private String moudlePath;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    private ModuleMaster moduleId;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="created_on")
    private Date createdOn;

    @Column(name="updated_by")
    private String updatedBy;

    @Column(name="updated_on")
    private Date updatedOn;

    @Column(name="is_delete")
    private boolean isDelete;

    @Column(name="is_active")
    private boolean isActive;

   
    
}
