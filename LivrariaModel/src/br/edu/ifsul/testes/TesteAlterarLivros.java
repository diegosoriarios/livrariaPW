package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
public class TesteAlterarLivros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        EntityManagerFactory emf = 
            emf = Persistence.createEntityManagerFactory("Livraria-PW-ModelPU");
        EntityManager em = emf.createEntityManager();
        Livro e = em.find(Livro.class, 1);
        e.setTitulo("A revolução dos Bichos");
        e.setIdioma(em.find(Idioma.class, 1));
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
