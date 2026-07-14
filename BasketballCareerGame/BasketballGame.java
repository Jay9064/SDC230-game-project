import java.util.Scanner;

public class BasketballGame {

    Scanner input = new Scanner(System.in);
    Player player = new Player();

    public void start() {

        int choice = 0;

        while (choice != 4) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("         MYHOOP CAREER");
            System.out.println("=================================");
            System.out.println("1. Start MyCareer");
            System.out.println("2. View Player");
            System.out.println("3. Play Game");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();

            if (choice == 1) {

                startCareer();

            }
            else if (choice == 2) {

                player.showPlayerInfo();

            }
            else if (choice == 3) {

                playGame();

            }
            else if (choice == 4) {

                System.out.println();
                System.out.println("Thanks for playing MyHoop Career!");

            }
            else {

                System.out.println();
                System.out.println("Invalid choice. Please choose 1 through 4.");

            }
        }

        input.close();
    }

    public void startCareer() {

        System.out.println();
        System.out.println("Your MyCareer has started!");
        System.out.println("Welcome to the league, Rookie!");
        System.out.println("Your goal is to become a basketball superstar.");

    }

    public void playGame() {

        System.out.println();
        System.out.println("Loading game...");
        System.out.println("Final Score: Your Team 98 - Opponent 91");
        System.out.println("You scored 22 points.");
        System.out.println("You had 8 assists.");
        System.out.println("You had 5 rebounds.");

    }
}