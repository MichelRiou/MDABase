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

/**
 * Seasons generated by hbm2java
 */
@Entity
@Table(name="seasons"
    ,catalog="flyinpizzas_mdabase"
)
public class Seasons  implements java.io.Serializable {


     private Integer seasonId;
     private String seasonName;
     private Set<Models> modelses = new HashSet<Models>(0);

    public Seasons() {
    }

	
    public Seasons(String seasonName) {
        this.seasonName = seasonName;
    }
    public Seasons(String seasonName, Set<Models> modelses) {
       this.seasonName = seasonName;
       this.modelses = modelses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="season_id", nullable=false)
    public Integer getSeasonId() {
        return this.seasonId;
    }
    
    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    
    @Column(name="season_name", unique=true, nullable=false, length=6)
    public String getSeasonName() {
        return this.seasonName;
    }
    
    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="seasons")
    public Set<Models> getModelses() {
        return this.modelses;
    }
    
    public void setModelses(Set<Models> modelses) {
        this.modelses = modelses;
    }




}


