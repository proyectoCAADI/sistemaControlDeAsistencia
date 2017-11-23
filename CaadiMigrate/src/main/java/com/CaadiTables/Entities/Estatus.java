/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CaadiTables.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author frodo
 */
@Entity
@Table(name = "estatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estatus.findAll", query = "SELECT e FROM Estatus e")
    , @NamedQuery(name = "Estatus.findByIdEstatus", query = "SELECT e FROM Estatus e WHERE e.idEstatus = :idEstatus")
    , @NamedQuery(name = "Estatus.findByEstatus", query = "SELECT e FROM Estatus e WHERE e.estatus = :estatus")})
public class Estatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estatus")
    private Integer idEstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estatus")
    private String estatus;
    @OneToMany(mappedBy = "idEstatus")
    private Collection<Juego> juegoCollection;
    @OneToMany(mappedBy = "idEstatus")
    private Collection<HojaTrabajo> hojaTrabajoCollection;

    public Estatus() {
    }

    public Estatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public Estatus(Integer idEstatus, String estatus) {
        this.idEstatus = idEstatus;
        this.estatus = estatus;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public Collection<Juego> getJuegoCollection() {
        return juegoCollection;
    }

    public void setJuegoCollection(Collection<Juego> juegoCollection) {
        this.juegoCollection = juegoCollection;
    }

    @XmlTransient
    public Collection<HojaTrabajo> getHojaTrabajoCollection() {
        return hojaTrabajoCollection;
    }

    public void setHojaTrabajoCollection(Collection<HojaTrabajo> hojaTrabajoCollection) {
        this.hojaTrabajoCollection = hojaTrabajoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstatus != null ? idEstatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estatus)) {
            return false;
        }
        Estatus other = (Estatus) object;
        if ((this.idEstatus == null && other.idEstatus != null) || (this.idEstatus != null && !this.idEstatus.equals(other.idEstatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idEstatus.toString();
    }
    
}
