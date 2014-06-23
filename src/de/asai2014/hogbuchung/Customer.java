package de.asai2014.hogbuchung;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by hannes on 6/22/14.
 */
@Entity
public class Customer {
    @GeneratedValue
    @Id
    private long id;

    private String name;

    @ManyToOne
    private Planet goalPlanet;

    private long cabins;

    public String getName() {
        return name;
    }

    public Planet getGoalPlanet() {
        return goalPlanet;
    }

    public long getCabins() {
        return cabins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoalPlanet(Planet goalPlanet) {
        this.goalPlanet = goalPlanet;
    }

    public void setCabins(long cabins) {
        this.cabins = cabins;
    }
}
