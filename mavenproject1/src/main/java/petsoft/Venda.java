/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsoft;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 00685193209
 */
@Entity
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByIdVenda", query = "SELECT v FROM Venda v WHERE v.idVenda = :idVenda"),
    @NamedQuery(name = "Venda.findByFuncionario", query = "SELECT v FROM Venda v WHERE v.funcionario = :funcionario"),
    @NamedQuery(name = "Venda.findByCliente", query = "SELECT v FROM Venda v WHERE v.cliente = :cliente")})
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVenda")
    private Integer idVenda;
    @Column(name = "funcionario")
    private Integer funcionario;
    @Column(name = "cliente")
    private Integer cliente;
    @JoinTable(name = "venda_has_diaria", joinColumns = {
        @JoinColumn(name = "venda", referencedColumnName = "idVenda")}, inverseJoinColumns = {
        @JoinColumn(name = "diaria", referencedColumnName = "idDiaria")})
    @ManyToMany
    private Collection<Diaria> diariaCollection;
    @JoinTable(name = "venda_has_produto", joinColumns = {
        @JoinColumn(name = "venda", referencedColumnName = "idVenda")}, inverseJoinColumns = {
        @JoinColumn(name = "produto", referencedColumnName = "idProduto")})
    @ManyToMany
    private Collection<Produto> produtoCollection;

    public Venda() {
    }

    public Venda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Integer funcionario) {
        this.funcionario = funcionario;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public Collection<Diaria> getDiariaCollection() {
        return diariaCollection;
    }

    public void setDiariaCollection(Collection<Diaria> diariaCollection) {
        this.diariaCollection = diariaCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idVenda == null && other.idVenda != null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "petsoft.Venda[ idVenda=" + idVenda + " ]";
    }
    
}
