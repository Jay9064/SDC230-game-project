import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BasketballGame {

    private Scanner input;
    private ArrayList<Character> characters;
    private Random random;

    public BasketballGame() {
        input = new Scanner(System.in);
        characters = new ArrayList<Character>();
        random = new Random();
    }

    public void start() {

        int choice = 0;

        while (choice != 6) {

            displayMenu();
            choice = readNumber();

            if (choice == 1) {
                createPointGuard();
            }
            else if (choice == 2) {
                createCenter();
            }
            else if (choice == 3) {
                displayCharacters();
            }
            else if (choice == 4) {
                playBasketballGame();
            }
            else if (choice == 5) {
                displayCareerStats();
            }
            else if (choice == 6) {
                System.out.println();
                System.out.println("Thanks for playing MyHoop Career!");
            }
            else {
                System.out.println();
                System.out.println("Invalid choice. Please choose 1 through 6.");
            }
        }

        input.close();
    }

    private void displayMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("         MYHOOP CAREER");
        System.out.println("=================================");
        System.out.println("1. Create Point Guard");
        System.out.println("2. Create Center");
        System.out.println("3. View Players");
        System.out.println("4. Play Basketball Game");
        System.out.println("5. View Career Stats");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private void createPointGuard() {

        System.out.println();
        System.out.println("===== CREATE POINT GUARD =====");

        System.out.print("Enter player name: ");
        String name = input.nextLine();

        System.out.print("Enter overall rating: ");
        int overall = readNumber();

        System.out.print("Enter team name: ");
        String teamName = input.nextLine();

        System.out.print("Enter passing rating: ");
        int passingRating = readNumber();

        Character pointGuard =
                new PointGuard(name, overall, teamName, passingRating);

        characters.add(pointGuard);

        System.out.println();
        System.out.println(name + " was created as a Point Guard!");
    }

    private void createCenter() {

        System.out.println();
        System.out.println("===== CREATE CENTER =====");

        System.out.print("Enter player name: ");
        String name = input.nextLine();

        System.out.print("Enter overall rating: ");
        int overall = readNumber();

        System.out.print("Enter team name: ");
        String teamName = input.nextLine();

        System.out.print("Enter rebounding rating: ");
        int reboundingRating = readNumber();

        Character center =
                new Center(name, overall, teamName, reboundingRating);

        characters.add(center);

        System.out.println();
        System.out.println(name + " was created as a Center!");
    }

    private void displayCharacters() {

        System.out.println();
        System.out.println("===== SAVED PLAYERS =====");

        if (characters.isEmpty()) {
            System.out.println("No players have been created yet.");
            return;
        }

        for (Character character : characters) {
            character.displayInfo();
        }

        System.out.println("------------------------------");
        System.out.println("Total Players: " + characters.size());
    }

    private void playBasketballGame() {

        System.out.println();
        System.out.println("===== PLAY BASKETBALL GAME =====");

        if (characters.isEmpty()) {
            System.out.println("You must create a player before playing a game.");
            return;
        }

        displayPlayerChoices();

        System.out.print("Choose a player number: ");
        int playerChoice = readNumber();

        if (playerChoice < 1 || playerChoice > characters.size()) {
            System.out.println("Invalid player selection.");
            return;
        }

        Character selectedPlayer = characters.get(playerChoice - 1);

        int points = random.nextInt(31) + 10;
        int teamScore = random.nextInt(31) + 80;
        int opponentScore = random.nextInt(31) + 80;

        System.out.println();
        System.out.println("The basketball game has started!");
        System.out.println(selectedPlayer.getName() + " is playing for "
                + selectedPlayer.getTeamName() + ".");

        selectedPlayer.specialAbility();
        selectedPlayer.playGame(points);

        System.out.println();
        System.out.println("===== GAME RESULTS =====");
        System.out.println(selectedPlayer.getTeamName() + ": " + teamScore);
        System.out.println("Opponent: " + opponentScore);

        if (teamScore > opponentScore) {
            System.out.println("Your team won the game!");
            selectedPlayer.gainXP(25);
        }
        else if (teamScore < opponentScore) {
            System.out.println("Your team lost the game.");
            selectedPlayer.gainXP(10);
        }
        else {
            System.out.println("The game ended in a tie.");
            selectedPlayer.gainXP(15);
        }

        System.out.println();
        System.out.println("Updated Overall: " + selectedPlayer.getOverall());
        System.out.println("Updated Level: " + selectedPlayer.getLevel());
        System.out.println("Updated XP: " + selectedPlayer.getXP());
        System.out.println("Games Played: " + selectedPlayer.getGamesPlayed());
    }

    private void displayCareerStats() {

        System.out.println();
        System.out.println("===== CAREER STATS =====");

        if (characters.isEmpty()) {
            System.out.println("No players have been created yet.");
            return;
        }

        for (Character character : characters) {
            character.displayInfo();
        }
    }

    private void displayPlayerChoices() {

        System.out.println();
        System.out.println("Choose a player:");

        for (int i = 0; i < characters.size(); i++) {
            System.out.println((i + 1) + ". "
                    + characters.get(i).getName()
                    + " - "
                    + characters.get(i).getPosition());
        }
    }

    private int readNumber() {

        while (!input.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            input.nextLine();
        }

        int number = input.nextInt();
        input.nextLine();

        return number;
    }
}