
public class Character {

    private String name;
    private int overall;
    private String teamName;

    public Character(String name, int overall, String teamName) {
        this.name = name;
        this.overall = overall;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPosition() {
        return "Basketball Player";
    }

    public void specialAbility() {
        System.out.println(name + " uses a basic basketball move.");
    }

    public void displayInfo() {
        System.out.println("------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Position: " + getPosition());
        System.out.println("Overall Rating: " + overall);
        System.out.println("Team: " + teamName);
    }
}