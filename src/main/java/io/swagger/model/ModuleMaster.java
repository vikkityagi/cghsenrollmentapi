package io.swagger.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="module_master")
public class ModuleMaster {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="module_name")
    private String moduleName;

    @Column(name="module_path")
    private String modulePath;


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
