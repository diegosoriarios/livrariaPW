package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Idioma;
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
public class TestePersistirIdioma {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirIdioma() {
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
        Idioma i = new Idioma();
        
        i.setNome("Portugues");
        i.setSigla("PT");
        
        em.getTransaction().begin();
        em.persist(i);        
        em.getTransaction().commit();    
        System.out.println("Idioma");
    }
    
}
