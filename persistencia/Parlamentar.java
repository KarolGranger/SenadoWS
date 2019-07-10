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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafae
 */
@Entity
@Table(name = "parlamentar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parlamentar.findAll", query = "SELECT p FROM Parlamentar p")
    , @NamedQuery(name = "Parlamentar.findByCodParlamentar", query = "SELECT p FROM Parlamentar p WHERE p.codParlamentar = :codParlamentar")
    , @NamedQuery(name = "Parlamentar.findByCodMandato", query = "SELECT p FROM Parlamentar p WHERE p.codMandato = :codMandato")
    , @NamedQuery(name = "Parlamentar.findByDescMandato", query = "SELECT p FROM Parlamentar p WHERE p.descMandato = :descMandato")
    , @NamedQuery(name = "Parlamentar.findByFormaTratamento", query = "SELECT p FROM Parlamentar p WHERE p.formaTratamento = :formaTratamento")
    , @NamedQuery(name = "Parlamentar.findByNome", query = "SELECT p FROM Parlamentar p WHERE p.nome = :nome")
    , @NamedQuery(name = "Parlamentar.findBySexo", query = "SELECT p FROM Parlamentar p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "Parlamentar.findBySiglaPartido", query = "SELECT p FROM Parlamentar p WHERE p.siglaPartido = :siglaPartido")
    , @NamedQuery(name = "Parlamentar.findByUFParlamentar", query = "SELECT p FROM Parlamentar p WHERE p.uFParlamentar = :uFParlamentar")})
public class Parlamentar implements Serializable {

    @Size(max = 255)
    @Column(name = "descMandato")
    private String descMandato;
    @Size(max = 255)
    @Column(name = "formaTratamento")
    private String formaTratamento;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 255)
    @Column(name = "siglaPartido")
    private String siglaPartido;
    @Size(max = 255)
    @Column(name = "UFParlamentar")
    private String uFParlamentar;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codParlamentar")
    private Integer codParlamentar;
    @Column(name = "codMandato")
    private Integer codMandato;

    public Parlamentar() {
    }

    public Parlamentar(Integer codParlamentar) {
        this.codParlamentar = codParlamentar;
    }

    public Integer getCodParlamentar() {
        return codParlamentar;
    }

    public void setCodParlamentar(Integer codParlamentar) {
        this.codParlamentar = codParlamentar;
    }

    public Integer getCodMandato() {
        return codMandato;
    }

    public void setCodMandato(Integer codMandato) {
        this.codMandato = codMandato;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codParlamentar != null ? codParlamentar.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parlamentar)) {
            return false;
        }
        Parlamentar other = (Parlamentar) object;
        if ((this.codParlamentar == null && other.codParlamentar != null) || (this.codParlamentar != null && !this.codParlamentar.equals(other.codParlamentar))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "persistencia.Parlamentar[ codParlamentar=" + codParlamentar + " ]";
    }

    public String getDescMandato() {
        return descMandato;
    }

    public void setDescMandato(String descMandato) {
        this.descMandato = descMandato;
    }

    public String getFormaTratamento() {
        return formaTratamento;
    }

    public void setFormaTratamento(String formaTratamento) {
        this.formaTratamento = formaTratamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getUFParlamentar() {
        return uFParlamentar;
    }

    public void setUFParlamentar(String uFParlamentar) {
        this.uFParlamentar = uFParlamentar;
    }
    
}
