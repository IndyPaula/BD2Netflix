/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.grupopostgres.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leonardo
 */
@Entity
public class Capitulo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar duracao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "capitulo_id_temporada", nullable = false)
    private Temporada temporada;
    
    @ManyToMany(targetEntity = Ator.class, mappedBy = "capitulos")
    private Collection<Ator> atores;
    
    public Long getId() {
        return id;
    }

    public Calendar getDuracao() {
        return duracao;
    }

    public void setDuracao(Calendar duracao) {
        this.duracao = duracao;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

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
        if (!(object instanceof Capitulo)) {
            return false;
        }
        Capitulo other = (Capitulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab.grupopostgres.entities.Capitulo[ id=" + id + " ]";
    }
    
}
