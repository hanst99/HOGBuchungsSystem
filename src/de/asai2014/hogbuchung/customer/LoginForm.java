package de.asai2014.hogbuchung.customer;

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
public class LoginForm {

    @Inject
    Users users;

    @Inject
    CurrentUser currentUser;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        User theUser;
        if ((theUser = users.find(username, password)) != null) {
            currentUser.setUser(theUser);
        } else {
            FacesContext.getCurrentInstance().addMessage("loginFailure",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Loginfehler",
                            "Diese Kombination von Nutzername und Passwort existiert nicht!"));
        }
    }
}
