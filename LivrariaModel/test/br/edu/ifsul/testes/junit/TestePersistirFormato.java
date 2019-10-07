package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Formato;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Diego
 */
public class TestePersistirFormato {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirFormato() {
    }
    
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
    public void teste(){
        Formato f = new Formato();
        
        f.setNome("Formato");
        
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit(); 
        
        System.out.println("Formato");
    }
    
}
