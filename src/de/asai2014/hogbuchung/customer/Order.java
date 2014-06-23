package de.asai2014.hogbuchung.customer;


import de.asai2014.hogbuchung.Planet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by hannes on 6/22/14.
 */
public class Order {

    private User user;

    private Planet goalPlanet;

    private long cabins;

    public Order() {
    }

    public Order(User user, Planet goalPlanet, long cabins) {
        this.user = user;
        this.goalPlanet = goalPlanet;
        this.cabins = cabins;
    }

    public User getUser() {
        return user;
    }

    public Planet getGoalPlanet() {
        return goalPlanet;
    }

    public long getCabins() {
        return cabins;
    }

    public void setUser(User name) {
        this.user = name;
    }

    public void setGoalPlanet(Planet goalPlanet) {
        this.goalPlanet = goalPlanet;
    }

    public void setCabins(long cabins) {
        this.cabins = cabins;
    }
}
