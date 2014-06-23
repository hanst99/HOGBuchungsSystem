package de.asai2014.hogbuchung.customer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by hannes on 6/23/14.
 */
@ApplicationScoped
public class Users {
    private Set<User> users;

    @PostConstruct
    private void initialize() {
        users = new CopyOnWriteArraySet<>();
        users.add(new User("ZaphodBeeblebrox", "42", UserRole.Admin));
    }

    public synchronized boolean exists(User user) {
        return users.contains(user);
    }

    public synchronized boolean register(User user) {
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                return false;
            }
        }
        users.add(user);
        return true;

    }

    public User find(String username, String password) {
        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
