package io.swagger.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="role_master")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="role_name")
    private String roleName;

    @ManyToMany
    private Set<ParichayUser> userList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sub_module_master_rolelist", joinColumns = @JoinColumn(name = "rolelist_id"), inverseJoinColumns = @JoinColumn(name = "sub_module_master_id"))
    private Set<SubModuleMaster> submodulemasterList;

    public boolean equals(Object obj){
        Role role =(Role)obj;
        if(this.id == role.getId())
        return true;
        return false;

    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", roleName=" + roleName + "]";
    }
   
    
}
