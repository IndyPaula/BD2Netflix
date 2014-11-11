/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.grupopostgres.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author leonardo
 */
@Entity
public class Diretor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue()
    @Column(name = "id_diretor")
    private Long id;

    private String nome;

    @ManyToMany(targetEntity = Midia.class)
    private Collection<Midia> midias;
    
    public Diretor() {
    }

    public Diretor(String name) {
        this.nome = name;
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public Collection<Midia> getMidias() {
        return midias;
    }

    public void setMidias(Midia midia) {
        this.midias.add(midia);
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
        if (!(object instanceof Diretor)) {
            return false;
        }
        Diretor other = (Diretor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab.grupopostgres.entities.Diretor[ id=" + id + " ]";
    }
    
}
