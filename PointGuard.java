
public class PointGuard extends Character {

    private int passingRating;

    public PointGuard(String name, int overall, String teamName, int passingRating) {
        super(name, overall, teamName);
        this.passingRating = passingRating;
    }

    public int getPassingRating() {
        return passingRating;
    }

    public void setPassingRating(int passingRating) {
        this.passingRating = passingRating;
    }

    @Override
    public String getPosition() {
        return "Point Guard";
    }

    @Override
    public void specialAbility() {
        System.out.println(
            getName() + " uses Floor General and delivers a perfect alley-oop!"
        );
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Passing Rating: " + passingRating);
    }
}
