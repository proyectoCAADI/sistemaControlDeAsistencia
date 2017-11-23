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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author frodo
 */
@Entity
@Table(name = "tipo_libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLibro.findAll", query = "SELECT t FROM TipoLibro t")
    , @NamedQuery(name = "TipoLibro.findByIdTipoLibro", query = "SELECT t FROM TipoLibro t WHERE t.idTipoLibro = :idTipoLibro")
    , @NamedQuery(name = "TipoLibro.findByTipoLibro", query = "SELECT t FROM TipoLibro t WHERE t.tipoLibro = :tipoLibro")})
public class TipoLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_libro")
    private Integer idTipoLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_libro")
    private String tipoLibro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoLibro")
    private Collection<Libro> libroCollection;

    public TipoLibro() {
    }

    public TipoLibro(Integer idTipoLibro) {
        this.idTipoLibro = idTipoLibro;
    }

    public TipoLibro(Integer idTipoLibro, String tipoLibro) {
        this.idTipoLibro = idTipoLibro;
        this.tipoLibro = tipoLibro;
    }

    public Integer getIdTipoLibro() {
        return idTipoLibro;
    }

    public void setIdTipoLibro(Integer idTipoLibro) {
        this.idTipoLibro = idTipoLibro;
    }

    public String getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(String tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    @XmlTransient
    public Collection<Libro> getLibroCollection() {
        return libroCollection;
    }

    public void setLibroCollection(Collection<Libro> libroCollection) {
        this.libroCollection = libroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoLibro != null ? idTipoLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLibro)) {
            return false;
        }
        TipoLibro other = (TipoLibro) object;
        if ((this.idTipoLibro == null && other.idTipoLibro != null) || (this.idTipoLibro != null && !this.idTipoLibro.equals(other.idTipoLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.TipoLibro[ idTipoLibro=" + idTipoLibro + " ]";
    }
    
}
