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
@Table(name = "subtitulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subtitulo.findAll", query = "SELECT s FROM Subtitulo s")
    , @NamedQuery(name = "Subtitulo.findByIdSubtitulo", query = "SELECT s FROM Subtitulo s WHERE s.idSubtitulo = :idSubtitulo")
    , @NamedQuery(name = "Subtitulo.findByIdiomaSubtitulo", query = "SELECT s FROM Subtitulo s WHERE s.idiomaSubtitulo = :idiomaSubtitulo")})
public class Subtitulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subtitulo")
    private Integer idSubtitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idioma_subtitulo")
    private String idiomaSubtitulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubtitulo")
    private Collection<Pelicula> peliculaCollection;

    public Subtitulo() {
    }

    public Subtitulo(Integer idSubtitulo) {
        this.idSubtitulo = idSubtitulo;
    }

    public Subtitulo(Integer idSubtitulo, String idiomaSubtitulo) {
        this.idSubtitulo = idSubtitulo;
        this.idiomaSubtitulo = idiomaSubtitulo;
    }

    public Integer getIdSubtitulo() {
        return idSubtitulo;
    }

    public void setIdSubtitulo(Integer idSubtitulo) {
        this.idSubtitulo = idSubtitulo;
    }

    public String getIdiomaSubtitulo() {
        return idiomaSubtitulo;
    }

    public void setIdiomaSubtitulo(String idiomaSubtitulo) {
        this.idiomaSubtitulo = idiomaSubtitulo;
    }

    @XmlTransient
    public Collection<Pelicula> getPeliculaCollection() {
        return peliculaCollection;
    }

    public void setPeliculaCollection(Collection<Pelicula> peliculaCollection) {
        this.peliculaCollection = peliculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubtitulo != null ? idSubtitulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subtitulo)) {
            return false;
        }
        Subtitulo other = (Subtitulo) object;
        if ((this.idSubtitulo == null && other.idSubtitulo != null) || (this.idSubtitulo != null && !this.idSubtitulo.equals(other.idSubtitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.Subtitulo[ idSubtitulo=" + idSubtitulo + " ]";
    }
    
}
