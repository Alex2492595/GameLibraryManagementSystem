package gamelibrary;

public class Manager extends User {
    public Manager(String username) {
        super(username);
    }

    public void addGame(Game game) {}

    public void removeGame(Game game) {}

    public void viewAllGames() {}

    @Override
    public void displayMenu() {}
}
