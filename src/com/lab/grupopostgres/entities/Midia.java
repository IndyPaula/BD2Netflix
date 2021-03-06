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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author leonardo
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Midia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id_midia")
    private Long id;

    @ManyToMany
    @JoinTable(name = "midia_perfis",
            joinColumns = {
                @JoinColumn(name = "id_midia")},
            inverseJoinColumns = {
                @JoinColumn(name = "username")})
    private Collection<Perfil> perfis;

    @ManyToMany
    @JoinTable(name = "midia_diretores",
            joinColumns = {
                @JoinColumn(name = "id_midia")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_diretor")})
    private Collection<Diretor> diretores;

    @ManyToMany
    @JoinTable(name = "midia_generos",
            joinColumns = {
                @JoinColumn(name = "id_midia")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_genero")})
    private Collection<Genero> generos;

    private String titulo;

    private String classificacao;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Collection<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Perfil perfil) {
        this.perfis.add(perfil);
    }

    public Collection<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(Diretor diretor) {
        this.diretores.add(diretor);
    }

    public Collection<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(Genero genero) {
        this.generos.add(genero);
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
        if (!(object instanceof Midia)) {
            return false;
        }
        Midia other = (Midia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lab.grupopostgres.entities.Midia[ id=" + id + " ]";
    }

}
