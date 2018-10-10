package hibernate.entities;
// Generated 10 oct. 2018 14:43:45 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CodeColors generated by hbm2java
 */
@Entity
@Table(name="code_colors"
    ,catalog="flyinpizzas_mdabase"
)
public class CodeColors  implements java.io.Serializable {


     private Integer codeColorsId;
     private String codeColorsCode;
     private String codeColorsDesignation;

    public CodeColors() {
    }

    public CodeColors(String codeColorsCode, String codeColorsDesignation) {
       this.codeColorsCode = codeColorsCode;
       this.codeColorsDesignation = codeColorsDesignation;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="code_colors_id", unique=true, nullable=false)
    public Integer getCodeColorsId() {
        return this.codeColorsId;
    }
    
    public void setCodeColorsId(Integer codeColorsId) {
        this.codeColorsId = codeColorsId;
    }

    
    @Column(name="code_colors_code", nullable=false, length=6)
    public String getCodeColorsCode() {
        return this.codeColorsCode;
    }
    
    public void setCodeColorsCode(String codeColorsCode) {
        this.codeColorsCode = codeColorsCode;
    }

    
    @Column(name="code_colors_designation", nullable=false, length=50)
    public String getCodeColorsDesignation() {
        return this.codeColorsDesignation;
    }
    
    public void setCodeColorsDesignation(String codeColorsDesignation) {
        this.codeColorsDesignation = codeColorsDesignation;
    }




}


