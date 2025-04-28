package gamelibrary;

public class Manager extends User {
    public Manager(String username) {
        super(username);
    }

    /**
     * Adds a game to the available games to be purchased
     * @param game the game to be added
     */
    public void addGame(Game game) {}

    /**
     * Removes a game from the available games to be purchased
     * @param game the game to be removed
     */
    public void removeGame(Game game) {}

    /**
     * Displays the available games that the manager can edit
     */
    public void viewAllGames() {}

    /**
     * Displays the available options for the manager
     */
    @Override
    public void displayMenu() {}
}
