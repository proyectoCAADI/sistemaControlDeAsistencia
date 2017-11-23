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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByIdLibro", query = "SELECT l FROM Libro l WHERE l.idLibro = :idLibro")
    , @NamedQuery(name = "Libro.findByIsbn", query = "SELECT l FROM Libro l WHERE l.isbn = :isbn")
    , @NamedQuery(name = "Libro.findByCantidad", query = "SELECT l FROM Libro l WHERE l.cantidad = :cantidad")
    , @NamedQuery(name = "Libro.findByA\u00f1oPublicacion", query = "SELECT l FROM Libro l WHERE l.a\u00f1oPublicacion = :a\u00f1oPublicacion")
    , @NamedQuery(name = "Libro.findByTituloLibro", query = "SELECT l FROM Libro l WHERE l.tituloLibro = :tituloLibro")
    , @NamedQuery(name = "Libro.findByAudioLibro", query = "SELECT l FROM Libro l WHERE l.audioLibro = :audioLibro")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_libro")
    private Long idLibro;
    @Column(name = "isbn")
    private Integer isbn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "a\u00f1o_publicacion")
    private String añoPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo_libro")
    private String tituloLibro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "audio_libro")
    private boolean audioLibro;
    @JoinTable(name = "autor_libro", joinColumns = {
        @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")}, inverseJoinColumns = {
        @JoinColumn(name = "id_autor", referencedColumnName = "id_autor")})
    @ManyToMany
    private Collection<Autor> autorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
    private Collection<Visit> visitCollection;
    @JoinColumn(name = "id_tipo_libro", referencedColumnName = "id_tipo_libro")
    @ManyToOne(optional = false)
    private TipoLibro idTipoLibro;
    @JoinColumn(name = "id_rating", referencedColumnName = "id_rating")
    @ManyToOne
    private Rating idRating;
    @JoinColumn(name = "id_area_libro", referencedColumnName = "id_area_libro")
    @ManyToOne(optional = false)
    private AreaLibro idAreaLibro;
    @JoinColumn(name = "id_idioma", referencedColumnName = "id_idioma")
    @ManyToOne(optional = false)
    private Idioma idIdioma;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne(optional = false)
    private Nivel idNivel;
    @JoinColumn(name = "id_editorial", referencedColumnName = "id_editorial")
    @ManyToOne(optional = false)
    private Editorial idEditorial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codBar")
    private Collection<RegistroLibro> registroLibroCollection;

    public Libro() {
    }

    public Libro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public Libro(Long idLibro, int cantidad, String añoPublicacion, String tituloLibro, boolean audioLibro) {
        this.idLibro = idLibro;
        this.cantidad = cantidad;
        this.añoPublicacion = añoPublicacion;
        this.tituloLibro = tituloLibro;
        this.audioLibro = audioLibro;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(String añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public boolean getAudioLibro() {
        return audioLibro;
    }

    public void setAudioLibro(boolean audioLibro) {
        this.audioLibro = audioLibro;
    }

    @XmlTransient
    public Collection<Autor> getAutorCollection() {
        return autorCollection;
    }

    public void setAutorCollection(Collection<Autor> autorCollection) {
        this.autorCollection = autorCollection;
    }

    @XmlTransient
    public Collection<Visit> getVisitCollection() {
        return visitCollection;
    }

    public void setVisitCollection(Collection<Visit> visitCollection) {
        this.visitCollection = visitCollection;
    }

    public TipoLibro getIdTipoLibro() {
        return idTipoLibro;
    }

    public void setIdTipoLibro(TipoLibro idTipoLibro) {
        this.idTipoLibro = idTipoLibro;
    }

    public Rating getIdRating() {
        return idRating;
    }

    public void setIdRating(Rating idRating) {
        this.idRating = idRating;
    }

    public AreaLibro getIdAreaLibro() {
        return idAreaLibro;
    }

    public void setIdAreaLibro(AreaLibro idAreaLibro) {
        this.idAreaLibro = idAreaLibro;
    }

    public Idioma getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Idioma idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Nivel getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Nivel idNivel) {
        this.idNivel = idNivel;
    }

    public Editorial getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editorial idEditorial) {
        this.idEditorial = idEditorial;
    }

    @XmlTransient
    public Collection<RegistroLibro> getRegistroLibroCollection() {
        return registroLibroCollection;
    }

    public void setRegistroLibroCollection(Collection<RegistroLibro> registroLibroCollection) {
        this.registroLibroCollection = registroLibroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibro != null ? idLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idLibro == null && other.idLibro != null) || (this.idLibro != null && !this.idLibro.equals(other.idLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.Libro[ idLibro=" + idLibro + " ]";
    }
    
}
