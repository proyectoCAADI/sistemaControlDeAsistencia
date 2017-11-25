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
@Table(name = "revista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revista.findAll", query = "SELECT r FROM Revista r")
    , @NamedQuery(name = "Revista.findByIdRevista", query = "SELECT r FROM Revista r WHERE r.idRevista = :idRevista")
    , @NamedQuery(name = "Revista.findByTituloRevista", query = "SELECT r FROM Revista r WHERE r.tituloRevista = :tituloRevista")
    , @NamedQuery(name = "Revista.findByNombreRevista", query = "SELECT r FROM Revista r WHERE r.nombreRevista = :nombreRevista")
    , @NamedQuery(name = "Revista.findByFecha", query = "SELECT r FROM Revista r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Revista.findByIdEstado", query = "SELECT r FROM Revista r WHERE r.idEstado = :idEstado")})
public class Revista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_revista")
    private Integer idRevista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo_revista")
    private String tituloRevista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 101)
    @Column(name = "nombre_revista")
    private String nombreRevista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id_estado")
    private String idEstado;
    @JoinColumn(name = "id_rating", referencedColumnName = "id_rating")
    @ManyToOne
    private Rating idRating;
    @JoinColumn(name = "id_editorial", referencedColumnName = "id_editorial")
    @ManyToOne(optional = false)
    private Editorial idEditorial;

    public Revista() {
    }

    public Revista(Integer idRevista) {
        this.idRevista = idRevista;
    }

    public Revista(Integer idRevista, String tituloRevista, String nombreRevista, String fecha, String idEstado) {
        this.idRevista = idRevista;
        this.tituloRevista = tituloRevista;
        this.nombreRevista = nombreRevista;
        this.fecha = fecha;
        this.idEstado = idEstado;
    }

    public Integer getIdRevista() {
        return idRevista;
    }

    public void setIdRevista(Integer idRevista) {
        this.idRevista = idRevista;
    }

    public String getTituloRevista() {
        return tituloRevista;
    }

    public void setTituloRevista(String tituloRevista) {
        this.tituloRevista = tituloRevista;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public Rating getIdRating() {
        return idRating;
    }

    public void setIdRating(Rating idRating) {
        this.idRating = idRating;
    }

    public Editorial getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editorial idEditorial) {
        this.idEditorial = idEditorial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRevista != null ? idRevista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revista)) {
            return false;
        }
        Revista other = (Revista) object;
        if ((this.idRevista == null && other.idRevista != null) || (this.idRevista != null && !this.idRevista.equals(other.idRevista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.Revista[ idRevista=" + idRevista + " ]";
    }
    
}
