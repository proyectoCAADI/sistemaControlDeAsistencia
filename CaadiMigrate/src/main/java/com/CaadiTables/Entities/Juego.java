/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CaadiTables.Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author frodo
 */
@Entity
@Table(name = "juego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j")
    , @NamedQuery(name = "Juego.findByIdJuego", query = "SELECT j FROM Juego j WHERE j.idJuego = :idJuego")
    , @NamedQuery(name = "Juego.findByNombreJuego", query = "SELECT j FROM Juego j WHERE j.nombreJuego = :nombreJuego")
    , @NamedQuery(name = "Juego.findByInstruccion", query = "SELECT j FROM Juego j WHERE j.instruccion = :instruccion")
    , @NamedQuery(name = "Juego.findByUnidad", query = "SELECT j FROM Juego j WHERE j.unidad = :unidad")
    , @NamedQuery(name = "Juego.findByDuracion", query = "SELECT j FROM Juego j WHERE j.duracion = :duracion")
    , @NamedQuery(name = "Juego.findByFecha", query = "SELECT j FROM Juego j WHERE j.fecha = :fecha")})
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_juego")
    private Integer idJuego;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_juego")
    private String nombreJuego;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "instruccion")
    private String instruccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidad")
    private int unidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_estatus", referencedColumnName = "id_estatus")
    @ManyToOne
    private Estatus idEstatus;
    @JoinColumn(name = "id_habilidad", referencedColumnName = "id_habilidad")
    @ManyToOne(optional = false)
    private Habilidad idHabilidad;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne(optional = false)
    private Nivel idNivel;
    @JoinColumn(name = "id_autor", referencedColumnName = "id_autor")
    @ManyToOne(optional = false)
    private AutorActividad idAutor;
    @JoinColumn(name = "id_idioma", referencedColumnName = "id_idioma")
    @ManyToOne(optional = false)
    private Idioma idIdioma;
    @JoinColumn(name = "id_rating", referencedColumnName = "id_rating")
    @ManyToOne
    private Rating idRating;

    public Juego() {
    }

    public Juego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Juego(Integer idJuego, String nombreJuego, String instruccion, int unidad, int duracion, Date fecha) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.instruccion = instruccion;
        this.unidad = unidad;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estatus getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Estatus idEstatus) {
        this.idEstatus = idEstatus;
    }

    public Habilidad getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Habilidad idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public Nivel getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Nivel idNivel) {
        this.idNivel = idNivel;
    }

    public AutorActividad getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(AutorActividad idAutor) {
        this.idAutor = idAutor;
    }

    public Idioma getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Idioma idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Rating getIdRating() {
        return idRating;
    }

    public void setIdRating(Rating idRating) {
        this.idRating = idRating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuego != null ? idJuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juego)) {
            return false;
        }
        Juego other = (Juego) object;
        if ((this.idJuego == null && other.idJuego != null) || (this.idJuego != null && !this.idJuego.equals(other.idJuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.Juego[ idJuego=" + idJuego + " ]";
    }
    
}
