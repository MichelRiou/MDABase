/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "weborder_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WeborderLines.findAll", query = "SELECT w FROM WeborderLines w")
    , @NamedQuery(name = "WeborderLines.findByWeborderLinesId", query = "SELECT w FROM WeborderLines w WHERE w.weborderLinesId = :weborderLinesId")
    , @NamedQuery(name = "WeborderLines.findByWeborderQty", query = "SELECT w FROM WeborderLines w WHERE w.weborderQty = :weborderQty")
    , @NamedQuery(name = "WeborderLines.findByWeborderHt", query = "SELECT w FROM WeborderLines w WHERE w.weborderHt = :weborderHt")
    , @NamedQuery(name = "WeborderLines.findByWeborderLinesTtc", query = "SELECT w FROM WeborderLines w WHERE w.weborderLinesTtc = :weborderLinesTtc")
    , @NamedQuery(name = "WeborderLines.findByWeborderLinesTaxCode", query = "SELECT w FROM WeborderLines w WHERE w.weborderLinesTaxCode = :weborderLinesTaxCode")})
public class WeborderLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "weborder_lines_id")
    private Integer weborderLinesId;
    @Basic(optional = false)
    @Column(name = "weborder_qty")
    private int weborderQty;
    @Basic(optional = false)
    @Column(name = "weborder_ht")
    private int weborderHt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "weborder_lines_ttc")
    private BigDecimal weborderLinesTtc;
    @Basic(optional = false)
    @Column(name = "weborder_lines_tax_code")
    private BigDecimal weborderLinesTaxCode;
    @JoinColumn(name = "weborder_lines_num", referencedColumnName = "weborder_num")
    @OneToOne(optional = false)
    private Weborders weborderLinesNum;
    @JoinColumn(name = "weborder_lines_article_id", referencedColumnName = "article_id")
    @ManyToOne(optional = false)
    private Articles weborderLinesArticleId;

    public WeborderLines() {
    }

    public WeborderLines(Integer weborderLinesId) {
        this.weborderLinesId = weborderLinesId;
    }

    public WeborderLines(Integer weborderLinesId, int weborderQty, int weborderHt, BigDecimal weborderLinesTtc, BigDecimal weborderLinesTaxCode) {
        this.weborderLinesId = weborderLinesId;
        this.weborderQty = weborderQty;
        this.weborderHt = weborderHt;
        this.weborderLinesTtc = weborderLinesTtc;
        this.weborderLinesTaxCode = weborderLinesTaxCode;
    }

    public Integer getWeborderLinesId() {
        return weborderLinesId;
    }

    public void setWeborderLinesId(Integer weborderLinesId) {
        this.weborderLinesId = weborderLinesId;
    }

    public int getWeborderQty() {
        return weborderQty;
    }

    public void setWeborderQty(int weborderQty) {
        this.weborderQty = weborderQty;
    }

    public int getWeborderHt() {
        return weborderHt;
    }

    public void setWeborderHt(int weborderHt) {
        this.weborderHt = weborderHt;
    }

    public BigDecimal getWeborderLinesTtc() {
        return weborderLinesTtc;
    }

    public void setWeborderLinesTtc(BigDecimal weborderLinesTtc) {
        this.weborderLinesTtc = weborderLinesTtc;
    }

    public BigDecimal getWeborderLinesTaxCode() {
        return weborderLinesTaxCode;
    }

    public void setWeborderLinesTaxCode(BigDecimal weborderLinesTaxCode) {
        this.weborderLinesTaxCode = weborderLinesTaxCode;
    }

    public Weborders getWeborderLinesNum() {
        return weborderLinesNum;
    }

    public void setWeborderLinesNum(Weborders weborderLinesNum) {
        this.weborderLinesNum = weborderLinesNum;
    }

    public Articles getWeborderLinesArticleId() {
        return weborderLinesArticleId;
    }

    public void setWeborderLinesArticleId(Articles weborderLinesArticleId) {
        this.weborderLinesArticleId = weborderLinesArticleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (weborderLinesId != null ? weborderLinesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeborderLines)) {
            return false;
        }
        WeborderLines other = (WeborderLines) object;
        if ((this.weborderLinesId == null && other.weborderLinesId != null) || (this.weborderLinesId != null && !this.weborderLinesId.equals(other.weborderLinesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.WeborderLines[ weborderLinesId=" + weborderLinesId + " ]";
    }
    
}
