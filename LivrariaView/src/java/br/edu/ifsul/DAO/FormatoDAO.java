/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.DAO;

import br.edu.ifsul.modelo.Formato;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author 20172PF.CC0095
 */
@Stateful
public class FormatoDAO extends DAOGenerico<Formato> implements Serializable{
    public FormatoDAO() {
        super();
        classePersistente = Formato.class;
    }
}
