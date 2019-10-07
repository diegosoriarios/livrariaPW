    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Catalogo;
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
@Named(value = "converteCatalogo")
@RequestScoped
public class ConverteCatalogo implements Serializable, Converter {

    @PersistenceContext(unitName = "Livraria-PW-WebPU")
    private EntityManager em;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        }
        System.out.println("string do converter: " + string);
        return em.find(Catalogo.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null) {
            return null;
        }
        
        Catalogo obj = (Catalogo) t;
        
        return obj.getId().toString();
    }
    
}
