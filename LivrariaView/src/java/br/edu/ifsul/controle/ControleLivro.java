/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.DAO.CatalogoDAO;
import br.edu.ifsul.DAO.FormatoDAO;
import br.edu.ifsul.DAO.LivroDAO;
import br.edu.ifsul.DAO.IdiomaDAO;
import br.edu.ifsul.modelo.Livro;
import br.edu.ifsul.util.Util;
import br.edu.ifsul.util.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author 20172PF.CC0095
 */
@Named(value = "controleLivro")
@ViewScoped
public class ControleLivro implements Serializable{
    @EJB
    private LivroDAO dao;
    private Livro objeto;
    
    private boolean foiEditado = false;

    @EJB
    private IdiomaDAO daoIdioma;
    @EJB
    private FormatoDAO daoFormato;
    @EJB
    private CatalogoDAO daoCatalogo;
    
    public ControleLivro() {
        
    }
    
    public String listar() {
        return "/privado/livro/listar?faces-redirect=true";
    }
    
    public void imprimeLivros(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("Livros", 
                parametros, dao.getListaTodos());
    }
    
    public void imprimeCatalogo(){
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("Catalogo", 
                parametros, daoCatalogo.getListaTodos());
    }
    
    public void novo() {
        objeto = new Livro();
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
            if (objeto.getISBN().isEmpty()) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public LivroDAO getDao() {
        return dao;
    }

    public void setDao(LivroDAO dao) {
        this.dao = dao;
    }

    public Livro getObjeto() {
        return objeto;
    }

    public void setObjeto(Livro objeto) {
        this.objeto = objeto;
    }

    public IdiomaDAO getDaoIdioma() {
        return daoIdioma;
    }

    public void setDaoIdioma(IdiomaDAO daoIdioma) {
        this.daoIdioma = daoIdioma;
    }

    public FormatoDAO getDaoFormato() {
        return daoFormato;
    }

    public void setDaoFormato(FormatoDAO daoFormato) {
        this.daoFormato = daoFormato;
    }

    public CatalogoDAO getDaoCatalogo() {
        return daoCatalogo;
    }

    public void setDaoCatalogo(CatalogoDAO daoCatalogo) {
        this.daoCatalogo = daoCatalogo;
    }
    
    
    
}
