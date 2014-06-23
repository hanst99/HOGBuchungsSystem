package de.asai2014.hogbuchung;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@Named
@Singleton
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
