/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafae
 */
@Entity
@Table(name = "auxilioimoveis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auxilioimoveis.findAll", query = "SELECT a FROM Auxilioimoveis a")
    , @NamedQuery(name = "Auxilioimoveis.findByCodAuxilio", query = "SELECT a FROM Auxilioimoveis a WHERE a.codAuxilio = :codAuxilio")
    , @NamedQuery(name = "Auxilioimoveis.findByAuxilioMoradia", query = "SELECT a FROM Auxilioimoveis a WHERE a.auxilioMoradia = :auxilioMoradia")
    , @NamedQuery(name = "Auxilioimoveis.findByFKcodParlamentar", query = "SELECT a FROM Auxilioimoveis a WHERE a.fKcodParlamentar = :fKcodParlamentar")
    , @NamedQuery(name = "Auxilioimoveis.findByImovelFuncional", query = "SELECT a FROM Auxilioimoveis a WHERE a.imovelFuncional = :imovelFuncional")
    , @NamedQuery(name = "Auxilioimoveis.findByNomeParlamentar", query = "SELECT a FROM Auxilioimoveis a WHERE a.nomeParlamentar = :nomeParlamentar")
    , @NamedQuery(name = "Auxilioimoveis.findByUf", query = "SELECT a FROM Auxilioimoveis a WHERE a.uf = :uf")})
public class Auxilioimoveis implements Serializable {

    //@Size(max = 255)
    @Column(name = "auxilioMoradia")
    private String auxilioMoradia;
   // @Size(max = 255)
    @Column(name = "imovelFuncional")
    private String imovelFuncional;
   // @Size(max = 255)
    @Column(name = "nomeParlamentar")
    private String nomeParlamentar;
    //@Size(max = 255)
    @Column(name = "UF")
    private String uf;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codAuxilio")
    private Integer codAuxilio;
    @Column(name = "FKcodParlamentar")
    private Integer fKcodParlamentar;

    public Auxilioimoveis() {
    }

    public Auxilioimoveis(Integer codAuxilio) {
        this.codAuxilio = codAuxilio;
    }

    public Integer getCodAuxilio() {
        return codAuxilio;
    }

    public void setCodAuxilio(Integer codAuxilio) {
        this.codAuxilio = codAuxilio;
    }


    public Integer getFKcodParlamentar() {
        return fKcodParlamentar;
    }

    public void setFKcodParlamentar(Integer fKcodParlamentar) {
        this.fKcodParlamentar = fKcodParlamentar;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAuxilio != null ? codAuxilio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auxilioimoveis)) {
            return false;
        }
        Auxilioimoveis other = (Auxilioimoveis) object;
        if ((this.codAuxilio == null && other.codAuxilio != null) || (this.codAuxilio != null && !this.codAuxilio.equals(other.codAuxilio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Auxilioimoveis[ codAuxilio=" + codAuxilio + " ]";
    }

    public String getAuxilioMoradia() {
        return auxilioMoradia;
    }

    public void setAuxilioMoradia(String auxilioMoradia) {
        this.auxilioMoradia = auxilioMoradia;
    }

    public String getImovelFuncional() {
        return imovelFuncional;
    }

    public void setImovelFuncional(String imovelFuncional) {
        this.imovelFuncional = imovelFuncional;
    }

    public String getNomeParlamentar() {
        return nomeParlamentar;
    }

    public void setNomeParlamentar(String nomeParlamentar) {
        this.nomeParlamentar = nomeParlamentar;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
}
