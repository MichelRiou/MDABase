package hibernate.entities;
// Generated 13 nov. 2018 17:17:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Roles generated by hbm2java
 */
@Entity
@Table(name="roles"
    ,catalog="flyinpizzas_mdabase"
    , uniqueConstraints = @UniqueConstraint(columnNames="role_name") 
)
public class Roles  implements java.io.Serializable {


     private Integer roleId;
     private String roleName;
     private byte roleValue;
     private Set<Users> userses = new HashSet<Users>(0);

    public Roles() {
    }

	
    public Roles(String roleName, byte roleValue) {
        this.roleName = roleName;
        this.roleValue = roleValue;
    }
    public Roles(String roleName, byte roleValue, Set<Users> userses) {
       this.roleName = roleName;
       this.roleValue = roleValue;
       this.userses = userses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="role_id", unique=true, nullable=false)
    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    
    @Column(name="role_name", unique=true, nullable=false, length=25)
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    
    @Column(name="role_value", nullable=false)
    public byte getRoleValue() {
        return this.roleValue;
    }
    
    public void setRoleValue(byte roleValue) {
        this.roleValue = roleValue;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="roles")
    public Set<Users> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }




}


