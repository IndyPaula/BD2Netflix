/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.grupopostgres.tests;

import com.lab.grupopostgres.entities.Anime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author leonardo
 */
public class TestJPA {

    public static void main(String[] args) {

        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("NetflixPU");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Anime a = new Anime();
        
        a.setQualidade("boa");
        
        a.setTitulo("Naruto");
        
        
        em.persist(a);
        
        
        em.getTransaction().commit();

        em.close();
        factory.close();
    }
}
