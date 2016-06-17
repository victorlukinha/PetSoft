/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsoft;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 00685193209
 */
@Entity
@Table(name = "animal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a"),
    @NamedQuery(name = "Animal.findByIdAnimal", query = "SELECT a FROM Animal a WHERE a.idAnimal = :idAnimal"),
    @NamedQuery(name = "Animal.findByNome", query = "SELECT a FROM Animal a WHERE a.nome = :nome"),
    @NamedQuery(name = "Animal.findByRaca", query = "SELECT a FROM Animal a WHERE a.raca = :raca"),
    @NamedQuery(name = "Animal.findByEspecie", query = "SELECT a FROM Animal a WHERE a.especie = :especie"),
    @NamedQuery(name = "Animal.findByDataNasc", query = "SELECT a FROM Animal a WHERE a.dataNasc = :dataNasc")})
public class Animal implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAnimal")
    private Integer idAnimal;
    @Column(name = "nome")
    private String nome;
    @Column(name = "raca")
    private String raca;
    @Column(name = "especie")
    private String especie;
    @Column(name = "dataNasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @JoinColumn(name = "dono", referencedColumnName = "idCliente")
    @ManyToOne
    private Cliente dono;
    @OneToMany(mappedBy = "animal")
    private Collection<Diaria> diariaCollection;

    public Animal() {
    }

    public Animal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        Integer oldIdAnimal = this.idAnimal;
        this.idAnimal = idAnimal;
        changeSupport.firePropertyChange("idAnimal", oldIdAnimal, idAnimal);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        String oldRaca = this.raca;
        this.raca = raca;
        changeSupport.firePropertyChange("raca", oldRaca, raca);
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        String oldEspecie = this.especie;
        this.especie = especie;
        changeSupport.firePropertyChange("especie", oldEspecie, especie);
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        Date oldDataNasc = this.dataNasc;
        this.dataNasc = dataNasc;
        changeSupport.firePropertyChange("dataNasc", oldDataNasc, dataNasc);
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        Cliente oldDono = this.dono;
        this.dono = dono;
        changeSupport.firePropertyChange("dono", oldDono, dono);
    }

    @XmlTransient
    public Collection<Diaria> getDiariaCollection() {
        return diariaCollection;
    }

    public void setDiariaCollection(Collection<Diaria> diariaCollection) {
        this.diariaCollection = diariaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "petsoft.Animal[ idAnimal=" + idAnimal + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
