package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Livro;
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
public class TesteListarLivros {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {       
        EntityManagerFactory emf = 
                emf = Persistence.createEntityManagerFactory("Livraria-PW-ModelPU");
        EntityManager em = emf.createEntityManager();
        List<Livro> lista = 
                em.createQuery("from Livro order by nome").getResultList();
        for (Livro e : lista){
            System.out.println("ID: " + e.getISBN()+ " Nome: " + e.getTitulo()+ 
                    " Resumo: " + e.getResumo());
        }
        
        em.close();
        emf.close();
    }

}
