/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "weborders", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"weborder_code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Weborders.findAll", query = "SELECT w FROM Weborders w")
    , @NamedQuery(name = "Weborders.findByWeborderId", query = "SELECT w FROM Weborders w WHERE w.weborderId = :weborderId")
    , @NamedQuery(name = "Weborders.findByWeborderCode", query = "SELECT w FROM Weborders w WHERE w.weborderCode = :weborderCode")
    , @NamedQuery(name = "Weborders.findByWeborderEmail", query = "SELECT w FROM Weborders w WHERE w.weborderEmail = :weborderEmail")
    , @NamedQuery(name = "Weborders.findByWeborderDate", query = "SELECT w FROM Weborders w WHERE w.weborderDate = :weborderDate")
    , @NamedQuery(name = "Weborders.findByWeborderCreated", query = "SELECT w FROM Weborders w WHERE w.weborderCreated = :weborderCreated")
    , @NamedQuery(name = "Weborders.findByWeborderStatus", query = "SELECT w FROM Weborders w WHERE w.weborderStatus = :weborderStatus")
    , @NamedQuery(name = "Weborders.findByWeborderCurrency", query = "SELECT w FROM Weborders w WHERE w.weborderCurrency = :weborderCurrency")
    , @NamedQuery(name = "Weborders.findByWeborderSubtotal", query = "SELECT w FROM Weborders w WHERE w.weborderSubtotal = :weborderSubtotal")
    , @NamedQuery(name = "Weborders.findByWeborderShipping", query = "SELECT w FROM Weborders w WHERE w.weborderShipping = :weborderShipping")
    , @NamedQuery(name = "Weborders.findByWeborderTaxes", query = "SELECT w FROM Weborders w WHERE w.weborderTaxes = :weborderTaxes")
    , @NamedQuery(name = "Weborders.findByWeborderRefunded", query = "SELECT w FROM Weborders w WHERE w.weborderRefunded = :weborderRefunded")
    , @NamedQuery(name = "Weborders.findByWeborderDiscountCode", query = "SELECT w FROM Weborders w WHERE w.weborderDiscountCode = :weborderDiscountCode")
    , @NamedQuery(name = "Weborders.findByWeborderDiscount", query = "SELECT w FROM Weborders w WHERE w.weborderDiscount = :weborderDiscount")
    , @NamedQuery(name = "Weborders.findByWeborderShippingMethod", query = "SELECT w FROM Weborders w WHERE w.weborderShippingMethod = :weborderShippingMethod")
    , @NamedQuery(name = "Weborders.findByWeborderShippingDate", query = "SELECT w FROM Weborders w WHERE w.weborderShippingDate = :weborderShippingDate")
    , @NamedQuery(name = "Weborders.findByWeborderBillingName", query = "SELECT w FROM Weborders w WHERE w.weborderBillingName = :weborderBillingName")
    , @NamedQuery(name = "Weborders.findByWeborderBillingAd1", query = "SELECT w FROM Weborders w WHERE w.weborderBillingAd1 = :weborderBillingAd1")
    , @NamedQuery(name = "Weborders.findByWeborderBillingAd2", query = "SELECT w FROM Weborders w WHERE w.weborderBillingAd2 = :weborderBillingAd2")
    , @NamedQuery(name = "Weborders.findByWeborderBillingCity", query = "SELECT w FROM Weborders w WHERE w.weborderBillingCity = :weborderBillingCity")
    , @NamedQuery(name = "Weborders.findByWeborderBillingZip", query = "SELECT w FROM Weborders w WHERE w.weborderBillingZip = :weborderBillingZip")
    , @NamedQuery(name = "Weborders.findByWeborderBillingProvince", query = "SELECT w FROM Weborders w WHERE w.weborderBillingProvince = :weborderBillingProvince")
    , @NamedQuery(name = "Weborders.findByWeborderBillingPhone", query = "SELECT w FROM Weborders w WHERE w.weborderBillingPhone = :weborderBillingPhone")
    , @NamedQuery(name = "Weborders.findByWeborderShippingName", query = "SELECT w FROM Weborders w WHERE w.weborderShippingName = :weborderShippingName")
    , @NamedQuery(name = "Weborders.findByWeborderShippingAd1", query = "SELECT w FROM Weborders w WHERE w.weborderShippingAd1 = :weborderShippingAd1")
    , @NamedQuery(name = "Weborders.findByWeborderShippingAd2", query = "SELECT w FROM Weborders w WHERE w.weborderShippingAd2 = :weborderShippingAd2")
    , @NamedQuery(name = "Weborders.findByWeborderShippingCity", query = "SELECT w FROM Weborders w WHERE w.weborderShippingCity = :weborderShippingCity")
    , @NamedQuery(name = "Weborders.findByWeborderShippingZip", query = "SELECT w FROM Weborders w WHERE w.weborderShippingZip = :weborderShippingZip")
    , @NamedQuery(name = "Weborders.findByWeborderShippingProvince", query = "SELECT w FROM Weborders w WHERE w.weborderShippingProvince = :weborderShippingProvince")})
public class Weborders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "weborder_id", nullable = false)
    private Integer weborderId;
    @Basic(optional = false)
    @Column(name = "weborder_code", nullable = false, length = 5)
    private String weborderCode;
    @Basic(optional = false)
    @Column(name = "weborder_email", nullable = false, length = 50)
    private String weborderEmail;
    @Basic(optional = false)
    @Column(name = "weborder_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date weborderDate;
    @Basic(optional = false)
    @Column(name = "weborder_created", nullable = false, length = 25)
    private String weborderCreated;
    @Basic(optional = false)
    @Column(name = "weborder_status", nullable = false)
    private short weborderStatus;
    @Basic(optional = false)
    @Column(name = "weborder_currency", nullable = false, length = 3)
    private String weborderCurrency;
    @Basic(optional = false)
    @Column(name = "weborder_subtotal", nullable = false)
    private float weborderSubtotal;
    @Basic(optional = false)
    @Column(name = "weborder_shipping", nullable = false)
    private float weborderShipping;
    @Basic(optional = false)
    @Column(name = "weborder_taxes", nullable = false)
    private float weborderTaxes;
    @Basic(optional = false)
    @Column(name = "weborder_refunded", nullable = false)
    private float weborderRefunded;
    @Basic(optional = false)
    @Column(name = "weborder_discount_code", nullable = false, length = 15)
    private String weborderDiscountCode;
    @Basic(optional = false)
    @Column(name = "weborder_discount", nullable = false)
    private float weborderDiscount;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_method", nullable = false, length = 50)
    private String weborderShippingMethod;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date weborderShippingDate;
    @Basic(optional = false)
    @Column(name = "weborder_billing_name", nullable = false, length = 100)
    private String weborderBillingName;
    @Basic(optional = false)
    @Column(name = "weborder_billing_ad1", nullable = false, length = 100)
    private String weborderBillingAd1;
    @Basic(optional = false)
    @Column(name = "weborder_billing_ad2", nullable = false, length = 100)
    private String weborderBillingAd2;
    @Basic(optional = false)
    @Column(name = "weborder_billing_city", nullable = false, length = 100)
    private String weborderBillingCity;
    @Basic(optional = false)
    @Column(name = "weborder_billing_zip", nullable = false, length = 20)
    private String weborderBillingZip;
    @Basic(optional = false)
    @Column(name = "weborder_billing_province", nullable = false, length = 100)
    private String weborderBillingProvince;
    @Basic(optional = false)
    @Column(name = "weborder_billing_phone", nullable = false, length = 20)
    private String weborderBillingPhone;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_name", nullable = false, length = 100)
    private String weborderShippingName;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_ad1", nullable = false, length = 100)
    private String weborderShippingAd1;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_ad2", nullable = false, length = 100)
    private String weborderShippingAd2;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_city", nullable = false, length = 100)
    private String weborderShippingCity;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_zip", nullable = false, length = 20)
    private String weborderShippingZip;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_province", nullable = false, length = 100)
    private String weborderShippingProvince;
    @JoinColumn(name = "weborder_billing_country_id", referencedColumnName = "country_id", nullable = false)
    @ManyToOne(optional = false)
    private Countries weborderBillingCountryId;
    @JoinColumn(name = "weborder_shipping_country_id", referencedColumnName = "country_id", nullable = false)
    @ManyToOne(optional = false)
    private Countries weborderShippingCountryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weborderLinesCode")
    private Collection<WeborderLines> weborderLinesCollection;

    public Weborders() {
    }

    public Weborders(Integer weborderId) {
        this.weborderId = weborderId;
    }

    public Weborders(Integer weborderId, String weborderCode, String weborderEmail, Date weborderDate, String weborderCreated, short weborderStatus, String weborderCurrency, float weborderSubtotal, float weborderShipping, float weborderTaxes, float weborderRefunded, String weborderDiscountCode, float weborderDiscount, String weborderShippingMethod, Date weborderShippingDate, String weborderBillingName, String weborderBillingAd1, String weborderBillingAd2, String weborderBillingCity, String weborderBillingZip, String weborderBillingProvince, Countries weborderBillingCountryId, String weborderBillingPhone, String weborderShippingName, String weborderShippingAd1, String weborderShippingAd2, String weborderShippingCity, String weborderShippingZip, String weborderShippingProvince, Countries weborderShippingCountryId) {
        this.weborderId = weborderId;
        this.weborderCode = weborderCode;
        this.weborderEmail = weborderEmail;
        this.weborderDate = weborderDate;
        this.weborderCreated = weborderCreated;
        this.weborderStatus = weborderStatus;
        this.weborderCurrency = weborderCurrency;
        this.weborderSubtotal = weborderSubtotal;
        this.weborderShipping = weborderShipping;
        this.weborderTaxes = weborderTaxes;
        this.weborderRefunded = weborderRefunded;
        this.weborderDiscountCode = weborderDiscountCode;
        this.weborderDiscount = weborderDiscount;
        this.weborderShippingMethod = weborderShippingMethod;
        this.weborderShippingDate = weborderShippingDate;
        this.weborderBillingName = weborderBillingName;
        this.weborderBillingAd1 = weborderBillingAd1;
        this.weborderBillingAd2 = weborderBillingAd2;
        this.weborderBillingCity = weborderBillingCity;
        this.weborderBillingZip = weborderBillingZip;
        this.weborderBillingProvince = weborderBillingProvince;
        this.weborderBillingCountryId = weborderBillingCountryId;
        this.weborderBillingPhone = weborderBillingPhone;
        this.weborderShippingName = weborderShippingName;
        this.weborderShippingAd1 = weborderShippingAd1;
        this.weborderShippingAd2 = weborderShippingAd2;
        this.weborderShippingCity = weborderShippingCity;
        this.weborderShippingZip = weborderShippingZip;
        this.weborderShippingProvince = weborderShippingProvince;
        this.weborderShippingCountryId = weborderShippingCountryId;
    }

    public Integer getWeborderId() {
        return weborderId;
    }

    public void setWeborderId(Integer weborderId) {
        this.weborderId = weborderId;
    }

    public String getWeborderCode() {
        return weborderCode;
    }

    public void setWeborderCode(String weborderCode) {
        this.weborderCode = weborderCode;
    }

    public String getWeborderEmail() {
        return weborderEmail;
    }

    public void setWeborderEmail(String weborderEmail) {
        this.weborderEmail = weborderEmail;
    }

    public Date getWeborderDate() {
        return weborderDate;
    }

    public void setWeborderDate(Date weborderDate) {
        this.weborderDate = weborderDate;
    }

    public String getWeborderCreated() {
        return weborderCreated;
    }

    public void setWeborderCreated(String weborderCreated) {
        this.weborderCreated = weborderCreated;
    }

    public short getWeborderStatus() {
        return weborderStatus;
    }

    public void setWeborderStatus(short weborderStatus) {
        this.weborderStatus = weborderStatus;
    }

    public String getWeborderCurrency() {
        return weborderCurrency;
    }

    public void setWeborderCurrency(String weborderCurrency) {
        this.weborderCurrency = weborderCurrency;
    }

    public float getWeborderSubtotal() {
        return weborderSubtotal;
    }

    public void setWeborderSubtotal(float weborderSubtotal) {
        this.weborderSubtotal = weborderSubtotal;
    }

    public float getWeborderShipping() {
        return weborderShipping;
    }

    public void setWeborderShipping(float weborderShipping) {
        this.weborderShipping = weborderShipping;
    }

    public float getWeborderTaxes() {
        return weborderTaxes;
    }

    public void setWeborderTaxes(float weborderTaxes) {
        this.weborderTaxes = weborderTaxes;
    }

    public float getWeborderRefunded() {
        return weborderRefunded;
    }

    public void setWeborderRefunded(float weborderRefunded) {
        this.weborderRefunded = weborderRefunded;
    }

    public String getWeborderDiscountCode() {
        return weborderDiscountCode;
    }

    public void setWeborderDiscountCode(String weborderDiscountCode) {
        this.weborderDiscountCode = weborderDiscountCode;
    }

    public float getWeborderDiscount() {
        return weborderDiscount;
    }

    public void setWeborderDiscount(float weborderDiscount) {
        this.weborderDiscount = weborderDiscount;
    }

    public String getWeborderShippingMethod() {
        return weborderShippingMethod;
    }

    public void setWeborderShippingMethod(String weborderShippingMethod) {
        this.weborderShippingMethod = weborderShippingMethod;
    }

    public Date getWeborderShippingDate() {
        return weborderShippingDate;
    }

    public void setWeborderShippingDate(Date weborderShippingDate) {
        this.weborderShippingDate = weborderShippingDate;
    }

    public String getWeborderBillingName() {
        return weborderBillingName;
    }

    public void setWeborderBillingName(String weborderBillingName) {
        this.weborderBillingName = weborderBillingName;
    }

    public String getWeborderBillingAd1() {
        return weborderBillingAd1;
    }

    public void setWeborderBillingAd1(String weborderBillingAd1) {
        this.weborderBillingAd1 = weborderBillingAd1;
    }

    public String getWeborderBillingAd2() {
        return weborderBillingAd2;
    }

    public void setWeborderBillingAd2(String weborderBillingAd2) {
        this.weborderBillingAd2 = weborderBillingAd2;
    }

    public String getWeborderBillingCity() {
        return weborderBillingCity;
    }

    public void setWeborderBillingCity(String weborderBillingCity) {
        this.weborderBillingCity = weborderBillingCity;
    }

    public String getWeborderBillingZip() {
        return weborderBillingZip;
    }

    public void setWeborderBillingZip(String weborderBillingZip) {
        this.weborderBillingZip = weborderBillingZip;
    }

    public String getWeborderBillingProvince() {
        return weborderBillingProvince;
    }

    public void setWeborderBillingProvince(String weborderBillingProvince) {
        this.weborderBillingProvince = weborderBillingProvince;
    }

    public String getWeborderBillingPhone() {
        return weborderBillingPhone;
    }

    public void setWeborderBillingPhone(String weborderBillingPhone) {
        this.weborderBillingPhone = weborderBillingPhone;
    }

    public String getWeborderShippingName() {
        return weborderShippingName;
    }

    public void setWeborderShippingName(String weborderShippingName) {
        this.weborderShippingName = weborderShippingName;
    }

    public String getWeborderShippingAd1() {
        return weborderShippingAd1;
    }

    public void setWeborderShippingAd1(String weborderShippingAd1) {
        this.weborderShippingAd1 = weborderShippingAd1;
    }

    public String getWeborderShippingAd2() {
        return weborderShippingAd2;
    }

    public void setWeborderShippingAd2(String weborderShippingAd2) {
        this.weborderShippingAd2 = weborderShippingAd2;
    }

    public String getWeborderShippingCity() {
        return weborderShippingCity;
    }

    public void setWeborderShippingCity(String weborderShippingCity) {
        this.weborderShippingCity = weborderShippingCity;
    }

    public String getWeborderShippingZip() {
        return weborderShippingZip;
    }

    public void setWeborderShippingZip(String weborderShippingZip) {
        this.weborderShippingZip = weborderShippingZip;
    }

    public String getWeborderShippingProvince() {
        return weborderShippingProvince;
    }

    public void setWeborderShippingProvince(String weborderShippingProvince) {
        this.weborderShippingProvince = weborderShippingProvince;
    }

    public Countries getWeborderBillingCountryId() {
        return weborderBillingCountryId;
    }

    public void setWeborderBillingCountryId(Countries weborderBillingCountryId) {
        this.weborderBillingCountryId = weborderBillingCountryId;
    }

    public Countries getWeborderShippingCountryId() {
        return weborderShippingCountryId;
    }

    public void setWeborderShippingCountryId(Countries weborderShippingCountryId) {
        this.weborderShippingCountryId = weborderShippingCountryId;
    }

    @XmlTransient
    public Collection<WeborderLines> getWeborderLinesCollection() {
        return weborderLinesCollection;
    }

    public void setWeborderLinesCollection(Collection<WeborderLines> weborderLinesCollection) {
        this.weborderLinesCollection = weborderLinesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (weborderId != null ? weborderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Weborders)) {
            return false;
        }
        Weborders other = (Weborders) object;
        if ((this.weborderId == null && other.weborderId != null) || (this.weborderId != null && !this.weborderId.equals(other.weborderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.Weborders[ weborderId=" + weborderId + " ]";
    }
    
}
