package gamelibrary;

public class Manager extends User {
    public Manager(String username) {
        super(username);
    }

    /**
     * Adds a game to the available games to be purchased
     * @param game the game to be added
     */
    public void addGame(Game game) {
        //TODO: Uses the GameDataController to load/save available games (Deliverable 3)
        /*
        List<Game> games = GameDataController.loadAvailableGames();

        games.add(game);
        GameDataController.saveAvailableGames(games);

        System.out.println(game.getTitle() + " added to catalog.");
         */
    }

    /**
     * Removes a game from the available games to be purchased
     * @param game the game to be removed
     */
    public void removeGame(Game game) {
        //TODO: Uses the GameDataController to load/save available games (Deliverable 3)
        /*
        List<Game> games = GameDataController.loadAvailableGames();

        if (games.remove(game)) {
            GameDataController.saveAvailableGames(games);
            System.out.println(game.getTitle() + " removed from catalog.");
        } else {
            System.out.println("Game not found.");
        }
         */
    }

    /**
     * Displays the available games that the manager can edit
     */
    public void viewAllGames() {
        //TODO: Loads available games from GameDataController (Deliverable 3)
        /*
        List<Game> games = GameDataController.loadAvailableGames();

        if (games.isEmpty()) {
            System.out.println("No available games found.");
        } else {
            for (Game game : games) {
                System.out.println(game.getDetails());
            }
        }
         */
    }

    /**
     * Displays the available options for the manager
     */
    @Override
    public void displayMenu() {
        System.out.println("Welcome, Manager " + getUsername() + "!");
        System.out.println("1. View All Games");
        System.out.println("2. Add New Game");
        System.out.println("3. Remove Game");
        System.out.println("4. Exit");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "username='" + username + '\'' +
                '}';
    }
}
