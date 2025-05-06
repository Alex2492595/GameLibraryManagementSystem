import gamelibrary.Game;
import gamelibrary.OwnedGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OwnedGameTest {
    @Test
    public void testRateGameValid() {
        OwnedGame ownedGame = new OwnedGame(new Game("GTA 6", "Action-Adventure", "PlayStation", 2026));

        ownedGame.rateGame(9);
        int result = ownedGame.getRating();

        Assertions.assertEquals(9, result);
    }

    @Test
    public void testRateGameInvalid() {
        OwnedGame ownedGame = new OwnedGame(new Game("GTA 6", "Action-Adventure", "PlayStation", 2026));

        ownedGame.rateGame(14);
        int result = ownedGame.getRating();

        Assertions.assertEquals(0, result);
    }
}
