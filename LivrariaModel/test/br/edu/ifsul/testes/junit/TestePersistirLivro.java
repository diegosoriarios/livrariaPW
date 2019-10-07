package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livro;
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
public class TestePersistirLivro {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirLivro() {
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
        
        Livro l = new Livro();
        
        l.setAtivo(Boolean.TRUE);
        l.setCadastro(Calendar.getInstance());
        l.setCatalogo(em.find(Catalogo.class, 1));
        l.setCodigoBarras("23357367357");
        l.setDataPublicacao(Calendar.getInstance());
        l.setEditora("Editora");
        l.setFormato(em.find(Formato.class, 1));
        l.setISBN("1322624762462");
        l.setIdioma(em.find(Idioma.class, 1));
        l.setNumeroPaginas(114);
        l.setResumo("Resumo");
        l.setTitulo("1984");
        l.setValor(39.99);
        
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();       
        
        System.out.println("Livro");
    }
    
}
