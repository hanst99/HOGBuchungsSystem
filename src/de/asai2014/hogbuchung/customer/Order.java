package de.asai2014.hogbuchung.customer;

import com.sun.javafx.binding.StringFormatter;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Created by hannes on 6/21/14.
 */
@Named
@RequestScoped
public class Order {
    private String customerName;
    private String goalPlanet;

    public String getGoalPlanet() {
        return goalPlanet;
    }

    public void setGoalPlanet(String goalPlanet) {
        this.goalPlanet = goalPlanet;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void placeOrder() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", String.format("%s ++ %s", customerName, goalPlanet)));
    }
}
