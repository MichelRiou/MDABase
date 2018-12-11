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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "weborder_lines", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"weborder_lines_code", "weborder_lines_article_id"})})
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
    @Column(name = "weborder_lines_id", nullable = false)
    private Integer weborderLinesId;
    @Basic(optional = false)
    @Column(name = "weborder_qty", nullable = false)
    private int weborderQty;
    @Basic(optional = false)
    @Column(name = "weborder_ht", nullable = false)
    private int weborderHt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "weborder_lines_ttc", nullable = false, precision = 9, scale = 2)
    private BigDecimal weborderLinesTtc;
    @Basic(optional = false)
    @Column(name = "weborder_lines_tax_code", nullable = false, precision = 4, scale = 2)
    private BigDecimal weborderLinesTaxCode;
    @JoinColumn(name = "weborder_lines_code", referencedColumnName = "weborder_code", nullable = false)
    @ManyToOne(optional = false)
    private Weborders weborderLinesCode;
    @JoinColumn(name = "weborder_lines_article_id", referencedColumnName = "article_id", nullable = false)
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

    public Weborders getWeborderLinesCode() {
        return weborderLinesCode;
    }

    public void setWeborderLinesCode(Weborders weborderLinesCode) {
        this.weborderLinesCode = weborderLinesCode;
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
