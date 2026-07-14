import java.util.ArrayList;
import java.util.Scanner;

public class BasketballGame {

    private Scanner input;
    private ArrayList<Player> players;
    private ArrayList<Team> teams;

    public BasketballGame() {
        input = new Scanner(System.in);
        players = new ArrayList<Player>();
        teams = new ArrayList<Team>();

        addStartingTeams();
    }

    public void start() {

        int choice = 0;

        while (choice != 5) {

            displayMenu();

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    createPlayer();
                }
                else if (choice == 2) {
                    displayPlayers();
                }
                else if (choice == 3) {
                    displayTeams();
                }
                else if (choice == 4) {
                    playGame();
                }
                else if (choice == 5) {
                    System.out.println();
                    System.out.println("Thanks for playing MyHoop Career!");
                }
                else {
                    System.out.println();
                    System.out.println("Invalid choice. Please choose 1 through 5.");
                }
            }
            else {
                System.out.println();
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine();
            }
        }

        input.close();
    }

    private void displayMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("         MYHOOP CAREER");
        System.out.println("=================================");
        System.out.println("1. Create Player");
        System.out.println("2. View All Players");
        System.out.println("3. View Teams");
        System.out.println("4. Play Game");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private void createPlayer() {

        System.out.println();
        System.out.println("===== CREATE A PLAYER =====");

        System.out.print("Enter player name: ");
        String name = input.nextLine();

        System.out.print("Enter player position: ");
        String position = input.nextLine();

        System.out.print("Enter overall rating: ");

        int overall;

        while (!input.hasNextInt()) {
            System.out.print("Please enter a number for the overall rating: ");
            input.nextLine();
        }

        overall = input.nextInt();
        input.nextLine();

        System.out.print("Enter team name: ");
        String teamName = input.nextLine();

        Player newPlayer = new Player(name, position, overall, teamName);

        players.add(newPlayer);

        System.out.println();
        System.out.println(name + " was successfully created!");
        System.out.println("The player was added to the player collection.");
    }

    private void displayPlayers() {

        System.out.println();
        System.out.println("===== SAVED PLAYERS =====");

        if (players.isEmpty()) {
            System.out.println("No players have been created yet.");
        }
        else {
            for (Player player : players) {
                player.displayPlayer();
            }

            System.out.println("------------------------------");
            System.out.println("Total Players: " + players.size());
        }
    }

    private void addStartingTeams() {

        Team team1 = new Team("Charleston Storm", "Charleston");
        Team team2 = new Team("Miami Heat", "Miami");
        Team team3 = new Team("Atlanta Hawks", "Atlanta");

        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
    }

    private void displayTeams() {

        System.out.println();
        System.out.println("===== AVAILABLE TEAMS =====");

        for (Team team : teams) {
            team.displayTeam();
        }
    }

    private void playGame() {

        System.out.println();

        if (players.isEmpty()) {
            System.out.println("You must create a player before playing a game.");
        }
        else {
            Player activePlayer = players.get(0);

            System.out.println("Loading game for " + activePlayer.getName() + "...");
            System.out.println("Final Score: Your Team 102 - Opponent 96");
            System.out.println(activePlayer.getName() + " scored 24 points.");
            System.out.println(activePlayer.getName() + " had 7 assists.");
            System.out.println(activePlayer.getName() + " had 6 rebounds.");
        }
    }
}