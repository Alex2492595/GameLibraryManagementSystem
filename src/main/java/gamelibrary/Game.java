package gamelibrary;

public class Game implements Comparable<Game> {
    private String title;
    private String genre;
    private String platform;
    private int releaseYear;

    public Game(String title, String genre, String platform, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.releaseYear = releaseYear;
    }

    /**
     * Formats the details of the game in a specific way (like toString)
     * @return the string representation of the game's details
     */
    public String getDetails() {
        return "Title: " + title + ", Genre: " + genre + ", Platform: " + platform + ", Release Year: " + releaseYear;
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
}
