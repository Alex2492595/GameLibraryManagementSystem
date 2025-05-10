import gamelibrary.Game;
import gamelibrary.GameDataController;
import gamelibrary.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ManagerTest {
    @Test
    public void testAddGame() {
        Game game = new Game("Minecraft", "Sandbox", "PC", 2011);
        Manager manager = new Manager("Alex");

        manager.addGame(game);
        List<Game> games = GameDataController.loadAvailableGames();

        Assertions.assertTrue(games.contains(game));
    }

    @Test
    public void testRemoveGame() {
        Game game = new Game("Minecraft", "Sandbox", "PC", 2011);
        Manager manager = new Manager("Alex");

        manager.removeGame(game);
        List<Game> games = GameDataController.loadAvailableGames();

        Assertions.assertFalse(games.contains(game));
    }
}
