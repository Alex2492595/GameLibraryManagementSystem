import gamelibrary.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testGetDetails() {
        Game game = new Game("Elden Ring", "RPG", "PC", 2022);

        game.addRating(8);
        game.addRating(10);

        String expected = "Title: Elden Ring, Genre: RPG, Platform: PC, Release Year: 2022, Average Rating: 9.0, Rating Count: 2";
        String result = game.getDetails();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCompareTo() {
        Game game1 = new Game("Doom", "FPS", "Console", 1993);
        Game game2 = new Game("Risk Of Rain 2", "Roguelike", "PC", 2020);
        int result = game1.compareTo(game2);

        Assertions.assertTrue(result < 0);
    }

    @Test
    public void testAddRating() {
        Game game = new Game("Celeste", "Platformer", "PC", 2018);

        game.addRating(8);
        game.addRating(9);

        Assertions.assertEquals(2, game.getRatingCount());
        Assertions.assertEquals(17, game.getTotalRating());
    }

    @Test
    public void testGetAverageRating() {
        Game game = new Game("Celeste", "Platformer", "PC", 2018);

        game.addRating(6);
        game.addRating(9);
        game.addRating(7);

        double expectedAverage = (6 + 9 + 7) / 3.0;

        Assertions.assertEquals(expectedAverage, game.getAverageRating());
    }
}
