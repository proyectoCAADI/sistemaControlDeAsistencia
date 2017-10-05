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
@Table(name = "Visit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v")
    , @NamedQuery(name = "Visit.findById", query = "SELECT v FROM Visit v WHERE v.id = :id")
    , @NamedQuery(name = "Visit.findBySkill", query = "SELECT v FROM Visit v WHERE v.skill = :skill")
    , @NamedQuery(name = "Visit.findByStart", query = "SELECT v FROM Visit v WHERE v.start = :start")
    , @NamedQuery(name = "Visit.findByEnd", query = "SELECT v FROM Visit v WHERE v.end = :end")})
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "skill")
    private String skill;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Column(name = "end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    @JoinColumn(name = "periodId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periods periodId;
    @JoinColumn(name = "nua", referencedColumnName = "nua")
    @ManyToOne(optional = false)
    private Students nua;

    public Visit() {
    }

    public Visit(Integer id) {
        this.id = id;
    }

    public Visit(Integer id, Date start) {
        this.id = id;
        this.start = start;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Periods getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Periods periodId) {
        this.periodId = periodId;
    }

    public Students getNua() {
        return nua;
    }

    public void setNua(Students nua) {
        this.nua = nua;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visit)) {
            return false;
        }
        Visit other = (Visit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.Visit[ id=" + id + " ]";
    }
    
}
