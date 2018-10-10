package hibernate.entities;
// Generated 10 oct. 2018 14:43:45 by Hibernate Tools 4.3.1


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

/**
 * Models generated by hbm2java
 */
@Entity
@Table(name="models"
    ,catalog="flyinpizzas_mdabase"
)
public class Models  implements java.io.Serializable {


     private Integer modelId;
     private GridSize gridSize;
     private String modelModel;
     private String modelDesignation;
     private String modelSeason;
     private Set colorses = new HashSet(0);

    public Models() {
    }

	
    public Models(GridSize gridSize, String modelModel, String modelDesignation, String modelSeason) {
        this.gridSize = gridSize;
        this.modelModel = modelModel;
        this.modelDesignation = modelDesignation;
        this.modelSeason = modelSeason;
    }
    public Models(GridSize gridSize, String modelModel, String modelDesignation, String modelSeason, Set colorses) {
       this.gridSize = gridSize;
       this.modelModel = modelModel;
       this.modelDesignation = modelDesignation;
       this.modelSeason = modelSeason;
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

    
    @Column(name="model_model", nullable=false, length=8)
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

    
    @Column(name="model_season", nullable=false, length=5)
    public String getModelSeason() {
        return this.modelSeason;
    }
    
    public void setModelSeason(String modelSeason) {
        this.modelSeason = modelSeason;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="models")
    public Set getColorses() {
        return this.colorses;
    }
    
    public void setColorses(Set colorses) {
        this.colorses = colorses;
    }




}


