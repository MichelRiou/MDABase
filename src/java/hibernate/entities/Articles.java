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
@Table(name = "articles", catalog = "flyinpizzas_mdabase", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"article_model_id", "article_color_id", "article_size"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articles.findAll", query = "SELECT a FROM Articles a")
    , @NamedQuery(name = "Articles.findByArticleId", query = "SELECT a FROM Articles a WHERE a.articleId = :articleId")
    , @NamedQuery(name = "Articles.findByArticleSize", query = "SELECT a FROM Articles a WHERE a.articleSize = :articleSize")
    , @NamedQuery(name = "Articles.findByArticleColorDesignation", query = "SELECT a FROM Articles a WHERE a.articleColorDesignation = :articleColorDesignation")
    , @NamedQuery(name = "Articles.findByArticleGencod", query = "SELECT a FROM Articles a WHERE a.articleGencod = :articleGencod")
    , @NamedQuery(name = "Articles.findByArticleKey", query = "SELECT a FROM Articles a WHERE a.articleKey = :articleKey")})
public class Articles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "article_id", nullable = false)
    private Integer articleId;
    @Basic(optional = false)
    @Column(name = "article_size", nullable = false, length = 6)
    private String articleSize;
    @Basic(optional = false)
    @Column(name = "article_color_designation", nullable = false, length = 50)
    private String articleColorDesignation;
    @Basic(optional = false)
    @Column(name = "article_gencod", nullable = false, length = 13)
    private String articleGencod;
    @Basic(optional = false)
    @Column(name = "article_key", nullable = false, length = 20)
    private String articleKey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weborderLinesArticleId")
    private Collection<WeborderLines> weborderLinesCollection;
    @JoinColumn(name = "article_color_id", referencedColumnName = "code_colors_id", nullable = false)
    @ManyToOne(optional = false)
    private CodeColors articleColorId;
    @JoinColumn(name = "article_model_id", referencedColumnName = "model_id", nullable = false)
    @ManyToOne(optional = false)
    private Models articleModelId;

    public Articles() {
    }

    public Articles(Integer articleId) {
        this.articleId = articleId;
    }

    public Articles(Integer articleId, String articleSize, String articleColorDesignation, String articleGencod, String articleKey) {
        this.articleId = articleId;
        this.articleSize = articleSize;
        this.articleColorDesignation = articleColorDesignation;
        this.articleGencod = articleGencod;
        this.articleKey = articleKey;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleSize() {
        return articleSize;
    }

    public void setArticleSize(String articleSize) {
        this.articleSize = articleSize;
    }

    public String getArticleColorDesignation() {
        return articleColorDesignation;
    }

    public void setArticleColorDesignation(String articleColorDesignation) {
        this.articleColorDesignation = articleColorDesignation;
    }

    public String getArticleGencod() {
        return articleGencod;
    }

    public void setArticleGencod(String articleGencod) {
        this.articleGencod = articleGencod;
    }

    public String getArticleKey() {
        return articleKey;
    }

    public void setArticleKey(String articleKey) {
        this.articleKey = articleKey;
    }

    @XmlTransient
    public Collection<WeborderLines> getWeborderLinesCollection() {
        return weborderLinesCollection;
    }

    public void setWeborderLinesCollection(Collection<WeborderLines> weborderLinesCollection) {
        this.weborderLinesCollection = weborderLinesCollection;
    }

    public CodeColors getArticleColorId() {
        return articleColorId;
    }

    public void setArticleColorId(CodeColors articleColorId) {
        this.articleColorId = articleColorId;
    }

    public Models getArticleModelId() {
        return articleModelId;
    }

    public void setArticleModelId(Models articleModelId) {
        this.articleModelId = articleModelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleId != null ? articleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articles)) {
            return false;
        }
        Articles other = (Articles) object;
        if ((this.articleId == null && other.articleId != null) || (this.articleId != null && !this.articleId.equals(other.articleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.entities.Articles[ articleId=" + articleId + " ]";
    }
    
}
