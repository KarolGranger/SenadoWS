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
@Table(name = "partidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partidos.findAll", query = "SELECT p FROM Partidos p")
    , @NamedQuery(name = "Partidos.findByIdPartido", query = "SELECT p FROM Partidos p WHERE p.idPartido = :idPartido")
    , @NamedQuery(name = "Partidos.findByDataCriacao", query = "SELECT p FROM Partidos p WHERE p.dataCriacao = :dataCriacao")
    , @NamedQuery(name = "Partidos.findByNomePartido", query = "SELECT p FROM Partidos p WHERE p.nomePartido = :nomePartido")
    , @NamedQuery(name = "Partidos.findBySigla", query = "SELECT p FROM Partidos p WHERE p.sigla = :sigla")})
public class Partidos implements Serializable {

    @Size(max = 255)
    @Column(name = "dataCriacao")
    private String dataCriacao;
    @Size(max = 255)
    @Column(name = "nomePartido")
    private String nomePartido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sigla")
    private String sigla;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "idPartido")
    private String idPartido;

    public Partidos() {
    }

    public Partidos(String idPartido) {
        this.idPartido = idPartido;
    }

    public Partidos(String idPartido, String sigla) {
        this.idPartido = idPartido;
        this.sigla = sigla;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartido != null ? idPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partidos)) {
            return false;
        }
        Partidos other = (Partidos) object;
        if ((this.idPartido == null && other.idPartido != null) || (this.idPartido != null && !this.idPartido.equals(other.idPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Partidos[ idPartido=" + idPartido + " ]";
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNomePartido() {
        return nomePartido;
    }

    public void setNomePartido(String nomePartido) {
        this.nomePartido = nomePartido;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
}
