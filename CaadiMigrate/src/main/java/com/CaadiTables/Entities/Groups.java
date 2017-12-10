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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g")
    , @NamedQuery(name = "Groups.findById", query = "SELECT g FROM Groups g WHERE g.id = :id")
    , @NamedQuery(name = "Groups.findByLearningUnit", query = "SELECT g FROM Groups g WHERE g.learningUnit = :learningUnit")
    , @NamedQuery(name = "Groups.findByLevel", query = "SELECT g FROM Groups g WHERE g.level = :level")
    , @NamedQuery(name = "Groups.findByIdentifier", query = "SELECT g FROM Groups g WHERE g.identifier = :identifier")})
public class Groups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "learningUnit")
    private String learningUnit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "level")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "identifier")
    private String identifier;
    @JoinTable(name = "GroupMembers", joinColumns = {
        @JoinColumn(name = "groupId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "nua", referencedColumnName = "nua")})
    @ManyToMany
    private Collection<Students> studentsCollection;
    @JoinColumn(name = "periodId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periods periodId;
    @JoinColumn(name = "employeeNumber", referencedColumnName = "employeeNumber")
    @ManyToOne(optional = false)
    private Teachers employeeNumber;

    public Groups() {
    }

    public Groups(Integer id) {
        this.id = id;
    }

    public Groups(Integer id, String learningUnit, String level, String identifier) {
        this.id = id;
        this.learningUnit = learningUnit;
        this.level = level;
        this.identifier = identifier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLearningUnit() {
        return learningUnit;
    }

    public void setLearningUnit(String learningUnit) {
        this.learningUnit = learningUnit;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @XmlTransient
    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
    }

    public Periods getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Periods periodId) {
        this.periodId = periodId;
    }

    public Teachers getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Teachers employeeNumber) {
        this.employeeNumber = employeeNumber;
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
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id.toString();
    }
    
}
