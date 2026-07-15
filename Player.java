public class Player {

    private String name;
    private String position;
    private int overall;
    private String teamName;

    public Player(String name, String position, int overall, String teamName) {
        this.name = name;
        this.position = position;
        this.overall = overall;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void displayPlayer() {
        System.out.println("------------------------------");
        System.out.println("Player Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Overall Rating: " + overall);
        System.out.println("Team: " + teamName);
    }
}