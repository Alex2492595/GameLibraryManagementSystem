package gamelibrary;

public class OwnedGame {
    private Game game;

    public OwnedGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
