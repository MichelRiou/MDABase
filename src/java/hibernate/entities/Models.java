/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "models", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"model_model"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Models.findAll", query = "SELECT m FROM Models m")
    , @NamedQuery(name = "Models.findByModelId", query = "SELECT m FROM Models m WHERE m.modelId = :modelId")
    , @NamedQuery(name = "Models.findByModelModel", query = "SELECT m FROM Models m WHERE m.modelModel = :modelModel")
    , @NamedQuery(name = "Models.findByModelDesignation", query = "SELECT m FROM Models m WHERE m.modelDesignation = :modelDesignation")})
public class Models implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "model_id", nullable = false)
    private Integer modelId;
    @Basic(optional = false)
    @Column(name = "model_model", nullable = false, length = 8)
    private String modelModel;
    @Basic(optional = false)
    @Column(name = "model_designation", nullable = false, length = 200)
    private String modelDesignation;
    @JoinColumn(name = "model_season_id", referencedColumnName = "season_id", nullable = false)
    @ManyToOne(optional = false)
    private Seasons modelSeasonId;
    @JoinColumn(name = "model_grid_size", referencedColumnName = "grid_size_id", nullable = false)
    @ManyToOne(optional = false)
    private GridSize modelGridSize;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleModelId")
    private Collection<Articles> articlesCollection;

    public Models() {
    }

    public Models(Integer modelId, String modelModel) {
        this.modelId = modelId;
        this.modelModel = modelModel;
    }

    public Models(String modelModel, String modelDesignation, Seasons modelSeasonId, GridSize modelGridSize) {
        this.modelModel = modelModel;
        this.modelDesignation = modelDesignation;
        this.modelSeasonId = modelSeasonId;
        this.modelGridSize = modelGridSize;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelModel() {
        return modelModel;
    }

    public void setModelModel(String modelModel) {
        this.modelModel = modelModel;
    }

    public String getModelDesignation() {
        return modelDesignation;
    }

    public void setModelDesignation(String modelDesignation) {
        this.modelDesignation = modelDesignation;
    }

    public Seasons getModelSeasonId() {
        return modelSeasonId;
    }

    public void setModelSeasonId(Seasons modelSeasonId) {
        this.modelSeasonId = modelSeasonId;
    }

    public GridSize getModelGridSize() {
        return modelGridSize;
    }

    public void setModelGridSize(GridSize modelGridSize) {
        this.modelGridSize = modelGridSize;
    }

    @XmlTransient
    public Collection<Articles> getArticlesCollection() {
        return articlesCollection;
    }

    public void setArticlesCollection(Collection<Articles> articlesCollection) {
        this.articlesCollection = articlesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelId != null ? modelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Models)) {
            return false;
        }
        Models other = (Models) object;
        if ((this.modelId == null && other.modelId != null) || (this.modelId != null && !this.modelId.equals(other.modelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.Models[ modelId=" + modelId + " ]";
    }

}
