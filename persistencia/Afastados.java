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
@Table(name = "afastados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Afastados.findAll", query = "SELECT a FROM Afastados a")
    , @NamedQuery(name = "Afastados.findByCodAfastados", query = "SELECT a FROM Afastados a WHERE a.codAfastados = :codAfastados")
    , @NamedQuery(name = "Afastados.findByDataLeitura", query = "SELECT a FROM Afastados a WHERE a.dataLeitura = :dataLeitura")
    , @NamedQuery(name = "Afastados.findByDescricaoCausaAfastamento", query = "SELECT a FROM Afastados a WHERE a.descricaoCausaAfastamento = :descricaoCausaAfastamento")
    , @NamedQuery(name = "Afastados.findByFKcodParlamentar", query = "SELECT a FROM Afastados a WHERE a.fKcodParlamentar = :fKcodParlamentar")
    , @NamedQuery(name = "Afastados.findByNomeAfastados", query = "SELECT a FROM Afastados a WHERE a.nomeAfastados = :nomeAfastados")
    , @NamedQuery(name = "Afastados.findBySiglaCausaAfastamento", query = "SELECT a FROM Afastados a WHERE a.siglaCausaAfastamento = :siglaCausaAfastamento")})
public class Afastados implements Serializable {

    @Size(max = 255)
    @Column(name = "dataLeitura")
    private String dataLeitura;
    @Size(max = 255)
    @Column(name = "descricaoCausaAfastamento")
    private String descricaoCausaAfastamento;
    @Size(max = 255)
    @Column(name = "nomeAfastados")
    private String nomeAfastados;
    @Size(max = 255)
    @Column(name = "siglaCausaAfastamento")
    private String siglaCausaAfastamento;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codAfastados")
    private Integer codAfastados;
    @Column(name = "FKcodParlamentar")
    private Integer fKcodParlamentar;

    public Afastados() {
    }

    public Afastados(Integer codAfastados) {
        this.codAfastados = codAfastados;
    }

    public Integer getCodAfastados() {
        return codAfastados;
    }

    public void setCodAfastados(Integer codAfastados) {
        this.codAfastados = codAfastados;
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
        hash += (codAfastados != null ? codAfastados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Afastados)) {
            return false;
        }
        Afastados other = (Afastados) object;
        if ((this.codAfastados == null && other.codAfastados != null) || (this.codAfastados != null && !this.codAfastados.equals(other.codAfastados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Afastados[ codAfastados=" + codAfastados + " ]";
    }

    public String getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(String dataLeitura) {
        this.dataLeitura = dataLeitura;
    }

    public String getDescricaoCausaAfastamento() {
        return descricaoCausaAfastamento;
    }

    public void setDescricaoCausaAfastamento(String descricaoCausaAfastamento) {
        this.descricaoCausaAfastamento = descricaoCausaAfastamento;
    }

    public String getNomeAfastados() {
        return nomeAfastados;
    }

    public void setNomeAfastados(String nomeAfastados) {
        this.nomeAfastados = nomeAfastados;
    }

    public String getSiglaCausaAfastamento() {
        return siglaCausaAfastamento;
    }

    public void setSiglaCausaAfastamento(String siglaCausaAfastamento) {
        this.siglaCausaAfastamento = siglaCausaAfastamento;
    }
    
}
