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
@Table(name = "lideranca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lideranca.findAll", query = "SELECT l FROM Lideranca l")
    , @NamedQuery(name = "Lideranca.findByCodLideranca", query = "SELECT l FROM Lideranca l WHERE l.codLideranca = :codLideranca")
    , @NamedQuery(name = "Lideranca.findByCodiUnidPartido", query = "SELECT l FROM Lideranca l WHERE l.codiUnidPartido = :codiUnidPartido")
    , @NamedQuery(name = "Lideranca.findByFKcodParlamentar", query = "SELECT l FROM Lideranca l WHERE l.fKcodParlamentar = :fKcodParlamentar")
    , @NamedQuery(name = "Lideranca.findByMembros", query = "SELECT l FROM Lideranca l WHERE l.membros = :membros")
    , @NamedQuery(name = "Lideranca.findByNomeUnidLideranca", query = "SELECT l FROM Lideranca l WHERE l.nomeUnidLideranca = :nomeUnidLideranca")
    , @NamedQuery(name = "Lideranca.findByPrioridade", query = "SELECT l FROM Lideranca l WHERE l.prioridade = :prioridade")
    , @NamedQuery(name = "Lideranca.findBySiglaUnidLideranca", query = "SELECT l FROM Lideranca l WHERE l.siglaUnidLideranca = :siglaUnidLideranca")
    , @NamedQuery(name = "Lideranca.findByTipoLideranca", query = "SELECT l FROM Lideranca l WHERE l.tipoLideranca = :tipoLideranca")
    , @NamedQuery(name = "Lideranca.findByTipoUnidLideranca", query = "SELECT l FROM Lideranca l WHERE l.tipoUnidLideranca = :tipoUnidLideranca")})
public class Lideranca implements Serializable {

    @Size(max = 255)
    @Column(name = "nomeUnidLideranca")
    private String nomeUnidLideranca;
    @Size(max = 255)
    @Column(name = "prioridade")
    private String prioridade;
    @Size(max = 255)
    @Column(name = "siglaUnidLideranca")
    private String siglaUnidLideranca;
    @Size(max = 255)
    @Column(name = "tipoLideranca")
    private String tipoLideranca;
    @Size(max = 255)
    @Column(name = "tipoUnidLideranca")
    private String tipoUnidLideranca;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codLideranca")
    private Integer codLideranca;
    @Column(name = "codiUnidPartido")
    private Integer codiUnidPartido;
    @Column(name = "FKcodParlamentar")
    private Integer fKcodParlamentar;
    @Column(name = "membros")
    private Integer membros;

    public Lideranca() {
    }

    public Lideranca(Integer codLideranca) {
        this.codLideranca = codLideranca;
    }

    public Integer getCodLideranca() {
        return codLideranca;
    }

    public void setCodLideranca(Integer codLideranca) {
        this.codLideranca = codLideranca;
    }

    public Integer getCodiUnidPartido() {
        return codiUnidPartido;
    }

    public void setCodiUnidPartido(Integer codiUnidPartido) {
        this.codiUnidPartido = codiUnidPartido;
    }

    public Integer getFKcodParlamentar() {
        return fKcodParlamentar;
    }

    public void setFKcodParlamentar(Integer fKcodParlamentar) {
        this.fKcodParlamentar = fKcodParlamentar;
    }

    public Integer getMembros() {
        return membros;
    }

    public void setMembros(Integer membros) {
        this.membros = membros;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLideranca != null ? codLideranca.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lideranca)) {
            return false;
        }
        Lideranca other = (Lideranca) object;
        if ((this.codLideranca == null && other.codLideranca != null) || (this.codLideranca != null && !this.codLideranca.equals(other.codLideranca))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "persistencia.Lideranca[ codLideranca=" + codLideranca + " ]";
    }

    public String getNomeUnidLideranca() {
        return nomeUnidLideranca;
    }

    public void setNomeUnidLideranca(String nomeUnidLideranca) {
        this.nomeUnidLideranca = nomeUnidLideranca;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getSiglaUnidLideranca() {
        return siglaUnidLideranca;
    }

    public void setSiglaUnidLideranca(String siglaUnidLideranca) {
        this.siglaUnidLideranca = siglaUnidLideranca;
    }

    public String getTipoLideranca() {
        return tipoLideranca;
    }

    public void setTipoLideranca(String tipoLideranca) {
        this.tipoLideranca = tipoLideranca;
    }

    public String getTipoUnidLideranca() {
        return tipoUnidLideranca;
    }

    public void setTipoUnidLideranca(String tipoUnidLideranca) {
        this.tipoUnidLideranca = tipoUnidLideranca;
    }
    
}
