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
@Table(name = "grid_size", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"grid_size_name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GridSize.findAll", query = "SELECT g FROM GridSize g")
    , @NamedQuery(name = "GridSize.findByGridSizeId", query = "SELECT g FROM GridSize g WHERE g.gridSizeId = :gridSizeId")
    , @NamedQuery(name = "GridSize.findByGridSizeName", query = "SELECT g FROM GridSize g WHERE g.gridSizeName = :gridSizeName")
    , @NamedQuery(name = "GridSize.findByGs01", query = "SELECT g FROM GridSize g WHERE g.gs01 = :gs01")
    , @NamedQuery(name = "GridSize.findByGs02", query = "SELECT g FROM GridSize g WHERE g.gs02 = :gs02")
    , @NamedQuery(name = "GridSize.findByGs03", query = "SELECT g FROM GridSize g WHERE g.gs03 = :gs03")
    , @NamedQuery(name = "GridSize.findByGs04", query = "SELECT g FROM GridSize g WHERE g.gs04 = :gs04")
    , @NamedQuery(name = "GridSize.findByGs05", query = "SELECT g FROM GridSize g WHERE g.gs05 = :gs05")
    , @NamedQuery(name = "GridSize.findByGs06", query = "SELECT g FROM GridSize g WHERE g.gs06 = :gs06")
    , @NamedQuery(name = "GridSize.findByGs07", query = "SELECT g FROM GridSize g WHERE g.gs07 = :gs07")
    , @NamedQuery(name = "GridSize.findByGs08", query = "SELECT g FROM GridSize g WHERE g.gs08 = :gs08")
    , @NamedQuery(name = "GridSize.findByGs09", query = "SELECT g FROM GridSize g WHERE g.gs09 = :gs09")
    , @NamedQuery(name = "GridSize.findByGs10", query = "SELECT g FROM GridSize g WHERE g.gs10 = :gs10")
    , @NamedQuery(name = "GridSize.findByGs11", query = "SELECT g FROM GridSize g WHERE g.gs11 = :gs11")
    , @NamedQuery(name = "GridSize.findByGs12", query = "SELECT g FROM GridSize g WHERE g.gs12 = :gs12")
    , @NamedQuery(name = "GridSize.findByGs13", query = "SELECT g FROM GridSize g WHERE g.gs13 = :gs13")
    , @NamedQuery(name = "GridSize.findByGs14", query = "SELECT g FROM GridSize g WHERE g.gs14 = :gs14")
    , @NamedQuery(name = "GridSize.findByGs15", query = "SELECT g FROM GridSize g WHERE g.gs15 = :gs15")
    , @NamedQuery(name = "GridSize.findByGs16", query = "SELECT g FROM GridSize g WHERE g.gs16 = :gs16")
    , @NamedQuery(name = "GridSize.findByGs17", query = "SELECT g FROM GridSize g WHERE g.gs17 = :gs17")
    , @NamedQuery(name = "GridSize.findByGs18", query = "SELECT g FROM GridSize g WHERE g.gs18 = :gs18")
    , @NamedQuery(name = "GridSize.findByGs19", query = "SELECT g FROM GridSize g WHERE g.gs19 = :gs19")
    , @NamedQuery(name = "GridSize.findByGs20", query = "SELECT g FROM GridSize g WHERE g.gs20 = :gs20")})
public class GridSize implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grid_size_id", nullable = false)
    private Integer gridSizeId;
    @Basic(optional = false)
    @Column(name = "grid_size_name", nullable = false, length = 20)
    private String gridSizeName;
    @Column(name = "GS01", length = 6)
    private String gs01;
    @Column(name = "GS02", length = 6)
    private String gs02;
    @Column(name = "GS03", length = 6)
    private String gs03;
    @Column(name = "GS04", length = 6)
    private String gs04;
    @Column(name = "GS05", length = 6)
    private String gs05;
    @Column(name = "GS06", length = 6)
    private String gs06;
    @Column(name = "GS07", length = 6)
    private String gs07;
    @Column(name = "GS08", length = 6)
    private String gs08;
    @Column(name = "GS09", length = 6)
    private String gs09;
    @Column(name = "GS10", length = 6)
    private String gs10;
    @Column(name = "GS11", length = 6)
    private String gs11;
    @Column(name = "GS12", length = 6)
    private String gs12;
    @Column(name = "GS13", length = 6)
    private String gs13;
    @Column(name = "GS14", nullable = true, length = 6)
    private String gs14;
    @Basic(optional = true)
    @Column(name = "GS15", nullable = true, length = 6)
    private String gs15;
    @Basic(optional = true)
    @Column(name = "GS16", nullable = true, length = 6)
    private String gs16;
    @Basic(optional = true)
    @Column(name = "GS17", nullable = true, length = 6)
    private String gs17;
    @Basic(optional = true)
    @Column(name = "GS18", nullable = true, length = 6)
    private String gs18;
    @Basic(optional = true)
    @Column(name = "GS19", nullable = true, length = 6)
    private String gs19;
    @Basic(optional = true)
    @Column(name = "GS20", nullable = true, length = 6)
    private String gs20;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelGridSize")
    private Collection<Models> modelsCollection;

    public GridSize() {
    }

    public GridSize(Integer gridSizeId) {
        this.gridSizeId = gridSizeId;
    }

    public GridSize(Integer gridSizeId, String gridSizeName, String gs01, String gs02, String gs03, String gs04, String gs05,String gs06, String gs07, String gs08, String gs09, String gs10, String gs11, String gs12,String gs13,String gs14,String gs15, String gs16, String gs17, String gs18, String gs19, String gs20) {
        this.gridSizeId = gridSizeId;
        this.gridSizeName = gridSizeName;
        this.gs01 = gs01;
        this.gs02 = gs02;
        this.gs03 = gs03;
        this.gs04 = gs04;
        this.gs05 = gs05;
        this.gs06 = gs06;
        this.gs07 = gs07;
        this.gs08 = gs08;
        this.gs09 = gs09;
        this.gs10 = gs10;
        this.gs11 = gs11;
        this.gs12 = gs12;
        this.gs13 = gs13;
        this.gs14 = gs14;
        this.gs15 = gs15;
        this.gs16 = gs16;
        this.gs17 = gs17;
        this.gs18 = gs18;
        this.gs19 = gs19;
        this.gs20 = gs20;
    }
    public GridSize(String gridSizeName, String gs01, String gs02, String gs03, String gs04, String gs05,String gs06, String gs07, String gs08, String gs09, String gs10, String gs11, String gs12,String gs13,String gs14,String gs15, String gs16, String gs17, String gs18, String gs19, String gs20) {
        this.gridSizeName = gridSizeName;
        this.gs01 = gs01;
        this.gs02 = gs02;
        this.gs03 = gs03;
        this.gs04 = gs04;
        this.gs05 = gs05;
        this.gs06 = gs06;
        this.gs07 = gs07;
        this.gs08 = gs08;
        this.gs09 = gs09;
        this.gs10 = gs10;
        this.gs11 = gs11;
        this.gs12 = gs12;
        this.gs13 = gs13;
        this.gs14 = gs14;
        this.gs15 = gs15;
        this.gs16 = gs16;
        this.gs17 = gs17;
        this.gs18 = gs18;
        this.gs19 = gs19;
        this.gs20 = gs20;
    }

    public Integer getGridSizeId() {
        return gridSizeId;
    }

    public void setGridSizeId(Integer gridSizeId) {
        this.gridSizeId = gridSizeId;
    }

    public String getGridSizeName() {
        return gridSizeName;
    }

    public void setGridSizeName(String gridSizeName) {
        this.gridSizeName = gridSizeName;
    }

    public String getGs01() {
        return gs01;
    }

    public void setGs01(String gs01) {
        this.gs01 = gs01;
    }

    public String getGs02() {
        return gs02;
    }

    public void setGs02(String gs02) {
        this.gs02 = gs02;
    }

    public String getGs03() {
        return gs03;
    }

    public void setGs03(String gs03) {
        this.gs03 = gs03;
    }

    public String getGs04() {
        return gs04;
    }

    public void setGs04(String gs04) {
        this.gs04 = gs04;
    }

    public String getGs05() {
        return gs05;
    }

    public void setGs05(String gs05) {
        this.gs05 = gs05;
    }

    public String getGs06() {
        return gs06;
    }

    public void setGs06(String gs06) {
        this.gs06 = gs06;
    }

    public String getGs07() {
        return gs07;
    }

    public void setGs07(String gs07) {
        this.gs07 = gs07;
    }

    public String getGs08() {
        return gs08;
    }

    public void setGs08(String gs08) {
        this.gs08 = gs08;
    }

    public String getGs09() {
        return gs09;
    }

    public void setGs09(String gs09) {
        this.gs09 = gs09;
    }

    public String getGs10() {
        return gs10;
    }

    public void setGs10(String gs10) {
        this.gs10 = gs10;
    }

    public String getGs11() {
        return gs11;
    }

    public void setGs11(String gs11) {
        this.gs11 = gs11;
    }

    public String getGs12() {
        return gs12;
    }

    public void setGs12(String gs12) {
        this.gs12 = gs12;
    }

    public String getGs13() {
        return gs13;
    }

    public void setGs13(String gs13) {
        this.gs13 = gs13;
    }

    public String getGs14() {
        return gs14;
    }

    public void setGs14(String gs14) {
        this.gs14 = gs14;
    }

    public String getGs15() {
        return gs15;
    }

    public void setGs15(String gs15) {
        this.gs15 = gs15;
    }

    public String getGs16() {
        return gs16;
    }

    public void setGs16(String gs16) {
        this.gs16 = gs16;
    }

    public String getGs17() {
        return gs17;
    }

    public void setGs17(String gs17) {
        this.gs17 = gs17;
    }

    public String getGs18() {
        return gs18;
    }

    public void setGs18(String gs18) {
        this.gs18 = gs18;
    }

    public String getGs19() {
        return gs19;
    }

    public void setGs19(String gs19) {
        this.gs19 = gs19;
    }

    public String getGs20() {
        return gs20;
    }

    public void setGs20(String gs20) {
        this.gs20 = gs20;
    }

    @XmlTransient
    public Collection<Models> getModelsCollection() {
        return modelsCollection;
    }

    public void setModelsCollection(Collection<Models> modelsCollection) {
        this.modelsCollection = modelsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gridSizeId != null ? gridSizeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GridSize)) {
            return false;
        }
        GridSize other = (GridSize) object;
        if ((this.gridSizeId == null && other.gridSizeId != null) || (this.gridSizeId != null && !this.gridSizeId.equals(other.gridSizeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.GridSize[ gridSizeId=" + gridSizeId + " ]";
    }
    
}
