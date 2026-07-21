import java.util.ArrayList;
import java.util.Scanner;

public class BasketballGame {

    private Scanner input;
    private ArrayList<Character> characters;

    public BasketballGame() {
        input = new Scanner(System.in);
        characters = new ArrayList<Character>();
    }

    public void start() {

        int choice = 0;

        while (choice != 6) {

            displayMenu();

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();

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
                    useSpecialAbilities();
                }
                else if (choice == 5) {
                    playGame();
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
        System.out.println("1. Create Point Guard");
        System.out.println("2. Create Center");
        System.out.println("3. View All Characters");
        System.out.println("4. Use Special Abilities");
        System.out.println("5. Play Game");
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
        System.out.println("The character was added to the collection.");
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
        System.out.println("The character was added to the collection.");
    }

    private int readNumber() {

        while (!input.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            input.nextLine();
        }

        int number = input.nextInt();
        input.nextLine();

        return number;
    }

    private void displayCharacters() {

        System.out.println();
        System.out.println("===== SAVED CHARACTERS =====");

        if (characters.isEmpty()) {
            System.out.println("No characters have been created yet.");
            return;
        }

        for (Character character : characters) {
            character.displayInfo();
        }

        System.out.println("------------------------------");
        System.out.println("Total Characters: " + characters.size());
    }

    private void useSpecialAbilities() {

        System.out.println();
        System.out.println("===== SPECIAL ABILITIES =====");

        if (characters.isEmpty()) {
            System.out.println("No characters have been created yet.");
            return;
        }

        for (Character character : characters) {
            character.specialAbility();
        }
    }

    private void playGame() {

        System.out.println();

        if (characters.isEmpty()) {
            System.out.println("Create at least one character before playing.");
            return;
        }

        System.out.println("The game has started!");
        System.out.println("Final Score: Your Team 105 - Opponent 99");
        System.out.println();

        for (Character character : characters) {
            System.out.println(character.getName() + " entered the game.");
            character.specialAbility();
        }
    }
}