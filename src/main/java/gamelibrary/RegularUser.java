package gamelibrary;

import java.util.ArrayList;
import java.util.List;

public class RegularUser extends User {
    private List<OwnedGame> library;

    public RegularUser(String username) {
        super(username);
        this.library = new ArrayList<>();
    }

    public void browseGames() {}

    public void purchaseGame(Game game) {}

    public void removeGame(OwnedGame game) {}

    public void rateGame(OwnedGame game, int rating) {}

    public void viewLibrary() {}

    @Override
    public void displayMenu() {}
}
