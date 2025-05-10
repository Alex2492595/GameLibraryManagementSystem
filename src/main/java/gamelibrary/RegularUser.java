package gamelibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RegularUser extends User {
    private List<OwnedGame> library;

    public RegularUser(String username) {
        super(username);
        this.library = new ArrayList<>();
    }

    /**
     * Displays the available games that the user can purchase
     */
    public void browseGames() {
        List<Game> games = GameDataController.loadAvailableGames();

        if (games.isEmpty()) {
            System.out.println("No games available.");
            return;
        }

        for (Game game : games) {
            System.out.println(game.getDetails());
        }
    }

    /**
     * Purchases a specified game and adds it to the user's personal game library
     * @param game the game to be purchased
     */
    public void purchaseGame(Game game) {
        for (OwnedGame g : library) {
            if (g.getGame().equals(game)) {
                System.out.println("Game already owned.");
                return;
            }
        }

        OwnedGame ownedGame = new OwnedGame(game);
        library.add(ownedGame);

        System.out.println(game.getTitle() + " purchased and added to library.");

        Map<String, List<OwnedGame>> userLibraries = GameDataController.loadUserLibraries();
        userLibraries.putIfAbsent(username, new ArrayList<>());
        userLibraries.get(username).add(ownedGame);

        GameDataController.saveUserLibraries(userLibraries);
    }

    /**
     * Removes a specified owned game from the user's library
     * @param game the game to be removed
     */
    public void removeGame(OwnedGame game) {
        if (library.remove(game)) {
            System.out.println(game.getGame().getTitle() + " removed from library.");
        } else {
            System.out.println("Game not found in library.");
        }

        Map<String, List<OwnedGame>> userLibraries = GameDataController.loadUserLibraries();
        List<OwnedGame> games = userLibraries.get(username);

        if (games != null) {
            games.remove(game);
            GameDataController.saveUserLibraries(userLibraries);
        }
    }

    /**
     * Rates a specified owned game in the user's library
     * @param game the game to be rated
     * @param rating the rating from 1 to 10
     */
    public void rateGame(OwnedGame game, int rating) {
        if (!library.contains(game)) {
            System.out.println("Game not found in library.");
            return;
        }

        if (rating < 1 || rating > 10) {
            System.out.println("Invalid rating. Enter a number from 1 to 10.");
            return;
        }

        game.setRating(rating);
        game.getGame().addRating(rating);
        System.out.println(game.getGame().getTitle() + " rated successfully.");

        Map<String, List<OwnedGame>> userLibraries = GameDataController.loadUserLibraries();
        List<OwnedGame> games = userLibraries.get(username);

        if (games != null) {
            for (OwnedGame g : games) {
                if (g.getGame().equals(game.getGame())) {
                    g.setRating(rating);
                }
            }

            GameDataController.saveUserLibraries(userLibraries);
        }
    }

    /**
     * Displays the personal library of the user
     */
    public void viewLibrary() {
        if (library.isEmpty()) {
            System.out.println("No games found in library.");
        } else {
            System.out.println("Game Library:\n");

            for (OwnedGame game: library) {
                System.out.println("- " + game.getGame().getDetails());
            }
        }
    }

    /**
     * Displays the available options for the regular user
     */
    @Override
    public void displayMenu() {
        System.out.println("Welcome, User " + getUsername() + "!");
        System.out.println("1. Browse Games");
        System.out.println("2. View Library");
        System.out.println("3. Purchase Game");
        System.out.println("4. Remove Game");
        System.out.println("5. Rate Game");
        System.out.println("6. Exit");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RegularUser that = (RegularUser) o;
        return Objects.equals(library, that.library);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(library);
    }

    @Override
    public String toString() {
        return "RegularUser{" +
                "library=" + library +
                super.toString() +
                '}';
    }

    public List<OwnedGame> getLibrary() {
        return library;
    }

    public void setLibrary(List<OwnedGame> library) {
        this.library = library;
    }
}
