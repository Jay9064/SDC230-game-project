public class Player {

    String name = "Jason";
    String position = "Point Guard";
    int overall = 60;
    String team = "Free Agent";

    public void showPlayerInfo() {
        System.out.println("===== PLAYER INFORMATION =====");
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Overall: " + overall);
        System.out.println("Team: " + team);
    }

}