package br.edu.ifsul.testes.junit;

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
public class TestePersistirUsuario {

    public TestePersistirUsuario() {
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
            Usuario obj = new Usuario();
            obj.setEmail("diegosoriarios@gmail.com");
            obj.setNome("Diego Soria Rios");
            obj.setNomeUsuario("diegosoriarios");
            obj.setSenha("123456");
            obj.setTelefoneAlternativo("(54)89387-9876");
            obj.setTelefonePrincipal("(54)98773-0987");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}