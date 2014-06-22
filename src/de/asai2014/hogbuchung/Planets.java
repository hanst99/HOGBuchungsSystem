package de.asai2014.hogbuchung;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Named
@Singleton
public class Planets {
    private List<Planet> planets;

    @PostConstruct
    private void initialize() {
        planets = new ArrayList<>();
    }
    public List<Planet> getPlanets() {
        return planets;
    }
}
