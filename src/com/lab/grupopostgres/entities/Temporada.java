/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.grupopostgres.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author leonardo
 */
@Entity
public class Temporada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id_temporada")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seriado_id_midia", nullable = false)
    private Seriado seriado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "anime_id_midia", nullable = false)
    private Anime anime;

    @OneToMany(targetEntity = Capitulo.class,
            mappedBy = "temporada",
            fetch = FetchType.EAGER)
    private Collection<Capitulo> capitulos;

    public Long getId() {
        return id;
    }

    public Seriado getSeriado() {
        return seriado;
    }

    public void setSeriado(Seriado seriado) {
        this.seriado = seriado;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Collection<Capitulo> getCapitulos() {
        return capitulos;
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
        if (!(object instanceof Temporada)) {
            return false;
        }
        Temporada other = (Temporada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab.grupopostgres.entities.Temporada[ id=" + id + " ]";
    }

}
