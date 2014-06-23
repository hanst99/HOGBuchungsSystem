package de.asai2014.hogbuchung;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Named
@ApplicationScoped
public class Planets {
    private List<Planet> planets;

    @PostConstruct
    private void initialize() {
        planets = new CopyOnWriteArrayList<>();
        Collections.addAll(planets, new Planet("Mars"), new Planet("Venus"));
    }

    public List<Planet> getPlanets() {
        return planets;

    }

    public void save(Planet planet) {
        planets.add(planet);
    }
}
