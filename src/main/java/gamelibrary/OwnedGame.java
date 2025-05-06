package gamelibrary;

import java.util.Objects;

public class OwnedGame implements Rateable {
    private Game game;
    private int rating;

    public OwnedGame(Game game) {
        this.game = game;
        this.rating = 0;
    }

    /**
     * Sets the rating for the owned game
     * @param rating the rating assigned to the game
     */
    @Override
    public void rateGame(int rating) {
        if (rating < 1 || rating > 10) {
            System.out.println("Invalid rating. Enter a number from 1 to 10.");
            return;
        }

        this.rating = rating;
        System.out.println("Rating for " + game.getTitle() + " is now set to " + rating + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OwnedGame ownedGame = (OwnedGame) o;
        return rating == ownedGame.rating && Objects.equals(game, ownedGame.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, rating);
    }

    @Override
    public String toString() {
        return "OwnedGame{" +
                "game=" + game +
                ", rating=" + rating +
                '}';
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
