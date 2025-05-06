package gamelibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GameDataController {

    /**
     * Saves a list of available games to availableGames.csv
     * @param games the list of games to be saved
     */
    public static void saveAvailableGames(List<Game> games) {
        String path = "src/main/resources/availableGames.csv";
        File file = new File(path);

        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Game game : games) {
                fileWriter.write(game.getTitle() + "," + game.getGenre() + "," + game.getPlatform() + "," + game.getReleaseYear() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads a list of available games from availableGames.csv
     * @return the list of available games
     */
    public static List<Game> loadAvailableGames() {
        List<Game> games = new ArrayList<>();
        String path = "src/main/resources/availableGames.csv";
        File file = new File(path);

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] rows = sc.nextLine().split(",");

                if (rows.length == 4) {
                    String title = rows[0];
                    String genre = rows[1];
                    String platform = rows[2];
                    int releaseYear = Integer.parseInt(rows[3]);
                    games.add(new Game(title, genre, platform, releaseYear));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return games;
    }

    /**
     * Saves the user game libraries to userLibraries.csv as a username with the game details
     * @param userLibraries the map of usernames to their list of owned games
     */
    public static void saveUserLibraries(Map<String, List<OwnedGame>> userLibraries) {
        String path = "src/main/resources/userLibraries.csv";
        File file = new File(path);

        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String username : userLibraries.keySet()) {
                List<OwnedGame> games = userLibraries.get(username);

                for (OwnedGame game : games) {
                    Game g = game.getGame();
                    int rating = game.getRating();

                    fileWriter.write(username + "," + g.getTitle() + "," + g.getGenre() + "," + g.getPlatform() + "," + g.getReleaseYear() + "," + rating + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads the user game libraries from userLibraries.csv where each username has their list of owned games
     * @return the map of usernames to each of their lists of owned games
     */
    public static Map<String, List<OwnedGame>> loadUserLibraries() {
        Map<String, List<OwnedGame>> userLibraries = new HashMap<>();
        String path = "src/main/resources/userLibraries.csv";
        File file = new File(path);

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] rows = line.split(",");

                if (rows.length == 6) {
                    String username = rows[0];
                    String title = rows[1];
                    String genre = rows[2];
                    String platform = rows[3];
                    int releaseYear = Integer.parseInt(rows[4]);
                    int rating = Integer.parseInt(rows[5]);

                    OwnedGame ownedGame = new OwnedGame(new Game(title, genre, platform, releaseYear));
                    ownedGame.setRating(rating);

                    userLibraries.putIfAbsent(username, new ArrayList<>());
                    userLibraries.get(username).add(ownedGame);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return userLibraries;
    }
}
