/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "weborders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Weborders.findAll", query = "SELECT w FROM Weborders w")
    , @NamedQuery(name = "Weborders.findByWeborderId", query = "SELECT w FROM Weborders w WHERE w.weborderId = :weborderId")
    , @NamedQuery(name = "Weborders.findByWeborderNum", query = "SELECT w FROM Weborders w WHERE w.weborderNum = :weborderNum")
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
    , @NamedQuery(name = "Weborders.findByWeborderShippingProvince", query = "SELECT w FROM Weborders w WHERE w.weborderShippingProvince = :weborderShippingProvince")})
public class Weborders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "weborder_id")
    private Integer weborderId;
    @Basic(optional = false)
    @Column(name = "weborder_num")
    private String weborderNum;
    @Basic(optional = false)
    @Column(name = "weborder_email")
    private String weborderEmail;
    @Basic(optional = false)
    @Column(name = "weborder_date")
    @Temporal(TemporalType.DATE)
    private Date weborderDate;
    @Basic(optional = false)
    @Column(name = "weborder_created")
    private String weborderCreated;
    @Basic(optional = false)
    @Column(name = "weborder_status")
    private short weborderStatus;
    @Basic(optional = false)
    @Column(name = "weborder_currency")
    private String weborderCurrency;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "weborder_subtotal")
    private BigDecimal weborderSubtotal;
    @Basic(optional = false)
    @Column(name = "weborder_shipping")
    private BigDecimal weborderShipping;
    @Basic(optional = false)
    @Column(name = "weborder_taxes")
    private BigDecimal weborderTaxes;
    @Basic(optional = false)
    @Column(name = "weborder_refunded")
    private BigDecimal weborderRefunded;
    @Basic(optional = false)
    @Column(name = "weborder_discount_code")
    private String weborderDiscountCode;
    @Basic(optional = false)
    @Column(name = "weborder_discount")
    private BigDecimal weborderDiscount;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_method")
    private String weborderShippingMethod;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_date")
    @Temporal(TemporalType.DATE)
    private Date weborderShippingDate;
    @Basic(optional = false)
    @Column(name = "weborder_billing_name")
    private String weborderBillingName;
    @Basic(optional = false)
    @Column(name = "weborder_billing_ad1")
    private String weborderBillingAd1;
    @Basic(optional = false)
    @Column(name = "weborder_billing_ad2")
    private String weborderBillingAd2;
    @Basic(optional = false)
    @Column(name = "weborder_billing_city")
    private String weborderBillingCity;
    @Basic(optional = false)
    @Column(name = "weborder_billing_zip")
    private String weborderBillingZip;
    @Basic(optional = false)
    @Column(name = "weborder_billing_province")
    private String weborderBillingProvince;
    @Basic(optional = false)
    @Column(name = "weborder_billing_phone")
    private String weborderBillingPhone;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_name")
    private String weborderShippingName;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_ad1")
    private String weborderShippingAd1;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_ad2")
    private String weborderShippingAd2;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_city")
    private String weborderShippingCity;
    @Basic(optional = false)
    @Column(name = "weborder_shipping_province")
    private String weborderShippingProvince;
    @JoinColumn(name = "weborder_billing_country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = false)
    private Countries weborderBillingCountryId;
    @JoinColumn(name = "weborder_shipping_country_id", referencedColumnName = "country_id")
    @OneToOne(optional = false)
    private Countries weborderShippingCountryId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "weborderLinesNum")
    private WeborderLines weborderLines;

    public Weborders() {
    }

    public Weborders(Integer weborderId) {
        this.weborderId = weborderId;
    }

    public Weborders(Integer weborderId, String weborderNum, String weborderEmail, Date weborderDate, String weborderCreated, short weborderStatus, String weborderCurrency, BigDecimal weborderSubtotal, BigDecimal weborderShipping, BigDecimal weborderTaxes, BigDecimal weborderRefunded, String weborderDiscountCode, BigDecimal weborderDiscount, String weborderShippingMethod, Date weborderShippingDate, String weborderBillingName, String weborderBillingAd1, String weborderBillingAd2, String weborderBillingCity, String weborderBillingZip, String weborderBillingProvince, String weborderBillingPhone, String weborderShippingName, String weborderShippingAd1, String weborderShippingAd2, String weborderShippingCity, String weborderShippingProvince) {
        this.weborderId = weborderId;
        this.weborderNum = weborderNum;
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
        this.weborderBillingPhone = weborderBillingPhone;
        this.weborderShippingName = weborderShippingName;
        this.weborderShippingAd1 = weborderShippingAd1;
        this.weborderShippingAd2 = weborderShippingAd2;
        this.weborderShippingCity = weborderShippingCity;
        this.weborderShippingProvince = weborderShippingProvince;
    }

    public Integer getWeborderId() {
        return weborderId;
    }

    public void setWeborderId(Integer weborderId) {
        this.weborderId = weborderId;
    }

    public String getWeborderNum() {
        return weborderNum;
    }

    public void setWeborderNum(String weborderNum) {
        this.weborderNum = weborderNum;
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

    public BigDecimal getWeborderSubtotal() {
        return weborderSubtotal;
    }

    public void setWeborderSubtotal(BigDecimal weborderSubtotal) {
        this.weborderSubtotal = weborderSubtotal;
    }

    public BigDecimal getWeborderShipping() {
        return weborderShipping;
    }

    public void setWeborderShipping(BigDecimal weborderShipping) {
        this.weborderShipping = weborderShipping;
    }

    public BigDecimal getWeborderTaxes() {
        return weborderTaxes;
    }

    public void setWeborderTaxes(BigDecimal weborderTaxes) {
        this.weborderTaxes = weborderTaxes;
    }

    public BigDecimal getWeborderRefunded() {
        return weborderRefunded;
    }

    public void setWeborderRefunded(BigDecimal weborderRefunded) {
        this.weborderRefunded = weborderRefunded;
    }

    public String getWeborderDiscountCode() {
        return weborderDiscountCode;
    }

    public void setWeborderDiscountCode(String weborderDiscountCode) {
        this.weborderDiscountCode = weborderDiscountCode;
    }

    public BigDecimal getWeborderDiscount() {
        return weborderDiscount;
    }

    public void setWeborderDiscount(BigDecimal weborderDiscount) {
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

    public WeborderLines getWeborderLines() {
        return weborderLines;
    }

    public void setWeborderLines(WeborderLines weborderLines) {
        this.weborderLines = weborderLines;
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
