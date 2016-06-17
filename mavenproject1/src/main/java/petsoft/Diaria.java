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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "diaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diaria.findAll", query = "SELECT d FROM Diaria d"),
    @NamedQuery(name = "Diaria.findByIdDiaria", query = "SELECT d FROM Diaria d WHERE d.idDiaria = :idDiaria"),
    @NamedQuery(name = "Diaria.findByQtdDias", query = "SELECT d FROM Diaria d WHERE d.qtdDias = :qtdDias")})
public class Diaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDiaria")
    private Integer idDiaria;
    @Column(name = "qtdDias")
    private String qtdDias;
    @ManyToMany(mappedBy = "diariaCollection")
    private Collection<Venda> vendaCollection;
    @ManyToMany(mappedBy = "diariaCollection")
    private Collection<Produto> produtoCollection;
    @JoinColumn(name = "animal", referencedColumnName = "idAnimal")
    @ManyToOne
    private Animal animal;

    public Diaria() {
    }

    public Diaria(Integer idDiaria) {
        this.idDiaria = idDiaria;
    }

    public Integer getIdDiaria() {
        return idDiaria;
    }

    public void setIdDiaria(Integer idDiaria) {
        this.idDiaria = idDiaria;
    }

    public String getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(String qtdDias) {
        this.qtdDias = qtdDias;
    }

    @XmlTransient
    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiaria != null ? idDiaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diaria)) {
            return false;
        }
        Diaria other = (Diaria) object;
        if ((this.idDiaria == null && other.idDiaria != null) || (this.idDiaria != null && !this.idDiaria.equals(other.idDiaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "petsoft.Diaria[ idDiaria=" + idDiaria + " ]";
    }
    
}
