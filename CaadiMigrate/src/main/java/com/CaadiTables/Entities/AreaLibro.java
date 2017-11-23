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
@Table(name = "area_libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaLibro.findAll", query = "SELECT a FROM AreaLibro a")
    , @NamedQuery(name = "AreaLibro.findByIdAreaLibro", query = "SELECT a FROM AreaLibro a WHERE a.idAreaLibro = :idAreaLibro")
    , @NamedQuery(name = "AreaLibro.findByAreaLibro", query = "SELECT a FROM AreaLibro a WHERE a.areaLibro = :areaLibro")})
public class AreaLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area_libro")
    private Integer idAreaLibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "area_libro")
    private String areaLibro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaLibro")
    private Collection<Libro> libroCollection;

    public AreaLibro() {
    }

    public AreaLibro(Integer idAreaLibro) {
        this.idAreaLibro = idAreaLibro;
    }

    public AreaLibro(Integer idAreaLibro, String areaLibro) {
        this.idAreaLibro = idAreaLibro;
        this.areaLibro = areaLibro;
    }

    public Integer getIdAreaLibro() {
        return idAreaLibro;
    }

    public void setIdAreaLibro(Integer idAreaLibro) {
        this.idAreaLibro = idAreaLibro;
    }

    public String getAreaLibro() {
        return areaLibro;
    }

    public void setAreaLibro(String areaLibro) {
        this.areaLibro = areaLibro;
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
        hash += (idAreaLibro != null ? idAreaLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaLibro)) {
            return false;
        }
        AreaLibro other = (AreaLibro) object;
        if ((this.idAreaLibro == null && other.idAreaLibro != null) || (this.idAreaLibro != null && !this.idAreaLibro.equals(other.idAreaLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idAreaLibro.toString();
    }
    
}
