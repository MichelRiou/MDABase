/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "countries", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"country_code"})
    , @UniqueConstraint(columnNames = {"country_name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c")
    , @NamedQuery(name = "Countries.findByCountryId", query = "SELECT c FROM Countries c WHERE c.countryId = :countryId")
    , @NamedQuery(name = "Countries.findByCountryName", query = "SELECT c FROM Countries c WHERE c.countryName = :countryName")
    , @NamedQuery(name = "Countries.findByCountryCode", query = "SELECT c FROM Countries c WHERE c.countryCode = :countryCode")
    , @NamedQuery(name = "Countries.findByCountryTax", query = "SELECT c FROM Countries c WHERE c.countryTax = :countryTax")})
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "country_id", nullable = false)
    private Integer countryId;
    @Basic(optional = false)
    @Column(name = "country_name", nullable = false, length = 50)
    private String countryName;
    @Basic(optional = false)
    @Column(name = "country_code", nullable = false, length = 2)
    private String countryCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "country_tax", nullable = false, precision = 4, scale = 2)
    private BigDecimal countryTax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weborderBillingCountryId")
    private Collection<Weborders> webordersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weborderShippingCountryId")
    private Collection<Weborders> webordersCollection1;

    public Countries() {
    }

    public Countries(Integer countryId) {
        this.countryId = countryId;
    }

    public Countries(Integer countryId, String countryName, String countryCode, BigDecimal countryTax) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryTax = countryTax;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public BigDecimal getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(BigDecimal countryTax) {
        this.countryTax = countryTax;
    }

    @XmlTransient
    public Collection<Weborders> getWebordersCollection() {
        return webordersCollection;
    }

    public void setWebordersCollection(Collection<Weborders> webordersCollection) {
        this.webordersCollection = webordersCollection;
    }

    @XmlTransient
    public Collection<Weborders> getWebordersCollection1() {
        return webordersCollection1;
    }

    public void setWebordersCollection1(Collection<Weborders> webordersCollection1) {
        this.webordersCollection1 = webordersCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.Countries[ countryId=" + countryId + " ]";
    }
    
}
