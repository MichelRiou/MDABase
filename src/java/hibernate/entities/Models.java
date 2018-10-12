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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Models generated by hbm2java
 */
@Entity
@Table(name="models"
    ,catalog="flyinpizzas_mdabase"
    , uniqueConstraints = @UniqueConstraint(columnNames="model_model") 
)
public class Models  implements java.io.Serializable {


     private Integer modelId;
     private GridSize gridSize;
     private Seasons seasons;
     private String modelModel;
     private String modelDesignation;
     private Set colorses = new HashSet(0);

    public Models() {
    }

	
    public Models(GridSize gridSize, Seasons seasons, String modelModel, String modelDesignation) {
        this.gridSize = gridSize;
        this.seasons = seasons;
        this.modelModel = modelModel;
        this.modelDesignation = modelDesignation;
    }
    public Models(GridSize gridSize, Seasons seasons, String modelModel, String modelDesignation, Set colorses) {
       this.gridSize = gridSize;
       this.seasons = seasons;
       this.modelModel = modelModel;
       this.modelDesignation = modelDesignation;
       this.colorses = colorses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="model_id", unique=true, nullable=false)
    public Integer getModelId() {
        return this.modelId;
    }
    
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="model_grid_size", nullable=false)
    public GridSize getGridSize() {
        return this.gridSize;
    }
    
    public void setGridSize(GridSize gridSize) {
        this.gridSize = gridSize;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="model_season_id", nullable=false)
    public Seasons getSeasons() {
        return this.seasons;
    }
    
    public void setSeasons(Seasons seasons) {
        this.seasons = seasons;
    }

    
    @Column(name="model_model", unique=true, nullable=false, length=8)
    public String getModelModel() {
        return this.modelModel;
    }
    
    public void setModelModel(String modelModel) {
        this.modelModel = modelModel;
    }

    
    @Column(name="model_designation", nullable=false, length=200)
    public String getModelDesignation() {
        return this.modelDesignation;
    }
    
    public void setModelDesignation(String modelDesignation) {
        this.modelDesignation = modelDesignation;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="models")
    public Set getColorses() {
        return this.colorses;
    }
    
    public void setColorses(Set colorses) {
        this.colorses = colorses;
    }




}


