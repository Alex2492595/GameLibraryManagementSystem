import gamelibrary.Game;
import gamelibrary.GameDataController;
import gamelibrary.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    public void testSortGamesByGenre() {
        Manager manager = new Manager("Alex");

        Game game1 = new Game("GTA 6", "Action-Adventure", "PlayStation", 2026);
        Game game2 = new Game("Risk Of Rain 2", "Roguelike", "PC", 2020);

        List<Game> games = new ArrayList<>();
        games.add(game2);
        games.add(game1);
        GameDataController.saveAvailableGames(games);

        manager.sortGamesByGenre();
        List<Game> sortedGames = GameDataController.loadAvailableGames();

        Assertions.assertEquals("GTA 6", sortedGames.get(0).getTitle());
        Assertions.assertEquals("Risk Of Rain 2", sortedGames.get(1).getTitle());
    }

    @Test
    public void testSortGamesByPlatform() {
        Manager manager = new Manager("Alex");

        Game game1 = new Game("GTA 6", "Action-Adventure", "PlayStation", 2026);
        Game game2 = new Game("Risk Of Rain 2", "Roguelike", "PC", 2020);

        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);
        GameDataController.saveAvailableGames(games);

        manager.sortGamesByPlatform();
        List<Game> sortedGames = GameDataController.loadAvailableGames();

        Assertions.assertEquals("Risk Of Rain 2", sortedGames.get(0).getTitle());
        Assertions.assertEquals("GTA 6", sortedGames.get(1).getTitle());
    }
}
