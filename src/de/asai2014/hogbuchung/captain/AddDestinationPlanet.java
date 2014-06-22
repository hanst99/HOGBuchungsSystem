package de.asai2014.hogbuchung.captain;

import de.asai2014.hogbuchung.Planet;
import de.asai2014.hogbuchung.Planets;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by hannes on 6/22/14.
 */
@Named
@RequestScoped
public class AddDestinationPlanet {
    @Inject
    Planets planets;
    private Planet newDestination;
    @PostConstruct
    private void initialize() {
        newDestination = new Planet();
    }
    public Planet getNewDestination() {
        return newDestination;
    }

    public void setNewDestination(Planet newDestination) {
        this.newDestination = newDestination;
    }

    public void add() {
        planets.save(newDestination);
    }
}
