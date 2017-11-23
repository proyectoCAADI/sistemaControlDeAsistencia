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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")
    , @NamedQuery(name = "Autor.findByIdAutor", query = "SELECT a FROM Autor a WHERE a.idAutor = :idAutor")
    , @NamedQuery(name = "Autor.findByNombreAutorlibro", query = "SELECT a FROM Autor a WHERE a.nombreAutorlibro = :nombreAutorlibro")
    , @NamedQuery(name = "Autor.findByApellidoAutorlibro", query = "SELECT a FROM Autor a WHERE a.apellidoAutorlibro = :apellidoAutorlibro")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autor")
    private Integer idAutor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_autorlibro")
    private String nombreAutorlibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido_autorlibro")
    private String apellidoAutorlibro;
    @ManyToMany(mappedBy = "autorCollection")
    private Collection<Libro> libroCollection;

    public Autor() {
    }

    public Autor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Autor(Integer idAutor, String nombreAutorlibro, String apellidoAutorlibro) {
        this.idAutor = idAutor;
        this.nombreAutorlibro = nombreAutorlibro;
        this.apellidoAutorlibro = apellidoAutorlibro;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutorlibro() {
        return nombreAutorlibro;
    }

    public void setNombreAutorlibro(String nombreAutorlibro) {
        this.nombreAutorlibro = nombreAutorlibro;
    }

    public String getApellidoAutorlibro() {
        return apellidoAutorlibro;
    }

    public void setApellidoAutorlibro(String apellidoAutorlibro) {
        this.apellidoAutorlibro = apellidoAutorlibro;
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
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idAutor.toString();
    }
    
}
