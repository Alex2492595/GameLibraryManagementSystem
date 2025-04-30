import gamelibrary.Game;
import gamelibrary.OwnedGame;
import gamelibrary.RegularUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RegularUserTest {
    @Test
    public void testPurchaseGame() {
        RegularUser user = new RegularUser("Alex");
        Game game = new Game("Minecraft", "Sandbox", "PC", 2011);

        user.purchaseGame(game);
        List<OwnedGame> library = user.getLibrary();

        Assertions.assertEquals(1, library.size());
        Assertions.assertEquals("Minecraft", library.get(0).getGame().getTitle());
    }

    @Test
    public void testRemoveGameSuccess() {
        RegularUser user = new RegularUser("Alex");
        Game game = new Game("Minecraft", "Sandbox", "PC", 2011);

        user.purchaseGame(game);
        OwnedGame ownedGame = user.getLibrary().get(0);
        user.removeGame(ownedGame);

        Assertions.assertEquals(0, user.getLibrary().size());
    }

    @Test
    public void testRemoveGameNotInLibrary() {
        RegularUser user = new RegularUser("Alex");
        Game game = new Game("Minecraft", "Sandbox", "PC", 2011);
        OwnedGame ownedGame = new OwnedGame(game);

        user.removeGame(ownedGame);

        Assertions.assertEquals(0, user.getLibrary().size());
    }

    @Test
    public void testRateGame() {
        RegularUser user = new RegularUser("Alex");
        Game game = new Game("Minecraft", "Sandbox", "PC", 2011);
        OwnedGame ownedGame = new OwnedGame(game);

        user.rateGame(ownedGame, 8);

        //TODO: Rating not yet fully implemented (Deliverable 3)
    }
}
