package gamelibrary;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = null;

        System.out.println("Welcome to the Game Library Management System!");
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Are you a Manager (M) or a Regular User (U)? ");
        String userType = sc.nextLine();

        if (userType.equalsIgnoreCase("M")) {
            user = new Manager(username);
        } else if (userType.equalsIgnoreCase("U")) {
            user = new RegularUser(username);
        } else {
            System.out.println("Invalid user type.");
            return;
        }

        boolean running = true;
        while (running) {
            user.displayMenu();
            System.out.print("\nEnter your choice: ");
            String choice = sc.nextLine();

            if (user instanceof Manager manager) {
                switch (choice) {
                    case "1" -> manager.viewAllGames();

                    case "2" -> {
                        System.out.print("Enter game title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter genre: ");
                        String genre = sc.nextLine();
                        System.out.print("Enter platform: ");
                        String platform = sc.nextLine();
                        System.out.print("Enter release year: ");
                        int releaseYear = Integer.parseInt(sc.nextLine());

                        manager.addGame(new Game(title, genre, platform, releaseYear));
                    }

                    case "3" -> {
                        System.out.print("Enter game title to remove: ");
                        String title = sc.nextLine();

                        List<Game> games = GameDataController.loadAvailableGames();
                        Game removedGame = null;

                        for (Game g : games) {
                            if (g.getTitle().equals(title)) {
                                removedGame = g;
                                break;
                            }
                        }

                        if (removedGame != null) {
                            manager.removeGame(removedGame);
                        } else {
                            System.out.println("Game not found.");
                        }
                    }

                    case "4" -> manager.sortGamesByGenre();

                    case "5" -> manager.sortGamesByPlatform();

                    case "6" -> running = false;

                    default -> System.out.println("Invalid choice.");
                }
            } else if (user instanceof RegularUser regularUser) {
                switch (choice) {
                    case "1" -> regularUser.browseGames();

                    case "2" -> regularUser.viewLibrary();

                    case "3" -> {
                        System.out.print("Enter game title to purchase: ");
                        String title = sc.nextLine();

                        List<Game> games = GameDataController.loadAvailableGames();
                        Game purchasedGame = null;

                        for (Game g : games) {
                            if (g.getTitle().equalsIgnoreCase(title)) {
                                purchasedGame = g;
                                break;
                            }
                        }

                        if (purchasedGame != null) {
                            regularUser.purchaseGame(purchasedGame);
                        } else {
                            System.out.println("Game not found.");
                        }
                    }

                    case "4" -> {
                        System.out.print("Enter game title to remove: ");
                        String title = sc.nextLine();
                        OwnedGame removedGame = null;

                        for (OwnedGame ownedGame : regularUser.getLibrary()) {
                            if (ownedGame.getGame().getTitle().equalsIgnoreCase(title)) {
                                removedGame = ownedGame;
                                break;
                            }
                        }

                        if (removedGame != null) {
                            regularUser.removeGame(removedGame);
                        } else {
                            System.out.println("Game not found.");
                        }
                    }

                    case "5" -> {
                        System.out.print("Enter game title to rate: ");
                        String title = sc.nextLine();
                        OwnedGame ratedGame = null;

                        for (OwnedGame ownedGame : regularUser.getLibrary()) {
                            if (ownedGame.getGame().getTitle().equalsIgnoreCase(title)) {
                                ratedGame = ownedGame;
                                break;
                            }
                        }

                        if (ratedGame != null) {
                            System.out.print("Enter rating (1 to 10): ");
                            int rating = sc.nextInt();
                            sc.nextLine();

                            regularUser.rateGame(ratedGame, rating);
                        } else {
                            System.out.println("Game not found.");
                        }
                    }

                    case "6" -> running = false;

                    default -> System.out.println("Invalid choice.");
                }
            }
        }

        sc.close();
    }
}
