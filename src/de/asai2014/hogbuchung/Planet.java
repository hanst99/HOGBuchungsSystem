package de.asai2014.hogbuchung;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by hannes on 6/21/14.
 */
@Entity
public class Planet {

    @Id
    private String name;

    public Planet() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Planet(String name) {
        this.name = name;
    }
}
