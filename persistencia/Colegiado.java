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
@Table(name = "colegiado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colegiado.findAll", query = "SELECT c FROM Colegiado c")
    , @NamedQuery(name = "Colegiado.findByCodColegiado", query = "SELECT c FROM Colegiado c WHERE c.codColegiado = :codColegiado")
    , @NamedQuery(name = "Colegiado.findByDataInicio", query = "SELECT c FROM Colegiado c WHERE c.dataInicio = :dataInicio")
    , @NamedQuery(name = "Colegiado.findByNomeColegiado", query = "SELECT c FROM Colegiado c WHERE c.nomeColegiado = :nomeColegiado")
    , @NamedQuery(name = "Colegiado.findByPresidente", query = "SELECT c FROM Colegiado c WHERE c.presidente = :presidente")
    , @NamedQuery(name = "Colegiado.findBySiglaColegiado", query = "SELECT c FROM Colegiado c WHERE c.siglaColegiado = :siglaColegiado")
    , @NamedQuery(name = "Colegiado.findBySuplentes", query = "SELECT c FROM Colegiado c WHERE c.suplentes = :suplentes")
    , @NamedQuery(name = "Colegiado.findByTitulares", query = "SELECT c FROM Colegiado c WHERE c.titulares = :titulares")
    , @NamedQuery(name = "Colegiado.findByVicePresidente", query = "SELECT c FROM Colegiado c WHERE c.vicePresidente = :vicePresidente")})
public class Colegiado implements Serializable {

    @Size(max = 255)
    @Column(name = "dataInicio")
    private String dataInicio;
    @Size(max = 255)
    @Column(name = "nomeColegiado")
    private String nomeColegiado;
    @Size(max = 255)
    @Column(name = "Presidente")
    private String presidente;
    @Size(max = 255)
    @Column(name = "siglaColegiado")
    private String siglaColegiado;
    @Size(max = 255)
    @Column(name = "VicePresidente")
    private String vicePresidente;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codColegiado")
    private Integer codColegiado;
    @Column(name = "suplentes")
    private Integer suplentes;
    @Column(name = "titulares")
    private Integer titulares;

    public Colegiado() {
    }

    public Colegiado(Integer codColegiado) {
        this.codColegiado = codColegiado;
    }

    public Integer getCodColegiado() {
        return codColegiado;
    }

    public void setCodColegiado(Integer codColegiado) {
        this.codColegiado = codColegiado;
    }


    public Integer getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(Integer suplentes) {
        this.suplentes = suplentes;
    }

    public Integer getTitulares() {
        return titulares;
    }

    public void setTitulares(Integer titulares) {
        this.titulares = titulares;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codColegiado != null ? codColegiado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colegiado)) {
            return false;
        }
        Colegiado other = (Colegiado) object;
        if ((this.codColegiado == null && other.codColegiado != null) || (this.codColegiado != null && !this.codColegiado.equals(other.codColegiado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Colegiado[ codColegiado=" + codColegiado + " ]";
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getNomeColegiado() {
        return nomeColegiado;
    }

    public void setNomeColegiado(String nomeColegiado) {
        this.nomeColegiado = nomeColegiado;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getSiglaColegiado() {
        return siglaColegiado;
    }

    public void setSiglaColegiado(String siglaColegiado) {
        this.siglaColegiado = siglaColegiado;
    }

    public String getVicePresidente() {
        return vicePresidente;
    }

    public void setVicePresidente(String vicePresidente) {
        this.vicePresidente = vicePresidente;
    }
    
}
