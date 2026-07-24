
public class PowerForward extends Character {

    private int insideScoringRating;

    public PowerForward(String name, int overall, String teamName,
            int insideScoringRating) {

        super(name, overall, teamName);
        this.insideScoringRating = insideScoringRating;
    }

    public int getInsideScoringRating() {
        return insideScoringRating;
    }

    public void setInsideScoringRating(int insideScoringRating) {
        this.insideScoringRating = insideScoringRating;
    }

    @Override
    public String getPosition() {
        return "Power Forward";
    }

    @Override
    public void specialAbility() {
        System.out.println(getName()
                + " uses Post Scorer and finishes through contact!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Inside Scoring Rating: "
                + insideScoringRating);
    }
}
