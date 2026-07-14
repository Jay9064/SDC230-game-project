public class Team {

    private String teamName;
    private String city;

    public Team(String teamName, String city) {
        this.teamName = teamName;
        this.city = city;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void displayTeam() {
        System.out.println("------------------------------");
        System.out.println("Team: " + teamName);
        System.out.println("City: " + city);
    }
}