/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CaadiTables.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author frodo
 */
@Entity
@Table(name = "Students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")
    , @NamedQuery(name = "Students.findByNua", query = "SELECT s FROM Students s WHERE s.nua = :nua")
    , @NamedQuery(name = "Students.findByFirstLastName", query = "SELECT s FROM Students s WHERE s.firstLastName = :firstLastName")
    , @NamedQuery(name = "Students.findBySecondLastName", query = "SELECT s FROM Students s WHERE s.secondLastName = :secondLastName")
    , @NamedQuery(name = "Students.findByName", query = "SELECT s FROM Students s WHERE s.name = :name")
    , @NamedQuery(name = "Students.findByGender", query = "SELECT s FROM Students s WHERE s.gender = :gender")
    , @NamedQuery(name = "Students.findByBirthday", query = "SELECT s FROM Students s WHERE s.birthday = :birthday")
    , @NamedQuery(name = "Students.findByProgram", query = "SELECT s FROM Students s WHERE s.program = :program")
    , @NamedQuery(name = "Students.findByEmail", query = "SELECT s FROM Students s WHERE s.email = :email")})
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nua")
    private String nua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "firstLastName")
    private String firstLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "secondLastName")
    private String secondLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Size(max = 500)
    @Column(name = "program")
    private String program;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 500)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nua")
    private Collection<Visit> visitCollection;

    public Students() {
    }

    public Students(String nua) {
        this.nua = nua;
    }

    public Students(String nua, String firstLastName, String secondLastName, String name, String gender) {
        this.nua = nua;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.name = name;
        this.gender = gender;
    }

    public String getNua() {
        return nua;
    }

    public void setNua(String nua) {
        this.nua = nua;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Visit> getVisitCollection() {
        return visitCollection;
    }

    public void setVisitCollection(Collection<Visit> visitCollection) {
        this.visitCollection = visitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nua != null ? nua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.nua == null && other.nua != null) || (this.nua != null && !this.nua.equals(other.nua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CaadiTables.Entities.Students[ nua=" + nua + " ]";
    }
    
}
