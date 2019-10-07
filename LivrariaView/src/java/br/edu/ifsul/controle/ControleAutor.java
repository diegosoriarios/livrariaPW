/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.DAO.AutorDAO;
import br.edu.ifsul.DAO.IdiomaDAO;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author 20172PF.CC0095
 */
@Named(value = "controleAutor")
@ViewScoped
public class ControleAutor implements Serializable{
    @EJB
    private AutorDAO dao;
    private Autor objeto;

    @EJB
    private IdiomaDAO daoEstado;
    
    public ControleAutor() {
        
    }
    
    public String listar() {
        return "/privado/autor/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Autor();
    }
    
    public void alterar(Object id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));       
        }
    }
    
    public void remover(Object id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));       
        }
    }
    
    public void salvar() {
        try {
            if (objeto.getId()== null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public AutorDAO getDao() {
        return dao;
    }

    public void setDao(AutorDAO dao) {
        this.dao = dao;
    }

    public Autor getObjeto() {
        return objeto;
    }

    public void setObjeto(Autor objeto) {
        this.objeto = objeto;
    }

    public IdiomaDAO getDaoEstado() {
        return daoEstado;
    }

    public void setDaoEstado(IdiomaDAO daoEstado) {
        this.daoEstado = daoEstado;
    }
    
    
}
