package br.edu.ifsul.DAO;

import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Diego Soria Rios
 * @email diegosoriarios@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
@Stateful
public class UsuarioDAO extends br.edu.ifsul.DAO.DAOGenerico<Usuario> implements Serializable {
    
    public UsuarioDAO(){
        super();
        classePersistente = Usuario.class;
        /*
        // adicionar as ordenações possiveis
        listaOrdem.add(new Ordem("nomeUsuario", "Nome Usuário", "like"));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));        
        // definir a ordem padrão
        ordemAtual = listaOrdem.get(1);
        // inicalizar o conversor com a lista de ordens
        converterOrdem = new ConverterOrdem(listaOrdem);               
        */
    }
    
    @Override
    public Usuario getObjectById(Object id){
        Usuario obj = em.find(Usuario.class, id);
        // Deve-se inicializar as coleções para não dar o erro 
        // lazyinicializationException
        obj.getPermissoes().size();
        return obj;
    }    

}
