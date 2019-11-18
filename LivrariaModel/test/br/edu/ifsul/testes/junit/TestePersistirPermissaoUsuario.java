package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirPermissaoUsuario {

    public TestePersistirPermissaoUsuario() {
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
    public void teste(){
        boolean exception = false;
        try {
            Usuario u = em.find(Usuario.class, "diegosoriarios");   
            
            Permissao p1 = em.find(Permissao.class,"ADMINISTRADOR");
            
            Permissao p2 = em.find(Permissao.class, "USUARIO");
            
            u.getPermissoes().add(p1);
            u.getPermissoes().add(p2);
            
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}