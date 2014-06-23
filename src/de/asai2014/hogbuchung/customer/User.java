package de.asai2014.hogbuchung.customer;

/**
 * Created by hannes on 6/23/14.
 */
public class User {
    private String userName;
    private String password;
    private UserRole role;
    private boolean placedOrder = false;

    public User() {
    }

    public User(String userName, String password, UserRole role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!password.equals(user.password)) return false;
        if (role != user.role) return false;
        if (!userName.equals(user.userName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    public boolean isPlacedOrder() {
        return placedOrder;
    }

    public void setPlacedOrder(boolean placedOrder) {
        this.placedOrder = placedOrder;
    }
}
