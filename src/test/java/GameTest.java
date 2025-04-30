import gamelibrary.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testGetDetails() {
        Game game = new Game("Elden Ring", "RPG", "PC", 2022);
        String expected = "Title: Elden Ring, Genre: RPG, Platform: PC, Release Year: 2022";
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
}
