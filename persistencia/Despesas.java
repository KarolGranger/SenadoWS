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
@Table(name = "despesas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Despesas.findAll", query = "SELECT d FROM Despesas d")
    , @NamedQuery(name = "Despesas.findByIdDespesas", query = "SELECT d FROM Despesas d WHERE d.idDespesas = :idDespesas")
    , @NamedQuery(name = "Despesas.findByAno", query = "SELECT d FROM Despesas d WHERE d.ano = :ano")
    , @NamedQuery(name = "Despesas.findByCnpjCpf", query = "SELECT d FROM Despesas d WHERE d.cnpjCpf = :cnpjCpf")
    , @NamedQuery(name = "Despesas.findByData", query = "SELECT d FROM Despesas d WHERE d.data = :data")
    , @NamedQuery(name = "Despesas.findByFornecedor", query = "SELECT d FROM Despesas d WHERE d.fornecedor = :fornecedor")
    , @NamedQuery(name = "Despesas.findByMes", query = "SELECT d FROM Despesas d WHERE d.mes = :mes")
    , @NamedQuery(name = "Despesas.findByNomeParlamentar", query = "SELECT d FROM Despesas d WHERE d.nomeParlamentar = :nomeParlamentar")
    , @NamedQuery(name = "Despesas.findByTipoDespesa", query = "SELECT d FROM Despesas d WHERE d.tipoDespesa = :tipoDespesa")
    , @NamedQuery(name = "Despesas.findByValorReembolsado", query = "SELECT d FROM Despesas d WHERE d.valorReembolsado = :valorReembolsado")})
public class Despesas implements Serializable {

    //@Size(max = 255)
    @Column(name = "ano")
    private String ano;
    //@Size(max = 255)
    @Column(name = "cnpj_cpf")
    private String cnpjCpf;
    //@Size(max = 255)
    @Column(name = "data")
    private String data;
   // @Size(max = 255)
    @Column(name = "fornecedor")
    private String fornecedor;
    //@Size(max = 255)
    @Column(name = "mes")
    private String mes;
    //@Size(max = 255)
    @Column(name = "nomeParlamentar")
    private String nomeParlamentar;
   // @Size(max = 255)
    @Column(name = "tipoDespesa")
    private String tipoDespesa;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDespesas")
    private Integer idDespesas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorReembolsado")
    private Double valorReembolsado;

    public Despesas() {
    }

    public Despesas(Integer idDespesas) {
        this.idDespesas = idDespesas;
    }

    public Integer getIdDespesas() {
        return idDespesas;
    }

    public void setIdDespesas(Integer idDespesas) {
        this.idDespesas = idDespesas;
    }


    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }


    public Double getValorReembolsado() {
        return valorReembolsado;
    }

    public void setValorReembolsado(Double valorReembolsado) {
        this.valorReembolsado = valorReembolsado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDespesas != null ? idDespesas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despesas)) {
            return false;
        }
        Despesas other = (Despesas) object;
        if ((this.idDespesas == null && other.idDespesas != null) || (this.idDespesas != null && !this.idDespesas.equals(other.idDespesas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Despesas[ idDespesas=" + idDespesas + " ]";
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getNomeParlamentar() {
        return nomeParlamentar;
    }

    public void setNomeParlamentar(String nomeParlamentar) {
        this.nomeParlamentar = nomeParlamentar;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }
    
}
