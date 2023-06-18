package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="role_registration_table")
@Data
public class RoleRegistration {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @OneToOne(fetch = FetchType.LAZY)
    Role role;

    @Column(name="reg_link_name")
    private String regLinkName;

    @Column(name="reg_link_path")
    private String regLinkPath;


    @Override
    public String toString() {
        return "RoleRegistration [id=" + id + ", role=" + role + ", regLinkName=" + regLinkName + ", regLinkPath="
                + regLinkPath + "]";
    }

}
