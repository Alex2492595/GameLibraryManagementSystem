package gamelibrary;

import java.util.Objects;

public abstract class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }

    /**
     * Displays the available options for either a regular user or manager
     */
    public abstract void displayMenu();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
