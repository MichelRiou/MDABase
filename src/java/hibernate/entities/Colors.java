/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "colors", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"colors_model_id", "colors_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colors.findAll", query = "SELECT c FROM Colors c")
    , @NamedQuery(name = "Colors.findByColorsId", query = "SELECT c FROM Colors c WHERE c.colorsId = :colorsId")
    , @NamedQuery(name = "Colors.findByColorsModelId", query = "SELECT c FROM Colors c WHERE c.colorsModelId = :colorsModelId")
    , @NamedQuery(name = "Colors.findByColorsCode", query = "SELECT c FROM Colors c WHERE c.colorsCode = :colorsCode")
    , @NamedQuery(name = "Colors.findByColorsLibelle", query = "SELECT c FROM Colors c WHERE c.colorsLibelle = :colorsLibelle")})
public class Colors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "colors_id", nullable = false)
    private Integer colorsId;
    @Basic(optional = false)
    @Column(name = "colors_model_id", nullable = false)
    private int colorsModelId;
    @Basic(optional = false)
    @Column(name = "colors_code", nullable = false, length = 5)
    private String colorsCode;
    @Basic(optional = false)
    @Column(name = "colors_libelle", nullable = false, length = 50)
    private String colorsLibelle;

    public Colors() {
    }

    public Colors(Integer colorsId) {
        this.colorsId = colorsId;
    }

    public Colors(Integer colorsId, int colorsModelId, String colorsCode, String colorsLibelle) {
        this.colorsId = colorsId;
        this.colorsModelId = colorsModelId;
        this.colorsCode = colorsCode;
        this.colorsLibelle = colorsLibelle;
    }

    public Integer getColorsId() {
        return colorsId;
    }

    public void setColorsId(Integer colorsId) {
        this.colorsId = colorsId;
    }

    public int getColorsModelId() {
        return colorsModelId;
    }

    public void setColorsModelId(int colorsModelId) {
        this.colorsModelId = colorsModelId;
    }

    public String getColorsCode() {
        return colorsCode;
    }

    public void setColorsCode(String colorsCode) {
        this.colorsCode = colorsCode;
    }

    public String getColorsLibelle() {
        return colorsLibelle;
    }

    public void setColorsLibelle(String colorsLibelle) {
        this.colorsLibelle = colorsLibelle;
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
