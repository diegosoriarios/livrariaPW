package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirLivros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Livraria-PW-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Livro l = new Livro();
        
        l.setAtivo(Boolean.TRUE);
        l.setCadastro(Calendar.getInstance());
        
        Livraria liv = new Livraria();
        liv.setNome("Livraria");
        liv.setSite("www.com");
        em.persist(liv);
        
        Catalogo c = new Catalogo();
        c.setNome("Catalogo");
        c.setDescricao("Descrição");
        c.setLivraria(liv);
        em.persist(c);
        
        l.setCatalogo(c);
        l.setCodigoBarras("23357367357");
        l.setDataPublicacao(Calendar.getInstance());
        l.setEditora("Editora");
        
        Formato f = new Formato();
        f.setNome("Formato");
        em.persist(f);
        
        l.setFormato(f);
        l.setISBN("1322624762462");
        
        Idioma i = new Idioma();
        i.setNome("Portugues");
        i.setSigla("PT");
        em.persist(i);
        
        l.setIdioma(i);
        l.setNumeroPaginas(114);
        l.setResumo("Resumo");
        l.setTitulo("1984");
        l.setValor(39.99);       
        
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
