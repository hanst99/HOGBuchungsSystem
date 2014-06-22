package de.asai2014.hogbuchung;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * Created by hannes on 6/21/14.
 */
@Named
@RequestScoped
public class Order {
    private String customerName;
    private long goalPlanet;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getGoalPlanet() {
        return goalPlanet;
    }

    public void setGoalPlanet(long goalPlanet) {
        this.goalPlanet = goalPlanet;
    }

    public void placeOrder() {
    }
}
