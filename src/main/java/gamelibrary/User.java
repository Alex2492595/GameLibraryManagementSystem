package gamelibrary;

public abstract class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }

    /**
     * Displays the available options for either a regular user or manager
     */
    public abstract void displayMenu();
}
