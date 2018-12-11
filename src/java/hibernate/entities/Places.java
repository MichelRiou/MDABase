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
@Table(name = "places", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"place_name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Places.findAll", query = "SELECT p FROM Places p")
    , @NamedQuery(name = "Places.findByPlaceId", query = "SELECT p FROM Places p WHERE p.placeId = :placeId")
    , @NamedQuery(name = "Places.findByPlaceName", query = "SELECT p FROM Places p WHERE p.placeName = :placeName")
    , @NamedQuery(name = "Places.findByPlaceDesignation", query = "SELECT p FROM Places p WHERE p.placeDesignation = :placeDesignation")})
public class Places implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "place_id", nullable = false)
    private Integer placeId;
    @Basic(optional = false)
    @Column(name = "place_name", nullable = false, length = 6)
    private String placeName;
    @Basic(optional = false)
    @Column(name = "place_designation", nullable = false, length = 50)
    private String placeDesignation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockPlaceId")
    private Collection<Stocks> stocksCollection;

    public Places() {
    }

    public Places(Integer placeId) {
        this.placeId = placeId;
    }

    public Places(Integer placeId, String placeName, String placeDesignation) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeDesignation = placeDesignation;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDesignation() {
        return placeDesignation;
    }

    public void setPlaceDesignation(String placeDesignation) {
        this.placeDesignation = placeDesignation;
    }

    @XmlTransient
    public Collection<Stocks> getStocksCollection() {
        return stocksCollection;
    }

    public void setStocksCollection(Collection<Stocks> stocksCollection) {
        this.stocksCollection = stocksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placeId != null ? placeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Places)) {
            return false;
        }
        Places other = (Places) object;
        if ((this.placeId == null && other.placeId != null) || (this.placeId != null && !this.placeId.equals(other.placeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.Places[ placeId=" + placeId + " ]";
    }
    
}
