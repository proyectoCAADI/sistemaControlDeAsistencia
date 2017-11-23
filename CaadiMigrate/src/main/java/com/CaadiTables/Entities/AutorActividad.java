/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CaadiTables.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author frodo
 */
@Entity
@Table(name = "autor_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorActividad.findAll", query = "SELECT a FROM AutorActividad a")
    , @NamedQuery(name = "AutorActividad.findByIdAutor", query = "SELECT a FROM AutorActividad a WHERE a.idAutor = :idAutor")
    , @NamedQuery(name = "AutorActividad.findByNua", query = "SELECT a FROM AutorActividad a WHERE a.nua = :nua")})
public class AutorActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autor")
    private Integer idAutor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nua")
    private int nua;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutor")
    private Collection<Juego> juegoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAutor")
    private Collection<HojaTrabajo> hojaTrabajoCollection;

    public AutorActividad() {
    }

    public AutorActividad(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public AutorActividad(Integer idAutor, int nua) {
        this.idAutor = idAutor;
        this.nua = nua;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public int getNua() {
        return nua;
    }

    public void setNua(int nua) {
        this.nua = nua;
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
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorActividad)) {
            return false;
        }
        AutorActividad other = (AutorActividad) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.AutorActividad[ idAutor=" + idAutor + " ]";
    }
    
}
