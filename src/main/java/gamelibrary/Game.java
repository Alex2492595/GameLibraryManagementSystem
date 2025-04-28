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

    public String getDetails() {
        return "Title: " + title + ", Genre: " + genre + ", Platform: " + platform + ", Release Year: " + releaseYear;
    }

    @Override
    public int compareTo(Game o) {
        return this.title.compareTo(o.title);
    }
}
