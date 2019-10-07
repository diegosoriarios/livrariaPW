/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.DAO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 20172PF.CC0095
 */
public class DAOGenerico<TIPO> implements Serializable {
    
    private List<TIPO> listaObjetos; //retorna uma consulta paginada
    private List<TIPO> listaTodos; //retorna todos os registros
    @PersistenceContext(unitName = "Livraria-PW-WebPU")
    protected EntityManager em;
    protected Class classePersistente;

    public List<TIPO> getListaObjetos() {
        String jpql = "from " + classePersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }

    public void setListaObjetos(List<TIPO> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public List<TIPO> getListaTodos() {
        String jpql = "from " + classePersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }
    
    public void persist(TIPO obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(TIPO obj) throws Exception {
        em.merge(obj);
    }
    
    public void remove(TIPO obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public TIPO getObjectById(Object id) {
        return (TIPO) em.find(classePersistente, id);
    }

    public void setListaTodos(List<TIPO> listaTodos) {
        this.listaTodos = listaTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class getClassePersistente() {
        return classePersistente;
    }

    public void setClassePersistente(Class classePersistente) {
        this.classePersistente = classePersistente;
    }
    
    
}
