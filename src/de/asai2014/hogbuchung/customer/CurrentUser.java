package de.asai2014.hogbuchung.customer;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by hannes on 6/23/14.
 */
@Named
@SessionScoped
public class CurrentUser implements Serializable {
    private User user;

    @Inject
    HttpSession session;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void logout() {
        setUser(null);
        session.invalidate();
    }
}
