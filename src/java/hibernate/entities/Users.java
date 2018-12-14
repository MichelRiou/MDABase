package hibernate.entities;
// Generated 13 nov. 2018 17:17:38 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users"
    ,catalog="flyinpizzas_mdabase"
    , uniqueConstraints = @UniqueConstraint(columnNames="user_name") 
)
public class Users  implements java.io.Serializable {


     private Integer userId;
     private Roles roles;
     private String userName;
     private String userPassword;

    public Users() {
    }

	
    public Users(Roles roles, String userName) {
        this.roles = roles;
        this.userName = userName;
    }
    public Users(Roles roles, String userName, String userPassword) {
       this.roles = roles;
       this.userName = userName;
       this.userPassword = userPassword;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="user_id", unique=true, nullable=false)
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_role", nullable=false)
    public Roles getRoles() {
        return this.roles;
    }
    
    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    
    @Column(name="user_name", unique=true, nullable=false, length=50)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    @Column(name="user_password", length=60)
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }




}


