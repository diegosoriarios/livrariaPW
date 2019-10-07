/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.DAO.FormatoDAO;
import br.edu.ifsul.DAO.IdiomaDAO;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author 20172PF.CC0095
 */
@Named(value = "controleFormato")
@ViewScoped
public class ControleFormato implements Serializable{
    @EJB
    private FormatoDAO dao;
    private Formato objeto;

    @EJB
    private IdiomaDAO daoEstado;
    
    public ControleFormato() {
        
    }
    
    public String listar() {
        return "/privado/formato/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Formato();
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
    
    public FormatoDAO getDao() {
        return dao;
    }

    public void setDao(FormatoDAO dao) {
        this.dao = dao;
    }

    public Formato getObjeto() {
        return objeto;
    }

    public void setObjeto(Formato objeto) {
        this.objeto = objeto;
    }

    public IdiomaDAO getDaoEstado() {
        return daoEstado;
    }

    public void setDaoEstado(IdiomaDAO daoEstado) {
        this.daoEstado = daoEstado;
    }
    
    
}
