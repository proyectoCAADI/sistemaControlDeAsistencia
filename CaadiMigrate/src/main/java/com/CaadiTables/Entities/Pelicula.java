/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CaadiTables.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author frodo
 */
@Entity
@Table(name = "pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
    , @NamedQuery(name = "Pelicula.findByIdPelicula", query = "SELECT p FROM Pelicula p WHERE p.idPelicula = :idPelicula")
    , @NamedQuery(name = "Pelicula.findByTituloPelicula", query = "SELECT p FROM Pelicula p WHERE p.tituloPelicula = :tituloPelicula")
    , @NamedQuery(name = "Pelicula.findByDuracionPelicula", query = "SELECT p FROM Pelicula p WHERE p.duracionPelicula = :duracionPelicula")
    , @NamedQuery(name = "Pelicula.findByBackCover", query = "SELECT p FROM Pelicula p WHERE p.backCover = :backCover")
    , @NamedQuery(name = "Pelicula.findByFrontCover", query = "SELECT p FROM Pelicula p WHERE p.frontCover = :frontCover")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pelicula")
    private Integer idPelicula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo_pelicula")
    private String tituloPelicula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_pelicula")
    private int duracionPelicula;
    @Size(max = 100)
    @Column(name = "back_cover")
    private String backCover;
    @Size(max = 100)
    @Column(name = "front_cover")
    private String frontCover;
    @JoinColumn(name = "id_idioma", referencedColumnName = "id_idioma")
    @ManyToOne(optional = false)
    private Idioma idIdioma;
    @JoinColumn(name = "id_subtitulo", referencedColumnName = "id_subtitulo")
    @ManyToOne(optional = false)
    private Subtitulo idSubtitulo;
    @JoinColumn(name = "id_actor", referencedColumnName = "id_actor")
    @ManyToOne(optional = false)
    private Actor idActor;
    @JoinColumn(name = "id_rating", referencedColumnName = "id_rating")
    @ManyToOne
    private Rating idRating;
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    @ManyToOne(optional = false)
    private Genero idGenero;

    public Pelicula() {
    }

    public Pelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Pelicula(Integer idPelicula, String tituloPelicula, int duracionPelicula) {
        this.idPelicula = idPelicula;
        this.tituloPelicula = tituloPelicula;
        this.duracionPelicula = duracionPelicula;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public int getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(int duracionPelicula) {
        this.duracionPelicula = duracionPelicula;
    }

    public String getBackCover() {
        return backCover;
    }

    public void setBackCover(String backCover) {
        this.backCover = backCover;
    }

    public String getFrontCover() {
        return frontCover;
    }

    public void setFrontCover(String frontCover) {
        this.frontCover = frontCover;
    }

    public Idioma getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Idioma idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Subtitulo getIdSubtitulo() {
        return idSubtitulo;
    }

    public void setIdSubtitulo(Subtitulo idSubtitulo) {
        this.idSubtitulo = idSubtitulo;
    }

    public Actor getIdActor() {
        return idActor;
    }

    public void setIdActor(Actor idActor) {
        this.idActor = idActor;
    }

    public Rating getIdRating() {
        return idRating;
    }

    public void setIdRating(Rating idRating) {
        this.idRating = idRating;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPelicula != null ? idPelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.idPelicula == null && other.idPelicula != null) || (this.idPelicula != null && !this.idPelicula.equals(other.idPelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.Pelicula[ idPelicula=" + idPelicula + " ]";
    }
    
}
