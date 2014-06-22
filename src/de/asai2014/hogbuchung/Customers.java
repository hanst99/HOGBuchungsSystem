package de.asai2014.hogbuchung;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Named;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by hannes on 6/22/14.
 */
@Named
@Singleton
public class Customers {
    private Set<Customer> customerList;

    @PostConstruct
    private void initialize() {
        this.customerList = new CopyOnWriteArraySet<>();
    }

    public Set<Customer> getCustomerList() {
        return customerList;
    }
}
