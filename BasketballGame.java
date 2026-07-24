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

            displayMainMenu();
            choice = readNumber();

            if (choice == 1) {
                createPlayer();
            }
            else if (choice == 2) {
                displayPlayers();
            }
            else if (choice == 3) {
                useSpecialAbilities();
            }
            else if (choice == 4) {
                playBasketballGame();
            }
            else if (choice == 5) {
                displayCareerStats();
            }
            else if (choice == 6) {
                System.out.println();
                System.out.println(
                        "Thanks for playing MyHoop Career!");
            }
            else {
                System.out.println();
                System.out.println(
                        "Invalid choice. Please choose 1 through 6.");
            }
        }

        input.close();
    }

    // Displays the main game menu.
    private void displayMainMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("         MYHOOP CAREER");
        System.out.println("=================================");
        System.out.println("1. Create Player");
        System.out.println("2. View Players");
        System.out.println("3. Use Special Abilities");
        System.out.println("4. Play Basketball Game");
        System.out.println("5. View Career Stats");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    // Allows the user to select one of five positions.
    private void createPlayer() {

        System.out.println();
        System.out.println("===== SELECT A POSITION =====");
        System.out.println("1. Point Guard");
        System.out.println("2. Shooting Guard");
        System.out.println("3. Small Forward");
        System.out.println("4. Power Forward");
        System.out.println("5. Center");
        System.out.print("Choose a position: ");

        int positionChoice = readNumber();

        if (positionChoice < 1 || positionChoice > 5) {
            System.out.println("Invalid position selection.");
            return;
        }

        System.out.print("Enter player name: ");
        String name = input.nextLine();

        System.out.print("Enter overall rating from 60 to 99: ");
        int overall = readRating();

        System.out.print("Enter team name: ");
        String teamName = input.nextLine();

        Character newPlayer;

        if (positionChoice == 1) {

            System.out.print("Enter passing rating: ");
            int passingRating = readRating();

            newPlayer = new PointGuard(
                    name,
                    overall,
                    teamName,
                    passingRating
            );
        }
        else if (positionChoice == 2) {

            System.out.print("Enter shooting rating: ");
            int shootingRating = readRating();

            newPlayer = new ShootingGuard(
                    name,
                    overall,
                    teamName,
                    shootingRating
            );
        }
        else if (positionChoice == 3) {

            System.out.print("Enter athletic rating: ");
            int athleticRating = readRating();

            newPlayer = new SmallForward(
                    name,
                    overall,
                    teamName,
                    athleticRating
            );
        }
        else if (positionChoice == 4) {

            System.out.print("Enter inside scoring rating: ");
            int insideScoringRating = readRating();

            newPlayer = new PowerForward(
                    name,
                    overall,
                    teamName,
                    insideScoringRating
            );
        }
        else {

            System.out.print("Enter rebounding rating: ");
            int reboundingRating = readRating();

            newPlayer = new Center(
                    name,
                    overall,
                    teamName,
                    reboundingRating
            );
        }

        characters.add(newPlayer);

        System.out.println();
        System.out.println(name + " was successfully created!");
        System.out.println("Position: " + newPlayer.getPosition());
        System.out.println("Team: " + teamName);
    }

    // Displays every player stored in the collection.
    private void displayPlayers() {

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
        System.out.println("Total Players: "
                + characters.size());
    }

    // Demonstrates polymorphism by calling the same method
    // on every player position.
    private void useSpecialAbilities() {

        System.out.println();
        System.out.println("===== SPECIAL ABILITIES =====");

        if (characters.isEmpty()) {
            System.out.println("No players have been created yet.");
            return;
        }

        for (Character character : characters) {
            System.out.print(character.getPosition() + ": ");
            character.specialAbility();
        }
    }

    // Simulates a game and updates the selected player's state.
    private void playBasketballGame() {

        System.out.println();
        System.out.println("===== PLAY BASKETBALL GAME =====");

        if (characters.isEmpty()) {
            System.out.println(
                    "Create a player before playing a game.");
            return;
        }

        displayPlayerChoices();

        System.out.print("Choose a player number: ");
        int playerChoice = readNumber();

        if (playerChoice < 1
                || playerChoice > characters.size()) {

            System.out.println("Invalid player selection.");
            return;
        }

        Character selectedPlayer =
                characters.get(playerChoice - 1);

        int points = random.nextInt(31) + 10;
        int assists = random.nextInt(13);
        int rebounds = random.nextInt(16);

        int teamScore = random.nextInt(31) + 85;
        int opponentScore = random.nextInt(31) + 85;

        System.out.println();
        System.out.println("The basketball game has started!");
        System.out.println(selectedPlayer.getName()
                + " is playing for "
                + selectedPlayer.getTeamName() + ".");

        selectedPlayer.specialAbility();
        selectedPlayer.playGame(points);

        System.out.println();
        System.out.println("===== PLAYER RESULTS =====");
        System.out.println("Points: " + points);
        System.out.println("Assists: " + assists);
        System.out.println("Rebounds: " + rebounds);

        System.out.println();
        System.out.println("===== FINAL SCORE =====");
        System.out.println(selectedPlayer.getTeamName()
                + ": " + teamScore);
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
        System.out.println("===== UPDATED GAME STATE =====");
        System.out.println("Player: "
                + selectedPlayer.getName());
        System.out.println("Position: "
                + selectedPlayer.getPosition());
        System.out.println("Overall: "
                + selectedPlayer.getOverall());
        System.out.println("Level: "
                + selectedPlayer.getLevel());
        System.out.println("XP: "
                + selectedPlayer.getXP());
        System.out.println("Games Played: "
                + selectedPlayer.getGamesPlayed());
        System.out.println("Career Points: "
                + selectedPlayer.getPointsScored());
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

            Character character = characters.get(i);

            System.out.println(
                    (i + 1)
                    + ". "
                    + character.getName()
                    + " - "
                    + character.getPosition()
            );
        }
    }

    // Prevents the program from crashing when letters are entered.
    private int readNumber() {

        while (!input.hasNextInt()) {
            System.out.print(
                    "Invalid input. Please enter a number: ");
            input.nextLine();
        }

        int number = input.nextInt();
        input.nextLine();

        return number;
    }

    // Makes sure player ratings stay between 60 and 99.
    private int readRating() {

        int rating = readNumber();

        while (rating < 60 || rating > 99) {
            System.out.print(
                    "Please enter a rating from 60 to 99: ");
            rating = readNumber();
        }

        return rating;
    }
}