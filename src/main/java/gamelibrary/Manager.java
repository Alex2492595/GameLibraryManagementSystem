package gamelibrary;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Manager extends User {
    public Manager(String username) {
        super(username);
    }

    /**
     * Adds a game to the available games to be purchased
     * @param game the game to be added
     */
    public void addGame(Game game) {
        List<Game> games = GameDataController.loadAvailableGames();

        if (!games.contains(game)) {
            games.add(game);
            GameDataController.saveAvailableGames(games);

            System.out.println(game.getTitle() + " added to catalog.");
        } else {
            System.out.println("Game already exists.");
        }
    }

    /**
     * Removes a game from the available games to be purchased
     * @param game the game to be removed
     */
    public void removeGame(Game game) {
        List<Game> games = GameDataController.loadAvailableGames();

        if (games.remove(game)) {
            GameDataController.saveAvailableGames(games);
            System.out.println(game.getTitle() + " removed from catalog.");
        } else {
            System.out.println("Game not found.");
        }
    }

    /**
     * Displays the available games that the manager can edit
     */
    public void viewAllGames() {
        List<Game> games = GameDataController.loadAvailableGames();

        if (games.isEmpty()) {
            System.out.println("No available games found.");
        } else {
            for (Game game : games) {
                System.out.println(game.getDetails());
            }
        }
    }

    /**
     * Sorts games by genre
     */
    public void sortGamesByGenre() {
        List<Game> games = GameDataController.loadAvailableGames();

        if (games.isEmpty()) {
            System.out.println("No available games to sort.");
            return;
        }

        Collections.sort(games, new GameGenreComparator());
        GameDataController.saveAvailableGames(games);

        System.out.println("Games sorted by genre:");

        for (Game game : games) {
            System.out.println(game.getDetails());
        }
    }

    /**
     * Sorts games by platform
     */
    public void sortGamesByPlatform() {
        List<Game> games = GameDataController.loadAvailableGames();

        if (games.isEmpty()) {
            System.out.println("No available games to sort.");
            return;
        }

        Collections.sort(games, new GamePlatformComparator());
        GameDataController.saveAvailableGames(games);

        System.out.println("Games sorted by platform:");
        for (Game game : games) {
            System.out.println(game.getDetails());
        }
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
        System.out.println("4. Sort Games By Genre");
        System.out.println("5. Sort Games By Platform");
        System.out.println("6. Exit");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "username='" + username + '\'' +
                '}';
    }

    //Comparator class to compare games by genre
    private static class GameGenreComparator implements Comparator<Game> {
        @Override
        public int compare(Game g1, Game g2) {
            return g1.getGenre().compareTo(g2.getGenre());
        }
    }

    //Comparator class to compare games by platform
    private static class GamePlatformComparator implements Comparator<Game> {
        @Override
        public int compare(Game g1, Game g2) {
            return g1.getPlatform().compareTo(g2.getPlatform());
        }
    }
}
