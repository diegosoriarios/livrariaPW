/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 20172PF.CC0095
 */
public class TestePersistirCatalogo {
    
    public TestePersistirCatalogo() {
    }
    
    EntityManagerFactory emf = null;
    EntityManager em = null;
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("Livraria-PW-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste() {
        boolean exception = false;
        try {
            Catalogo c = new Catalogo();
            
            c.setNome("Nome");
            c.setDescricao("Descrição");
            c.setLivraria(em.find(Livraria.class, 1));
            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            
            System.out.println("Catalogo");
        } catch(Exception e) {
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}
