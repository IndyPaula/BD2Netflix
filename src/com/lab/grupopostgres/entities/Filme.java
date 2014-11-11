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
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author leonardo
 */
@PrimaryKeyJoinColumn(name = "id_midia")
@Entity
public class Filme extends Midia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "id_midia", 
            nullable = false, 
            insertable = false, 
            updatable = false)
    private Long id;
    
    @ManyToMany(targetEntity = Ator.class, mappedBy = "filmes")
    private Collection<Ator> atores;

    public Collection<Ator> getAtores() {
        return atores;
    }

    public void setAtores(Ator ator) {
        this.atores.add(ator);
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
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab.grupopostgres.entities.Filme[ id=" + id + " ]";
    }
    
}
