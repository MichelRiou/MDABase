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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "code_colors", catalog = "flyinpizzas_mdabase", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeColors.findAll", query = "SELECT c FROM CodeColors c")
    , @NamedQuery(name = "CodeColors.findByCodeColorsId", query = "SELECT c FROM CodeColors c WHERE c.codeColorsId = :codeColorsId")
    , @NamedQuery(name = "CodeColors.findByCodeColorsCode", query = "SELECT c FROM CodeColors c WHERE c.codeColorsCode = :codeColorsCode")
    , @NamedQuery(name = "CodeColors.findByCodeColorsDesignation", query = "SELECT c FROM CodeColors c WHERE c.codeColorsDesignation = :codeColorsDesignation")})
public class CodeColors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code_colors_id", nullable = false)
    private Integer codeColorsId;
    @Basic(optional = false)
    @Column(name = "code_colors_code", nullable = false, length = 6)
    private String codeColorsCode;
    @Basic(optional = false)
    @Column(name = "code_colors_designation", nullable = false, length = 50)
    private String codeColorsDesignation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colorsCodeId")
    private Collection<Colors> colorsCollection;

    public CodeColors() {
    }

    public CodeColors(Integer codeColorsId) {
        this.codeColorsId = codeColorsId;
    }

    public CodeColors(Integer codeColorsId, String codeColorsCode, String codeColorsDesignation) {
        this.codeColorsId = codeColorsId;
        this.codeColorsCode = codeColorsCode;
        this.codeColorsDesignation = codeColorsDesignation;
    }

    public Integer getCodeColorsId() {
        return codeColorsId;
    }

    public void setCodeColorsId(Integer codeColorsId) {
        this.codeColorsId = codeColorsId;
    }

    public String getCodeColorsCode() {
        return codeColorsCode;
    }

    public void setCodeColorsCode(String codeColorsCode) {
        this.codeColorsCode = codeColorsCode;
    }

    public String getCodeColorsDesignation() {
        return codeColorsDesignation;
    }

    public void setCodeColorsDesignation(String codeColorsDesignation) {
        this.codeColorsDesignation = codeColorsDesignation;
    }

    @XmlTransient
    public Collection<Colors> getColorsCollection() {
        return colorsCollection;
    }

    public void setColorsCollection(Collection<Colors> colorsCollection) {
        this.colorsCollection = colorsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeColorsId != null ? codeColorsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeColors)) {
            return false;
        }
        CodeColors other = (CodeColors) object;
        if ((this.codeColorsId == null && other.codeColorsId != null) || (this.codeColorsId != null && !this.codeColorsId.equals(other.codeColorsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.CodeColors[ codeColorsId=" + codeColorsId + " ]";
    }
    
}
