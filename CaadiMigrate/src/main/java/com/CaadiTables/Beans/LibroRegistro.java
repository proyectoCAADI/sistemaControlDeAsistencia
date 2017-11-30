/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CaadiTables.Beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nico
 */
@Entity
@Table(name = "libro_registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroRegistro.findAll", query = "SELECT l FROM LibroRegistro l")
    , @NamedQuery(name = "LibroRegistro.findByCodBar", query = "SELECT l FROM LibroRegistro l WHERE l.codBar = :codBar")
    , @NamedQuery(name = "LibroRegistro.findByNua", query = "SELECT l FROM LibroRegistro l WHERE l.nua = :nua")
    , @NamedQuery(name = "LibroRegistro.findByFecha", query = "SELECT l FROM LibroRegistro l WHERE l.fecha = :fecha")})
public class LibroRegistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_bar")
    private Long codBar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nua")
    private int nua;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public LibroRegistro() {
    }

    public LibroRegistro(Long codBar) {
        this.codBar = codBar;
    }

    public LibroRegistro(Long codBar, int nua) {
        this.codBar = codBar;
        this.nua = nua;
    }

    public Long getCodBar() {
        return codBar;
    }

    public void setCodBar(Long codBar) {
        this.codBar = codBar;
    }

    public int getNua() {
        return nua;
    }

    public void setNua(int nua) {
        this.nua = nua;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBar != null ? codBar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroRegistro)) {
            return false;
        }
        LibroRegistro other = (LibroRegistro) object;
        if ((this.codBar == null && other.codBar != null) || (this.codBar != null && !this.codBar.equals(other.codBar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Beans.LibroRegistro[ codBar=" + codBar + " ]";
    }
    
}
