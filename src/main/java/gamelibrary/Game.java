package gamelibrary;

import java.util.Objects;

public class Game implements Comparable<Game> {
    private String title;
    private String genre;
    private String platform;
    private int releaseYear;
    private int totalRating;
    private int ratingCount;

    public Game(String title, String genre, String platform, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.totalRating = 0;
        this.ratingCount = 0;
    }

    /**
     * Formats the details of the game in a specific way (like toString)
     * @return the string representation of the game's details
     */
    public String getDetails() {
        return "Title: " + title + ", Genre: " + genre + ", Platform: " + platform + ", Release Year: " + releaseYear + ", Average Rating: " + String.format("%.1f", getAverageRating()) + ", Rating Count: " + ratingCount;
    }

    /**
     * Adds the user rating by increasing the total rating for the game and its rating count
     * @param rating the rating to add
     */
    public void addRating(int rating) {
        totalRating += rating;
        ratingCount++;
    }

    /**
     * Calculates the average rating of the game
     * @return the average rating
     */
    public double getAverageRating() {
        if (ratingCount == 0) {
            return 0;
        }

        return (double) totalRating / ratingCount;
    }

    /**
     * Compares this game with the specified game to sort based on title
     * @param o the game to be compared
     * @return a negative, zero, or positive integer depending on the game's title compared to the other game's title
     */
    @Override
    public int compareTo(Game o) {
        return this.title.compareTo(o.title);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return releaseYear == game.releaseYear && Objects.equals(title, game.title) && Objects.equals(genre, game.genre) && Objects.equals(platform, game.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, platform, releaseYear);
    }

    @Override
    public String toString() {
        return "Game{" +
                "genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", platform='" + platform + '\'' +
                ", releaseYear=" + releaseYear +
                ", totalRating=" + totalRating +
                ", ratingCount=" + ratingCount +
                '}';
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }
}
