package de.asai2014.hogbuchung.customer;

import com.sun.javafx.binding.StringFormatter;
import de.asai2014.hogbuchung.Customer;
import de.asai2014.hogbuchung.Customers;
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
public class Order {
    private Customer customer;

    @Inject
    private Customers customers;

    @PostConstruct
    private void initialize() {
        customer = new Customer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public void placeOrder() {
        FacesMessage message;
        if(customers.save(customer)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
                    "Auftrag akzeptiert!");
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler",
                            "Kabinenzahl übersteigt Kapazität, Auftrag abgelehnt!");
        }
        FacesContext.getCurrentInstance().addMessage("confirmSubmission",
                message);
    }
}
