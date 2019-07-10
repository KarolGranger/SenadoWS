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
@Table(name = "apoioescritorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apoioescritorio.findAll", query = "SELECT a FROM Apoioescritorio a")
    , @NamedQuery(name = "Apoioescritorio.findByIdApoio", query = "SELECT a FROM Apoioescritorio a WHERE a.idApoio = :idApoio")
    , @NamedQuery(name = "Apoioescritorio.findByEndereco", query = "SELECT a FROM Apoioescritorio a WHERE a.endereco = :endereco")
    , @NamedQuery(name = "Apoioescritorio.findByEstado", query = "SELECT a FROM Apoioescritorio a WHERE a.estado = :estado")
    , @NamedQuery(name = "Apoioescritorio.findByNomeParlamentar", query = "SELECT a FROM Apoioescritorio a WHERE a.nomeParlamentar = :nomeParlamentar")
    , @NamedQuery(name = "Apoioescritorio.findBySetor", query = "SELECT a FROM Apoioescritorio a WHERE a.setor = :setor")
    , @NamedQuery(name = "Apoioescritorio.findByTelefone", query = "SELECT a FROM Apoioescritorio a WHERE a.telefone = :telefone")})
public class Apoioescritorio implements Serializable {

    @Size(max = 255)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "nomeParlamentar")
    private String nomeParlamentar;
    @Size(max = 255)
    @Column(name = "setor")
    private String setor;
    @Size(max = 255)
    @Column(name = "telefone")
    private String telefone;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idApoio")
    private Integer idApoio;

    public Apoioescritorio() {
    }

    public Apoioescritorio(Integer idApoio) {
        this.idApoio = idApoio;
    }

    public Integer getIdApoio() {
        return idApoio;
    }

    public void setIdApoio(Integer idApoio) {
        this.idApoio = idApoio;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApoio != null ? idApoio.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apoioescritorio)) {
            return false;
        }
        Apoioescritorio other = (Apoioescritorio) object;
        if ((this.idApoio == null && other.idApoio != null) || (this.idApoio != null && !this.idApoio.equals(other.idApoio))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "persistencia.Apoioescritorio[ idApoio=" + idApoio + " ]";
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNomeParlamentar() {
        return nomeParlamentar;
    }

    public void setNomeParlamentar(String nomeParlamentar) {
        this.nomeParlamentar = nomeParlamentar;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
