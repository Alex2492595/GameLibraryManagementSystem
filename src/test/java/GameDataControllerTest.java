import gamelibrary.Game;
import gamelibrary.GameDataController;
import gamelibrary.OwnedGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameDataControllerTest {
    @Test
    public void testLoadAvailableGames() {
        List<Game> games = GameDataController.loadAvailableGames();

        Assertions.assertFalse(games.isEmpty());
    }

    @Test
    public void testSaveAvailableGames() {
        List<Game> games = new ArrayList<>();
        games.add(new Game("GTA 6", "Action-Adventure", "PlayStation", 2026));
        games.add(new Game("Risk Of Rain 2", "Roguelike", "PC", 2020));

        GameDataController.saveAvailableGames(games);
        List<Game> loadedGames = GameDataController.loadAvailableGames();

        Assertions.assertEquals(2, loadedGames.size());
        Assertions.assertEquals("GTA 6", loadedGames.get(0).getTitle());
    }

    @Test
    public void testLoadUserLibraries() {
        Map<String, List<OwnedGame>> userLibraries = GameDataController.loadUserLibraries();

        Assertions.assertFalse(userLibraries.isEmpty());
    }

    @Test
    public void testSaveUserLibraries() {
        Map<String, List<OwnedGame>> userLibraries = new HashMap<>();

        OwnedGame ownedGame1 = new OwnedGame(new Game("Elden Ring", "RPG", "PC", 2022));
        ownedGame1.setRating(9);
        OwnedGame ownedGame2 = new OwnedGame(new Game("Stardew Valley", "Simulation", "Switch", 2016));
        ownedGame2.setRating(8);

        List<OwnedGame> ownedGames = new ArrayList<>();
        ownedGames.add(ownedGame1);
        ownedGames.add(ownedGame2);

        userLibraries.put("Alex", ownedGames);

        GameDataController.saveUserLibraries(userLibraries);
        Map<String, List<OwnedGame>> loadedUserLibraries = GameDataController.loadUserLibraries();

        Assertions.assertEquals(1, loadedUserLibraries.size());
        Assertions.assertTrue(loadedUserLibraries.containsKey("Alex"));
        Assertions.assertEquals(2, loadedUserLibraries.get("Alex").size());
        Assertions.assertEquals("Elden Ring", loadedUserLibraries.get("Alex").get(0).getGame().getTitle());
        Assertions.assertEquals(9, loadedUserLibraries.get("Alex").get(0).getRating());
    }
}
