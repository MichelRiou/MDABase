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
@Table(name = "colors", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"colors_model_id", "colors_code_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colors.findAll", query = "SELECT c FROM Colors c")
    , @NamedQuery(name = "Colors.findByColorsId", query = "SELECT c FROM Colors c WHERE c.colorsId = :colorsId")
    , @NamedQuery(name = "Colors.findByColorsLibelle", query = "SELECT c FROM Colors c WHERE c.colorsLibelle = :colorsLibelle")})
public class Colors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "colors_id", nullable = false)
    private Integer colorsId;
    @Basic(optional = false)
    @Column(name = "colors_libelle", nullable = false, length = 50)
    private String colorsLibelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "articleColorId")
    private Collection<Articles> articlesCollection;
    @JoinColumn(name = "colors_code_id", referencedColumnName = "code_colors_id", nullable = false)
    @ManyToOne(optional = false)
    private CodeColors colorsCodeId;
    @JoinColumn(name = "colors_model_id", referencedColumnName = "model_id", nullable = false)
    @ManyToOne(optional = false)
    private Models colorsModelId;

    public Colors() {
    }

    public Colors(Integer colorsId) {
        this.colorsId = colorsId;
    }

    public Colors(Integer colorsId, String colorsLibelle) {
        this.colorsId = colorsId;
        this.colorsLibelle = colorsLibelle;
    }

    public Integer getColorsId() {
        return colorsId;
    }

    public void setColorsId(Integer colorsId) {
        this.colorsId = colorsId;
    }

    public String getColorsLibelle() {
        return colorsLibelle;
    }

    public void setColorsLibelle(String colorsLibelle) {
        this.colorsLibelle = colorsLibelle;
    }

    @XmlTransient
    public Collection<Articles> getArticlesCollection() {
        return articlesCollection;
    }

    public void setArticlesCollection(Collection<Articles> articlesCollection) {
        this.articlesCollection = articlesCollection;
    }

    public CodeColors getColorsCodeId() {
        return colorsCodeId;
    }

    public void setColorsCodeId(CodeColors colorsCodeId) {
        this.colorsCodeId = colorsCodeId;
    }

    public Models getColorsModelId() {
        return colorsModelId;
    }

    public void setColorsModelId(Models colorsModelId) {
        this.colorsModelId = colorsModelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (colorsId != null ? colorsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colors)) {
            return false;
        }
        Colors other = (Colors) object;
        if ((this.colorsId == null && other.colorsId != null) || (this.colorsId != null && !this.colorsId.equals(other.colorsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.Colors[ colorsId=" + colorsId + " ]";
    }
    
}
