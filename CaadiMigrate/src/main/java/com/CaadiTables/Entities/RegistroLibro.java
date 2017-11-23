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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author frodo
 */
@Entity
@Table(name = "registro_libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroLibro.findAll", query = "SELECT r FROM RegistroLibro r")
    , @NamedQuery(name = "RegistroLibro.findByIdRegistro", query = "SELECT r FROM RegistroLibro r WHERE r.idRegistro = :idRegistro")})
public class RegistroLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_registro")
    private Integer idRegistro;
    
    @ManyToOne(optional = false)
    private Visit idVisita;
    
    @ManyToOne(optional = false)
    private Libro codBar;

    public RegistroLibro() {
    }

    public RegistroLibro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Visit getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Visit idVisita) {
        this.idVisita = idVisita;
    }

    public Libro getCodBar() {
        return codBar;
    }

    public void setCodBar(Libro codBar) {
        this.codBar = codBar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroLibro)) {
            return false;
        }
        RegistroLibro other = (RegistroLibro) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.RegistroLibro[ idRegistro=" + idRegistro + " ]";
    }
    
}
