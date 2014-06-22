package de.asai2014.hogbuchung;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Named
@Singleton
public class Planets {
    private Set<Planet> planets;

    @PostConstruct
    private void initialize() {
        planets = new CopyOnWriteArraySet<>();
        Collections.addAll(planets, new Planet("Mars"), new Planet("Venus"));
    }
    public Set<Planet> getPlanets() {
        return planets;
    }

    public void save(Planet planet) {
        planets.add(planet);
    }
}
