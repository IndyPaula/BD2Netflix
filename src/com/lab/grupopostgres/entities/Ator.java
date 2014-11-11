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
public class Ator implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue()
    @Column(name = "id_ator")
    private Long id;
    
    private String nome;
    
    @ManyToMany(targetEntity = Filme.class)
    private Collection<Filme> filmes;
    
    @ManyToMany(targetEntity = Capitulo.class)
    private Collection<Capitulo> capitulos;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(Filme filme) {
        this.filmes.add(filme);
    }

    public Collection<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Collection<Capitulo> capitulos) {
        this.capitulos = capitulos;
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
        if (!(object instanceof Ator)) {
            return false;
        }
        Ator other = (Ator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab.grupopostgres.entities.Ator[ id=" + id + " ]";
    }
    
}
