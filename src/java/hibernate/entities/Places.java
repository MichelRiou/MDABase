package hibernate.entities;
// Generated 12 oct. 2018 17:49:19 by Hibernate Tools 4.3.1


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
 * Places generated by hbm2java
 */
@Entity
@Table(name="places"
    ,catalog="flyinpizzas_mdabase"
    , uniqueConstraints = @UniqueConstraint(columnNames="place_name") 
)
public class Places  implements java.io.Serializable {


     private Integer placeId;
     private String placeName;
     private String placeDesignation;
     private Set stockses = new HashSet(0);

    public Places() {
    }

	
    public Places(String placeName, String placeDesignation) {
        this.placeName = placeName;
        this.placeDesignation = placeDesignation;
    }
    public Places(String placeName, String placeDesignation, Set stockses) {
       this.placeName = placeName;
       this.placeDesignation = placeDesignation;
       this.stockses = stockses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="place_id", unique=true, nullable=false)
    public Integer getPlaceId() {
        return this.placeId;
    }
    
    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    
    @Column(name="place_name", unique=true, nullable=false, length=6)
    public String getPlaceName() {
        return this.placeName;
    }
    
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    
    @Column(name="place_designation", nullable=false, length=50)
    public String getPlaceDesignation() {
        return this.placeDesignation;
    }
    
    public void setPlaceDesignation(String placeDesignation) {
        this.placeDesignation = placeDesignation;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="places")
    public Set getStockses() {
        return this.stockses;
    }
    
    public void setStockses(Set stockses) {
        this.stockses = stockses;
    }




}


