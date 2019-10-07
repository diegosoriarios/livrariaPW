/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Idioma;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 20172PF.CC0095
 *//**
 *
 * @author 20172PF.CC0095
 */
@Named(value = "converteIdioma")
@RequestScoped
public class ConverteIdioma implements Serializable, Converter {

    @PersistenceContext(unitName = "PW-2019-2-WebPU")
    private EntityManager em;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        }
        
        return em.find(Idioma.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null) {
            return null;
        }
        
        Idioma obj = (Idioma) t;
        
        return obj.getId().toString();
    }
    
}
