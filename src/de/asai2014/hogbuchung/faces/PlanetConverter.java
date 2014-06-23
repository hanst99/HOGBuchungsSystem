package de.asai2014.hogbuchung.faces;

import de.asai2014.hogbuchung.Planet;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 * Created by hannes on 6/22/14.
 */
@Named
@FacesConverter
public class PlanetConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s==null) return null;
        return new Planet(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o!=null) return o.toString();
        return null;
    }
}
