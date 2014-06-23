package de.asai2014.hogbuchung.customer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by hannes on 6/23/14.
 */
@Named
@RequestScoped
public class RegisterForm {
    private User user;
    @Inject
    private Users users;
    @Inject
    private CurrentUser currentUser;

    @PostConstruct
    private void initialize() {
        user = new User();
        user.setRole(UserRole.Customer);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void register() {
        if(users.register(user)) {
            currentUser.setUser(user);
        } else {
            FacesContext.getCurrentInstance().addMessage("registerFailure",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registrierfehler", "Nutzername bereits in Verwendung!"));
        }
    }
}
