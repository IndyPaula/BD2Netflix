/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.grupopostgres.tests;

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
        
        em.close();
        factory.close();
    }
}
