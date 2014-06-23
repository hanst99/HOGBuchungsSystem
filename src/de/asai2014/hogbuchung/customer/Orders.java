package de.asai2014.hogbuchung.customer;

import de.asai2014.hogbuchung.Planet;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by hannes on 6/22/14.
 */
@Named
@ApplicationScoped
public class Orders {


    private final long maxCabins = 42;
    private final long maxCustomers = 5;
    private List<Order> orders;
    private long usedCabins;

    @PostConstruct
    private void initialize() {
        this.orders = new CopyOnWriteArrayList<>();
        usedCabins = 0;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public synchronized boolean save(Order order) {
        long totalCabins = order.getCabins() + usedCabins;
        if (totalCabins <= maxCabins && orders.size() < maxCustomers) {
            for (Order o : orders) {
                if (o.getUser().equals(order.getUser())) {
                    return false;
                }
            }
            usedCabins = totalCabins;
            orders.add(order);
            order.getUser().setPlacedOrder(true);
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
        List<Order> remainingOrders = new CopyOnWriteArrayList<>();
        long newUsedCabins = usedCabins;
        for (Order order : orders) {
            if (order.getGoalPlanet().equals(destination)) {
                newUsedCabins -= order.getCabins();
                order.getUser().setPlacedOrder(false);
            } else {
                remainingOrders.add(order);
            }
        }
        usedCabins = newUsedCabins;
        orders = remainingOrders;
    }
}
