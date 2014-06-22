package de.asai2014.hogbuchung.captain;

import de.asai2014.hogbuchung.Planet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by hannes on 6/22/14.
 */

@Named
@RequestScoped
public class SelectNextPlanet {
    private Planet nextPlanet;

    public Planet getNextPlanet() {
        return nextPlanet;
    }

    public void setNextPlanet(Planet nextPlanet) {
        this.nextPlanet = nextPlanet;
    }
}
