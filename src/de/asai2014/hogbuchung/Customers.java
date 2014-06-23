package de.asai2014.hogbuchung;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by hannes on 6/22/14.
 */
@Named
@Singleton
public class Customers {


    private final long maxCabins = 42;
    private List<Customer> customers;
    private long usedCabins;

    @PostConstruct
    private void initialize() {
        this.customers = new CopyOnWriteArrayList<>();
        usedCabins = 0;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public synchronized boolean save(Customer customer) {
        long totalCabins = customer.getCabins() + usedCabins;
        if(totalCabins <= maxCabins) {
            usedCabins = totalCabins;
            customers.add(customer);
            return true;
        }
        return false;
    }

    public long getMaxCabins() {
        return maxCabins;
    }

    public long getUsedCabins() {
        return usedCabins;
    }

    public synchronized void dropOffAt(Planet destination) {
        List<Customer> remainingCustomers = new CopyOnWriteArrayList<>();
        long newUsedCabins = usedCabins;
        for (Customer customer : customers) {
            if (customer.getGoalPlanet().equals(destination)) {
                newUsedCabins -= customer.getCabins();
            } else {
                remainingCustomers.add(customer);
            }
        }
        usedCabins=newUsedCabins;
        customers=remainingCustomers;
    }
}
