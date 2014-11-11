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
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author leonardo
 */
@PrimaryKeyJoinColumn(name = "id_midia")
@Entity
public class Anime extends Midia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_midia",
            nullable = false,
            insertable = false,
            updatable = false)
    private Long id;

    @OneToMany(targetEntity = Temporada.class,
            mappedBy = "anime",
            fetch = FetchType.EAGER)
    private Collection<Temporada> Temporadas;

    public Collection<Temporada> getTemporadas() {
        return Temporadas;
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
        if (!(object instanceof Anime)) {
            return false;
        }
        Anime other = (Anime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab.grupopostgres.entities.Anime[ id=" + id + " ]";
    }

}
