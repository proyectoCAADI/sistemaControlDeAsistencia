/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CaadiTables.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author frodo
 */
@Embeddable
public class VisitPK implements Serializable {

    
    @Basic(optional = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "libro_id_libro")
    private long libroIdLibro;

    public VisitPK() {
    }

    public VisitPK(int id, long libroIdLibro) {
        this.id = id;
        this.libroIdLibro = libroIdLibro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLibroIdLibro() {
        return libroIdLibro;
    }

    public void setLibroIdLibro(long libroIdLibro) {
        this.libroIdLibro = libroIdLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) libroIdLibro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitPK)) {
            return false;
        }
        VisitPK other = (VisitPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.libroIdLibro != other.libroIdLibro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.VisitPK[ id=" + id + ", libroIdLibro=" + libroIdLibro + " ]";
    }
    
}
