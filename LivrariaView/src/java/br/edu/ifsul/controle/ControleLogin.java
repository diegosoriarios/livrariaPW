/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 20172PF.CC0095
 */
@Named
@SessionScoped
public class ControleLogin implements Serializable {
    
    private Usuario usuarioAutenticado;
    @EJB
    private UsuarioDAO dao;
    private String usuario;
    private String senha;

    public ControleLogin() {}
    
    public String irPaginaLogin() {
        return "/login?faces-redirect=true";
    }
    
    public String efetuarLogin() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.
                    getCurrentInstance().
                    getExternalContext().
                    getRequest();
            request.login(usuario, senha);
            if(request.getUserPrincipal() != null) {
                usuarioAutenticado = dao.getObjectById(request.getUserPrincipal().getName());
                Util.mensagemInformacao("Login realizado com sucesso!");
                usuario = "";
                senha = "";
            }
            return "/index?faces-redirect=true";
        } catch(Exception e) {
            Util.mensagemErro("Erro ao realizar login: " + Util.getMensagemErro(e));
            return "/login?faces-redirect=true";
        }
    }
    
    public String efetuarLogout() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.
                    getCurrentInstance().
                    getExternalContext().
                    getRequest();
            usuarioAutenticado = null;
            request.logout();
            Util.mensagemInformacao("Logout efetuado com sucesso!");
            return "/index?faces-redirect=true";
        } catch(Exception e) {
            Util.mensagemErro("Erro ao realizar logout: " + Util.getMensagemErro(e));
            return "/index?faces-redirect=true";
        }
    }
    
    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }  
    
    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public UsuarioDAO getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
