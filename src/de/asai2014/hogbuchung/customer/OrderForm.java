package de.asai2014.hogbuchung.customer;

import de.asai2014.hogbuchung.Planet;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by hannes on 6/21/14.
 */
@Named
@RequestScoped
public class OrderForm {
    private Planet planet;
    private long cabins;

    @Inject
    CurrentUser currentUser;

    @Inject
    private Orders orders;


    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public long getCabins() {
        return cabins;
    }

    public void setCabins(long cabins) {
        this.cabins = cabins;
    }

    public void placeOrder() {
        FacesMessage message;
        if(orders.save(new Order(currentUser.getUser(),planet,cabins))) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
                    "Auftrag akzeptiert!");
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler",
                            "Kabinenzahl übersteigt Kapazität oder maximale Kundenzahl erreicht, Auftrag abgelehnt!");
        }
        FacesContext.getCurrentInstance().addMessage("confirmSubmission",
                message);
    }
}
