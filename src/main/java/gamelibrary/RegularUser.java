package gamelibrary;

import java.util.ArrayList;
import java.util.List;

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
        //TODO
    }

    /**
     * Purchases a specified game and adds it to the user's personal game library
     * @param game the game to be purchased
     */
    public void purchaseGame(Game game) {
        //TODO
    }

    /**
     * Removes a specified owned game from the user's library
     * @param game the game to be removed
     */
    public void removeGame(OwnedGame game) {
        //TODO
    }

    /**
     * Rates a specified owned game in the user's library
     * @param game the game to be rated
     * @param rating the rating from 1 to 10
     */
    public void rateGame(OwnedGame game, int rating) {
        //TODO
    }

    /**
     * Displays the personal library of the user
     */
    public void viewLibrary() {
        //TODO
    }

    /**
     * Displays the available options for the regular user
     */
    @Override
    public void displayMenu() {
        //TODO
    }
}
