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
@Table(name = "stocks", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"stock_article_id", "stock_place_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stocks.findAll", query = "SELECT s FROM Stocks s")
    , @NamedQuery(name = "Stocks.findByStockId", query = "SELECT s FROM Stocks s WHERE s.stockId = :stockId")
    , @NamedQuery(name = "Stocks.findByStockArticleId", query = "SELECT s FROM Stocks s WHERE s.stockArticleId = :stockArticleId")
    , @NamedQuery(name = "Stocks.findByStockQty", query = "SELECT s FROM Stocks s WHERE s.stockQty = :stockQty")})
public class Stocks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stock_id", nullable = false)
    private Integer stockId;
    @Basic(optional = false)
    @Column(name = "stock_article_id", nullable = false)
    private int stockArticleId;
    @Basic(optional = false)
    @Column(name = "stock_qty", nullable = false)
    private int stockQty;
    @JoinColumn(name = "stock_place_id", referencedColumnName = "place_id", nullable = false)
    @ManyToOne(optional = false)
    private Places stockPlaceId;

    public Stocks() {
    }

    public Stocks(Integer stockId) {
        this.stockId = stockId;
    }

    public Stocks(Integer stockId, int stockArticleId, int stockQty) {
        this.stockId = stockId;
        this.stockArticleId = stockArticleId;
        this.stockQty = stockQty;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public int getStockArticleId() {
        return stockArticleId;
    }

    public void setStockArticleId(int stockArticleId) {
        this.stockArticleId = stockArticleId;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public Places getStockPlaceId() {
        return stockPlaceId;
    }

    public void setStockPlaceId(Places stockPlaceId) {
        this.stockPlaceId = stockPlaceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockId != null ? stockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stocks)) {
            return false;
        }
        Stocks other = (Stocks) object;
        if ((this.stockId == null && other.stockId != null) || (this.stockId != null && !this.stockId.equals(other.stockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.Stocks[ stockId=" + stockId + " ]";
    }
    
}
